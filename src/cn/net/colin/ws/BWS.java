package cn.net.colin.ws;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/BWS/{userId}",configurator = SpringConfigurator.class)
public class BWS {

	private static Logger logger = LogManager.getLogger(BWS.class);

    //ConcurrentHashMap是线程安全的，而HashMap是线程不安全的。
    public static ConcurrentHashMap<String,Session> mapUS = new ConcurrentHashMap<String,Session>();
	public static ConcurrentHashMap<Session,String> mapSU = new ConcurrentHashMap<Session,String>();

    //连接建立成功调用的方法
	@OnOpen
	public void onOpen(Session session,@PathParam("userId") String userId) {
		String jsonString="{'content':'online','id':"+userId+",'type':'onlineStatus'}";
		session.setMaxIdleTimeout(1800000);
		mapUS.put(userId+"",session);
		mapSU.put(session,userId+"");
		logger.info("用户"+userId+"进入llws,当前在线人数为" + mapUS.size() );

	}
  
    //连接关闭调用的方法 
    @OnClose  
    public void onClose(Session session) { 
    	String userId=mapSU.get(session);
    	if(userId!=null&&userId!=""){
    	 	//更新redis中的用户在线状态
        	mapUS.remove(userId);
        	mapSU.remove(session);
			logger.info("用户"+userId+"退出llws,当前在线人数为" + mapUS.size());
    	}
    }  
  
    // 收到客户端消息后调用的方法 
    @OnMessage  
    public void onMessage(String message, Session session) {
		for(Session s:session.getOpenSessions()){		//循环发给所有在线的人
			try {
				s.getAsyncRemote().sendText(message);
			} catch (Exception e) {
				logger.error(e);
			}
		}
    }  
  
    /** 
     * 发生错误时调用 
     * @param session 
     * @param error 
     */  
    @OnError  
    public void onError(Session session, Throwable error) {  
    	String userId=mapSU.get(session);
    	if(userId!=null&&userId!=""){
    	 	//更新redis中的用户在线状态
        	mapUS.remove(userId);
        	mapSU.remove(session);
			logger.info("用户"+userId+"退出llws！当前在线人数为" + mapUS.size());
    	}
		logger.error("llws发生错误!");
        error.printStackTrace();
    }  
    
    /** 
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。 
     */  
    public void sendMessage(Session session,String message) {  
           session.getAsyncRemote().sendText(message);  
    }

	/**
	 * 广播消息
	 * @param message
	 */
	public void broadcast(String message){
		for (String value : mapSU.values()) {
			try {
				mapUS.get(value).getAsyncRemote().sendText(message);
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}
	
}
