<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>登录页面</title>
    <link rel="stylesheet" href="<%=basePath%>resources/css/login/signin.css">
    <link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap/css/bootstrap.css">

    <script src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
    <style type="text/css">
    	
    </style>
</head>
<body class="text-center" background="<%=basePath%>resources/images/login/background.gif" style="background-position:50% 50%; background-origin:content; background-repeat:no-repeat; background-size:100% 100%; background-attachment:fixed;  background-color: rgba(255,255,255,0.5);">

<h1  style="margin: 100px;color: white;">校园二手交易网后台管理系统</h1>
<form class="form-signin" action="<%=basePath%>user/login" method="post">
	
    <img class="mb-4" src="<%=basePath%>resources/images/bootstrap-solid.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal" style="color: white">请登录</h1>
    <!--判断-->
    <p style="color: red">${msg}</p>
    <label class="sr-only">用户名</label>
    <input type="text"  name="userName" class="form-control" placeholder="用户名" required="" autofocus="">
    <label class="sr-only">密码</label>
    <input type="password" name="userPsw" class="form-control" placeholder="密码" required="">
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted" style="color: white;">Copyright 2019-2020 by 王宇峰 </p>
</form>
<script>
    if(this.parent!=this) this.parent.window.location.href=window.location.href;
</script>
</body>
</html>