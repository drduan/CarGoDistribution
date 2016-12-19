package com.neusoft.cargo.action;
// 这是一个pojo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.service.UserService;

@Controller("UserAction")
@RequestMapping("/User")
public class UserAction extends BaseAction {

	@Autowired
	private UserService userService;

	// @RequestMapping(method = RequestMethod.GET)
	// public String info(Model model,Page page){
	// return null;
	// List<User> infoList = userService.listPageInfo(page);
	// model.addAttribute("infoList", infoList);
	// model.addAttribute("page", page);
	// return "info";
	// }

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value="/register.do")
	public String Register() {
		System.out.println("注册");

		return "{\"message\",\"ok\"}";
	}
}
