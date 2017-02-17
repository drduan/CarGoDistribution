<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../common/css/bootstrap.min.css" />
<script type="text/javascript" src="../common/js/jquery-3.1.1.min.js"></script>

<title>欢迎注册-中国货运物流信息平台-第一步</title>
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="../head.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">

						<div class="tabbable" id="tabs-91824">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#"
									data-toggle="tab">1. 选择会员类型</a></li>
								<li><a href="#" data-toggle="tab">2. 填写账户信息</a>
								</li>
							</ul>
							<div class="tab-content">
								<div id="panel-924786">
									<p>
									
									<form action="reg_next.do" method="get">
									
									<table>
										<tbody>
										<tr>
                        <td colspan="4" align="left">
                            尊敬的用户，欢迎您注册速配网会员。<p><font color="#FF0000">请选择适合的会员类型注册</font>
                        </td>
                    </tr>
						<tr>
                        <td colspan="4" height="13" onmouseover="this.bgColor='#FFF9ED'" onmouseout="this.bgColor='#f5fafe'" bgcolor="#f5fafe">
                            <table width="100%">
                                <tbody><tr>
                                    <td align="left" width="32">
                                        <strong>
                                            <input value="1" name="cust_kind" type="radio" id="chezhu"></strong>
                                    </td>
                                    <td align="left" class="px14" width="120">
                                        <strong>车&nbsp;&nbsp;&nbsp;&nbsp;主</strong>
                                        </td><td height="45" align="left">
                                            提供物流运输服务且具备营运资格的车队或个体车主。<br>
                                            可免费发布车辆信息，线路信息，免费查询货源信息。
                                        </td>
                                </tr>
                            </tbody></table>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4" height="13" onmouseover="this.bgColor='#FFF9ED'" onmouseout="this.bgColor='#e9f5fe'" bgcolor="#e9f5fe">
                            <table width="100%">
                                <tbody><tr>
                                    <td align="left" width="32">
                                        <strong>
                                            <input value="2" name="cust_kind" type="radio" id="huoyuan"></strong>
                                    </td>
                                    <td width="120" align="left" class="px14">
                                        <strong>发货企业或个人</strong>
                                    </td>
                                    <td height="45" align="left">
                                        需要发货的企业或个人。<br>
                                        可免费发布国内外货物运输信息，免费查询运输车辆及物流公司信息。
                                    </td>
                                </tr>
                            </tbody></table>
                        </td>
                    </tr>
                    <tr>
                    <td>
                    <input align="right"  type="submit" value="下一步" class="btn btn-primary"/>
					</td>
                    </tr>
                    
										</tbody>
									</table>
									
									
													</form>
								</div>
								<div class="tab-pane"  class="tab-pane active" id="panel-585601">
									<p>Howdy, I'm in Section 2.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="../common/js/bootstrap.min.js"></script>
</body>
</html>