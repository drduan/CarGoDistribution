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
<link href="https://cdn.insdep.com/themes/1.0.0/default_theme.css" rel="stylesheet" type="text/css">

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
									<h2>货主</h2>
									<dl>
										<dt>${user.email}</dt>
										<dd>${user.phone}</dd>
									</dl>
								</div>

							</div>
						</div>
					</div>
				</div>
			
				<!--  http://www.jeasyui.com/demo/main/index.php?plugin=Tabs& -->
				
				<div class="row">
				<div class="easyui-tabs" style="height: 500px; padding-top: 0px"
					data-options="tabPosition:'left',headerWidth:80">
					<div title="我的订单" style="padding: 10px;">
						<div style="margin: 20px 0;"></div>
						<h2>我的订单</h2>
					</div>
					<div title="我的汽车" style="padding: 10px;">

<table id="dg" title="汽车管理"
							style="width: 700px; height: 250px"
							data-options="rownumbers:true,singleSelect:true,pagination:true,url:'GetUserCars.json',method:'get'">
							<thead>
								<tr>
									<th data-options="field:'carHost',width:80">Item ID</th>
									<th data-options="field:'CarNumber',width:100">车牌号</th>
									<th data-options="field:'listprice',width:80,align:'right'">运费</th>
									<th data-options="field:'CarType',width:80,align:'right'">车辆类型</th>
									<th data-options="field:'attr1',width:240">负载量</th>
									<th data-options="field:'status',width:60,align:'center'">联系方式</th>
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
													$('#w').window('open')
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
					<div title="车主评价" style="padding: 10px;">货主评价 3</div>
				</div>
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
		style="width: 500px; height: 500px; padding: 10px;">
		
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="loadLocal()">LoadLocal</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="loadRemote()">LoadRemote</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	</div>
	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff" method="post" action="<%=request.getContextPath() %>/Car/InsertCarForUser.do">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="CarHost" style="width:100%" data-options="label:'车主:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="CarNumber" style="width:100%" data-options="label:'车牌号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="FreightRate" style="width:100%;height:60px" data-options="label:'运费:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<select class="easyui-combobox" name="CarType" label="车辆类型" style="width:100%">
				<option value="ar">厢式货车</option>
				<option value="bg">面包车</option>
				<option value="ca">平板车</option>
				<option value="zh-cht">半挂车</option>
				<option value="cs">自卸车</option>
				<option value="da">保温车</option>
				<option value="nl">罐式车</option>
				<option value="en" selected="selected">铁笼车</option>
				<option value="et">集装箱运输车</option>
				<option value="fi">轿车运输车</option>
				<option value="fr">大件运输车</option>
				<option value="de">起重车</option>
				<option value="el">危险品车</option>
				<option value="ht">爬梯车</option>
				<option value="he">全挂车</option>
				<option value="hi">加长挂车</option>
				<option value="mww">金杯车(高顶)</option>
				<option value="hu">金杯车(低顶)</option>
				</select>
			</div>
			
			<div style="margin-bottom:20px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
			</div>
		</form>
	</div>
	<script>
		function loadLocal(){
			$('#ff').form('load',{
				CarHost:'myname',
				CarNumber:'mymail@gmail.com',
				FreightRate:'subject',
				CarType:'en'
			});
		}
		function loadRemote(){
			$('#ff').form('load', '#');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					$('#w').window('close')
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
	</script>
		
		
	</div>

</body>

</html>