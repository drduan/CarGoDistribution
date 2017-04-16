package com.neusoft.cargo.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.cargo.service.MessageService;

@Controller("MsgAction")
public class MsgAction extends Base {

	
	@Autowired
	private MessageService messageservice;
	Logger logger = Logger.getLogger(UserAction.class);
	
	
	@RequestMapping(value = "markasread.do")
	public String MarkAsRead(Model model,String id)

	{
		messageservice.updateMsgAsRead(Integer.parseInt(id));
		
		return "redirect:sysmsglist.do";
	}
	
	
}
