<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../common/css/font-awesome.min.css" rel="stylesheet"/>
<link href="common/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="global-nav sf-header">
		<nav class="container nav">
		<div class="hidden-sm hidden-lg hidden-md">
			<div class="sf-header__logo sf-header__logo--response">
				<h1>
					<a></a>
				</h1>
			</div>
			<div class="dropdown m-menu">
				<a href="javascript:void(0);" id="dLabel"
					class="visible-xs-block m-toptools" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"><span
					class="glyphicon glyphicon-align-justify"></span><span
					class="mobile-menu__unreadpoint"></span></a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li class="mobile-menu__item"><a href="/news">头条</a></li>
					<li class="mobile-menu__item"><a href="/questions/newest">问答</a></li>
					<li class="mobile-menu__item"><a href="/blogs">文章</a></li>
					<li class="mobile-menu__item"><a href="/user/note">笔记</a></li>
					<li class="mobile-menu__item"><a href="/jobs">职位</a></li>
					<li class="mobile-menu__item"><a href="/events">活动</a></li>
					<li class="mobile-menu__item"><a href="/tags">标签</a></li>
					<li class="mobile-menu__item"><a href="/users">榜单</a></li>
					<li class="mobile-menu__item"><a href="/sites">子站</a></li>
					<li role="presentation" class="divider"></li>
					<li class="mobile-menu__item"><a href="/user/notifications">消息<span
							class="pull-right badge mt4" id="m-messageCount"></span></a></li>
					<li role="presentation" class="divider"></li>
					<li class="mobile-menu__item"><a
						href="/api/user/logout?_=c378ec1c7c7c62c54afa493c0bee0492">退出</a></li>
				</ul>
			</div>
			<a href="/ask" class="visible-xs-block pull-right m-ask m-toptools"><span
				class="glyphicon glyphicon-pencil"></span></a>
		</div>
		<div class="row hidden-xs">
			<div class="col-sm-10 col-md-8 col-lg-7">
				<div class="sf-header__logo">
					<h1>
						<a href="/">SegmentFault</a>
					</h1>
				</div>
				<ul class="menu list-inline pull-left hidden-xs">
					<li class="menu__item menu__item--new"><a href="/news">头条</a></li>
					<li class="menu__item"><a href="/questions">问答</a></li>
					<li class="menu__item"><a href="/blogs">专栏</a></li>
					<li class="menu__item"><a href="/jobs">职位</a></li>
					<li class="menu__item"><a href="/events">活动</a></li>
					<li
						class="menu__item menu__item-sfdc--new hide menu__item--new-show"><a
						href="/sfdc-2016/hz">SFDC</a></li>
					<li class="menu__item menu__item-app--new"><a href="/app">App</a></li>
				</ul>
			</div>
			<div class="col-sm-2 col-md-4 col-lg-5 text-right">
				<form action="/search"
					class="header-search  hidden-sm hidden-xs mr20">
					<button class="btn btn-link">
						<span class="sr-only">搜索</span><span
							class="glyphicon glyphicon-search"></span>
					</button>
					<input id="searchBox" name="q" type="text" placeholder="输入关键字搜索"
						class="form-control" value="">
				</form>
				<ul class="opts list-inline hidden-xs">
					<li class="opts__item dropdown hoverDropdown write-btns"><a
						class="dropdownBtn" data-toggle="dropdown" href="/ask"
						aria-expanded="false"><i class="fa fa-plus" aria-hidden="true"></i><span
							class="caret"></span></a>
						<ul class="dropdown-menu dropdown-menu-right ">
							<li><a href="/submit">发头条</a></li>
							<li><a href="/ask">提问题</a></li>
							<li><a href="/write">写文章</a></li>
							<li><a href="/record">记笔记</a></li>
							<li class="divider"></li>
							<li><a href="/user/draft">草稿箱</a></li>
						</ul></li>
					<li class="opts__item message has-unread hidden-sm"><a
						id="dLabel" class="dropdown-toggle-message"
						href="/user/notifications"><span class="sr-only">消息</span><span
							id="messageCount" class="fa fa-bell-o"></span></a>
						<div class="opts__item--message hide">
							<div class="panel panel-default">
								<div class="panel-heading">
									<ul class="nav nav-tabs nav-tabs-message">
										<li role="presentation" class="active"><a
											href="#messageGeneral" id="home-tab" role="tab"
											data-toggle="tab" aria-controls="home" aria-expanded="true"><i
												class="fa fa-bullhorn"></i><span
												class="notice-dot hide notice-dot-general"></span></a></li>
										<li role="presentation" class=""><a href="#messageRanked"
											id="home-tab" role="tab" data-toggle="tab"
											aria-controls="home" aria-expanded="true"><i
												class="fa fa-thumbs-o-up"></i><span
												class="notice-dot hide notice-dot-ranked"></span></a></li>
										<li role="presentation" class=""><a
											href="#messageFollowed" id="home-tab" role="tab"
											data-toggle="tab" aria-controls="home" aria-expanded="true"><i
												class="fa fa-user-plus"></i><span
												class="notice-dot hide notice-dot-followed"></span></a></li>
									</ul>
								</div>
								<div class="panel-body">
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane active"
											id="messageGeneral"></div>
										<div role="tabpanel" class="tab-pane" id="messageRanked"></div>
										<div role="tabpanel" class="tab-pane" id="messageFollowed"></div>
										<script
											src="//hm.baidu.com/hm.js?e23800c454aa573c0ccb16b52665ac26"></script>
										<script async="" src="//www.google-analytics.com/analytics.js"></script>
										
									</div>
									<p class="opts__item--message-loading follow-tips">loading</p>
								</div>
								<div class="panel-footer">
									<div class="row">
										<div class="col-sm-6">
											<a href="javascript:;" class="message-ingore-all hide"><span
												class="glyphicon glyphicon-ok-sign"></span> 全部标记为已读</a>
										</div>
										<div class="col-sm-6">
											<a class="opts__item--message-view-all"
												href="/user/notifications">查看全部 »</a>
										</div>
									</div>
								</div>
							</div>
						</div></li>
					<li class="opts__item letter has-unread hidden-sm"><a
						id="dLabel" class="dropdown-toggle-letter" href="/user/messages"><span
							class="sr-only">私信</span><span id="letterCount"
							class="fa fa-envelope-o"></span></a>
						<div class="opts__item--letter hide">
							<div class="panel panel-default">
								<div class="panel-heading">
									<ul class="nav nav-tabs nav-tabs-letter">
										<li role="presentation" class="active"><span
											class="opts__item--letter-heading">最近的私信</span></li>
									</ul>
								</div>
								<div class="panel-body">
									<div class="tab-content">
										<div id="messageInbox"></div>
										
									</div>
									<p class="opts__item--letter-loading follow-tips">loading</p>
								</div>
								<div class="panel-footer">
									<div class="row">
										<div class="col-sm-6">
											<a href="javascript:;" class="message-ingore-all hide"><span
												class="glyphicon glyphicon-ok-sign"></span> 全部标记为已读</a>
										</div>
										<div class="col-sm-6">
											<a class="opts__item--message-view-all" href="/user/messages">查看全部
												»</a>
										</div>
									</div>
								</div>
							</div>
						</div></li>
					<li class="opts__item user dropdown hoverDropdown"><a
						class="dropdownBtn user-avatar" data-toggle="dropdown"
						style="background-image: url('https://sfault-avatar.b0.upaiyun.com/397/343/3973431515-5871a5d594750_big64')"
						href="/u/drduan" aria-expanded="false"></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="/u/drduan">我的主页</a></li>
							<li><a href="/u/drduan/about">我的档案</a></li>
							<li><a href="/user/finance">我的资产</a></li>
							<li><a href="/user/settings">账号设置</a></li>
							<li><a
								href="/api/user/logout?_=c378ec1c7c7c62c54afa493c0bee0492">退出</a></li>
							<li class="divider"></li>
							<li><a href="https://board.segmentfault.com/">建议反馈</a></li>
							<li><a class="js__action--complain"
								href="javascript:void(0);">用户申诉</a></li>
							<script type="text/template" id="js__action--complain-tpl"><form class="complain__form" method="post" action="/api/appeals/add"><div class="form-group"><label>理由</label><textarea name="description" class="form-control"
                                                              rows="3"></textarea></div></form></script>
						</ul></li>
				</ul>
			</div>
		</div>
		</nav>
	</div>
</body>
</html>