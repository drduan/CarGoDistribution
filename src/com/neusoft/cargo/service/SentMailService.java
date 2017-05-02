package com.neusoft.cargo.service;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SentMailService {

	public void send() {

		MultiPartEmail email = new MultiPartEmail();

		email.setHostName("smtp.qq.com");// 设置使用发电子邮件的邮件服务器 smtp.163.com
		try {
			email.addTo("收件人信箱", "收件人别名");
			email.setAuthentication("发件人信箱", "发件人信箱密码");// smtp认证的用户名和密码
			email.setFrom("发件人信箱", "发件人别名");// 写的信箱要与设置使用发电子邮件的邮件服务器相对应
			email.setSubject("Test apache.commons.mail message");// 标题
			email.setMsg("This is a simple test of commons-email");// 内容
			EmailAttachment emailattachment = new EmailAttachment();
			emailattachment.setPath("love.jpg");// 放到工程下
			email.attach(emailattachment);
			email.send();
		} catch (EmailException ex) {
			ex.printStackTrace();
		}

	}
}
