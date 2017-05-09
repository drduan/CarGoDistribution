
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="_CarGoDistribution/../static/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="_CarGoDistribution/../static/css/font-awesome.min.css"
	rel="stylesheet" />
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认订单</title>
</head>
<body>
	<script type="text/javascript">
	
	$(document).ready(function () {
		$('col-md-4 carlist').click(function (e) {
			alert("");
		//e.preventDefault();
		$('col-md-4 carlist').removeClass('active');
		$(this).addClass('active');

		});

		});
	
		$(function() {
			$("#submitNext").click(function() {
				var temp = $('.easyui-combobox option:selected') .val();//选中的值
				var val = parseInt(temp);
				var rid = ${cargoResource.carresourceid};
				if (val == null) {
					alert("什么也没选中!");
					return false;
				} else {
					/*  */
					$.ajax({
						url : 'bookresource.do',
						type : 'POST', //GET
						async : true, //或false,是否异步
						data : {
							cid : val,
							rid : rid
						},
						timeout : 5000, //超时时间
					//	dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
					dataType : 'text',
					beforeSend : function(xhr) {
							console.log('发送前')
						},
						success : function(data, textStatus, jqXHR) {
							
							var dataObj=eval("("+data+")");
							  
							if(dataObj.status=='success')
								
								{
								alert("已通知车主，请等待审核通过！");
								$('#submitNext').attr('disabled',"true");
								//window.open("paying.do");
								window.location.href="successmsg.do?msg=&orderid="+dataObj.orderno+"&info="+${cargoResource.weightFate}; 
								}
							else
								{
								alert("该货源或车源已经在运输中");
								$('#submitNext').attr('disabled',"true");
								}  
						},
						error : function(xhr, textStatus) {
							alert('未选中车辆');
						},
						complete : function() {
							
							console.log('结束')
						}
					})

				}

			});
		});
	</script>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">

						<div class="row">
							<jsp:include page="user/head.jsp"></jsp:include>
						</div>

						<div class="row">
							<div class="col-md-12">
								<h3>确认订单</h3>
								<div class="row">
								<a href="complaints.do"><label for="state">投诉反馈</label></a>
									<label for="state">选择车源</label> <select class="easyui-combobox"
										name="state" label="State:" labelPosition="top"
										style="width: 100%;">
										<c:forEach var="carsource" items="${carsource}">


											<c:if test="${carsource.carStatus eq true}">
												<option disabled="disabled"  value="${carsource.id}"> 
													联系人：${carsource.carHost} 
													车牌号：${carsource.carNumber}  
													手机号：${carsource.phone}  
													车辆类型：${carsource.carType}  
													运输中 暂时不可选择</option>
											</c:if>
											<c:if test="${carsource.carStatus ne true}">
												<option value="${carsource.id}">  联系人：${carsource.carHost} 
													车牌号：${carsource.carNumber}  
													手机号：${carsource.phone}  
													车辆类型：${carsource.carType}  
												</option>
											</c:if>
										</c:forEach>
									</select>



									<div class="col-md-4"></div>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<p>
									<div class="col-md-4"></div>
									<div class="col-md-4"></div>
								</div>
								<table class="table">

									<tbody>
										<tr>
											<td>商品名</td>
											<td>${cargoResource.goodName}</td>

										</tr>
										<tr class="active">

											<td>发布日期</td>
											<td>${cargoResource.addDate}</td>
										</tr>
										<tr class="success">

											<td>联系人</td>
											<td>${cargoResource.contact}/${cargoResource.phone}</td>
										</tr>

										<tr class="success">

											<td>出发地</td>
											<td>${cargoResource.departurePlace}</td>
										</tr>
										<tr class="success">

											<td>目的地</td>
											<td>${cargoResource.destPlace}</td>
										</tr>

										<tr class="warn">

											<td>需要支付押金</td>
											<c:if test="${cargoResource.weightFate ne '面议' }">
											<td><span> ${cargoResource.weightFate}</span>元</td>
											</c:if>
											<c:if test="${cargoResource.weightFate eq '面议' }">
											<td><span> 面议</span></td>
											</c:if>
										</tr>



										<tr class="warn">

											<td>体积</td>
											<td><span> ${cargoResource.weight}</span>m³</td>
										</tr>
										<tr class="warn">

											<td>重量</td>
											<td><span> ${cargoResource.capacity} 吨</span></td>
										</tr>
									</tbody>
								</table>
								<div>
									<tr class="success">
										<button id="submitNext" class="btn btn-default">提交预约申请</button>
										<!-- 需要检测是否选择车辆 -->
										<!-- 席位已锁定，请在10 分钟内进行支付，完成网上购票。 支付剩余时间： -->
										<!--网上支付 -->
										<button class="btn btn-default" href="\">返回</button>
									</tr>
								</div>
								<div class="row">
									<div class="col-md-12"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">支付进行中</h4>
				</div>
				<div class="modal-body">按下 ESC 按钮退出。</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">支付完成</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>