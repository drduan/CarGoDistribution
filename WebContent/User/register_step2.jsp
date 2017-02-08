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
<title>欢迎注册-中国货运物流信息平台-第二步</title>
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="../head.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">

						<div class="tabbable" id="tabs-91824">
							<ul class="nav nav-tabs">
								<li><a href="#" data-toggle="tab">1. 选择会员类型</a></li>
								<li class="active"><a href="#" data-toggle="tab">2.
										填写账户信息</a></li>
							</ul>
							<div class="tab-content">
								<div id="panel-924786" class="tab-pane">
									<p>
									<form action="#" method="post">

										<table>
											<tbody>
												<tr>
													<td colspan="4" align="left">尊敬的用户，欢迎您注册中国物通网会员。首先，<font
														color="#FF0000">请选择适合的会员类型注册</font>
													</td>
												</tr>
												<tr>
													<td colspan="4" height="13"
														onmouseover="this.bgColor='#FFF9ED'"
														onmouseout="this.bgColor='#f5fafe'" bgcolor="#f5fafe">
														<table width="100%">
															<tbody>
																<tr>
																	<td align="left" width="32"><strong> <input
																			value="车主" name="cust_kind" type="radio" id="chezhu"></strong>
																	</td>
																	<td align="left" class="px14" width="120"><strong>车&nbsp;&nbsp;&nbsp;&nbsp;主</strong>
																	</td>
																	<td height="45" align="left">
																		提供物流运输服务且具备营运资格的车队或个体车主。<br>
																		可免费发布车辆信息，线路信息，免费查询货源信息。
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>

												<tr>
													<td colspan="4" height="13"
														onmouseover="this.bgColor='#FFF9ED'"
														onmouseout="this.bgColor='#e9f5fe'" bgcolor="#e9f5fe">
														<table width="100%">
															<tbody>
																<tr>
																	<td align="left" width="32"><strong> <input
																			value="货源提供商" name="cust_kind" type="radio"
																			id="huoyuan"></strong></td>
																	<td width="120" align="left" class="px14"><strong>发货企业或个人</strong>
																	</td>
																	<td height="45" align="left">需要发货的企业或个人。<br>
																		可免费发布国内外货物运输信息，免费查询运输车辆及物流公司信息。
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
												<tr>
													<td><input align="right" type="submit" name="bttreg"
														value="下一步" onclick="return Finish();" id="bttreg"
														class="btn btn-primary" /></td>
												</tr>

											</tbody>
										</table>


									</form>
								</div>
								<div class="tab-pane active" id="panel-585601">

									<!--  -->


									<div>
										<table width="882" border="0" cellspacing="0" cellpadding="0">
											<tbody>
												<tr>
													<td height="28" align="left" valign="top"><font
														color="black" style="font-size: 14px;">&nbsp;感谢您注册&nbsp;

															${usertype}<font color="red">车主会员</font>，&nbsp;请您准确填写注册信息。如需改变注册会员类型，请点击&nbsp;<a
															href="reg.aspx"
															style="color: red; text-decoration: underline">上一步</a>选择会员类型！
													</font></td>
												</tr>

												<tr>
													<td align="left" height="28">
														<div style="padding-left: 16px; font-size: 14px;">
															<span class="regc">*&nbsp;</span>若您长时间收取不到验证信息，请拨打客服电话400-010-5656协助完成身份验证。
														</div>

													</td>
												</tr>
												<tr>
													<td align="left" height="28">
														<div style="padding-left: 16px; font-size: 14px;">
															<span class="regc">*&nbsp;</span>提醒：物流公司必须提供真实网点信息和具有物流公司的相关资质。
														</div>

													</td>
												</tr>
												<tr>
													<td align="left"><img src="img/tb.gif" width="11"
														height="11"> <span
														style="font-size: 14px; font-weight: bold;">填写您的帐户信息</span>
													</td>
												</tr>
												<tr>
													<td height="5"></td>
												</tr>
												<tr>
													<td height="1"
														style="border-bottom: 1px dashed #999999; background: url(img/xiaobiao.gif)">
													</td>
												</tr>
											</tbody>
										</table>
										<table id="Table1" cellpadding="0" cellspacing="0"
											width="100%" border="0" align="center"
											style="margin-top: 10px;">
											<tbody>
												<tr>
													<td align="right" width="220" height="40"><span
														class="font14">会员登录名：</span> <span
														style="color: #FF0000; font-size: 18px;">*</span></td>
													<td align="left"><input name="tbUserName" type="text"
														id="tbUserName" class="textBox1"
														onblur="return CheckingUser(this)"
														tooltiptext="<ul><li>由4-18个字母或数字组成（不区分大小写）</li><li>不能用中文，注册成功后不可修改</li></ul>"
														style="ime-mode: disabled" iserror="true"> <img
														src="images/true.gif" style="visibility: hidden"></td>
												</tr>
												<tr>
													<td align="right" height="45"><span class="font14">输入登录密码：</span>
														<span style="color: #FF0000; font-size: 18px">*</span></td>
													<td height="45" align="left"><input name="tbPwd"
														type="password" id="tbPwd" class="textBox1"
														onblur="return CheckingPwd(this)"
														tooltiptext="<ul id='ul_pass'><li>密码长度6～16个字符，字母区分大小写</li></ul>">
														<img src="images/true.gif" style="visibility: hidden">

													</td>
												</tr>
												<tr>
													<td align="right" height="45"><span class="font14">确认登录密码：
													</span><span style="color: #FF0000; font-size: 18px">*</span></td>
													<td height="45" align="left"><input name="tbEnterPwd"
														type="password" id="tbEnterPwd" class="textBox1"
														onblur="return CheckingEnterPwd(this)"
														tooltiptext="<ul id='ul_pass2'><li>请重复输入一次相同的登录密码</li></ul>">
														<img src="images/true.gif" style="visibility: hidden">
													</td>
												</tr>

												<tr>
													<td height="45" align="right"><span class="font14"><label
															id="lbname">车辆所有人</label>：</span> <span
														style="color: #FF0000; font-size: 18px">*</span></td>
													<td height="45" align="left"><input name="tbRegMan"
														type="text" id="tbRegMan" class="textBox1"
														onblur="return CheckingName(this)"
														tooltiptext="<ul><li>请填写您真实中文姓名</li></ul>"> <img
														src="images/true.gif" style="visibility: hidden"></td>
												</tr>

												<tr>
													<td height="45" align="right"><span class="font14">注册人手机：</span>
														<span style="color: #FF0000; font-size: 18px">*</span></td>
													<td height="45" align="left"><input name="tbRegTel"
														type="text" id="tbRegTel" class="textBox1"
														onblur="return CheckingRegTel(this)"
														tooltiptext="<ul><li>请填写正确的电话号码</li></ul>"> <img
														src="images/true.gif" style="visibility: hidden"></td>
												</tr>
												<tr style="display: none;">
													<td height="45" align="right"><span class="font14">注册人邮箱：</span>
													</td>
													<td height="45" align="left"><input name="tbRegMail"
														type="text" id="tbRegMail" class="textBox1"
														onblur="return CheckingRegMail(this)"
														tooltiptext="<ul><li>请填写有效、常用的邮箱，便于找回密码</li></ul>">
														<img src="images/true.gif" style="visibility: hidden">
													</td>
												</tr>

												<tr>

												</tr>

												<tr>
													<td height="45" align="right"><span class="font14"><label
															id="lbArea">车辆所属地</label>：</span><span
														style="color: #FF0000; font-size: 18px">*</span></td>
													<td height="45" align="left"><input name="tbArea"
														type="text" id="tbArea" class="textBox1"
														wtmap="{c:'tbArea',cb:true}" sheng="false"
														tooltiptext="<ul><li>请点击选择车辆所属地区</li></ul>"
														readonly="readonly"> <img src="images/true.gif"
														style="visibility: hidden"></td>
												</tr>

												<tr>
													<td height="45" align="right"><span class="font14">推荐人：&nbsp;</span>
													</td>
													<td height="45" align="left"><input name="tbtuijian"
														type="text" id="tbtuijian" class="textBox1"
														onkeyup="getval(event)" autocomplete="off"
														onblur="return CheckingRegTel(this)"
														tooltiptext="<ul id='tjr'><li>如没有推荐人，此栏可以不填。</li></ul>">
														<img src="images/true.gif" style="visibility: hidden">
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
																		tooltiptext="<ul><li>请准确填写验证码。</li></ul>" offset="120"
																		style="width: 90px;"></td>
																	<td><style type="text/css">
