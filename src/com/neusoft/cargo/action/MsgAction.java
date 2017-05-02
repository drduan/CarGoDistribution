package com.neusoft.cargo.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neusoft.cargo.service.MessageService;

@Controller("MsgAction")
public class MsgAction extends Base {

	@Autowired
	private MessageService messageservice;
	Logger logger = Logger.getLogger(UserAction.class);

	@RequestMapping(value = "markasread.do")
	public String MarkAsRead(Model model, String id)

	{
		messageservice.updateMsgAsRead(Integer.parseInt(id));

		return "redirect:sysmsglist.do";
	}

	@RequestMapping(value = "/successmsg.do")
	public String upload(Model model, @RequestParam(value = "msg") String t_name,
			@RequestParam(value = "info") String t_id) {

		model.addAttribute("msg", "支付请求");
		model.addAttribute("info", "请您支付预约金额￥" + t_id);
		model.addAttribute("btn", "ok");
		model.addAttribute("btn1", "支付完成");
		model.addAttribute("btn2", "取消支付");

		return "/views/layout/successmodel";
	}

}
