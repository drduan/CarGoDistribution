<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>空车配货平台首页-I</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/font-awesome.min.css" rel="stylesheet"/>

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

			
			<div class="container-fluid" >
			<jsp:include page="../include/head.jsp"></jsp:include>
			<nav class="navbar .nav-divider" 
				role="navigation" style="background: #dddddd" >
				<div class="nav" style=" border-bottom: solid #ddddd 1px;padding-left: 0px;font-size: 12px" >
					<a class="first01" style="color: red" >分站</a> <a href="#"
						target="_blank">北京</a> <a href="#"
						target="_blank">上海</a> <a href="#"
						target="_blank">广东</a> <a href="#"
						target="_blank">浙江</a> <a href="#"
						target="_blank">江苏</a> <a href="#"
						target="_blank">天津</a> <a href="#"
						target="_blank">重庆</a> <a href="#"
						target="_blank">山西</a> <a href="#"
						target="_blank">山东</a> <a href="#"
						target="_blank">河南</a> <a href="#"
						target="_blank">四川</a> <a href="#"
						target="_blank">湖北</a> <a href="#"
						target="_blank">福建</a> <a href="#"
						target="_blank">陕西</a> <a href="#"
						target="_blank">湖南</a> <a href="#"
						target="_blank">云南</a> <a href="#"
						target="_blank">广西</a> <a href="#"
						target="_blank">安徽</a> <a href="#"
						target="_blank">河北</a> <a href="#"
						target="_blank">海南</a> <a href="#"
						target="_blank">辽宁</a> <a href="#"
						target="_blank">青海</a> <a href="#"
						target="_blank">吉林</a> <a href="#"
						target="_blank">甘肃</a> <a href="#"
						target="_blank">江西</a> <a href="#"
						target="_blank">黑龙江</a> <a href="#"
						target="_blank">内蒙古</a> <a href="#"
						target="_blank">宁夏</a> <a href="#"
						target="_blank">贵州</a> <span><a data-toggle="collapse"
						data-target="#demo">更多</a>
						<div id="demo" class="collapse out">
							<a href="#" target="_blank">香港</a>
							<a href="#" target="_blank">新疆</a>
							<a href="#" target="_blank">台湾</a> <a
								href="#" target="_blank">西藏</a> <a
								href="#" target="_blank">澳门</a>
						</div> </span>
				</div>
			</nav>
			</div>
			<div class="col-md-12">
				<div class="jumbotron"
					>
					<h2>Hello, world!</h2>
					<p>This is a template for a simple marketing or informational
						website. It includes a large callout called the hero unit and
						three supporting pieces of content. Use it as a starting point to
						create something more unique.</p>
					<p>
						<a class="btn btn-primary btn-large" href="#">Learn more</a>
					</p>
				</div>
				<div class="row">
					<div class="col-md-6">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>起点</th>
									<th>终点</th>
									<th>重量</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Default</td>
								</tr>
								<tr class="active">
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Approved</td>
								</tr>
								<tr class="success">
									<td>2</td>
									<td>TB - Monthly</td>
									<td>02/04/2012</td>
									<td>Declined</td>
								</tr>
								<tr class="warning">
									<td>3</td>
									<td>TB - Monthly</td>
									<td>03/04/2012</td>
									<td>Pending</td>
								</tr>
								<tr class="danger">
									<td>4</td>
									<td>TB - Monthly</td>
									<td>04/04/2012</td>
									<td>Call in to confirm</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-6">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>起点</th>
									<th>终点</th>
									<th>负载</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Default</td>
								</tr>
								<tr class="active">
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Approved</td>
								</tr>
								<tr class="success">
									<td>2</td>
									<td>TB - Monthly</td>
									<td>02/04/2012</td>
									<td>Declined</td>
								</tr>
								<tr class="warning">
									<td>3</td>
									<td>TB - Monthly</td>
									<td>03/04/2012</td>
									<td>Pending</td>
								</tr>
								<tr class="danger">
									<td>4</td>
									<td>TB - Monthly</td>
									<td>04/04/2012</td>
									<td>Call in to confirm</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="../include/foot.jsp"></jsp:include>
	<!-- 各种模态框 -->
	

	<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>