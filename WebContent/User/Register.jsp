<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../common/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../common/js/jquery-3.1.1.min.js"></script>
<title>欢迎注册-中国货运物流信息平台</title>
</head>
<script type="text/javascript">
	function refreshCode(imgObj) {
		if (!imgObj) {
			imgObj = document.getElementById("validationCode");
		}
		var index = imgObj.src.indexOf("?");
		if (index != -1) {
			var url = imgObj.src.substring(0, index + 1);
			imgObj.src = url + Math.random();
		} else {
			imgObj.src = imgObj.src + "?" + Math.random();
		}
	
	}
</script>

<script type="text/javascript">

//$("#select_id").change(function(){//code...}); //为Select添加事件，当选择其中一项时触发 
	//var checkText=$("#select_id").find("option:selected").text(); //获取Select选择的Text 
	//var checkValue=$("#select_id").val(); //获取Select选择的Value 
	//var checkIndex=$("#select_id ").get(0).selectedIndex; //获取Select选择的索引值 
	//var maxIndex=$("#select_id option:last").attr("index"); //获取Select最大的索引值

	$(document).ready(
	function () {

	
//$("#usertype").click(function(){
	
	
$("#usertype").change(
		
		
		function()
		{
			var checkValue = $("#usertype").val();
			switch(checkValue)
			{
			case "OWNER":
				$("#OWNER").show();
				$("#DRIVER").hide();
			
				break;
			case "DRIVER":
				$("#OWNER").hide();
				$("#DRIVER").show();
			
				break;
			case "GUEST":
				$("#OWNER").hide();
				$("#DRIVER").hide();
		
				break;
			}
		
		//	confirm("文本")
		//	prompt("文本","默认值")
		}
		)	
//$("[id="+selectt+"]").toggle();
	});


</script>

<body >
	<div class="container-fluid">
		<jsp:include page="../head.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<form method="post"
							action="${pageContext.request.contextPath}/User/register.do">
							<ul class="list-unstyled">
								<li>
								<select id="usertype" class="form-control">
										<option value="GUEST">游客</option>
										<option value="DRIVER">车主</option>
										<option value="OWNER">货主</option>
								</select>
								<br/>
								</li>
								<li> <label>会员登录名</label><br/> <input type="text" name="username" />
								</li>
								<li hidden="true">手机号
								 <input type="text" name="phone" placeholder="请输入手机号">
								<button type="button" value="">获取验证码</button>
								</li>
								
								
								
								<li><label>密码 </label>
								<br/><input type="text" placeholder="请输入6-20位登录密码"
									id="password"></li>
								<li><label>再次输入密码</label>
								<br/><input type="text" placeholder="请再次输入登录密码"
									id="repassword"></li>
									
									<li>
								<img id="validationCode" alt="验证码图片" title="验证码图片"
									src="../validationCodeServlet.png" onclick="refreshCode(this)" />
								<a id="aRecode" href="javascript:void(0);"
									onclick="refreshCode()"><label>换一张</label></a>
									</li>
									<li> <label>验证码</label><br/>
								 <input type="text" placeholder="请输入验证码">
								</li>
								
								
								<li><input class="btn btn-block" type="submit" value="注册"></input></li>
							</ul>
						</form>
					</div>
					<div class="col-md-4">

						<div class="tab-content">
							
							<div id="OWNER" style="display: none" >
							
							<form action="User/upload.do" method="post" enctype="multipart/form-data">  
								上传营业执照<input type="file" name="file" />
								 <input type="submit" value="提交" />
							</form>
							
							
							</div>
							<div id="DRIVER" style="display: none" >hello driver</div>
						

						</div>
					</div>
				</div>
			</div>
		</div>
</div>

	<script type="text/javascript" src="../common/js/bootstrap.js"></script>	
</body>
</html>