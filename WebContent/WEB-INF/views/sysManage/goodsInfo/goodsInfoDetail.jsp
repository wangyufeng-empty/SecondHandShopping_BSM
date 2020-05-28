﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String SecondHandShoppingPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/SecondHandShopping/";
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
		<!-- 第一行 -->
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-block">
						<input type="text" readonly id="goodsName" name="goodsName" value="${goodsInfo.goodsName}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">发布人</label>
					<div class="layui-input-block">
						<input type="text" readonly id="goodsPublisher" name="goodsPublisher" value="${goodsInfo.goodsPublisher}" autocomplete="off" class="layui-input" />
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
					<label class="layui-form-label">商品类别</label>
					<div class="layui-input-block">
						<input type="text" readonly id="goodsCategory" name="goodsCategory" value="${goodsInfo.goodsCategory}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">发布时间</label>
					<div class="layui-input-block">
						<input type="text" readonly id="goodsIssudate" name="goodsIssudate" value="${goodsInfo.goodsIssudate}" autocomplete="off" class="layui-input" />
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
					<label class="layui-form-label">商品价格</label>
					<div class="layui-input-block">
						<input type="text" readonly id="goodsPrice" name="goodsPrice" value="${goodsInfo.goodsPrice}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs5">
				<div class="layui-form-item">
					<label class="layui-form-label">商品库存</label>
					<div class="layui-input-block">
						<input type="text" readonly id="goodsStock" name="goodsStock" value="${goodsInfo.goodsStock}" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
		<!-- 第四行 -->
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs10">
				<div class="layui-form-item">
					<label class="layui-form-label">商品描述</label>
					<div class="layui-input-block">
						<textarea style="min-height: 75px" readonly name="goodsDescribe" id="goodsDescribe" class="layui-textarea">${goodsInfo.goodsDescribe}</textarea>
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-xs1">　</div>
			<div class="layui-col-xs10">
				<div class="layui-carousel" id="test10" >
					<div carousel-item="">
					<c:choose>
						<c:when test="${(goodsInfo.goodsPictures)!= null && fn:length(goodsInfo.goodsPictures) > 0}">
							<c:forEach items="${goodsInfo.goodsPictures}" var="goodsPicture">
								<div>
									<c:choose>
										<c:when test="${goodsPicture.homepageShow eq 1}">
											<button onclick="homePageChange('${goodsPicture.goodsId}',${goodsPicture.homepageShow},${goodsPicture.idAuto});" type="button" class="layui-btn layui-btn-danger layui-btn-radius"style="position: absolute;top: 2px;right: 2px;">从首页移除</button>
										</c:when>
										<c:otherwise>
											<button onclick="homePageChange('${goodsPicture.goodsId}',${goodsPicture.homepageShow},${goodsPicture.idAuto});" type="button" class="layui-btn layui-btn-radius" style="position: absolute;top: 2px;right: 2px;">在首页展示</button>
										</c:otherwise>
									</c:choose>
									<img src="<%=SecondHandShoppingPath%>${goodsPicture.productImage}" style="width: 100%;height: 100%">
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<img src="../../resources/images/nopic.jpg">
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			</div>
			<div class="layui-col-xs1">　</div>
		</div>
</div>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=basePath%>resources/plugin/layui/layui.js"></script>
<script src="<%=basePath%>resources/js/common.js"></script>
<script src="<%=basePath%>resources/js/utils/layuiFromVerify.js"></script>
<script src="<%=basePath%>resources/js/sysManage/goodsInfo/goodsInfoDetail.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>