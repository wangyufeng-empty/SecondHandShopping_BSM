<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>校园二手交易网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="错误处理页">
	<meta http-equiv="description" content="错误处理页">
	<style type="text/css">
		#tb1 {
			
		}
	</style>
  </head>
  
   <body>
   <div style="width: 100%;height: 100%;padding: 0px 0px 0px 0px;">
    	<table id="tb1" align="center" width="100%" cellpadding="0" cellspacing="0" border="0" height="100%">
        	<tr>
        		<td>
                <div align="center"><img alt="请与管理员联系！" src="<%=path %>/resources/images/making.jpg">
                </div>
            	</td>
            </tr>
        </table>
   </div>
    </body>
</html>
