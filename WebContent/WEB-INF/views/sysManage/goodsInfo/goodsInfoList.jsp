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
	关键词：
	<div class="layui-inline">
		<input class="layui-input" style="width: 300px;" name="queryStr" id="queryStr" placeholder="商品名称、发布人、商品类型、商品描述" autocomplete="off">
	</div>
	主页显示：
	<div class="layui-inline">
		<select class="layui-select" name="homepageShow"  id="homepageShow">
			<option value="">全部</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<button class="layui-btn" onclick="search();" id="findBy">搜索</button>
	<button type="reset" class="layui-btn" id="chongzhi">重置</button>
</div>


<table class="layui-hide" id="goodslist" lay-filter="goodstable"></table>

<script type="text/html" id="info_toolbar">
	<div class="layui-btn-container">
		<div class="layui-inline" title="删除" lay-event="delete">
			<i class="layui-icon layui-icon-delete"></i>
		</div>
	</div>
</script>

<script type="text/html" id="barGoodslist">
	<a class="layui-btn layui-btn-xs" lay-event="details">详情</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/main.js"></script>
<script src="<%=basePath%>resources/js/sysManage/goodsInfo/goodsInfoList.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>