.outmsg {
	border: 1px solid #F6E0A4;
	background-color: #FFFAEE;
	padding: 8px;
	line-height: 22px;
	margin-left: 10px;
	width: 510px;
}

.outmsg .disline {
	display: block
}

.thehuoquon, .thehuoquoff {
	width: 100px;
	height: 22px;
	line-height: 22px;
	border: 0px;
}

.thehuoquon {
	background: url("http://www.chinawutong.com/images/telyanzheng.png")
		no-repeat 0 0;
	cursor: pointer;
	color: #BC1402
}

.thehuoquoff {
	background: url("http://www.chinawutong.com/images/telyanzheng.png")
		no-repeat 0 -23px;
	color: #999999
}
</style> <input id="bt_GetPhoneCode" class="thehuoquon" type="button"
																		value="获取短信验证码" onclick="GetPhoneCode(this)">
																		<input id="hdPrePhone" value="" type="hidden">
																		<input id="hdCodeType" value="sms" type="hidden">
																		<script type="text/javascript">
																			function GetPhoneCode(
																					obj) {

																				var phone = document
																						.getElementById("tbRegTel");
																				if (phone.value == '') {
																					alert("请先输入手机号码！");
																					// var phone = document.all ? document.all["tbRegTel"] : document.getElementById("tbRegTel");
																					tooltipObj
																							.Show(phone);
																					$(
																							"#tbRegTel")
																							.focus();
																					return false;
																				}

																				var noReg = CheckingRegTel(document
																						.getElementById("tbRegTel"));
																				if (!noReg) {
																					alert("手机号已存在，请更换其他手机号！");
																					return false;
																				}

																				var codeType = "sms";
																				//去掉语音验证
																				//var codeType = obj == null ? "voice" : "sms";
																				document
																						.getElementById("outmsg").style.display = "block";
																				var xhojb = new XmlHttp();
																				var url = "/ashx/GetPhoneCode1.ashx?ran="
																						+ Math
																								.random()
																						+ "&code="
																						+ phone.value
																						+ "&Kind=Reg";
																				if (codeType != null
																						&& codeType == "voice") {
																					url = "/ashx/GetPhoneCode1.ashx?ran="
																							+ Math
																									.random()
																							+ "&code="
																							+ phone.value
																							+ "&Kind=Reg&CodeType=voice";
																					document
																							.getElementById("hdCodeType").value = "sms";
																				} else {
																					url = "/ashx/GetPhoneCode1.ashx?ran="
																							+ Math
																									.random()
																							+ "&code="
																							+ phone.value
																							+ "&Kind=Reg&CodeType=sms";
																					//去掉语音验证
																					//document.getElementById("hdCodeType").value = "voice";
																				}
																				var result = xhojb
																						.DownloadString(url);

																				if (result == "3") {
																					document
																							.getElementById("Phone_bottom").innerHTML = "<font color='red'>您的手机号获取验证码过于频繁，请于24小时后重试。</font>";
																					return false;
																				} else if (result == "1") {
																					document
																							.getElementById("Phone_bottom").innerHTML = "<font color='red'>您的手机号获取验证码过于频繁，请1分钟后再试。</font>";
																					return false;
																				} else if (result == "4") {

																					document
																							.getElementById("Phone_top").innerHTML = "若该手机号无法接收验证信息，请拨打客服电话400-010-5656协助完成身份验证";
																					//document.getElementById("Phone_bottom").innerHTML = "验证码已发出，请注意查收短信，如果没有收到，您可以在<span id=\"timer\" style=\"color:red\">180</span>秒后要求系统重新发送";
																					if (codeType == "sms") {
																						document
																								.getElementById("bt_GetPhoneCode").className = "thehuoquoff";
																						document
																								.getElementById('bt_GetPhoneCode').disabled = true;
																						//去掉语音验证
																						// document.getElementById("hdCodeType").value = "voice";
																						// document.getElementById("Phone_bottom").innerHTML = "验证码已发出，请注意查收短信，如果没有收到，您可以在<span id=\"timer\" style=\"color:red\">60</span>秒后点击发送语音验证码";
																						document
																								.getElementById("Phone_bottom").innerHTML = "验证码已发出，请注意查收短信,您可以在<span id=\"timer\" style=\"color:red\">60</span>秒后点击重新获取验证码";
																						timer = document
																								.getElementById("timer");

																						countDown(60);

																					} else {
																						document
																								.getElementById("hdCodeType").value = "sms";
																						document
																								.getElementById("Phone_bottom").innerHTML = "<font style='color:#333'>语音验证码已发出，您将接收到电话为您播报验证码......</font>";
																						document
																								.getElementById("bt_GetPhoneCode").className = "thehuoquon";
																						document
																								.getElementById('bt_GetPhoneCode').disabled = false;
																					}

																				} else {
																					document
																							.getElementById("Phone_top").innerHTML = "若该手机号无法接收验证信息，请拨打客服电话400-010-5656协助完成身份验证";
																				}
																				return false;
																			}
																			var timerID = null;
																			var timer;
																			function countDown(
																					secs) {
																				timer.innerHTML = secs;
																				if (secs-- > 0) {
																					timerID = setTimeout(
																							"countDown("
																									+ secs
																									+ ")",
																							1000);
																				} else {
																					//document.getElementById("Phone_top").innerHTML = ""; 
																					//去掉语音验证

																					//if (document.getElementById("hdCodeType").value == "voice") {
																					//    document.getElementById("Phone_bottom").innerHTML = "<a class='a_voice' onclick='GetPhoneCode(null)' style='color:#f30'>没有收到验证码？点击获取<strong>语音验证码</strong></a>";
																					//}
																					//else {
																					//    document.getElementById("Phone_bottom").innerHTML = "请输入您收到的语音验证码";
																					//}

																					document
																							.getElementById("outmsg").style.display = "none";
																					document
																							.getElementById("bt_GetPhoneCode").className = "thehuoquon";
																					document
																							.getElementById('bt_GetPhoneCode').disabled = false;
																				}
																			}
																		</script></td>
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
															<input type="submit" name="btReg" value=""
																onclick="return FinishChecking(this);" id="btReg"
																class="buttontj">
															<p
																style="width: 146px; text-align: center; font-size: 12px; line-height: 30px;">
																<a href="agreement.aspx" target="_blank"><font
																	color="#333">《物通网使用条款与协议》</font></a>
															</p>
														</div></td>
												</tr>
											</tbody>
										</table>

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