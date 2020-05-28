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
<div class="layui-container">
	<form id="form1" class="layui-form" check="real_name_verification">
		<input type="hidden" id="id" name="id" tableColumn="student_id"  value="${realName.studentId}"/>
		<div class="layui-form-item" hidden>
			<div class="layui-input-block">
				<button id="permissionSubmit" class="layui-btn" lay-submit lay-filter="save">
					保存
				</button>
			</div>
		</div>
		<!-- 第一行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>学号</label>
					<div class="layui-input-block">
						<input type="text" <c:if test="${!empty realName}">readonly</c:if> id="student_id" name="studentId" value="${realName.studentId}" lay-verify="required|dasLength|repeatCheck" daslength="12" placeholder="请输入学号" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第二行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>姓名</label>
					<div class="layui-input-block">
						<input type="text" id="studentName" name="studentName" value="${realName.studentName}" lay-verify="required|dasLength" daslength="5" placeholder="请输入姓名" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/utils/layuiFromVerify.js"></script>
<script src="<%=basePath%>resources/js/sysManage/userInfo/realNameSaveOrUpdate.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>