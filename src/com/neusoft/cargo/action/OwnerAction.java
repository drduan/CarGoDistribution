package com.neusoft.cargo.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import com.neusoft.cargo.service.CarService;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;

@Controller("OwnerAction")
@RequestMapping("/admins")
public class OwnerAction extends Base {

	private Logger logger = Logger.getLogger(OwnerAction.class);
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
	public String Home(Model model  ) {
		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {
			if (message.getToperson().getId() == getUser().getId()) {
				if (!message.isStatus()) {
					++messagecount;
				}
				
			}
		}
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		model.addAttribute("carsource", userservice.GetCargoResourceList(user));
		List<TrackOrder> orders = new ArrayList<TrackOrder>();
		for (CargoResource iterable_element : userservice.GetCargoResourceList(user)) {

			if (iterable_element.getOrder() != null) {
//				orders.add(iterable_element.getOrder());
				for (TrackOrder trackOrder : iterable_element.getOrder() ) {
					logger.info("admin order size"+iterable_element.getOrder().size());
					orders.add(trackOrder);
				}
				
			}

		}
		model.addAttribute("orders", orders);
//		logger.info("admin order size"+orders.size());
		model.addAttribute("messagecount", messagecount);
		return "views/layout/admins/profile";
	}

	@RequestMapping(value = "adminprofile.do")
	public String AdminProfile(Model model) {
		int messagecount = 0;
		List<Message> lmsg = messageservice.findAll();
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser()) &&! message.isStatus()) {
			
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
		StringBuilder str = new StringBuilder();// 定义变长字符串
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		// 将字符串转换为数字并输出
		int num = Integer.parseInt(str.toString());
		resource.setYpbm(""+num);
		resource.set_user(user);
		carResourceService.save(resource);
		return "redirect:home.do";
	}

	@RequestMapping(value = "GetUserCargoResource.json")
	@ResponseBody
	public List<CargoResource> GetUserCargoResource() {
		List<CargoResource> result = userservice.GetCargoResourceList(getUser());
		return result;
	}

//	@ResponseBody
//	@RequestMapping("GetOwnerOrder.json")
//	public List<Order> GetUserOrder() {
//
//		List<Order> lTrackOrders = new ArrayList<>();
//		User user2 = userservice.find(getUser().getId());
//		for (CargoResource iterable_element : user2.getCargoResources()) {
//			if (iterable_element.getOrder() != null) {
//				
//				for (TrackOrder order : iterable_element.getOrder()) {
//					Order ordern = new Order();
//					ordern.setUuid(order.getUuid());
//					ordern.setCreateTime(order.getCreateTime());
//					ordern.setGoodName(iterable_element.getGoodName());
//					ordern.setDepartPlace(iterable_element.getDeparturePlace());
//					ordern.setDestPlace(iterable_element.getDestPlace());
//					ordern.setMstatus(order.getMstatus());
//					ordern.setContact(order.getCar().getUser().getUsername());
//					ordern.setPhone(order.getCar().getUser().getPhone());
//					lTrackOrders.add(ordern);
//				}
//				
//			}
//		}
//		return lTrackOrders;
//
//	}

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
				if (!message.isStatus()) {
					messagecount++;
				}
			
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
		order.setState(OrderType.PENDING); // 设置为运输中
		orderservice.update(order);
		CargoResource cargoResource = carResourceService.find(order.getcResource().getCarresourceid());
//		cargoResource.setStatus(true);
		cargoResource.setStatus(1);
		for (TrackOrder iterable_element : cargoResource.getOrder()) {
			//设置其他订单的状态
//			if (iterable_element.getUuid()!=uuid) {
//				iterable_element.setOrderType(OrderType.CANCEL);
//				iterable_element.getCar().setCarStatus(false);
//				orderservice.save(iterable_element);
//			}
			
			if (!iterable_element.getState().equals(OrderType.PENDING)) {
				
				iterable_element.setState(OrderType.CANCEL);
				iterable_element.getCar().setCarStatus(false);
				orderservice.save(iterable_element);
			}
		
		}
		carResourceService.save(cargoResource);
		Message message = new Message();
		message.setContent("预约申请已经通过");
		message.setToperson(order.getCar().getUser());
		messageservice.save(message);
		return "success";

	}

	@RequestMapping(value = "markasread.do")
	public String MarkAsRead(Model model, String id) {
		messageservice.updateMsgAsRead(Integer.parseInt(id));
		return "redirect:msgl.do";
	}

	// 支付尾款 退回押金 交易结束
	@RequestMapping("payorder.do")
	@ResponseBody
	public String payorder(Model model, String orderid)

	{
		TrackOrder order = orderservice.find(orderid);
		order.setState(OrderType.DISPATCHED);
		order.setFinish_time(new Timestamp(System.currentTimeMillis()));
		orderservice.save(order);

		Car car = carService.find(order.getCar().getId());
		car.setCarStatus(false);
		carService.update(car);
		Message message = new Message();
		message.setContent("订单结束~ 请您抓紧时间评论哦");
		message.setToperson(order.getCar().getUser());
		messageservice.save(message);
		
		return "success";
	}

}
