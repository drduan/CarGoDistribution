package com.neusoft.cargo.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Comment;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.service.impl.CommentServiceImpl;

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
	Logger logger = Logger.getLogger(UserAction.class);

	@RequestMapping(value = "markasread.do")
	public String MarkAsRead(Model model, String id)

	{
		messageservice.updateMsgAsRead(Integer.parseInt(id));

		return "redirect:sysmsglist.do";
	}

	@RequestMapping(value = "/successmsg.do")
	public String upload(Model model, @RequestParam(value = "msg") String t_name,
			@RequestParam(value = "info") String t_id) {

		logger.info("message /successmsg.do");
		model.addAttribute("msg", "支付请求");
		model.addAttribute("info", "请您支付预约金额￥" + t_id);
		model.addAttribute("btn", "ok");
		model.addAttribute("btn1", "支付完成");
		model.addAttribute("btn2", "取消支付");

		return "/views/layout/successmodel";
	}

	@RequestMapping("comment.do")
	public String Comment(Comment comment) {

	
		
		TrackOrder order = orderService.find(comment.getUuid());
		User user = userService.find(order.getcResource().get_user().getId());
		user.setRate(Integer.parseInt(comment.getRate()));
		userService.save(user);
		
		order.setDrivercommented(true);
		orderService.save(order);
		comment.setOrder(order);
		comment.setFlag("toowner");
		commentService.save(comment);
		return "redirect:/home.do";
	}
	@RequestMapping("commentto.do")
	public String Commentto(Comment comment) {

		TrackOrder order = orderService.find(comment.getUuid());
		User user = userService.find(order.getCar().getUser().getId());
		user.setRate(Integer.parseInt(comment.getRate()));
		userService.save(user);
		order.setOwnercommented(true);
		orderService.save(order);
		comment.setOrder(order);
		comment.setFlag("todriver");
		commentService.save(comment);
		return "redirect:/home.do";
	}

}
