﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String SecondHandShoppingPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/SecondHandShoppingPath/";
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
<body style="overflow-y: auto;">
<div class="layui-container layui-form">
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>订单详情</legend>
	</fieldset>
		<!-- 第一行 -->
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">下单学号</label>
					<div class="layui-input-block">
						<input type="text" readonly id="userId" name="userId" value="${orderInfo.userId}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-block">
						<input type="text" readonly id="orderId" name="orderId" value="${orderInfo.orderId}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
		<!-- 第二行 -->
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">收货人</label>
					<div class="layui-input-block">
						<input type="text" readonly id="consignee" name="consignee" value="${orderInfo.consignee}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">收货人电话</label>
					<div class="layui-input-block">
						<input type="text" readonly id="telNum" name="telNum" value="${orderInfo.telNum}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
		<!-- 第三行 -->
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">收货地址</label>
					<div class="layui-input-block">
						<input type="text" readonly id="address" name="address" value="${orderInfo.address}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">订单状态</label>
					<div class="layui-input-block">
						<input type="text" readonly id="orderState" name="orderState" value="${orderInfo.orderState}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
		<!-- 第四行 -->
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">下单时间</label>
					<div class="layui-input-block">
						<input type="text" readonly id="orderTime" name="orderTime" value="${orderInfo.orderTime}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">订单总价</label>
					<div class="layui-input-block">
						<input type="text" readonly id="sumAccount" name="sumAccount" value="${orderInfo.sumAccount}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>商品列表</legend>
		</fieldset>
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs10">
				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="150">
						<col width="200">
						<col>
					</colgroup>
					<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>选购数量</th>
						<th>小计</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderInfo.historyorderInfoList}" var="historyorderInfo">
							<tr>
								<td>${historyorderInfo.goodsId}</td>
								<td>${historyorderInfo.goodsName}</td>
								<td>${historyorderInfo.selectedquantity}</td>
								<td>${historyorderInfo.subtotal}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
</div>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>