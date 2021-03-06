﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="<%=basePath%>resources/plugin/ace/assets/css/font-awesome.min.css" />
	<style>
		body{margin: 10px;}
	</style>
</head>
<body>
<div class="demoTable layui-form">
	用户名称：
	<div class="layui-inline">
		<input class="layui-input" name="userName" id="userName" autocomplete="off">
	</div>
	性别：
	<div class="layui-inline">
		<select class="layui-select" name="userSex"  id="userSex">
			<option value=""></option>
			<option value="男">男</option>
			<option value="女">女</option>
		</select>
	</div>
	年级：
	<div class="layui-inline">
		<select class="layui-select" name="userGrade"  id="userGrade">
			<option value=""></option>
			<option value="大一">大一</option>
			<option value="大二">大二</option>
			<option value="大三">大三</option>
			<option value="大四">大四</option>
		</select>
	</div>
	电话号码：
	<div class="layui-inline">
		<input class="layui-input" name="userTel" id="userTel" autocomplete="off">
	</div>
	<button class="layui-btn" onclick="search();" id="findBy">搜索</button>
	<button type="reset" class="layui-btn" id="chongzhi">重置</button>
</div>


<table class="layui-hide" id="userlist" lay-filter="usertable"></table>

<script type="text/html" id="info_toolbar">
	<div class="layui-btn-container">
		<div class="layui-inline" title="新增" lay-event="add">
			<i class="layui-icon layui-icon-add-1"></i>
		</div>
		<div class="layui-inline" title="删除" lay-event="delete">
			<i class="layui-icon layui-icon-delete"></i>
		</div>
		<div class="layui-inline" title="导出" lay-event="export" id="exportFile">
			<i class="icon-upload-alt" style="font-size: 16px;"></i>
		</div>
	</div>
</script>

<script type="text/html" id="barUserlist">
	<a class="layui-btn layui-btn-xs" lay-event="details">详情</a>
	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/main.js"></script>
<script src="<%=basePath%>resources/js/sysManage/userInfo/userInfoList.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>