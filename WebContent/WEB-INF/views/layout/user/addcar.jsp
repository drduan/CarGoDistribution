<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加车辆</title>
<link href="_CarGoDistribution/../../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../../static/css/font-awesome.min.css"
	rel="stylesheet" />
</head>
<body>

	<div class="container-fluid" style="background: ddddd">

		<!--  background-image: url(resources/images/index_car.png) -->
		<div class="row">

			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid"> 
					<jsp:include page="../../include/head.jsp"></jsp:include>
					<form class="form-horizontal" role="form" action="../Car/InsertCarForUser.do" method="get" >
				<div class="form-group">
					 
					<label for="inputEmail3" class="col-sm-2 control-label">
						车牌号
					</label>
					<div class="col-sm-10">
						<input type="text" name="CarNumber" class="form-control" id="inputEmail3" />
					</div>
				</div>
				<div class="form-group">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						车主
					</label>
					<div class="col-sm-10">
						<input type="text"  name="CarHost" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						运费
					</label>
					<div class="col-sm-10">
						<input name="FreightRates" type="text" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						负载
					</label>
					<div class="col-sm-10">
						<input name="Capicity" type="text" class="form-control" id="inputPassword3" />
					</div>
				</div>
				
				<div class="form-group">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						车辆类型
					</label>
					<div class="col-sm-10">
						<input name="CarType" type="text" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						联系方式
					</label>
					<div class="col-sm-10">
						<input name="phone" type="text" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default">
							提交
						</button>
					</div>
				</div>
			</form>
				</div>
			</div>
			<div class="col-md-1">
			
			</div>
		</div>
		
		
	</div>

	<script type="text/javascript" src="../static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
</body>
</html>