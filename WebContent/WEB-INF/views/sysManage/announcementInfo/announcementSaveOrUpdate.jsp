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
	<form id="form1" class="layui-form">
		<input type="hidden" id="announcementId" name="announcementId"  value="${announcementInfo.announcementId}"/>
		<div class="layui-form-item" hidden>
			<div class="layui-input-block">
				<button id="permissionSubmit" class="layui-btn" lay-submit lay-filter="save">
					保存
				</button>
			</div>
		</div>
		<!-- 第一行 -->
		<div class="layui-row">
			<div class="layui-col-xs12">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>公告内容</label>
					<div class="layui-input-block">
						<textarea style="height: 200px;" name="announcementContent" id="announcementContent"  placeholder="公告内容" lay-verify="dasLength" daslength="1000" class="layui-textarea">${announcementInfo.announcementContent}</textarea>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/utils/layuiFromVerify.js"></script>
<script src="<%=basePath%>resources/js/sysManage/announcementInfo/announcementSaveOrUpdate.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>