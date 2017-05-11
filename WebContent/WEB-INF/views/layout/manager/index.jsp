<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta charset="utf-8">
<title>管理员管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="../static/css/x-admin.css" media="all">
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<a class="logo" href="home.do"> 系统管理员首页 </a>
				<ul class="layui-nav" lay-filter="">
					<li class="layui-nav-item"><img
						src="../static/images/logo.png" class="layui-circle"
						style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
					<li class="layui-nav-item x-index"><a href="javascript:;">管理员</a>
						</li>
					<!-- <li class="layui-nav-item">
                        <a href="" title="消息">
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                        </li> -->
					<li class="layui-nav-item x-index"><a href="../logout.do">退出</a></li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black x-side">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">

	<li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe607;</i><cite>投诉反馈管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="../complaintlist.do?type=yp">
                                            <cite>运品违禁</cite>
                                        </a>
                                    </dd>
                                </dd>
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="../complaintlist.do?type=yd">
                                            <cite>运单问题</cite>
                                        </a>
                                    </dd>
                                </dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>认证管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <dd class="">
                                        <a href="javascript:;" _href="./welcome.html">
                                            <cite>产品列表（待开发）</cite>
                                        </a>
                                    </dd>
                                </dd>
                               
                            </dl>
                        </li>


				</ul>
			</div>

		</div>
		<div class="layui-tab layui-tab-card site-demo-title x-main"
			lay-filter="x-tab" lay-allowclose="true">
			<div class="x-slide_left"></div>
			<ul class="layui-tab-title">
				<li class="layui-this">认证管理 <i
					class="layui-icon layui-unselect layui-tab-close">ဆ</i>
				</li>
			</ul>
			<div class="layui-tab-content site-demo site-demo-body">
				<div class="layui-tab-item layui-show">
					<iframe frameborder="0" src="./banner-list.do" class="x-iframe"></iframe>
				</div>
			</div>
		</div>
		<div class="site-mobile-shade"></div>
	</div>
	<script src="../static/lib/layui/layui.js" charset="utf-8"></script>
	<script src="../static/js/x-admin.js"></script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>