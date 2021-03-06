<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
    <head>
        <meta charset="utf-8">
        <title>
           管理员首页
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="../static/css/x-admin.css" media="all">
    </head>
    
    <body style="background-color: #ffffff">
        <div class="x-box">
            <div class="x-top">
                <i class="layui-icon x-login-close">
                    &#x1007;
                </i>
                <ul class="x-login-right">
                    <li style="background-color: #F1C85F;" color="#F1C85F">
                    </li>
                    <li style="background-color: #EA569A;" color="#EA569A">
                    </li>
                    <li style="background-color: #393D49;" color="#393D49">
                    </li>
                </ul>
            </div>
            <div class="x-mid" style="background:#65A654">
                <div class="x-avtar">
                    <img src="../static/images/logo.png" alt="">
                </div>
                <div class="input" >
                    <form class="form-control" action="login.do" method="post">
                        <div class="layui-form-item x-login-box">
                            <label for="username" class="layui-form-label">
                                <i class="layui-icon">&#xe612;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="text" id="username" name="email" required="" lay-verify="username"
                                autocomplete="off" placeholder="username" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item x-login-box" >
                            <label for="pass" class="layui-form-label">
                                <i class="layui-icon">&#xe628;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="password" id="pass" name="password" required="" lay-verify="pass"
                                autocomplete="off" placeholder="******" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item" id="loginbtn">
                            <button style="background: #283857"  class="layui-btn" lay-filter="save" lay-submit="">
                                登 录
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="..static/lib/layui/layui.js" charset="utf-8">
        </script>
        <script>
            layui.use(['form'],
            function() {
                $ = layui.jquery;
                var form = layui.form(),
                layer = layui.layer;

                $('.x-login-right li').click(function(event) {
                    color = $(this).attr('color');
                    $('body').css('background-color', color);
                });

                //监听提交
                form.on('submit(save)',
                function(data) {
                    console.log(data);
                    layer.alert(JSON.stringify(data.field), {
                      title: '最终的提交信息'
                    },function  () {
                        location.href = "./index.html";
                    })
                    return false;
                });

            });

        </script>
    </body>

</html>