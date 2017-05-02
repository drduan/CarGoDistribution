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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.OrderType;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.model.Order;
import com.neusoft.cargo.service.CarService;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.TrackOrderService;
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
	@Autowired
	TrackOrderService orderservice;
	@Autowired
	CarService carService;

	@RequestMapping(value = "settings.do")
	public String adminSet() {
		// todo
		return "redirect:/home.do";
	}

	@RequestMapping(value = "home.do")
	public String Home(Model model) {
		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {
			if (message.getToperson().getId() == getUser().getId()) {
				++messagecount;
			}
		}
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		model.addAttribute("carsource", userservice.GetCargoResourceList(user));
		List<TrackOrder> orders = new ArrayList<TrackOrder>();
		for (CargoResource iterable_element : userservice.GetCargoResourceList(user)) {

			if (iterable_element.getOrder() != null) {
				orders.add(iterable_element.getOrder());
			}

		}
		model.addAttribute("orders", orders);
		model.addAttribute("messagecount", messagecount);
		return "views/layout/admins/profile";
	}

	@RequestMapping(value = "adminprofile.do")
	public String AdminProfile(Model model) {
		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				messagecount++;
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
	public String publishgoods(Model model) {

		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				messagecount++;
			}
		}
		model.addAttribute("messagecount", messagecount);

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

	@RequestMapping("msgl.do")
	public String msgList(Model model) {

		logger.info("admin msg ");
		List<Message> lmsg = messageservice.findAll();
		List<Message> selflmsg = new ArrayList<Message>(0);
		for (Message message : lmsg) {
			if (message.getToperson().equals(getUser())) {
				selflmsg.add(message);
			}
		}
		int messagecount = 0;
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				messagecount++;
			}
		}
		model.addAttribute("messagecount", messagecount);
		model.addAttribute("msglist", selflmsg);
		return "views/layout/admins/sysmsglist";
	}

	@RequestMapping("passorder.do")
	@ResponseBody
	public String PassOrder(@RequestParam("orderid") String uuid) {

		logger.info(uuid);
		TrackOrder order = orderservice.find(uuid);
		order.setOrderType(OrderType.PENDING); // 设置为运输中
		orderservice.update(order);
		CargoResource cargoResource = carResourceService.find(order.getcResource().getCarresourceid());
		cargoResource.setStatus(true);
		carResourceService.save(cargoResource);
		return "success";

	}

	@RequestMapping(value = "markasread.do")
	public String MarkAsRead(Model model, String id) {
		messageservice.updateMsgAsRead(Integer.parseInt(id));
		return "redirect:msgl.do";
	}

	// 支付尾款 退回押金
	@RequestMapping("payorder.do")
	@ResponseBody
	public String payorder(Model model, String orderid)

	{
		TrackOrder order = orderservice.find(orderid);
		order.setOrderType(OrderType.RECEIVED);
		orderservice.save(order);

		Car car = carService.find(order.getCar().getId());
		car.setCarStatus(false);
		carService.update(car);
		// messageservice.updateMsgAsRead(Integer.parseInt(id));
		// return "redirect:msgl.do";
		return "success";
	}

}
