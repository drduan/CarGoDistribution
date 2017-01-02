<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/cssimport.html" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册-中国货运物流信息平台</title>
</head>

<script type="text/javascript">
function refreshCode(imgObj) {  
    if (!imgObj) {  
        imgObj = document.getElementById("validationCode");  
    }  
    var index = imgObj.src.indexOf("?");  
    if(index != -1) {  
        var url = imgObj.src.substring(0,index + 1);  
        imgObj.src = url + Math.random();  
    } else {  
        imgObj.src = imgObj.src + "?" + Math.random();  
    }  
}  
</script>
<body>
	<div class="container-fluid">
	 <jsp:include page="head.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<form method="post"
							action="${pageContext.request.contextPath}/User/register.do">
							<ul class="list-unstyled">
								<li>您的身份是 <input type="radio" name="usertype" value="DRIVER">
									车主： <input type="radio" name="usertype" value="OWNER"> 货主：
								</li>
								<li> 会员登录名 
								<input type="text" name="username"/> 
								</li>
								<li>手机号 <input type="text" name="phone" placeholder="请输入手机号">
									<button type="button" value="">获取验证码</button>
								</li>
								<li> 验证码 <input type="text" placeholder="请输入短信中的验证码	">

									<button type="button" hidden="hidden" value="确定" />
								</li>
									<img id="validationCode" alt="验证码图片" title="验证码图片"
									src="./validationCodeServlet.png"
									onclick="refreshCode(this)" />
									<a id="aRecode" href="javascript:void(0);"
									onclick="refreshCode()">换一张</a>
								<li>密码 <input type="text" placeholder="请输入6-20位登录密码"
									id="password"></li>
								<li>再次输入密码<input type="text" placeholder="请再次输入登录密码"
									id="repassword"></li>
								<li><input type="submit" value="注册"></input></li>
							</ul>
						</form>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>