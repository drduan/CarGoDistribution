<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="_CarGoDistribution/../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../static/css/font-awesome.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看投诉结果</title>
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




						<div class="row">
							<table class="table table-hover table-condensed table-bordered">
								<thead>
									<tr>
										<th>投诉ID</th>
										<th>运品编码</th>
										<th>投诉内容</th>
										<th>处理结果</th>

									</tr>
								</thead>

								<tbody>

									<c:forEach var="model" items="${model }">
										<tr>
											<td>${model.id }</td>
											<td>${model.ypbm }</td>
											<td>${model.content }</td>
											<td>${model.result }</td>
											<c:if test="${model.relateMan.locked eq true}">
												已经处理
										</c:if>
											<c:if test="${model.relateMan.locked eq false}">
												等待回复
										</c:if>
									</c:forEach>




								</tbody>

							</table>


						</div>


					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>