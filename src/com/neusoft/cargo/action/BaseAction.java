package com.neusoft.cargo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class BaseAction {

	
	@RequestMapping(method=RequestMethod.POST )
	public  String  index() {
		
		return "index.jsp";
	}
	
	
	
	
}


