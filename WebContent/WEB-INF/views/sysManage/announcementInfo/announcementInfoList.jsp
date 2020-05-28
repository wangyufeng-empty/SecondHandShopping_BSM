﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>校园二手交易网</title>
	<link rel="stylesheet" href="<%=basePath%>resources/css/index.css">
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="<%=basePath%>resources/css/dasui.css" media="all">
	<style>
		body{margin: 10px;}
	</style>
</head>
<body>
<div class="demoTable layui-form">
	公告内容：
	<div class="layui-inline">
		<input class="layui-input" style="width: 300px;" name="announcementContent" id="announcementContent" placeholder="" autocomplete="off">
	</div>
	<button class="layui-btn" onclick="search();" id="findBy">搜索</button>
	<button type="reset" class="layui-btn" id="chongzhi">重置</button>
</div>


<table class="layui-hide" id="announcementInfoList" lay-filter="announcementInfoTable"></table>

<script type="text/html" id="info_toolbar">
	<div class="layui-btn-container">
		<div class="layui-inline" title="新增" lay-event="add">
			<i class="layui-icon layui-icon-add-1"></i>
		</div>
		<div class="layui-inline" title="删除" lay-event="delete">
			<i class="layui-icon layui-icon-delete"></i>
		</div>
	</div>
</script>

<script type="text/html" id="barAnnouncementInfolist">
	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/main.js"></script>
<script src="<%=basePath%>resources/js/sysManage/announcementInfo/announcementInfoList.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>