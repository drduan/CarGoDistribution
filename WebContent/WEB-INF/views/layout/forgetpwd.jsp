<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘记密码</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/js/jquery.imagecropper.js"></script>
<link href="_CarGoDistribution/../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../static/css/font-awesome.min.css"
	rel="stylesheet" />
<script src="static/js/jquery.validate.min.js"></script>
<script src="static/js/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<script>
$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
    }
});
$().ready(function() {
    $("#commentForm").validate();
});
</script>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<jsp:include page="../include/head.jsp"></jsp:include>
						<form id="commentForm" class="form-horizontal" role="form">
							<div class="form-group">

								<label for="inputEmail3" class="col-sm-2 control-label">
									邮箱 </label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="inputEmail3" required>
								</div>
							</div>
							<div class="form-group">

								<label for="inputPassword3" class="col-sm-2 control-label">
									输入验证码 </label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPassword3" minlength="5" required>
								</div>
							</div>
							<div class="form-group">

								<label for="inputPassword3" class="col-sm-2 control-label">
									密码 </label>
								<div class="col-sm-10">
									<input id="fpwd" type="password" class="form-control" minlength="5" id="inputPassword3" required>
								</div>
							</div>
							<div class="form-group">

								<label for="inputPassword3" class="col-sm-2 control-label">
									再次输入密码 </label>
								<div class="col-sm-10">
									<input equalTo="#fpwd" type="password" class="form-control" id="inputPassword3" required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">

									<button type="submit" class="btn btn-default">更改密码</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>