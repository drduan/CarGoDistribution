<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="../static/css/x-admin.css" media="all">
<body>

	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>认证资料
				</label>

			</div>
			<div class="layui-form-item">
				<input type="hidden" name="id" value="${au.id}">
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">缩略图 </label> <img
					id="LAY_demo_upload" width="400" src="${au.address1}"> <img
					id="LAY_demo_upload" width="400" src="${au.address2}">
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"> </label>
			</div>

			<div class="layui-form-item"">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>发布时间
				</label>
				<div class="layui-input-inline">
					<input type="text" id="link" required="" lay-verify="required"
						value="${au.add_date} " autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="desc" class="layui-form-label"> <span
					class="x-red">*</span>审核意见
				</label>
				<div class="layui-input-inline">
					<input type="text" id="desc" name="result" required=""
						lay-verify="required" value="${au.result}" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="desc" class="layui-form-label"> <span
					class="x-red">*</span>审核结果
				</label>

				<div class="layui-input-inline">
				
					<select  name="pass">
					<option value="true">通过</option>
					<option value="false">不通过</option>
					</select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					确认</button>
			</div>
		</form>
	</div>
	<script src="../static/lib/layui/layui.js" charset="utf-8">
		
	</script>
	<script src="../static/js/x-layui.js" charset="utf-8">
		
	</script>
	<script>
		layui.use([ 'form', 'layer', 'upload' ], function() {
			$ = layui.jquery;
			var form = layui.form(), layer = layui.layer;

			//图片上传接口

			//监听提交
			form.on('submit(add)', function(data) {
				console.log(data.field);
				var data = data.field;
				var enddata = JSON.stringify(data);
				/* 	htmlobj=$.ajax({url:"banner-add.do?data="+enddata,async:false}); */
				$.post("banner-add.do", {
					suggest : JSON.stringify(data)
				}, function(result) {
					if (result == "success") {

						layer.alert("增加成功", {
							icon : 6
						},
								function() {
									// 获得frame索引
									var index = parent.layer
											.getFrameIndex(window.name);
									//关闭当前frame
									parent.layer.close(index);
								});

					}

				});

				//发异步，把数据提交给php

				return false;
			});

		});
	</script>
</body>
</html>