<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script src="static/js/jquery.validate.min.js"></script>
<script src="static/js/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投诉反馈</title>
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
							<label><a href="comresult.do">查看投诉结果</a></label>
						</div>

						<form class="form-horizontal" role="form" action="complaints.do"
							method="post">
							<div class="form-group">

								<label for="inputEmail3" class="col-sm-2 control-label">
									投诉反馈类型 </label>
								<div class="col-sm-10">
									<select name="comptype">
										<option value="0">货物违禁</option>
										<option value="1">投诉货主</option>
										<option value="2">投诉车主</option>

									</select>
								</div>
							</div>

							<div class="form-group">

								<label for="inputEmail3" class="col-sm-2 control-label">
									订单号</label>
								<div class="col-sm-10">
									<input class="form-control" type="number"
										placeholder="若无则填写无" name="uuid" required />
								</div>
							</div>
							<div class="form-group">

								<label for="inputPassword3" class="col-sm-2 control-label">
									运品编码 </label>
								<div class="col-sm-10">
									<input name="ypbm" placeholder="若无则填写无" type="number"
										class="form-control" id="inputPassword3" required />
								</div>
							</div>

							<div class="form-group">

								<label for="inputPassword3" class="col-sm-2 control-label">
									投诉内容 </label>
								<div class="col-sm-10">
									<textarea name="Content" class="form-control"
										id="inputPassword3" required>
									</textarea>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">

									<button type="submit" class="btn btn-default">提交</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>