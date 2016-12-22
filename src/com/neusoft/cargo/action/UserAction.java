package com.neusoft.cargo.action;
// 这是一个pojo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.service.impl.UserServiceImpl;

@Controller("UserAction")
@RequestMapping("/User")
public class UserAction extends BaseAction {

	@Autowired
	private UserServiceImpl userService;

//	 @RequestMapping("/greeting")
//	    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//	        model.addAttribute("name", name);
//	        return "greeting";
//	    }

	
	
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value="/register.do")
	public String Register() {
		System.out.println("注册");
//		Session session = this.
		User person = new User();
		person.setUsername("a");
		
			userService.save(person);
			// TODO: handle exception
		
		
		return "{\"message\",\"ok\"}";
	}
}
