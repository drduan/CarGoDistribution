package com.neusoft.cargo.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.alibaba.fastjson.JSON;
import com.neusoft.cargo.dao.RoleDao;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.Role;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.model.Order;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.TrackOrderService;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.util.Md5Util;

@Controller("UserAction")
@RequestMapping("/User")
public class UserAction extends Base {

	@Autowired
	private UserService userService;

	@Autowired
	private TrackOrderService orderservice;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MessageService messageservice;
	Logger logger = Logger.getLogger(UserAction.class);

	@RequestMapping(value = "home.do")

	public String userhome(Model model)

	{
		if (getUser().getUsertype() == UserType.OWNER) {
			return "redirect:/admins/home.do";
		}
		List<Message> lmsg = messageservice.findAll();
		int messagecount = 0;
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				messagecount++;
			}
		}
		model.addAttribute("messagecount", messagecount);

		return "views/layout/user/index";
	}

	@RequestMapping(value = "addcar.do")
	public String addCar(Model model) {

		List<Message> lmsg = messageservice.findAll();
		int messagecount = 0;
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				messagecount++;
			}
		}
		model.addAttribute("messagecount", messagecount);

		return "views/layout/user/addcar";
	}

	@RequiresRoles(value = "user")
	@RequestMapping(value = "profile.do")
	public String profile(Model model, String orderid)

	{

		if (getUser().getUsertype() == UserType.OWNER) {
			return "redirect:/admins/home.do";
		}

		logger.error("orderid" + orderid);

		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("avater", "https://sfault-avatar.b0.upaiyun.com/397/343/3973431515-5871a5d594750_big64");
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		model.addAttribute("carsource", userService.GetCarList(user));
		List<TrackOrder> orders = new ArrayList<TrackOrder>();
		for (Car iterable_element : userService.GetCarList(user)) {

			if (iterable_element.getTock() != null) {
				orders.add(iterable_element.getTock());
			}

		}
		model.addAttribute("orders", orders);
		if (orderid != null) {
			model.addAttribute("orderdetail", "18");
		}

		return "views/layout/user/profile";
	}

	@RequiresRoles(value = "user")
	@RequestMapping(value = "orderdetail.do")
	@ResponseBody
	public String orderdetail(String orderid)

	{
		logger.info("orderid" + orderid);
		TrackOrder order = orderservice.find(orderid);
		Order disorder = new Order();
		disorder.setUuid(order.getUuid());
		disorder.setCreateTime(order.getCreateTime());
		disorder.setGoodName(order.getcResource().getGoodName());
		disorder.setDepartPlace(order.getcResource().getDeparturePlace());
		disorder.setDestPlace(order.getcResource().getDestPlace());
		disorder.setMstatus(order.getMstatus());
		disorder.setContact(order.getCar().getUser().getUsername());
		disorder.setPhone(order.getCar().getUser().getPhone());
		return JSON.toJSONString(disorder);

	}

	@RequestMapping(value = "register.do", method = RequestMethod.GET)
	public String index() {

		return "views/layout/register_step1";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(User userValidate, boolean rememberMe, Model model) {
		ensureUserIsLoggedOut();

		userValidate.setPassword(Md5Util.md5Encode(userValidate.getPassword()));

		UsernamePasswordToken token = new UsernamePasswordToken(userValidate.getEmail(), userValidate.getPassword());

		token.setRememberMe(rememberMe);
		try {
			SecurityUtils.getSubject().login(token);
			SecurityUtils.getSubject().getSession();
			SecurityUtils.getSubject().getSession().setAttribute("avater",
					"https://sfault-avatar.b0.upaiyun.com/397/343/3973431515-5871a5d594750_big64");

		} catch (UnknownAccountException e) {
			return "views/layout/UnknownAccountException";
		} catch (IncorrectCredentialsException e) {
			return "views/layout/WrongPwdException";
		} catch (LockedAccountException e) {
			// logger.error("LockedAccountException");
		} catch (ExcessiveAttemptsException e) {
			// logger.error("ExcessiveAttemptsException");
		} catch (ExpiredCredentialsException e) {
			// logger.error("ExpiredCredentialsException");
		} finally {
			token.clear();
		}

		UserType uType = (UserType) SecurityUtils.getSubject().getSession().getAttribute("usertype");
		if (uType == null) {
			return "";
		}
		if (uType.equals(UserType.DRIVER)) {
			return "redirect:/home.do";
		} else if (uType.equals(UserType.OWNER)) {
			return "redirect:/admins/home.do";
		} else if (uType.equals(UserType.MANAGER)) {
			logger.info("message manager loged in");
			ensureUserIsLoggedOut();
			return "redirect:/Manager/home.do";
		}

		else {
			return "home.do";
		}

	}

	// Logout the user fully before continuing.
	private void ensureUserIsLoggedOut() {
		try {
			// Get the user if one is logged in.
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser == null) {
				return;
			}
			// Log the user out and kill their session if possible.
			currentUser.logout();
			Session session = currentUser.getSession(false);
			if (session == null)
				return;

			session.stop();
		} catch (Exception e) {
			// Ignore all errors, as we're trying to silently
			// log the user out.
		}
	}

	/*
	 * 进行注册信息的处理 并且 注册成功 返回cookie和对应的网页
	 * 
	 * @Validated ？？
	 */
	@RequestMapping(method = RequestMethod.POST, value = "driver_register.do")
	public String DriverRegister(User user, String userType, HttpServletRequest req, HttpSession session) {
		session.setAttribute("usertype", userType);
		session.setMaxInactiveInterval(6000);
		user.setUsertype(UserType.DRIVER);
		// Role role = new Role("user", "user");
		// List<Role> roles = roleDao.findAll();
		// Set<Role> roleList = new HashSet<>();
		// Set<Role> roleList = new HashSet<>(roles);
		// for (Role r : roles) {
		// if (r.getDescription().equals("user")) {
		// roleList.add(r);
		// }
		// }
		// roleList.add(ro);
		String pwd = user.getPassword();
		String newpwd = Md5Util.md5Encode(pwd);
		user.setPassword(newpwd);
		// todo user.setRoleList(roleList);
		userService.save(user);
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST, value = "owner_register.do")
	public String OwnerRegister(User user, String userType, HttpServletRequest req, HttpSession session) {
		session.setAttribute("username", user.getUsername());
		user.setUsertype(UserType.OWNER);
		// Role role = new Role("user", "user");
		List<Role> roles = roleDao.findAll();
		// Set<Role> roleList = new HashSet<>();
		Set<Role> roleList = new HashSet<>(roles);
		// for (Role r : roles) {
		// if (r.getDescription().equals("user")) {
		// roleList.add(r);
		// }
		// }
		// roleList.add(ro);
		String pwd = user.getPassword();
		String newpwd = Md5Util.md5Encode(pwd);

		user.setPassword(newpwd);
		// todo user.setRoleList(roleList);

		userService.save(user);

		return "redirect:/";

	}

	/*
	 * 判断用户邮箱是否已经注册 返回可以使用jsonp
	 */
	@RequestMapping(value = "/ifuserexist.do")
	@ResponseBody
	public String ifuserexist(HttpSession session, @RequestParam(value = "username") String username) {
		return "true";
	}

	/*
	 * 判断验证码
	 */
	@RequestMapping(value = "/ifvalidationcode.do")
	@ResponseBody
	public String ifvalidatecodeexist(HttpSession session,
			@RequestParam(value = "validationCode") String validationCode) {
		String string = session.getAttribute("validationCode").toString().toLowerCase();
		return "" + string.equals(validationCode.toLowerCase());
	}

	// /*
	// *
	// * 处理上传文件
	// */
	// @RequestMapping(value = "/upload.do")
	// public String upload(@RequestParam(value = "file", required = false)
	// MultipartFile file, HttpServletRequest request,
	// ModelMap model) {
	// if (file.isEmpty()) {
	// return "error";
	// }
	//
	// UserAuthInfo userinfo = new UserAuthInfo();
	// userinfo.setUser(getUser());
	//
	// String path =
	// request.getSession().getServletContext().getRealPath("upload");
	// String fileName = file.getOriginalFilename();
	// // String fileName = new Date().getTime()+".jpg";
	// System.out.println(path);
	// File targetFile = new File(path, fileName);
	// if (!targetFile.exists()) {
	// targetFile.mkdirs();
	// }
	//
	// // 保存
	// try {
	// file.transferTo(targetFile);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("fileUrl", request.getContextPath() + "/upload/" +
	// fileName);
	//
	// return "result";
	// }

	/*
	 * 	
	 */
	@RequestMapping(value = "/reg_next.do", method = RequestMethod.GET)
	public String dealUserType(@RequestParam(value = "cust_kind") int cust_kind, RedirectAttributes redirectAttrs,
			Model model) {

		switch (cust_kind) {

		case 1:
			redirectAttrs.addFlashAttribute("usertype", "1");
			break;
		case 2:
			redirectAttrs.addFlashAttribute("usertype", "2");
			break;
		default:
			break;
		}
		return "redirect:/User/redirect_reg_next.do";// 默认为forward模式
	}

	@RequestMapping(value = "redirect_reg_next.do", method = RequestMethod.GET)
	public String dealUserTypeAndRedirect(@ModelAttribute("usertype") String form,
			RedirectAttributesModelMap redirectAttrs, ModelAndView model) {

		if (form.equals("1")) {
			return "views/layout/register_driver";
		} else {
			return "views/layout/register_owner";
		}

	}

	public void upload(HttpRequest request) throws IOException {
		File uploadfile = new File("");
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartHttpServletRequest.getFile("file");
		FileCopyUtils.copy(file.getBytes(), uploadfile);
	}

	@ResponseBody
	@RequestMapping("GetUserCars.json")
	public List<Car> GetUserCars(Car car) {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		List<Car> lc = userService.GetCarList(user);
		return lc;
	}

	/*
	 * 根据参数 cargoresource 的id 寻找id信息
	 */
	@ResponseBody
	@RequestMapping("TakeOrder.json")
	public String TakeOrder(long cargoresourceid) {

		return null;
	}

	@RequestMapping("settings.do")
	public String Settings() {
		return "views/layout/settings";
	}

	@RequestMapping(value = "settings.do", method = RequestMethod.POST)
	public String PostSettings(User user, Model model) {
		User user1 = getUser();
		userService.update(user1);
		model.addAttribute("message", "修改成功");
		return "/views/layout/SuccessMessage";
	}

	@ResponseBody
	@RequestMapping("GetUserOrders.json")
	public List<Order> GetUserOrders(long cargoresourceid) {
		List<Order> ark = new ArrayList<>();
		User user = userService.find(getUser().getId());
		for (Car iterable_element : user.getCars()) {
			Order order = new Order();
			order.setUuid(iterable_element.getTock().getUuid());
			order.setCreateTime(iterable_element.getTock().getCreateTime());
			order.setGoodName(iterable_element.getTock().getcResource().getGoodName());
			order.setDepartPlace(iterable_element.getTock().getcResource().getDeparturePlace());
			order.setDestPlace(iterable_element.getTock().getcResource().getDestPlace());
			order.setMstatus(iterable_element.getTock().getMstatus());
			order.setContact(iterable_element.getTock().getCar().getUser().getUsername());
			order.setPhone(iterable_element.getTock().getCar().getUser().getPhone());
			ark.add(order);
		}

		return null;
	}
	//
	// @RequestMapping("getdetailedorder.do")
	// public String getdetailedorder (long )
	// {
	//
	// return "";
	// }

}
