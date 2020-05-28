package cn.net.colin.interceptor;


import cn.net.colin.entity.sysManage.AdministratorInfo;
import cn.net.colin.entity.sysManage.UserInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log= LogManager.getLogger(LoginInterceptor.class);

     @Override
     public boolean preHandle(HttpServletRequest request,  
             HttpServletResponse response, Object handler) throws Exception {            
        
         log.info("==============执行顺序: 1、preHandle================");  
         String requestUri = request.getRequestURI();
         String contextPath = request.getContextPath();
         String url = requestUri.substring(contextPath.length());         
         
         if ("/user/tologin".equals(url)||"/user/login".equals(url)) {                  
                 return true;
         }else {               
                 AdministratorInfo user  = (AdministratorInfo) request.getSession().getAttribute("user");
                 
                 if(user == null){
                         log.info("Interceptor：跳转到login页面！");
                         request.getRequestDispatcher("/user/tologin").forward(request, response);
                         return false;
                 }else
                         return true;   
        }
         
     }        

}