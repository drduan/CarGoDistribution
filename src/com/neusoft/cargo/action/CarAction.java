package com.neusoft.cargo.action;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.CarService;
import com.neusoft.cargo.service.UserService;

@Controller("BookAction")
@RequestMapping("/Car")
public class CarAction extends Base {

	@Autowired
	private UserService userService;

	@Autowired
	private CarService carService;

	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CarAction.class);

	@RequestMapping("InsertCarForUser.do")
	public String InsertCarForUser(Car car) {

		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");

		userService.addCarToUser(user, car);
		return "redirect:/User/profile.do";

	}

	@ResponseBody
	@RequestMapping("delcar.do")
	public String delcar(String carid) {
		// userService.delCar(getUser(),Long.parseLong(carid));
		carService.remove(Long.parseLong(carid));
		return "success";
	}

}
