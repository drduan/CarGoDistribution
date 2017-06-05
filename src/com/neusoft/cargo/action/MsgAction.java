package com.neusoft.cargo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.Comment;
import com.neusoft.cargo.entity.Complaints;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.service.impl.CommentServiceImpl;
import com.neusoft.cargo.service.impl.ComplaintServiceImpl;
import com.opensymphony.xwork2.Result;

@Controller("MsgAction")
public class MsgAction extends Base {

	@Autowired
	private MessageService messageservice;
	@Autowired
	private CommentServiceImpl commentService;
	@Autowired
	private TrackOrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	public ComplaintServiceImpl compliantservice;
	@Autowired
	private CargoResourceService cargoResourceService;
	
	
	Logger logger = Logger.getLogger(UserAction.class);

	@RequestMapping(value = "markasread.do")
	public String MarkAsRead(Model model, String id) {
		messageservice.updateMsgAsRead(Integer.parseInt(id));
		return "redirect:sysmsglist.do";
	}

	@RequestMapping(value = "/successmsg.do")
	public String upload(Model model, @RequestParam(value = "msg") String t_name,
			@RequestParam(value = "info") String t_id) {
		logger.info("message /successmsg.do");
		model.addAttribute("msg", "支付请求"+t_name);
		model.addAttribute("info", "请您支付预约金额￥" + t_id);
		model.addAttribute("btn", "ok");
		model.addAttribute("btn1", "支付完成");
		model.addAttribute("btn2", "取消支付");
		return "/views/layout/successmodel";
	}

	/*
	 * 车主给评论
	 */
	@RequestMapping("comment.do")
	public String Comment(Comment comment) {
		TrackOrder order = orderService.find("" + comment.getUuid());
		User user = userService.find(order.getcResource().get_user().getId());
		user.setRate((user.getRate() + Integer.parseInt(comment.getRate())) / 2);
		userService.save(user);
		
		order.setDrivercommented(true);
		orderService.save(order);
		comment.setOrder(order);
		comment.setFlag("toowner");
		commentService.save(comment);
		
		Message message = new Message();
		message.setContent("车主已经评论过订单 评论内容"+comment.getContent()+"\n  给您评分"+comment.getRate());
		message.setToperson(user);
		messageservice.save(message);
		
		return "redirect:/home.do";
	}


	/*
	 * 货主给评论
	 */
	@RequestMapping("commentto.do")
	public String Commentto(Comment comment) {
		TrackOrder order = orderService.find("" + comment.getUuid());
		User user = userService.find(order.getCar().getUser().getId());
		user.setRate((user.getRate() + Integer.parseInt(comment.getRate())) / 2);
		userService.save(user);
		order.setOwnercommented(true);
		orderService.save(order);
		comment.setOrder(order);
		comment.setFlag("todriver");
		commentService.save(comment);
		
		Message message = new Message();
		message.setContent("货主已经评论过订单 评论内容"+comment.getContent()+"\n   给您评分"+comment.getRate());
		message.setToperson(user);
		messageservice.save(message);
		
		return "redirect:/home.do";
	}

	@RequestMapping(value = "complaints.do", method = RequestMethod.POST)
	public String PostComplaints(Complaints complaints) {
		complaints.setLaunchMan(getUser());

		if (orderService.find("" + complaints.getUuid()) != null) {
			Car car = orderService.find("" + complaints.getUuid()).getCar();
			CargoResource resource = orderService.find("" + complaints.getUuid()).getcResource();
			if (car != null && resource != null) {
				if (car.getUser().getId() == getUser().getId()) {
					complaints.setRelateMan(resource.get_user());
				} else {
					complaints.setRelateMan(car.getUser());
				}
			}
		}
		if (complaints.getYpbm() != null) {

			CargoResource resource = cargoResourceService.findByYpbm("" + complaints.getYpbm());
			if (resource!=null) {
				complaints.setRelateMan(resource.get_user());
			}
			

		}
		compliantservice.save(complaints);
		return "redirect:/home.do";
	}
	// 其实对于list，只能通过遍历来查找，对于数据不大，性能上没问题。
	// 要是数据很多，应该优先考虑hashmap，而不是用list来存放数据

	// 投诉接口
	@RequestMapping(value = "complaints.do", method = RequestMethod.GET)
	public String Complaints() {

		return "views/layout/complaint";
	}

	@RequestMapping(value = "complaintlist.do", method = RequestMethod.GET)
	public String Complaintslist(Model model, @RequestParam("type") String type) {

		List<Complaints> complaints = compliantservice.findAll();
		List<Complaints> complaintsshow = new ArrayList<Complaints>();

		if (type.equals("yp")) {
			logger.error("type" + "yp");
			for (Complaints complaints2 : complaints) {

				if (complaints2.getComptype() == 0) {
					TrackOrder order = orderService.find("" + complaints2.getUuid());
					complaintsshow.add(complaints2);
				}
			}
		} else if (type.equals("yd")) {
			for (Complaints complaints2 : complaints) {
				if (complaints2.getComptype() != 0) {
					complaintsshow.add(complaints2);
				}
			}
		}
		model.addAttribute("complaints", complaintsshow);
		return "views/layout/manager/complaint-list";
	}
	
	@RequestMapping("comresult.do")
	public String comresult(Model model)
	{
		
		model.addAttribute("messagecuount",getMessageCount());
		model.addAttribute("model",compliantservice.findAll());
		return "views/layout/comresult";
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
}
