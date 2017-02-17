function GetPhoneCode(obj) {
	var phone = document.getElementById("tbRegTel");
	if (phone.value == '') {
		alert("请先输入手机号码！");
	
		tooltipObj.Show(phone);
		$("#tbRegTel").focus();
		return false;
	}

	var noReg = CheckingRegTel(document.getElementById("tbRegTel"));
	if (!noReg) {
		alert("手机号已存在，请更换其他手机号！");
		return false;
	}

	var codeType = "sms";
	
	document.getElementById("outmsg").style.display = "block";
	var xhojb = new XmlHttp();
	var url = "/ashx/GetPhoneCode1.ashx?ran=" + Math.random() + "&code="
			+ phone.value + "&Kind=Reg";
	if (codeType != null && codeType == "voice") {
		url = "/ashx/GetPhoneCode1.ashx?ran=" + Math.random() + "&code="
				+ phone.value + "&Kind=Reg&CodeType=voice";
		document.getElementById("hdCodeType").value = "sms";
	} else {
		url = "/ashx/GetPhoneCode1.ashx?ran=" + Math.random() + "&code="
				+ phone.value + "&Kind=Reg&CodeType=sms";
	}
	var result = xhojb.DownloadString(url);

	if (result == "3") {
		document.getElementById("Phone_bottom").innerHTML = "<font color='red'>您的手机号获取验证码过于频繁，请于24小时后重试。</font>";
		return false;
	} else if (result == "1") {
		document.getElementById("Phone_bottom").innerHTML = "<font color='red'>您的手机号获取验证码过于频繁，请1分钟后再试。</font>";
		return false;
	} else if (result == "4") {

		document.getElementById("Phone_top").innerHTML = "若该手机号无法接收验证信息，请拨打客服电话400-010-5656协助完成身份验证";
		if (codeType == "sms") {
			document.getElementById("bt_GetPhoneCode").className = "thehuoquoff";
			document.getElementById('bt_GetPhoneCode').disabled = true;
		
			document.getElementById("Phone_bottom").innerHTML = "验证码已发出，请注意查收短信,您可以在<span id=\"timer\" style=\"color:red\">60</span>秒后点击重新获取验证码";
			timer = document.getElementById("timer");

			countDown(60);

		} else {
			document.getElementById("hdCodeType").value = "sms";
			document.getElementById("Phone_bottom").innerHTML = "<font style='color:#333'>语音验证码已发出，您将接收到电话为您播报验证码......</font>";
			document.getElementById("bt_GetPhoneCode").className = "thehuoquon";
			document.getElementById('bt_GetPhoneCode').disabled = false;
		}

	} else {
		document.getElementById("Phone_top").innerHTML = "若该手机号无法接收验证信息，请拨打客服电话400-010-5656协助完成身份验证";
	}
	return false;
}
var timerID = null;
var timer;
function countDown(secs) {
	timer.innerHTML = secs;
	if (secs-- > 0) {
		timerID = setTimeout("countDown(" + secs + ")", 1000);
	} else {
	
		document.getElementById("outmsg").style.display = "none";
		document.getElementById("bt_GetPhoneCode").className = "thehuoquon";
		document.getElementById('bt_GetPhoneCode').disabled = false;
	}
}
