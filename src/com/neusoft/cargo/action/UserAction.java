package com.neusoft.cargo.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.impl.UserServiceImpl;
import com.neusoft.cargo.util.Md5Util;

@Controller("UserAction")
@RequestMapping("/User")
public class UserAction extends BaseAction {

	@Autowired
	private UserServiceImpl userService;

	Logger logger = Logger.getLogger(UserAction.class);

	@RequestMapping(value = "register.do", method = RequestMethod.GET)
	public String index() {

		return "views/layout/register_step1";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(User userValidate, boolean rememberMe) {
		// @RequestParam(value = "rememberMe") boolean rememberMe
		ensureUserIsLoggedOut();

		logger.error(userValidate.toString());
		UsernamePasswordToken token = new UsernamePasswordToken(userValidate.getEmail(),
				Md5Util.md5Encode(userValidate.getPassword()));
		token.setRememberMe(rememberMe);

		try {
			SecurityUtils.getSubject().login(token);
			SecurityUtils.getSubject().getSession();
			logger.info("User [" + token.getPrincipal() + "] logged in successfully.");
			
			return "login success";
		} catch (UnknownAccountException uae) {
			return "error username";
		} catch (IncorrectCredentialsException ice) {
			return "error password";
		}finally {
			token.clear();
		}

	}

	// Logout the user fully before continuing.
	private void ensureUserIsLoggedOut() {
		try {
			// Get the user if one is logged in.
			Subject currentUser = SecurityUtils.getSubject();
			if (currentUser == null) {
				logger.log(Priority.DEBUG, "current user == null");
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
	@RequestMapping(method = RequestMethod.POST, value = "register.do")
	public String Register(User user, String userType, HttpServletRequest req, HttpSession session) {

		logger.error("message");
		System.out.println(user.getEmail());
			
		session.setAttribute("username", user.getUsername());
		session.setMaxInactiveInterval(6000);

		String pwd = user.getPassword();
		String newpwd = Md5Util.md5Encode(pwd);
		
		user.setPassword(newpwd);

		userService.save(user);

		return "redirect:/";

	}

	/*
	 * 判断用户邮箱是否已经注册 返回可以使用jsonp
	 */
	@RequestMapping(value = "/ifuserexist.do")
	@ResponseBody
	public String ifuserexist(HttpSession session, @RequestParam(value = "username") String username) {

		// if(false)
		// {
		//
		// }
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

	/*
	 * 
	 * 处理上传文件
	 */
	@RequestMapping(value = "/upload.do")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) {
		if (file.isEmpty()) {
			return "error";
		}
		// CommonsMultipartFile[] files
		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

		return "result";
	}

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

		logger.log(Priority.DEBUG, "message");
		return "views/layout/register_step2";
	}

}
