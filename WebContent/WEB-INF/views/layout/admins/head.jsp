<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>


<nav class="navbar " role="navigation"
	style="margin-top: 0px; margin-bottom: 0px; border-bottom-width: 0px; border-bottom: solid #ddddd 1px">
	<div class="navbar-header">

		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only"></span><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<a class="navbar-brand"
			href="<%=request.getContextPath()%>/admins/home.do">欢迎来到空车配货网站</a>
			
	</div>


	<div class="collapse navbar-collapse "
		id="bs-example-navbar-collapse-1">
		
		<ul class="nav navbar-nav navbar-left">
		<li><a href="<%=request.getContextPath()%>/admins/publishgoods.do">发布货源</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">


			<shiro:notAuthenticated>
				<li><a href="<%=request.getContextPath()%>/User/register.do">
						注册</a></li>
				<li><a id="modal-302051" href="#modal-container-302051"
					role="button" class="btn" data-toggle="modal"><i
						class="fa fa-user"></i>登录</a></li>






				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> 菜单<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>

			</shiro:notAuthenticated>
			<shiro:authenticated>


				<li><label> <a
						href="<%=request.getContextPath()%>/logout.do">注销</a></label></li>

				<li class="opts__item message"><a
					id="dLabel" class="dropdown-toggle-message" href="../admins/msgl.do"> <span
						class="sr-only"> 消息</span> <span id="messageCount"
						class="fa fa-bell-o">${messagecount} </span></a></li>
				<li class="dropdown hoverDropdown"
					style="width: 30px; height: 30px; margin-right: 15px"><a
					class="dropdownBtn user-avatar" data-toggle="dropdown"
					style="background-image: url('<%=request.getContextPath()%>/userfiles/avatar/2.jpg'); width: 30px; height: 30px"
					href="#" aria-expanded="true"> </a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li><a
							href="<%=request.getContextPath()%>/admins/adminprofile.do">我的主页</a></li>
						<li><a href="../settings.do">账号设置</a></li>
						<li><a
							href="/User/logout.do">退出</a></li>
							<li><a
							href="../authentication.do">账户认证</a></li>
						<li class="divider"></li>
						<li><a href="#">建议反馈</a></li>
					</ul>
			</shiro:authenticated>
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
				<h4 class="modal-title" id="myModalLabel">登录</h4>
			</div>
			<div class="modal-body">
				<form role="form" action="User/login.do" method="post">
					<div class="form-group">

						<label for="exampleInputEmail1"> 邮箱地址 </label> <input name="email"
							type="email" class="form-control" id="email" />
					</div>
					<div class="form-group">

						<label for="_password"> 密码 </label> <input type="password"
							name="password" class="form-control" id="password" />
					</div>

					<div class="checkbox">

						<label> <input type="checkbox" name="rememberMe" /> 
						记住我
						</label>
					</div>
					<button type="submit" class="btn btn-default">登录</button>
				</form>
			</div>
			<div class="modal-footer"></div>
		</div>

	</div>

</div>



