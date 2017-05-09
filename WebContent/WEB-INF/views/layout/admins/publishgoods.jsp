<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../static/css/bootstrap.min.css" rel="stylesheet" />
<link href="../static/css/font-awesome.min.css" rel="stylesheet" />
<link href="../static/css/easyui.css" rel="stylesheet" />
<link href="../static/css/icon.css">
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/jquery.easyui.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script src="../static/js/jquery.validate.min.js"></script>
<script src="../static/js/messages_zh.js"></script>
<title>发布货源</title>
</head>
<body>


	<script type="text/javascript">
		$.validator.setDefaults({
			submitHandler : function() {

				//判断 
				var value = $("#departurePlace").val();
				if (value.indexOf('省') >= 0 && value.indexOf('市') >= 0
						&& value.indexOf('县') >= 0) {
					form.submit();
				}

			}
		});

		$().ready(function() {
			$("#publishgoods").validate({
				rules : {
					weightFate : {
						required : true,
						minlength : 2
					},
					contact : {
						required : true,
					},

					Phone : {
						required : true,
						minlength : 11
					},
					destPlace : {
						required : true
					},
					goodName : {
						required : true
					},
					weight : {
						required : true,
					},
					volume : {
						required : true,
					},
					capacity : {
						required : true,
					},
					departurePlace : {
						required : true,
					},

					messages : {

					}
				}
			});

		})
	</script>

	<script type="text/javascript">
		
	</script>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="head.jsp"></jsp:include>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<div class="form-group">

					<form class="form-horizontal" role="form" action="publishgoods.do"
						id="publishgoods" class="publishgoods" method="post">
						<table>
						</table>




						<div class="form-group">
							<label for="weightFate" class="col-sm-3 control-label">货物名</label>
							<div class="col-sm-9">

								<input class="form-control" type="text" name="goodName"
									data-options="required:true" />
							</div>
						</div>
						<div class="form-group">
							<label for="contact" class="col-sm-3 control-label">联系人:</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="contact"
									data-options="required:true" />
							</div>
						</div>
						<div class="form-group">
							<label for="Phone" class="col-sm-3 control-label">手机号:</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="Phone"
									data-options="validType:'phone'" />
							</div>
						</div>
						<div class="form-group">
							<label for="capacity" class="col-sm-3 control-label">负载:</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="capacity"
									data-options="required:true" />
							</div>
						</div>

						<div class="form-group">
							<label for="departurePlace" class="col-sm-3 control-label">出发地</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="departurePlace"
									id="departurePlace" data-options="required:true" />
							</div>

						</div>
						<div class="form-group">
							<label for="destPlace" class="col-sm-3 control-label">目的地</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="destPlace"
									data-options="required:true" />
							</div>
						</div>
						<div class="form-group">
							<label for="weight" class="col-sm-3 control-label">重量</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="weight"
									data-options="required:true" />
							</div>
						</div>
						<div class="form-group">
							<label for="volume" class="col-sm-3 control-label">体积</label>

							<div class="col-sm-9">
								<input class="form-control" type="text" name="volume"
									data-options="required:true" />
							</div>
						</div>
						<div class="form-group">
							<label for="weightFate" class="col-sm-3 control-label">费率</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="weightFate"
									data-options="required:true" />
							</div>
						</div>

						<div class="form-group">
							<label for="weightFate" class="col-sm-3 control-label">备注</label>
							<div class="col-sm-9">
								<textarea class="form-control" type="text" name="note"
									data-options="required:true"></textarea>
							</div>
						</div>



						<div class="form-group">
							<button type="submit" class="btn btn-default">发布货源</button>
						</div>
					</form>
				</div>

			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>


</body>
</html>