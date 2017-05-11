package com.neusoft.cargo.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;

@Controller("ObserveAction")
public class ObserveAction extends Base {

	@Autowired
	public UserService userservice;

	@RequestMapping(value = "user.do", method = RequestMethod.GET)
	public String lookuser(@RequestParam("id") long id, Model model) {

		User user = userservice.find(id);
		model.addAttribute("user", user);
		model.addAttribute("utype", user.getUsertype());

		List<TrackOrder> orders = new ArrayList<>();
		for (Car iterable_element : user.getCars()) {
			for (TrackOrder trackOrder : iterable_element.getTock()) {
				orders.add(trackOrder);
			}
		}

		model.addAttribute("orders", orders);

		return "views/layout/userinfo";

	}

}
