<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="common/cssimport.html" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册-中国货运物流信息平台</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/User/register.do">
		<ul>
			<li>您的身份是 <input type="radio" name="userType" value="1">
				车主： <input type="radio" name="userType" value="0"> 货主：
			</li>
			<li><input type="text" placeholder="请输入手机号">
				<button type="button" value="">获取验证码</button></li>
			<li><input type="text" placeholder="请输入短信中的验证码	">
				<button type="button" hidden="hidden" value="确定" /></li>
			<li><input type="text" placeholder="请输入6-20位登录密码" id="password">
			</li>
			<li><input type="text" placeholder="请再次输入登录密码" id="repassword">
			</li>
			<li><input type="submit" value="注册"></input></li>
		</ul>
	</form>
</body>
</html>