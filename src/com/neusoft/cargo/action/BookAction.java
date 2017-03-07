package com.neusoft.cargo.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.impl.CarServiceImpl;
import com.neusoft.cargo.service.impl.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller("BookAction")
@RequestMapping("/Car")
public class BookAction extends BaseAction {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private CarServiceImpl carService;

	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BookAction.class);

	@RequestMapping("InsertCarForUser.do")
	public String InsertCarForUser(Car car) {

		logger.error(car.toString());
		// SecurityUtils.getSubject().getSession().setAttribute("user", user);
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		Set<Car> sc = new HashSet<>(0);
		sc.add(car);
		user.setStockDailyRecords(sc);
		carService.save(car);
		userService.save(user);

		return "redirect:/User/profile.do";

	}

	@ResponseBody
	@RequestMapping("GetUserCars.json")
	public Map<String, Object> GetUserCars(Car car) {
		logger.error(car.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		List<Car> lc = userService.GetCarList(user);
		return map;
	}

}
