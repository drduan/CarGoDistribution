<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>空车配货信息系统首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="_CarGoDistribution/../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../static/css/font-awesome.min.css"
	rel="stylesheet" />



<style type="text/css">
.navbar {
	position: relative;
	min-height: 20px;
	margin-bottom: 10px;
	border: 1px solid transparent;
}
</style>
<script src="../static/js/jquery.validate.min.js"></script>
</head>
<body>

	<div class="container-fluid" style="background: ddddd">

		<!--  background-image: url(resources/images/index_car.png) -->
		<div class="row">

			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid">
					<jsp:include page="../include/head.jsp"></jsp:include>
					
				</div>
				<div class="col-md-12">
					<div class="jumbotron">
						<h2>空车配货网</h2>
						<p>中国物通网是中国专业的物流信息网，是中国物流信息最全面、社会需求面最广、
							实用性最强的物流行业网站，免费提供物流信息发布及货运信息查询、物流查询服务的一站式发货平台。</p>
					</div>
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<table class="table" title="附近的货源">

								<tbody title="附近的货源">
									<c:if test="${not empty resource}">
										<div class="row">附近的货源</div>
									</c:if>
									<c:if test="${empty resource }">
										<div class="row">附近没有货源</div>
									</c:if>
									<c:forEach var="resource" items="${resource}">

										<tr>
											<td><img class="img-circle" width="100" height="100"
												alt="alt" src="<%=request.getContextPath()%>/userfiles/avatar/${resource._user.img}"> <br> <b class="text-center">${resource.contact}</b></td>
											<td>
												<h1 style="color: #333; font-size: 14px; font-weight: 700">从
													${resource.departurePlace} 到 ${resource.destPlace}</h1> <span
												class="price" style="font-size: 18px">运费：${resource.weightFate}</span><br>
												<span class="help-block" style="font-size: 80%">重量 ${resource.weight} 吨;体积 ${resource.capacity} 立方米</span>

											</td>
											<td>发布时间： 01/04/2012</td>
											<td><shiro:authenticated>
													<button name="pre_submit"
														onClick="window.location=('bookresource.do?idname=${resource.carresourceid}')"
														type="button" class="btn btn-default">预约订单</button>

												</shiro:authenticated> <shiro:notAuthenticated>

													<button id="modal-302051" href="#modal-container-302051"
														type="button" class="btn btn-default" data-toggle="modal">预约订单</button>

												</shiro:notAuthenticated></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
						<div class="col-md-3"></div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>

		</div>
	</div>

	<jsp:include page="../include/foot.jsp"></jsp:include>
	<!-- 各种模态框 -->


	<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>