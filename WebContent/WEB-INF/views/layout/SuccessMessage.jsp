<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<script language="javascript">
		/* alert("${msg} ${info}"); */
		if(conform(${msg}${info})==true)
			{
			alert("支付成功");
			}
		else
			{
			alert("支付失败");
			}
		window.history.back(-1);
		window.open("paying.do");
	</script>
</body>
</html>