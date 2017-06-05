<%@page import="com.neusoft.cargo.entity.User.UserType"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<link href="static/css/default_theme.css" rel="stylesheet"
	type="text/css">
<link href="_CarGoDistribution/../static/css/font-awesome.min.css"
	rel="stylesheet" />
<link rel="stylesheet" media="screen" href="static/css/general.css">
<link rel="stylesheet" media="screen" href="static/css/b1njTimeline.css">

<title>用户资料</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<div class="row">
							<jsp:include page="../include/head.jsp"></jsp:include>
						</div>

						<div
							class="easyui-panel panel-body panel-body-noheader panel-body-noborder"
							id="control" data-options="fit:true,border:false" title="">
							<div class="theme-user-info-panel">
								<div class="left">
									<img src="userfiles/avatar/${user.img}" width="86" height="86">
								</div>
								<div class="right">
									<ul>
										<li class="text-success">￥0<span>收益总额</span></li>
										<li class="text-info">${user.rate}<span>我的信用</span></li>
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
									<c:set var="driver" value="<%=UserType.DRIVER%>"></c:set>
									<c:set var="owner" value="<%=UserType.OWNER%>"></c:set>
									<c:if test="${utype eq driver }">
										<h2>车主</h2>
									</c:if>
									<c:if test="${utype eq owner }">
										<h2>货主</h2>
									</c:if>
									<dl>
										<dt>${user.email}</dt>
										<dd>${user.phone}</dd>
									</dl>
								</div>

							</div>
						</div>
						<div id="page">
						
							<ol id="timeline">
								<c:forEach var="order" items="${orders}">
									<li><time datetime="${order.createTime}">${order.createTime}</time>
										<p>${order.cResource.goodName}</p>
										<div class="description">
											<p>${user.rate}</p>
										</div></li>
								</c:forEach>

							
							</ol>
						</div>

					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/moment.min.js"></script>
	<script src="static/js/jquery.b1njTimeline.js"></script>
	<script>
		$(function() {
			$('#timeline').b1njTimeline({
				'height' : 100
			});

		});
	</script>
</body>


</html>