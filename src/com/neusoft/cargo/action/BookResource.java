package com.neusoft.cargo.action;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.OrderType;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.service.CarService;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;

@Controller("BookResourceAction")
public class BookResource extends Base {

	Logger logger = Logger.getLogger(BookResource.class);

	@Autowired
	private UserService userservice;
	@Autowired
	private CarService carService;
	@Autowired
	private CargoResourceService cargoResourceService;
	@Autowired
	private TrackOrderService trackOrderService;
	@Autowired
	private MessageService messageservice;
	@Autowired
	private MessageService msgService;

	// ${pageContext.request.contextPath}/person/updatePersonList.action"
	@RequestMapping(value = "bookresource.do", method = RequestMethod.GET)
	public String bookresource(String idname, Model model) {
		// JsonParameter
		model.addAttribute("messagecount", getMessageCount());
		List<Car> cl = userservice.GetCarList(getUser());
		CargoResource cargoResource = cargoResourceService.find(Integer.parseInt(idname));

		model.addAttribute("cargoResource", cargoResource);
		model.addAttribute("carsource", cl);
		return "views/layout/checkout";
	}

	public int getMessageCount() {
		List<Message> lmsg = messageservice.findAll();
		int messagecount = 0;
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				if (!message.isStatus()) {
					messagecount++;
				}

			}
		}
		return messagecount;
	}

	@ResponseBody
	@RequestMapping(value = "bookresource.do", method = RequestMethod.POST)
	public String postbookresource(long cid, int rid, Integer idname, Model model) {
		// 判断 车和货物是否在运输中
		// false表示不可送达
		Car car2 = carService.find(cid);
		CargoResource car = cargoResourceService.find(rid);
		if (car.isStatus() || car2.isCarStatus()) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", "faild");
			return jsonObject.toJSONString();
		}

		// 设置资源状态 不可用
		car2.setCarStatus(true);
		// car.setStatus(true);

		UUID uuid = UUID.randomUUID();
		TrackOrder tOrder = new TrackOrder();
		tOrder.setCar(car2);
		tOrder.setcResource(car);
		// 可以未支付
		// tOrder.setOrderType(OrderType.WAITINGACCESS);
		tOrder.setOrderType(OrderType.PENDING);
		tOrder.setUuid(uuid.toString());
		trackOrderService.save(tOrder);

		Message message = new Message();
		message.setContent("有新的预约 前去查看;订单号" + tOrder.getUuid());
		message.setToperson(userservice.find(car.get_user().getId()));
		msgService.save(message);
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("status", "success");
		jsonObject.put("orderno", tOrder.getUuid());
		return jsonObject.toJSONString();

	}

	@RequestMapping(value = "paying.do", method = RequestMethod.GET)
	public String paying() {

		return "views/layout/paying";

	}

	/*
	 * 车主支付完押金
	 */
	@RequestMapping(value = "paid.do", method = RequestMethod.GET)
	public String paid(String orderid) {
		TrackOrder order = trackOrderService.find(orderid);
		order.setOrderType(OrderType.PAID);
		trackOrderService.update(order);
		return "redirect:/User/profile.do";
	}

	@RequestMapping("finishtrans.do")
	@ResponseBody
	public String finishtrans(String orderid) {
		logger.info("orderid"+orderid);
		TrackOrder order = trackOrderService.find(orderid);
		order.setOrderType(OrderType.COMPLETED);// 订单完成
		trackOrderService.update(order);
		return "success";
	}

}
