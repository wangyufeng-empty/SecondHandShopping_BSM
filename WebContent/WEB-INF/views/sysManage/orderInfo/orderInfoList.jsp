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
	下单学号：
	<div class="layui-inline">
		<input class="layui-input" name="userId" id="userId" placeholder="学号" autocomplete="off">
	</div>
	订单号：
	<div class="layui-inline">
		<input class="layui-input" name="orderId" id="orderId" placeholder="订单号" autocomplete="off">
	</div>
	收货人：
	<div class="layui-inline">
		<input class="layui-input" name="consignee" id="consignee" placeholder="收货人姓名" autocomplete="off">
	</div>
	收货人电话：
	<div class="layui-inline">
		<input class="layui-input" name="telNum" id="telNum" placeholder="收货人电话" autocomplete="off">
	</div>
	<button class="layui-btn" onclick="search();" id="findBy">搜索</button>
	<button type="reset" class="layui-btn" id="chongzhi">重置</button>
</div>


<table class="layui-hide" id="orderlist" lay-filter="ordertable"></table>

<script type="text/html" id="barOrderlist">
	<a class="layui-btn layui-btn-xs" lay-event="details">详情</a>
</script>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/main.js"></script>
<script src="<%=basePath%>resources/js/sysManage/orderInfo/orderInfoList.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>