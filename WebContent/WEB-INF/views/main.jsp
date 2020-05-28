﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String baseWsPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>校园二手交易网</title>
	<%--<title>预警信息基层应用子系统</title>--%>
	<link rel="stylesheet" href="<%=basePath%>resources/css/index.css">
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap/css/bootstrap-theme.css">
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/ace/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/ace/assets/css/ace.min.css" />
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/layui/css/layui.css" media="all">
	<script>
        var baselink = '<%=basePath%>';
	</script>
</head>
<body>
<input type="hidden" id="baseWsPath" value="<%=baseWsPath%>"/>
<input type="hidden" id="identifier" value="${identifier}" />
<div class="navbar navbar-default" id="navbar">
	<div class="navbar-container" id="navbar-container">
		<div class="contentBigBox">
			<div id="headerNav" class="active">
				<h1>
					<img src="<%=basePath%>/resources/images/cloud.png" style="width: 40px;">
					<span style="display: inline-block;vertical-align: middle;font-size: 26px;font-family: '时尚中黑简体';line-height: 58px;color: white;">校园二手交易网</span>
				</h1>
				<ul id="nav">
					<%--<li onclick="showSecondMenu('82','','1')">
						<i class="icon-cog"></i>
						<p>系统管理</p>
					</li>--%>
				</ul>
				<div class="navTime">
					<ul>
						<li class="userName">
							<span>${sessionScope.user.adminName} ，欢迎你！</span>

						</li>
						<li class="exit" id="loginout" style="margin-top: 2px;margin-right: 5px; "onclick="loginOut()">
							<i class=" icon-signout"></i>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div><!-- /.container -->
</div>
<div class="main-container" id="main-container">
	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="javascript:;">
			<span class="menu-text"></span>
		</a>
		<div class="sidebar" id="sidebar">
			<ul class="nav nav-list" id="secondmenu">

			</ul><!-- /.nav-list -->

			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
			</div>
		</div>

		<div class="main-content" id="main-content">
			<div class="page-content" style="padding:0;" id="iframeBox">
				<iframe id="rightframe" name="rightframe" src="" frameborder="0" style="width:100%;height:100%;"></iframe>
			</div><!-- /.page-content -->
		</div><!-- /.main-content -->

	</div><!-- /.main-container-inner -->
</div><!-- /.main-container -->
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/plugin/bootstrap/js/bootstrap.js"></script>
<script src="<%=basePath%>resources/plugin/ace/assets/js/ace.min.js"></script>
<script src="<%=basePath%>resources/plugin/ace/assets/js/ace-extra.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/main.js"></script>
<script src="<%=basePath%>resources/js/announcementWS.js"></script>
<script>
    $("#nav li").on('click',function(){
        $(this).addClass('navActive').siblings().removeClass('navActive');  // 头部导航切换效果
    });
    $("#nav li").first().click();
    function loginOut(){
        sessionStorage.clear();
        window.location.href = "../user/loginOut";
}
</script>
</body>
</html>