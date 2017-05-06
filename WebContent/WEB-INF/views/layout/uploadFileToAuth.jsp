<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<title>身份验证</title>
</head>
<body>
<div class="container-fluid">
		<jsp:include page="../include/head.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-12">

	<form action="upload.do" method="post" enctype="multipart/form-data">
		<!--  货主 车主写一个吧 选择的时候  选择 车主认证还是货主认证 -->

		真实名字 <p>
		<input class="form-control" type="text" name="t_name"/><p>
		身份证号 <p>
		<input  class="form-control"  type="text" name="t_id"/><p>
		上传身份证 正反面 （上传企业营业执照）<p>

		<input  class="form-control"  type="file" name="file">
		<input class="form-control"   type="file" name="file">
			<h2>
			
			<input  class="form-control" class="btn" type="submit" value="提交"/>
		</h2>
	</form>
</div>
</div>
</div>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>