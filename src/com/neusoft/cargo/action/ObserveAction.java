package com.neusoft.cargo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ObserveAction")
public class ObserveAction extends Base {

	@RequestMapping(value = "user.do", method = RequestMethod.GET)
	public String lookuser() {
		
		return "views/layout/userinfo";

	}
	
}
