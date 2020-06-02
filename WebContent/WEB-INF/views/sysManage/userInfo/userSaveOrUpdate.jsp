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
<body style="overflow-y: scroll;">
<div class="layui-container">
	<form id="form1" class="layui-form" check="user_info">
		<input type="hidden" id="id" name="id" tableColumn="user_id"  value="${userInfo.userId}"/>
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
						<input type="text" id="user_id" <c:if test="${!empty userInfo}">readonly</c:if> name="userId" value="${userInfo.userId}" lay-verify="required|dasLength|repeatCheck" daslength="12" placeholder="请输入学号" autocomplete="off" class="layui-input" />
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
						<input type="text" id="userName" name="userName" value="${userInfo.userName}" lay-verify="required|dasLength" daslength="5" placeholder="请输入姓名" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第三行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>密码</label>
					<div class="layui-input-block">
						<input type="text" id="userPsw" name="userPsw" value="${userInfo.userPsw}" lay-verify="required|dasLength" daslength="10" placeholder="请输入密码" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第四行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>性别</label>
					<div class="layui-input-block">
						<input type="radio" name="userSex" <c:if test="${userInfo.userSex eq '男' or empty userInfo}">checked</c:if> value="男" title="男"/>
						<input type="radio" name="userSex" <c:if test="${userInfo.userSex eq '女'}">checked</c:if> value="女" title="女"/>
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第五行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>年级</label>
					<div class="layui-input-block">
						<select id="userGrade" name="userGrade" lay-verify="required">
							<option value=""></option>
							<option <c:if test="${userInfo.userGrade eq '大一' or empty userInfo}">selected</c:if> value="大一">大一</option>
							<option <c:if test="${userInfo.userGrade eq '大二'}">selected</c:if> value="大二">大二</option>
							<option <c:if test="${userInfo.userGrade eq '大三'}">selected</c:if> value="大三">大三</option>
							<option <c:if test="${userInfo.userGrade eq '大四'}">selected</c:if> value="大四">大四</option>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第六行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">电话号码</label>
					<div class="layui-input-block">
						<input type="text" id="userTel" name="userTel" value="${userInfo.userTel}" lay-verify="dasPhone" placeholder="请输入电话号码" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第七行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-block">
						<input type="text" id="userEmail" name="userEmail" value="${userInfo.userEmail}" lay-verify="dasEmail" placeholder="请输入邮箱" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第八行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">爱好</label>
					<div class="layui-input-block">
						<input type="text" id="userHobby" name="userHobby" value="${userInfo.userHobby}" lay-verify="dasLength" daslength="50" placeholder="请输入爱好" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第九行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">收货地址</label>
					<div class="layui-input-block">
						<input type="text" id="userAddress" name="userAddress" value="${userInfo.userAddress}" lay-verify="dasLength" daslength="50" placeholder="请输入收货地址" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第十行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">自我介绍</label>
					<div class="layui-input-block">
						<textarea name="selfIntroduce" id="selfIntroduce"  placeholder="自我介绍" lay-verify="dasLength" daslength="200" class="layui-textarea">${userInfo.selfIntroduce}</textarea>
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第十一行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">自我祝福</label>
					<div class="layui-input-block">
						<textarea rows="3" name="selfBlessing" id="selfBlessing" placeholder="祝福语" lay-verify="dasLength" daslength="200" class="layui-textarea">${userInfo.selfBlessing}</textarea>
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第十二行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">密保问题</label>
					<div class="layui-input-block">
						<input type="text" id="userquestionMothername" name="userquestionMothername" value="${userInfo.userquestionMothername}" lay-verify="dasLength" daslength="50" placeholder="母亲姓名" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第十三行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">密保问题</label>
					<div class="layui-input-block">
						<input type="text" id="userquestionFirstlove" name="userquestionFirstlove" value="${userInfo.userquestionFirstlove}" lay-verify="dasLength" daslength="50" placeholder="初恋姓名" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 第十四行 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label">注册时间</label>
					<div class="layui-input-block">
						<input type="text" id="registerTime" name="registerTime" value="${userInfo.registerTime}" lay-verify="dasLength" daslength="50" placeholder="请输入注册时间" autocomplete="off" class="layui-input" />
					</div>
				</div>
			</div>
			<div class="layui-col-xs2">　</div>
		</div>
		<!-- 账号状态 -->
		<div class="layui-row">
			<div class="layui-col-xs2">　</div>
			<div class="layui-col-xs8">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="span-red">*</span>状态</label>
					<div class="layui-input-block">
						<input type="radio" name="accountState" <c:if test="${userInfo.accountState == 1 or empty userInfo}">checked</c:if> value="1" title="正常"/>
						<input type="radio" name="accountState" <c:if test="${userInfo.accountState == 0}">checked</c:if> value="0" title="封禁"/>
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
<script src="<%=basePath%>resources/js/sysManage/userInfo/userSaveOrUpdate.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>