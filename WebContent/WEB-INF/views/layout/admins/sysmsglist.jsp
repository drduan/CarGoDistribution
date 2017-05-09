<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="/_CarGoDistribution/static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/_CarGoDistribution/static/css/font-awesome.min.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息列表</title>
</head>
<body>



	<div class="container-fluid">


		<div class="row">

			<div class="col-md-1"></div>
			<div class="col-md-10">
				<jsp:include page="head.jsp"></jsp:include>
				<c:if test="${not empty msglist}">
					<div class="row">消息</div>



				</c:if>
				<c:if test="${empty msglist }">
					<div class="row">没有消息</div>
				</c:if>


				<c:forEach var="msglist" items="${msglist}">

					<c:if test="${msglist.status}">
						<div class="alert alert-success alert-dismissable">
							<p />

							消息内容:<a href="adminprofile.do">${msglist.content} </a>

							<p />
							<a class="markasread" href="#">已读</a>

						</div>
					</c:if>
					<c:if test="${!msglist.status}">
						<div class="alert alert-dismissable alert-warning">
							<p />
							消息内容:<a href="">${msglist.content} </a>
							<p />
							<a class="markasread" href="markasread.do?id=${msglist.id}">标为已读</a>
						</div>
					</c:if>





				</c:forEach>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="../static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>

</body>
</html>