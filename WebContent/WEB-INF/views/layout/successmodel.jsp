<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>等待支付完成</title>
<link href="_CarGoDistribution/../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../static/css/font-awesome.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
</head>
<body>

	<script type="text/javascript">
		function getQueryString(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return null;
		}

		function fun1(curObj) {
			window.location.href = "paid.do?orderid="+getQueryString("orderid");
		}
	</script>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">



				<div class="modal fade" id="modal-container-749629" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">

								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">支付</h4>
							</div>
							<div class="modal-body">${msg}${info}</div>
							<div class="modal-footer">

								<button type="button" class="btn btn-default"
									data-dismiss="modal" onclick="fun1(this);">${btn1}</button>
								<button type="button" class="btn btn-primary">${btn2}</button>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
	</div>
	<script>
		$(function() {
			$('#modal-container-749629').modal({
				show : true,
				backdrop : true
			})
		});
	</script>
	<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>