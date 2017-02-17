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
<link rel="stylesheet" href="../common/css/bootstrap.min.css" />
<script type="text/javascript" src="../common/js/jquery-3.1.1.min.js"></script>
<script src="../common/js/jquery.validate.min.js"></script>
<script src="../common/js/messages_zh.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=uope2aX3CaeidDG0xETWGcW7jmcOdYwP"></script>
<script type="text/javascript">
	// 百度地图API功能
	function myFun(result) {
		var map = new BMap.Map("allmap");
		var cityName = result.name;
		//alert("当前定位城市:"+cityName);
		document.getElementsByName("tbArea").value = ""+cityName;
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);
</script>

<script type="text/javascript">
$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
    }
});
$().ready(function() {
    $("#commentForm").validate();
});


</script>
<title>欢迎注册-中国货运物流信息平台-第二步</title>
</head>
<body>

	<div class="container-fluid">
		
		<jsp:include page="../head.jsp"></jsp:include>
		<input name="UserType" value="1" style="display: none" >
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
										<form action="register.do" method="post" dir="ltr" id="commentForm" 
											>
											<!-- onsubmit="return check();" -->
											<table id="Table1" cellpadding="0" cellspacing="0"
												width="100%" border="0" align="center"
												style="margin-top: 10px;">
												<tbody>
													<tr>
														<td align="right" width="220" height="40"><span
															class="font14">会员登录名：</span> <span
															style="color: #FF0000; font-size: 18px;">*</span></td>
														<td align="left">
														
														
														
														<input name="username" type="text"
															id="username" class="textBox1"
															
															 minlength="2"
															 
															onblur="return CheckingUser(this)"
															tooltiptext="
															<ul><li>由4-18个字母或数字组成（不区分大小写）</li><li>不能用中文，注册成功后不可修改</li></ul>"
															style="ime-mode: disabled" iserror="true"  required>
															
															
															 <img
															src="http://www.chinawutong.com/images/true.gif"
															style="visibility: hidden"></td>

													</tr>
													<tr>
														<td align="right" height="45"><span class="font14">输入登录密码：</span>
															<span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left">
														<input name="password"
															type="password" id="password" class="textBox1"
															 required>
														</td>
													</tr>
													<tr>
														<td align="right" height="45"><span class="font14">确认登录密码：
														</span><span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left">
														<input name="tbEnterPwd"
														minlength="8"
															type="password" id="tbEnterPwd" class="textBox1"
															required></td>
													</tr>

													<tr style="display: none;" >
														<td height="45" align="right"><span class="font14"><label
																id="lbname">车辆所有人</label>：</span> <span
															style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left">
														<input name="tbRegMan"
															type="text" id="tbRegMan" class="textBox1"
															minlength="2" required>
															</td>
													</tr>

													<tr>
														<td height="45" align="right"><span class="font14">注册人手机：</span>
															<span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left"><input name="phone"
															type="text" id="tbRegTel" class="textBox1"
															onblur=""
															tooltiptext="<ul><li>请填写正确的电话号码</li></ul>"> </td>
													</tr>
													<tr >
														<td height="45" align="right"><span class="font14">注册人邮箱：</span>
														</td>
														<td height="45" align="left"><input name="email"
															type="text" id="email" class="textBox1"
															onblur="return CheckingRegMail(this)"
															tooltiptext="<ul><li>请填写有效、常用的邮箱，便于找回密码</li></ul>">
															</td>
													</tr>

													<tr>

													</tr>

													<tr style="display: none;" >
														<td height="45" align="right"><span class="font14"><label
																id="lbArea">车辆所属地</label>：</span><span
															style="color: #FF0000; font-size: 18px">*</span></td>
														

														<td><input name="tbArea" type="text" id="tbArea"
															class="textBox1" /></td>



													</tr>

													<tr>
														<td height="45" align="right"><span class="font14">推荐人：&nbsp;</span>
														</td>
														<td height="45" align="left"><input name="tbtuijian"
															type="text" id="tbtuijian" class="textBox1"
															onkeyup="getval(event)" autocomplete="off"
															onblur="return CheckingRegTel(this)"
															tooltiptext="<ul id='tjr'><li>如没有推荐人，此栏可以不填。</li></ul>">
															</td>
													</tr>





													<tr>
														<td height="45" align="right"><span class="font14">手机验证码：</span>
															<span style="color: #FF0000; font-size: 18px">*</span></td>
														<td height="45" align="left">
															<table border="0" cellspacing="0" cellpadding="0">
																<tbody>
																	<tr>
																		<td><input name="tbValidCode" type="text"
																			id="tbValidCode" class="textBox1"
																			tooltiptext="<ul><li>请准确填写验证码。</li></ul>"
																			offset="120" style="width: 90px;"></td>
																		<td><style type="text/css">
.thehuoquon, .thehuoquoff {
	width: 100px;
	height: 22px;
	line-height: 22px;
	border: 0px;
}

.thehuoquon {
		no-repeat 0 0;
	cursor: pointer;
	color: #BC1402
}


</style> <input id="bt_GetPhoneCode" class="thehuoquon" type="button"
																			value="获取短信验证码" onclick="GetPhoneCode(this)">
																			<input id="hdPrePhone" value="" type="hidden">
																			<input id="hdCodeType" value="sms" type="hidden">
																		</td>
																		<td style="padding-left: 5px;"><input
																			name="tbType" type="text" value="车主" id="tbType"
																			class="textBox1" style="display: none"></td>
																	</tr>
																</tbody>
															</table>
														</td>
													</tr>
													<tr>
														<td align="right"></td>
														<td align="left" height="15"><div id="outmsg"
																class="outmsg" style="display: none">
																<span id="Phone_bottom" class="disline"
																	style="color: #666666"></span><span id="Phone_top"
																	class="disline" style="color: #666666"></span>
															</div></td>
													</tr>
													<tr>
														<td></td>
														<td align="left"><div class="font1"
																style="padding-left: 10px;">
																<input type="submit" name="btReg" value="注册"
																	onclick="return FinishChecking(this);" id="btReg"
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

	<script type="text/javascript" src="../common/js/bootstrap.min.js"></script>
</body>
</html>