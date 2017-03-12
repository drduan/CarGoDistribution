package com.neusoft.cargo.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.CarService;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.service.impl.CarServiceImpl;

@Controller("BookAction")
@RequestMapping("/Car")
public class BookAction extends BaseAction {

//	@Autowired
//	private UserServiceImpl userService;

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private CarServiceImpl carService;
	
	
	@Autowired
	private CarService carService;

	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BookAction.class);

	@RequestMapping("InsertCarForUser.do")
	public String InsertCarForUser(Car car) {

		logger.error(car.toString());
		// SecurityUtils.getSubject().getSession().setAttribute("user", user);
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");

		userService.addCarToUser(user,car);
		return "redirect:/User/profile.do";

	}


}
