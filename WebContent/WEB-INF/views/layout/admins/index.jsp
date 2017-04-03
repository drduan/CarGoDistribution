<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>空车配货平台首页-I</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="_CarGoDistribution/../../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../../static/css/font-awesome.min.css"
	rel="stylesheet" />



<style type="text/css">
.navbar {
	position: relative;
	min-height: 20px;
	margin-bottom: 10px;
	border: 1px solid transparent;
} 
</style>
</head>
<body>

	<div class="container-fluid" style="background: ddddd">

		<!--  background-image: url(resources/images/index_car.png) -->
		<div class="row">

			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid">
					<jsp:include page="head.jsp"></jsp:include>
					<nav class="navbar .nav-divider" role="navigation"
						style="background: #dddddd">
						<div class="nav"
							style="border-bottom: solid #ddddd 1px; padding-left: 0px; font-size: 12px">
							<a class="first01" style="color: red">分站</a> <a href="#"
								target="_blank">北京</a> <a href="#" target="_blank">上海</a> <a
								href="#" target="_blank">广东</a> <a href="#" target="_blank">浙江</a>
							<a href="#" target="_blank">江苏</a> <a href="#" target="_blank">天津</a>
							<a href="#" target="_blank">重庆</a> <a href="#" target="_blank">山西</a>
							<a href="#" target="_blank">山东</a> <a href="#" target="_blank">河南</a>
							<a href="#" target="_blank">四川</a> <a href="#" target="_blank">湖北</a>
							<a href="#" target="_blank">福建</a> <a href="#" target="_blank">陕西</a>
							<a href="#" target="_blank">湖南</a> <a href="#" target="_blank">云南</a>
							<a href="#" target="_blank">广西</a> <a href="#" target="_blank">安徽</a>
							<a href="#" target="_blank">河北</a> <a href="#" target="_blank">海南</a>
							<a href="#" target="_blank">辽宁</a> <a href="#" target="_blank">青海</a>
							<a href="#" target="_blank">吉林</a> <a href="#" target="_blank">甘肃</a>
							<a href="#" target="_blank">江西</a> <a href="#" target="_blank">黑龙江</a>
							<a href="#" target="_blank">内蒙古</a> <a href="#" target="_blank">宁夏</a>
							<a href="#" target="_blank">贵州</a> <span><a
								data-toggle="collapse" data-target="#demo">更多</a>
								<div id="demo" class="collapse out">
									<a href="#" target="_blank">香港</a> <a href="#" target="_blank">新疆</a>
									<a href="#" target="_blank">台湾</a> <a href="#" target="_blank">西藏</a>
									<a href="#" target="_blank">澳门</a>
								</div> </span>
						</div>
					</nav>
				</div>
				<div class="col-md-12">
					<div class="jumbotron">
						<h2>您好</h2>
						<p>  中国物通网是中国专业的物流信息网，是中国物流信息最全面、社会需求面最广、
						实用性最强的物流行业网站，免费提供物流信息发布及货运信息查询、物流查询服务的一站式发货平台。找物流公司、找货源、发货配货就上中国物通网。</p>
						<p>
							<a class="btn btn-primary btn-large" href="#">Learn more</a>
						</p>
					</div>
					<div class="row">
						<div class="col-md-12">
							<table class="table" title="附近的货源">

								<tbody>


									<%
										for (int i = 0; i < 10; i++) {
									%>
									<tr>
										<td >
										<img alt="alt" src="/static/images/orange.png">
										</td>
										<td>TB - Monthly</td>
										<td>01/04/2012</td>
										<td>Default</td>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>

		</div>
	</div>

	<!-- 各种模态框 -->


	<script type="text/javascript" src="../static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
</body>
</html>