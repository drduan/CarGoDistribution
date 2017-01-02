package com.neusoft.cargo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

// 这是一个pojo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Driver;
import com.neusoft.cargo.entity.Owner;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.service.impl.UserServiceImpl;

@Controller("UserAction")
@RequestMapping("/User")
public class UserAction extends BaseAction {

	@Autowired
	private UserServiceImpl userService;

	// @RequestMapping("/greeting")
	// public String greeting(@RequestParam(value="name", required=false,
	// defaultValue="World") String name, Model model) {
	// model.addAttribute("name", name);
	// return "greeting";
	// }

	// @ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/register.do")
	public String Register(User user, String userType, HttpServletRequest req, HttpSession session) {
		// validationCode

		if (user == null) {

			return "ERROR";
		}
		if (user.getUsertype() == UserType.DRIVER) {
			User user2 = new Driver();
			user2 = user;
			userService.save(user);
		}
		if (user.getUsertype() == UserType.OWNER) {
			User user2 = new Owner();
			user2 = user;
			userService.save(user);
		}
	
		
	
		return "index";
		// return "{\"message\",\"ok\"}";
	}
}
