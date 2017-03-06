<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- https://www.insdep.com -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>

<link href="../static/css/bootstrap.min.css" rel="stylesheet" />
<link href="../static/css/font-awesome.min.css" rel="stylesheet" />
<link href="../static/css/easyui.css" rel="stylesheet" />
<link href="../static/css/icon.css">

<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/jquery.easyui.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>



</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12">

						<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
						<div
							class="easyui-panel panel-body panel-body-noheader panel-body-noborder"
							id="control" data-options="fit:true,border:false"
							style="padding: 0px; background-color: rgb(255, 255, 255); width: 967px; height: 86px; background-position: initial initial; background-repeat: initial initial;"
							title="">
							<div class="theme-user-info-panel">
								<div class="left">
									<img src="${avater}" width="86" height="86">
								</div>
								<div class="right">
									<ul>
										<li class="text-success">￥6,200.00<span>收益总额</span></li>
										<li class="text-info">33<span>我的信用</span></li>

										<li class="text-warning">9820<span>我的积分</span></li>
										<li>优秀<span>信誉评级</span></li>
									</ul>
								</div>
								<div class="center">
									<h1>${user.username}

										<c:if test="${user.hasauthentication}">
											<span class="badge color-success"> 已认证 </span>
										</c:if>
										<c:if test="${not user.hasauthentication}">
											<span class="badge color-failed"> 未认证 </span>
										</c:if>

									</h1>
									<h2>管理员</h2>
									<dl>
										<dt>${user.email}</dt>
										<dd>${user.phone}</dd>
									</dl>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- 
				<div class="row">
					<div class="col-md-6">我的汽车</div>
					<div class="col-md-6">我的订单</div>
				</div>
				<div class="row">
					<div class="col-md-6">货主评价</div>

					<div class="col-md-6">货源收藏</div>
				</div>
				<div class="row">
					<div class="col-md-12">
					 -->

				<!--  http://www.jeasyui.com/demo/main/index.php?plugin=Tabs& -->
				<div class="easyui-tabs" style="height: 500px; padding-top: 0px"
					data-options="tabPosition:'left',headerWidth:80">
					<div title="我的订单" style="padding: 10px;">
						<!-- http://localhost:8080/_CarGoDistribution/static/js/jquery-3.1.1.min.js -->
						<div style="margin: 20px 0;"></div>
						<table id="dg" title="Custom DataGrid Pager"
							style="width: 700px; height: 250px"
							data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
							<thead>
								<tr>
									<th data-options="field:'itemid',width:80">Item ID</th>
									<th data-options="field:'productid',width:100">Product</th>
									<th data-options="field:'listprice',width:80,align:'right'">List
										Price</th>
									<th data-options="field:'unitcost',width:80,align:'right'">Unit
										Cost</th>
									<th data-options="field:'attr1',width:240">Attribute</th>
									<th data-options="field:'status',width:60,align:'center'">Status</th>
								</tr>
							</thead>
						</table>
						<script type="text/javascript">
							$(
									function() {
										var pager = $('#dg').datagrid()
												.datagrid('getPager'); // get the pager of datagrid
										pager.pagination({
											buttons : [ {
												iconCls : 'icon-search',
												handler : function() {
													alert('search');
												}
											}, {
												iconCls : 'icon-add',
												handler : function() {
													alert('add');
												}
											}, {
												iconCls : 'icon-edit',
												handler : function() {
													alert('edit');
												}
											} ]
										});
									})
						</script>

					</div>
					<div title="我的汽车" style="padding: 10px;">我的汽车 2</div>
					<div title="货主评价" style="padding: 10px;">货主评价 3</div>
				</div>

				<div>
					<font style="margin-top: 100px">NI </font>
				</div>

			</div>
			<div class="col-md-1"></div>
		</div>

	</div>

	<!-- 分界线 -->

	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="$('#w').window('open')">Open</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="$('#w').window('close')">Close</a>
	</div>
	<div id="w" class="easyui-window" title="Modal Window"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 500px; height: 200px; padding: 10px;">The window
		content.</div>

</body>

</html>