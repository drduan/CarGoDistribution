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
<link href="https://cdn.insdep.com/themes/1.0.0/default_theme.css"
	rel="stylesheet" type="text/css">
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/jquery.easyui.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<title>发布货源</title>
</head>
<body>
<script type="text/javascript">
/* 	$('#ff').form('submit', {
    url:"publishgoods.do",
    onSubmit: function(){
    	alert("aa")
    },
    success:function(data){
		alert(data)
    }
}); */
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

				<form  action="publishgoods.do" method="post">
					
					<div>
						<label for="weightFate">货物名</label> <input
							class="easyui-validatebox" type="text" name="goodName"
							data-options="required:true" />
					</div>
					<div>
						<label for="contact">联系人:</label> <input class="easyui-validatebox"
							type="text" name="contact" data-options="required:true" />
					</div>
					<div>
						<label for="Phone">手机号:</label>
						 <input
							class="easyui-validatebox" type="text" name="Phone"
							data-options="validType:'phone'" />
					</div>
					<div>
						<label for="capacity">负载:</label> <input
							class="easyui-validatebox" type="text" name="capacity"
							data-options="required:true" />
					</div>
					<div>
						<label for="departurePlace">出发地</label> <input
							class="easyui-validatebox" type="text" name="departurePlace"
							data-options="required:true" />
					</div>
					<div>
						<label for="destPlace">目的地</label> <input
							class="easyui-validatebox" type="text" name="destPlace"
							data-options="required:true" />
					</div>
					<div>
						<label for="weight">重量</label> <input
							class="easyui-validatebox" type="text" name="weight"
							data-options="required:true" />
					</div>
					<div>
						<label for="volume">体积</label> <input
							class="easyui-validatebox" type="text" name=""
							data-options="required:true" />
					</div>
					<div>
						<label for="weightFate">费率</label> <input
							class="easyui-validatebox" type="text" name="weightFate"
							data-options="required:true" />
					</div>
				
					
					<div>
	 	<input class="easyui-validatebox" type="submit"  value="提交" />
					</div>
				</form>


			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>


</body>
</html>