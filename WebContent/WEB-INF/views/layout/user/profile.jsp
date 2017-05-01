<%@page import="com.neusoft.cargo.entity.TrackOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.neusoft.cargo.entity.OrderType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- https://www.insdep.com -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>

<link rel="stylesheet" type="text/css"
	href="../static/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="../static/css/default.css">

<link href="../static/css/bootstrap.min.css" rel="stylesheet" />
<link href="../static/css/font-awesome.min.css" rel="stylesheet" />
<!-- -->
<link href="../static/css/easyui.css" rel="stylesheet" />
<link href="../static/css/icon.css">
<link href="https://cdn.insdep.com/themes/1.0.0/default_theme.css"
	rel="stylesheet" type="text/css">




<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
	width: 100%;
	/*height: 100%;*/
	font-family: 'Raleway';
}

ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

.icon {
	position: relative;
	width: 32px;
	height: 32px;
	display: block;
	fill: rgba(51, 51, 51, 0.5);
	margin-right: 20px;
	-webkit-transition: all .2s ease-out;
	transition: all .2s ease-out;
}

.icon.active {
	fill: #E74C3C;
}

.icon.big {
	width: 64px;
	height: 64px;
	fill: rgba(51, 51, 51, 0.5);
}

#wrapper {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 700px;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-align: center;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: left;
	-webkit-justify-content: left;
	-ms-flex-pack: left;
	justify-content: left;
	overflow: hidden;
}

#left-side {
	height: 70%;
	width: 25%;
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-align: center;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
}

#left-side ul li {
	padding-top: 10px;
	padding-bottom: 10px;
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	line-height: 34px;
	color: rgba(51, 51, 51, 0.5);
	font-weight: 500;
	cursor: pointer;
	-webkit-transition: all .2s ease-out;
	transition: all .2s ease-out;
}

#left-side ul li:hover {
	color: #333333;
	-webkit-transition: all .2s ease-out;
	transition: all .2s ease-out;
}

#left-side ul li:hover>.icon {
	fill: #333;
}

#left-side ul li.active {
	color: #333333;
}

#left-side ul li.active:hover>.icon {
	fill: #E74C3C;
}

#border {
	height: 288px;
	width: 1px;
	background-color: rgba(51, 51, 51, 0.2);
}

#border #line.one {
	width: 5px;
	height: 54px;
	background-color: #E74C3C;
	margin-left: -2px;
	margin-top: 35px;
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out;
}

#border #line.two {
	width: 5px;
	height: 54px;
	background-color: #E74C3C;
	margin-left: -2px;
	margin-top: 89px;
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out;
}

#border #line.three {
	width: 5px;
	height: 54px;
	background-color: #E74C3C;
	margin-left: -2px;
	margin-top: 143px;
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out;
}

#border #line.four {
	width: 5px;
	height: 54px;
	background-color: #E74C3C;
	margin-left: -2px;
	margin-top: 197px;
	-webkit-transition: all .4s ease-in-out;
	transition: all .4s ease-in-out;
}

#right-side {
	height: 300px;
	width: 75%;
	overflow: hidden;
}

#right-side #first, #right-side #second, #right-side #third, #right-side #fourth
	{
	position: absolute;
	height: 300px;
	width: 75%;
	-webkit-transition: all .6s ease-in-out;
	transition: all .6s ease-in-out;
	margin-top: -350px;
	opacity: 0;
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-align: center;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center; -webkit-box-orient : vertical;
	-webkit-box-direction: normal;
	-webkit-flex-direction: column;
	-ms-flex-direction: column;
	flex-direction: column;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	-webkit-box-orient: vertical;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	-webkit-box-orient: vertical;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	-webkit-box-orient: vertical;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	-webkit-box-orient: vertical;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	-webkit-box-orient: vertical;
	-ms-flex-pack: center;
	justify-content: center;
	-webkit-box-orient: vertical;
	justify-content: center;
	-webkit-box-orient: vertical;
	-webkit-box-orient: vertical;
}

#right-side #first h1, #right-side #second h1, #right-side #third h1,
	#right-side #fourth h1 {
	font-weight: 800;
	color: #333;
}

#right-side #first p, #right-side #second p, #right-side #third p,
	#right-side #fourth p {
	color: #333;
	font-weight: 500;
	padding-left: 30px;
	padding-right: 30px;
}

#right-side #first.active, #right-side #second.active, #right-side #third.active,
	#right-side #fourth.active {
	margin-top: 0px;
	opacity: 1;
	-webkit-transition: all .6s ease-in-out;
	transition: all .6s ease-in-out;
}
</style>

<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/jquery.easyui.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>


</head>

