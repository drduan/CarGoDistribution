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

<link href="https://cdn.insdep.com/themes/1.0.0/easyui.css"
	rel="stylesheet" type="text/css">
<link href="https://cdn.insdep.com/themes/1.0.0/default_theme.css"
	rel="stylesheet" type="text/css">
<link href="https://cdn.insdep.com/themes/1.0.0/icon.css"
	rel="stylesheet" type="text/css">
	

<script type="text/javascript"
	src="https://cdn.insdep.com/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="https://cdn.insdep.com/easyui/jquery.easyui-1.5.1.min.js"></script>
<script type="text/javascript"
	src="https://cdn.insdep.com/themes/1.0.0/jquery.insdep-extend.min.js"></script>


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
					<table id="dg" class="easyui-datagrid" title="Row Editing in DataGrid" style="width:700px;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				url: '../static/js/datagrid_data1.js',
				method: 'get',
				onClickCell: onClickCell,
				onEndEdit: onEndEdit
			">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100,
						formatter:function(value,row){
							return row.productname;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'productid',
								textField:'productname',
								method:'get',
								url:'products.json',
								required:true
							}
						}">Product</th>
				<th data-options="field:'listprice',width:80,align:'right',editor:{type:'numberbox',options:{precision:1}}">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right',editor:'numberbox'">Unit Cost</th>
				<th data-options="field:'attr1',width:250,editor:'textbox'">Attribute</th>
				<th data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:''}}">Status</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
	</div>
	
	<script type="text/javascript">
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
					if (ed){
						($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
					}
					editIndex = index;
				} else {
					setTimeout(function(){
						$('#dg').datagrid('selectRow', editIndex);
					},0);
				}
			}
		}
		function onEndEdit(index, row){
			var ed = $(this).datagrid('getEditor', {
				index: index,
				field: 'productid'
			});
			row.productname = $(ed.target).combobox('getText');
		}
		function append(){
			if (endEditing()){
				$('#dg').datagrid('appendRow',{status:'P'});
				editIndex = $('#dg').datagrid('getRows').length-1;
				$('#dg').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		function removeit(){
			if (editIndex == undefined){return}
			$('#dg').datagrid('cancelEdit', editIndex)
					.datagrid('deleteRow', editIndex);
			editIndex = undefined;
		}
		function accept(){
			if (endEditing()){
				$('#dg').datagrid('acceptChanges');
			}
		}
		function reject(){
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges(){
			var rows = $('#dg').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}
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
</body>
</html>