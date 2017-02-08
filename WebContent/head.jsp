<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="../common/css/font-awesome.min.css" rel="stylesheet"/>
</head>
<body class="container-fluid" style="margin: 0;">

	<nav class="navbar " role="navigation"
		style="margin-top: 0px; margin-bottom: 0px; border-bottom-width: 0px;  border-bottom: solid #ddddd 1px">
		<div class="navbar-header">

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath() %>">欢迎来到空车配货网站！</a>
		</div>

		<div class="collapse navbar-collapse "
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active">
					
					<a href="#"><i class="fa fa-android"></i>App下载</a></li>
				<li>
					<a href="#">帮助</a></li>

			</ul>
		
			<ul class="nav navbar-nav navbar-right">

				<li><a href="<%=request.getContextPath() %>/User/register_step1.jsp">
					注册</a></li>
				<li><a id="modal-302051" href="#modal-container-302051"
					role="button" class="btn" data-toggle="modal"><i class="fa fa-user"></i>登录</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">
					菜单<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>

		</div>

	</nav>


<div class="modal fade" id="modal-container-302051" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">登录框</h4>
				</div>
				<div class="modal-body">
					<form role="form">
						<div class="form-group">

							<label for="exampleInputEmail1"> 邮箱地址 </label> <input
								type="email" class="form-control" id="exampleInputEmail1" />
						</div>
						<div class="form-group">

							<label for="exampleInputPassword1"> 密码 </label> <input
								type="password" class="form-control" id="exampleInputPassword1" />
						</div>
						<div class="form-group">

							<label for="exampleInputFile"> 输入文件 </label> <input type="file"
								id="exampleInputFile" />
							<p class="help-block">Example block-level help text here.</p>
						</div>
						<div class="checkbox">

							<label> <input type="checkbox" /> Check me out
							</label>
						</div>
						<button type="submit" class="btn btn-default" data-dismiss="modal">
							Submit</button>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>

		</div>

	</div>


</body>
</html>