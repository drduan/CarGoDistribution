package com.neusoft.cargo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.model.Order;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.UserService;

@Controller("AdminAction")
@RequestMapping("/admins")
public class AdminAction extends Base {

	private Logger logger = Logger.getLogger(AdminAction.class);
	@Autowired
	private UserService userservice;
	@Autowired
	private CargoResourceService carResourceService;

	@Autowired
	private MessageService messageservice;

	
	@RequestMapping(value="settings.do")
	public String adminSet()
	{
		
		return "redirect:/home.do";
				
	}
	
	
	@RequestMapping(value = "home.do")
	public String Home(Model model) {
		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {
			if (message.getToperson().getEmail() ==getUser().getEmail()) {
				 ++messagecount;
				 logger.info(""+message.getToperson().getEmail()+""+getUser().getEmail());
			}
		}
		model.addAttribute("messagecount", messagecount);
		return "views/layout/admins/profile";
	}

	@RequestMapping(value = "adminprofile.do")
	public String AdminProfile(Model model) {
		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				messagecount ++;
			}
		}
		model.addAttribute("messagecount", messagecount);
		
		List<CargoResource> cargoResources = ((User) SecurityUtils.getSubject().getSession().getAttribute("user"))
				.getCargoResources();
		model.addAttribute("cargoResources", cargoResources);
		return "views/layout/admins/profile";
	}

	@RequestMapping(value = "logout.do")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/";
	}

	@RequestMapping(value = "publishgoods.do", method = RequestMethod.GET)
	public String publishgoods() {

		return "views/layout/admins/publishgoods";
	}

	@RequestMapping(value = "publishgoods.do", method = RequestMethod.POST)
	public String publishgoodsPost(CargoResource resource) {

		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");

		resource.set_user(user);
		carResourceService.save(resource);
		return "redirect:adminprofile.do";
	}

	@RequestMapping(value = "GetUserCargoResource.json")
	@ResponseBody
	public List<CargoResource> GetUserCargoResource() {
		List<CargoResource> result = userservice.GetCargoResourceList(getUser());
		return result;
	}

	@ResponseBody
	@RequestMapping("GetOwnerOrder.json")
	public List<Order> GetUserOrder() {

		List<Order> lTrackOrders = new ArrayList<>();
		User user2 = userservice.find(getUser().getId());
		for (CargoResource iterable_element : user2.getCargoResources()) {
			if (iterable_element.getOrder() != null) {
				Order order = new Order();
				order.setUuid(iterable_element.getOrder().getUuid());
				order.setCreateTime(iterable_element.getOrder().getCreateTime());
				order.setGoodName(iterable_element.getGoodName());
				order.setDepartPlace(iterable_element.getDeparturePlace());
				order.setDestPlace(iterable_element.getDestPlace());
				order.setMstatus(iterable_element.getOrder().getMstatus());
				order.setContact(iterable_element.getOrder().getCar().getUser().getUsername());
				order.setPhone(iterable_element.getOrder().getCar().getUser().getPhone());
				lTrackOrders.add(order);
			}
		}
		return lTrackOrders;

	}

}
