<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../static/css/bootstrap.min.css" />
<script type="text/javascript" src="../static/js/jquery-3.1.1.min.js"></script>
<script src="../static/js/jquery.validate.min.js"></script>
<script src="../static/js/messages_zh.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=uope2aX3CaeidDG0xETWGcW7jmcOdYwP"></script>
<script type="text/javascript">
	// 百度地图API功能
	function myFun(result) {
		var map = new BMap.Map("allmap");
		var cityName = result.name;
		//alert("当前定位城市:"+cityName);
		document.getElementsByName("tbArea").value = "" + cityName;
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);
</script>

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

	$.validator.setDefaults({
		submitHandler : function() {

			alert("注册成功!");
			form.submit();
		}
	});

	
	
	$().ready(function() {
		$("#commentForm").validate({
			rules : {
				username : {
					required : true,
					minlength : 2
				},
				password : {
					required : true,
					minlength : 5,
				},
				confirm_password : {
					required : true,
					minlength : 5,
					 equalTo: "#password_id"
				},
				phone : {
					required : true,
					minlength : 11
				},
				email : {
					required : true,
					email : true,
					remote : {
						url : "ifuserexist.do",
						type : "post",
						data : {
							username : function() {
								return $("#username").val();
							}
						}
					}
				},
				validationCode : {
					required : true,
					remote : {
						url : "ifvalidationcode.do",
						type : "post",
						data : {
							username : function() {
								return $("#validationCode").val();
							}
						}
					}
				}
			},
		 messages: {
			 validationCode: {
                  required: "请填写验证码！",
                  remote: "验证码不正确 请重新填写！"　　　
              }
         }
		});

	})
</script>
<title>欢迎注册-速配网-第二步</title>
</head>
<body>

	<div class="container-fluid">

		<jsp:include page="../include/head.jsp"></jsp:include>
		<input name="UserType" value="1" style="display: none;"> <input
			name="tbArea" value="" style="display: none;">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">

						<div class="tabbable" id="tabs-91824">
							<ul class="nav nav-tabs">
								<li><a href="" data-toggle="tab">1. 选择会员类型</a></li>
								<li class="active"><a href="#" data-toggle="tab">2.填写账户信息</a></li>
							</ul>
							<div class="tab-content">
								<div id="panel-924786" class="tab-pane"></div>
								<div class="tab-pane active" id="panel-585601">
									<div>
										<table width="882" border="0" cellspacing="0" cellpadding="0">
											<tbody>
												<tr>
													<td height="28" align="left" valign="top"><font
														color="black" style="font-size: 14px;">&nbsp;感谢您注册&nbsp;


															<c:if test="${usertype eq 1}">
																<font color="red">车主会员</font>，&nbsp;
</c:if> <c:if test="${usertype eq 2}">
																<font color="red">货主会员</font>，&nbsp;
</c:if> 请您准确填写注册信息。如需改变注册会员类型，
															<p>
																&nbsp;请点击&nbsp;<a
																	href="<%=request.getContextPath()%>/User/register_step1.jsp"
																	style="color: red; text-decoration: underline">上一步</a>选择会员类型！




															
													</font></td>
												</tr>



												<tr>
													<td align="left"><span
														style="font-size: 14px; font-weight: bold;">填写您的帐户信息</span>
													</td>
												</tr>


											</tbody>
										</table>

										<!-- todo -->
										<form action="owner_register.do" method="post" dir="ltr"
											id="commentForm" >
											<table id="Table1" cellpadding="0" cellspacing="0"
												width="100%" border="0" align="center"
												style="margin-top: 10px;">
												<tbody>
													<tr>
														<td align="right" width="220" height="40"><span
															class="font14">会员登录名：</span> <span
															style="color: #FF0000; font-size: 18px;">*</span></td>
														<td align="left"><input name="username" type="text"
															id="username" class="textBox1" minlength="2" onblur=""
															required></td>

													</tr>
													<tr>
														<td align="right" height="45"><span class="font14">输入登录密码：</span>
															<span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left">
														<input id="password_id" name="password"  type="password" required>
														</td>
													</tr>
													<tr>
														<td align="right" height="45"><span class="font14">确认登录密码：
														</span><span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left">
														<input id="confirm_password"  name="confirm_password" type="password" required>
															</td>
													</tr>



													<tr>
														<td height="45" align="right"><span class="font14">注册人手机：</span>
															<span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left"><input name="phone"
															type="text" id="phone" class="phone"></td>
													</tr>
													<tr>
														<td height="45" align="right"><span class="font14">注册人邮箱：</span><span
															style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left"><input name="email"
															id="email"></td>
													</tr>

													<tr>

													</tr>



													<tr>
														<td height="45" align="right"><span class="font14">推荐人：&nbsp;</span>
														</td>
														<td height="45" align="left"><input name="tbtuijian"
															type="text" id="tbtuijian" class="textBox1"></td>
													</tr>


													<tr>
														<td height="45" align="right"><span class="font14">验证码&nbsp;</span>
														</td>
														<td height="45" align="left"><img id="validationCode"
															alt="验证码图片" title="验证码图片"
															src="<%=request.getContextPath()%>/validationCodeServlet.png"
															onclick="refreshCode(this)" /></td>
													</tr>
													<tr>
														<td align="right"></td>
														<td align="left"><input type="text"
															name="validationCode" placeholder="请输入验证码" class="active" />
														</td>


													</tr>









													<tr>
														<td></td>
														<td align="left"><div class="font1"
																style="padding-left: 10px;">
																<input type="submit" name="btReg" value="注册" id="btReg"
																	class="btn btn-primary">
																<p
																	style="width: 146px; text-align: center; font-size: 12px; line-height: 30px;">
																	<a href="http://www.chinawutong.com/agreement.aspx"
																		target="_blank"><font color="#333">《物通网使用条款与协议》</font></a>
																</p>
															</div></td>
													</tr>
												</tbody>
											</table>
										</form>
									</div>





								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
</body>
</html>