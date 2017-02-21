package com.neusoft.cargo.action;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminAction")
@RequestMapping("/admins")
public class AdminAction {
	

	private Logger logger = Logger.getLogger(AdminAction.class);
	
	@RequestMapping(value="home.do")
	public String Home() {
		
//		logger.info("进入AdminAction");
//		Subject subject = SecurityUtils.getSubject();
//		logger.error("hasrole"+subject.hasRole("admin"));
//		Assert.assertEquals("\n user has role admin \n ", true, subject.hasRole("admin")); 
		return "views/layout/admins/index";
	}

}
