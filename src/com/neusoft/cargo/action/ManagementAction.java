package com.neusoft.cargo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.cargo.entity.Complaints;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.UserAuthInfo;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.UserAuthService;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.service.impl.ComplaintServiceImpl;
import com.neusoft.cargo.util.Md5Util;

/*
 * 纪念
 */
@Controller("ManagerAction")
@RequestMapping("/Manager")
public class ManagementAction {

	@Autowired
	UserService userservice;
	@Autowired
	MessageService msgService;
	@Autowired
	UserAuthService userauthService;

	@Autowired
	ComplaintServiceImpl complaintServiceImpl;

	private Logger logger = Logger.getLogger(ManagementAction.class);

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String index(Model model, User user) {
		List<UserAuthInfo> auth = new ArrayList<>();
		auth = userauthService.findAll();
		logger.info("auth message" + auth.size());
		model.addAttribute("auth", auth);

		return "views/layout/manager/index";

	}

	@RequestMapping(value = "welcome.do", method = RequestMethod.GET)
	public String welcome(Model model, User user) {

		return "views/layout/manager/welcome";

	}

	@RequestMapping(value = "banner-edit.do", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("auid") int auid) {
		// http://localhost:8080/_CarGoDistribution/Manager/banner-edit.do?auid=9

		UserAuthInfo ui = userauthService.find(auid);
		model.addAttribute("au", ui);
		return "views/layout/manager/banner-edit";

	}

	@ResponseBody
	@RequestMapping(value = "banner-add.do")
	public String add(Model model, String suggest) {
		logger.info(suggest);
		JSONObject jObject = JSON.parseObject(suggest);
		UserAuthInfo userAuthInfo = userauthService.find(jObject.getInteger("id"));
		userAuthInfo.setResult(jObject.getString("result"));
		userAuthInfo.setPass(jObject.getBooleanValue("pass"));
		userauthService.save(userAuthInfo);

		if (jObject.getBooleanValue("pass")) {
			userAuthInfo.getUser().setHasauthentication(true);
		} else {
			userAuthInfo.getUser().setHasauthentication(false);

		}
		return "success";

	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login(Model model, User user) {

		return "views/layout/manager/login";

	}

	@RequestMapping("banner-list")
	public String bannerL(Model model) {
		List<UserAuthInfo> auth = new ArrayList<>();
		// List<UserAuthInfo> newauth = new ArrayList<>();
		// for (UserAuthInfo userAuthInfo : auth) {
		// userAuthInfo.setAddress1(userAuthInfo.getAddress1().);
		// }
		auth = userauthService.findAll();

		logger.info("auth message" + auth.size());
		model.addAttribute("auth", auth);
		return "views/layout/manager/banner-list";
	}

	/*
	 * 审核通过
	 */
	@RequestMapping("passauth.do")
	@ResponseBody
	public String passauth(Model model, @RequestParam("userid") long userid, @RequestParam("result") String Result) {

		User user = userservice.find(userid);
		user.getUserAuthInfo().setResult(Result);
		user.setHasauthentication(true);
		Message message = new Message();
		message.setContent("系统审核通过");
		message.setToperson(user);
		msgService.save(message);
		return "success";
	}

	/*
	 * 审核不通过
	 */
	@RequestMapping("rejectauth.do")
	@ResponseBody
	public String rejectauth(Model model, @RequestParam("userid") long userid, @RequestParam("result") String Result) {

		User user = userservice.find(userid);
		user.getUserAuthInfo().setResult(Result);
		user.setHasauthentication(false);
		userservice.save(user);
		Message message = new Message();
		message.setContent("系统审核不通过");
		message.setToperson(user);
		msgService.save(message);
		return "success";
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
		return "redirect:/Manager/home.do";

	}

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

	@RequestMapping("getAllComplaints.do")
	public String GetAllComplaints(Model model) {

		List<Complaints> lComplaints = complaintServiceImpl.findAll();
		model.addAttribute("lComplaints", lComplaints);
		// complaintServiceImpl
		return null;
	}

	@RequestMapping("updateComplaints.do")
	public String UpdateComplaints(Model model, Complaints complaints) {
		complaintServiceImpl.save(complaints);
		// List<Complaints> lComplaints = complaintServiceImpl.findAll();
		// model.addAttribute("lComplaints", lComplaints)
		// complaintServiceImpl

		return null;
	}

}
