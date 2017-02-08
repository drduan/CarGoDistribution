<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../common/css/bootstrap.min.css" />
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
	
	function checkuser()
	{
		var mail = $("input[name='email']").val();
		var name = $("input[name='username']").val();
		var pwd = $("input[name='password']").val();
		var repwd = $("input[name='repassword']").val();
		var validchar = $("input[name='validchar']").val();
		var phone = $("input[name='phone']").val();
		
		 htmlobj=$.ajax({url:"<%=request.getContextPath()%>/User/userexist.do",async: false,}).responseText;
		 obj = JSON.parse(""+htmlobj);
		
		
		  	
		 
		 if(mail=="" || name=="" || pwd==""|| repwd=="" ||validchar=="" || phone=="")
			 
		{
			alert("请检查是否有遗漏选项！");
			return false;
		}
		
		else if(pwd!=repwd)
		{
			alert("密码不同");
			return false;
		}
		else if(obj.message != validchar)
			{
		
			alert("验证码错误");
			return false;
			}
		
		else
			{
			//document.getElementById("fname").innerHTML=obj.employees[1].firstName 
			//document.getElementById("lname").innerHTML=obj.employees[1].lastName 			
			 return true;
			}
			
	}
			
		 
		 
		
//		$(document).ready(function(){
//		jQuery.post(url,data,success(data, textStatus, jqXHR),dataType)
		//判断邮箱是否已经被注册
		//判断密码是否重复
		// 判断验证码是否正确
		//留空手机号验证
	
//	
//	$(document).ready(function(){
//$("#btn btn-block").click(function(){
//  $.get("http://www.baidu.com",function(data,status){
//    alert("数据：" + data + "\n状态：" + status);
//  });
//});
//});
	function checkotherinfo()
	{
		return false;
	}
	
	function checkemailexist(){
	
		return false;
		 
	}
</script>

<script type="text/javascript">
//$("#select_id").change(function(){//code...}); //为Select添加事件，当选择其中一项时触发 
	//var checkText=$("#select_id").find("option:selected").text(); //获取Select选择的Text 
	//var checkValue=$("#select_id").val(); //获取Select选择的Value 
	//var checkIndex=$("#select_id ").get(0).selectedIndex; //获取Select选择的索引值 
	//var maxIndex=$("#select_id option:last").attr("index"); //获取Select最大的索引值
	
	/**
	根据option进行绑定事件
	*/
/*
	$(document).ready(
	function () {
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
	});
*/

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
							action="${pageContext.request.contextPath}/User/register.do" onsubmit="return checkuser()" accept-charset="UTF-8">
							<ul class="list-unstyled">
								<li>
								<select id="usertype" class="form-control">
										<option value="GUEST">游客</option>
										<option value="DRIVER">车主</option>
										<option value="OWNER">货主</option>
								</select>
								<br/>
								</li>
								<li> <label>登陆邮箱</label><br/> 
								<input type="email" name="email" autofocus="autofocus" onchange="checkemailexist()" />
								</li>
								<li> <label>会员登录名</label><br/> <input type="text" name="username" placeholder="输入3位以上英文"/>
								</li>
							
								
								
								
								<li><label>密码 </label>
								<br/><input type="password" placeholder="请输入6-20位登录密码"
									name="password"
									id="password"></li>
								<li><label>再次输入密码</label>
								<br/><input type="password" name="repassword" placeholder="请再次输入登录密码"
									id="repassword"></li>
									
									<li>
								<img id="validationCode" alt="验证码图片" title="验证码图片"
									src="../validationCodeServlet.png" onclick="refreshCode(this)" />
								<a id="aRecode" href="javascript:void(0);"
									onclick="refreshCode()"><label>换一张</label></a>
									</li>
									<li> <label>验证码</label><br/>
								 <input  placeholder="请输入验证码" name="validchar">
								</li>
								
								</li>
									<li> <label>手机号</label><br/>
								 <input type="tel" placeholder="请输入手机号" name="phone" >
								</li>
								
								
								<li><input class="btn btn-block" type="submit" value="注册" ></input></li>
							</ul>
						</form>
					</div>
					<div class="col-md-4">

						<div class="tab-content">
							
							<div id="OWNER" style="display: none" >
							
							<form action="${pageContext.request.contextPath}/User/register.do" method="post" enctype="multipart/form-data" onsubmit="return checkotherinfo()" >  
								上传营业执照<input type="file" name="file" />
								<!--  <input type="submit" value="提交" /> -->
							</form>
							
							
							</div>
							<div id="DRIVER" style="display: none" >hello driver</div>
						

						</div>
					</div>
				</div>
			</div>
		</div>
</div>

	<script type="text/javascript" src="../common/js/bootstrap.min.js"></script>	
</body>
</html>