<body>

	<script type="text/javascript">
		
	</script>



	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12">

						<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
						<div
							class="easyui-panel panel-body panel-body-noheader panel-body-noborder"
							id="control" data-options="fit:true,border:false" title="">
							<div class="theme-user-info-panel">
								<div class="left">
									<img src="../userfiles/avatar/${user.img}" width="86"
										height="86">
								</div>
								<div class="right">
									<ul>
										<li class="text-success">￥0<span>收益总额</span></li>
										<li class="text-info">100<span>我的信用</span></li>
										<li>优秀<span>信誉评级</span></li>
									</ul>
								</div>
								<div class="center">
									<h1>${user.username}

										<c:if test="${user.hasauthentication}">
											<span class="badge color-success"> 已认证 </span>
										</c:if>
										<c:if test="${not user.hasauthentication}">
											<span class="badge color-failed"> <a
												href="../authentication.do">未认证</a>
											</span>
										</c:if>

									</h1>
									<h2>车主</h2>
									<dl>
										<dt>${user.email}</dt>
										<dd>${user.phone}</dd>
									</dl>
								</div>

							</div>
						</div>
					</div>
				</div>


				<!-- ICONS -->
				<div class="row">
					<div id="wrapper">
						<div id="left-side">
							<ul>
								<li class="choose active">
									<div class="icon active"></div> 我的车源
								</li>
								<li class="pay">
									<div class="icon"></div> 我的订单
								</li>
								<!-- 
								<li class="wrap">
									<div class="icon"></div> 我的订单
								</li>
								<li class="ship">
									<div class="icon"></div> 我的订单
								</li>
								 -->
							</ul>
						</div>

						<div id="border">
							<div id="line" class="one"></div>
						</div>

						<div id="right-side">
							<div id="first" class="active">

								<c:if test="${empty carsource}">
									<div class="row">没有车辆</div>
								</c:if>
								<c:if test="${not  empty carsource}">
									<table class="table table-hover table-condensed table-bordered">
										<caption>
											<button class="btn btn-xs btn-primary pull-right"
												id="modal-111082" role="button" type="button"
												data-toggle="modal">删除车辆信息</button>
										</caption>
										<thead>
											<tr>
												<th>选择</th>
												<th>ID</th>
												<th>车辆状态</th>
												<th>车牌号</th>
												<th>联系方式</th>
												<th>车主</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="carsource" items="${carsource}">
												<tr class="danger">
													<td><input type="checkbox" name="bb" value="${carsource.carid}" /></td>
													<td>${carsource.carid}</td>
													<c:if test="${carsource.carStatus eq false}">

														<td>可以使用</td>
													</c:if>
													<c:if test="${carsource.carStatus ne false}">

														<td>正在运输中</td>
													</c:if>

													<td>${carsource.carNumber}</td>
													<td>${carsource.phone}</td>
													<td>${carsource.carHost}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:if>
							</div>
							<div id="second">
								<div class="icon big"></div>


								<c:if test="${empty orders}">
									<div class="row">没有车辆</div>
								</c:if>
								<c:if test="${not  empty orders}">
									<table class="table table-hover table-condensed table-bordered">
										<caption>
											<button class="btn btn-xs btn-primary pull-right"
												id="modal-111081" role="button" type="button"
												data-toggle="modal">更新订单状态</button>
										</caption>
										<thead>
											<tr>
												<th>选择</th>
												<th>ID</th>
												<th>订单状态</th>
												<th>订单号</th>
												<th>联系人</th>
												<th>联系方式</th>
												<th>订单时间</th>
											</tr>
										</thead>
										<tbody>
											<c:set var="paid" value="<%=OrderType.PAID%>"></c:set>
											<c:set var="not_paid" value="<%=OrderType.NOT_PAID%>"></c:set>
											<c:forEach var="orders" items="${orders}">
												<tr class="danger">
													<td><input type="checkbox" id="orderid"
														value="${orders.uuid}" name="aa" onclick="" /></td>
													<td>${orders.id	}</td>

													<c:if test="${orders.orderType eq paid}">
														<td><select disabled="disabled">
																<option>已经支付，等待货主通过</option>
														</select></td>
													</c:if>
													<c:if test="${orders.orderType eq not_paid}">
														<td><select disabled="disabled">
																<option>订单已经被取消</option></td>
													</c:if>
													<td>${orders.uuid}</td>
													<td>${orders.cResource.contact}</td>
													<td>${orders.cResource.phone}</td>
													<td>${orders.createTime}</td>
												</tr>

											</c:forEach>
										</tbody>
									</table>
								</c:if>
							</div>
							<div id="third">
								<div class="icon big"></div>

								<h1>We will wrap it</h1>

								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Donec at viverra est, eu finibus mauris. Quisque tempus
									vestibulum fringilla. Morbi tortor eros, sollicitudin eu arcu
									sit amet, aliquet sagittis dolor.</p>

							</div>
							<div id="fourth">
								<div class="icon big"></div>

								<h1>Ship it</h1>

								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Donec at viverra est, eu finibus mauris. Quisque tempus
									vestibulum fringilla. Morbi tortor eros, sollicitudin eu arcu
									sit amet, aliquet sagittis dolor.</p>

							</div>
						</div>
					</div>
				</div>

				<script>
					$('.choose').click(function() {
						$('.choose').addClass('active');
						$('.choose > .icon').addClass('active');
						$('.pay').removeClass('active');
						$('.wrap').removeClass('active');
						$('.ship').removeClass('active');
						$('.pay > .icon').removeClass('active');
						$('.wrap > .icon').removeClass('active');
						$('.ship > .icon').removeClass('active');
						$('#line').addClass('one');
						$('#line').removeClass('two');
						$('#line').removeClass('three');
						$('#line').removeClass('four');
					});
					$('.pay').click(function() {
						$('.pay').addClass('active');
						$('.pay > .icon').addClass('active');
						$('.choose').removeClass('active');
						$('.wrap').removeClass('active');
						$('.ship').removeClass('active');
						$('.choose > .icon').removeClass('active');
						$('.wrap > .icon').removeClass('active');
						$('.ship > .icon').removeClass('active');
						$('#line').addClass('two');
						$('#line').removeClass('one');
						$('#line').removeClass('three');
						$('#line').removeClass('four');
					});
					$('.wrap').click(function() {
						$('.wrap').addClass('active');
						$('.wrap > .icon').addClass('active');
						$('.pay').removeClass('active');
						$('.choose').removeClass('active');
						$('.ship').removeClass('active');
						$('.pay > .icon').removeClass('active');
						$('.choose > .icon').removeClass('active');
						$('.ship > .icon').removeClass('active');
						$('#line').addClass('three');
						$('#line').removeClass('two');
						$('#line').removeClass('one');
						$('#line').removeClass('four');
					});
					$('.ship').click(function() {
						$('.ship').addClass('active');
						$('.ship > .icon').addClass('active');
						$('.pay').removeClass('active');
						$('.wrap').removeClass('active');
						$('.choose').removeClass('active');
						$('.pay > .icon').removeClass('active');
						$('.wrap > .icon').removeClass('active');
						$('.choose > .icon').removeClass('active');
						$('#line').addClass('four');
						$('#line').removeClass('two');
						$('#line').removeClass('three');
						$('#line').removeClass('one');
					});
					$('.choose').click(function() {
						$('#first').addClass('active');
						$('#second').removeClass('active');
						$('#third').removeClass('active');
						$('#fourth').removeClass('active');
					});
					$('.pay').click(function() {
						$('#first').removeClass('active');
						$('#second').addClass('active');
						$('#third').removeClass('active');
						$('#fourth').removeClass('active');
					});
					$('.wrap').click(function() {
						$('#first').removeClass('active');
						$('#second').removeClass('active');
						$('#third').addClass('active');
						$('#fourth').removeClass('active');
					});
					$('.ship').click(function() {
						$('#first').removeClass('active');
						$('#second').removeClass('active');
						$('#third').removeClass('active');
						$('#fourth').addClass('active');
					});
				</script>

			</div>
			<div class="col-md-1"></div>
		</div>
	</div>


	<div class="modal fade" id="modal-container-111081" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body" id="modal-body"></div>
				<div class="modal-footer">

					<button type="button" class="btn btn-default" data-dismiss="modal">
						Close</button>
					<button type="button" class="btn btn-primary">Save changes
					</button>
				</div>
			</div>

		</div>

	</div>
	<script type="text/javascript">
		$("#modal-111081").click(function() {
			var obj = document.getElementsByName("aa");
			var len = 0;
			var checkedobj;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].checked == true) {
					checkedobj = obj[i];
					++len;
				}
			}
			if (len > 1) {
				alert("只能编辑一项内容");
				return;
			}
			if (len < 1) {
				alert("请选择一项内容");
				return;
			}
			/*else {
				/*  htmlobj=$.ajax({url:"orderdetail.do?orderid="+checkedobj.value,dataType: "json",async:false});
				 alert(htmlobj.responseText); */
			/* $('#modal-container-111081').modal({
				show : true,
				backdrop : true
			});*/

			/*	console.log('${orders[0].uuid}');
			}*/
		});
		
		
		$("#modal-111082").click(function() {
			var obj = document.getElementsByName("bb");
			var len = 0;
			var checkedobj;
			for (var i = 0; i < obj.length; i++) {
				if (obj[i].checked == true) {
					checkedobj = obj[i];
					++len;
				}
			}
			if (len > 1) {
				alert("只能删除一项内容");
				return;
			}
			if (len < 1) {
				alert("请选择一项内容");
				return;
			}
			
			htmlobj=$.ajax({url:"../Car/delcar.do?carid="+checkedobj.value,dataType: "json",async:false});
			 if(htmlobj.responseText == 'success')
				 {
				 location.reload()
				 }
			 else
				 {
				 alert("稍后重试");
				 }
		});
		
	</script>
</body>

</html>