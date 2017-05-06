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

		<div class="row">

			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid">
					<jsp:include page="../../include/head.jsp"></jsp:include>

				</div>
				<div class="col-md-12">
					<div class="jumbotron">
						<h2>您好</h2>
						<p>中国物通网是中国专业的物流信息网，是中国物流信息最全面、社会需求面最广、
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
										<td></td>
										<td>TB - Monthly</td>
										<td>01/04/2012</td>
										<td>user/index</td>
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

	<jsp:include page="../../include/foot.jsp"></jsp:include>
	<!-- 各种模态框 -->


	<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>