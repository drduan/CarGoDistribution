package com.neusoft.cargo.action;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.digester.annotations.rules.AttributeCallParam;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
// 这是一个pojo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.google.gxp.org.apache.xerces.impl.xpath.regex.REUtil;
import com.neusoft.cargo.entity.Driver;
import com.neusoft.cargo.entity.Owner;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.service.impl.UserServiceImpl;

@Controller("UserAction")
@RequestMapping("/User")
public class UserAction extends BaseAction {

	@Autowired
	private UserServiceImpl userService;

	// @RequestMapping("/greeting")
	// public String greeting(@RequestParam(value="name", required=false,
	// defaultValue="World") String name, Model model) {
	// model.addAttribute("name", name);
	// return "greeting";
	// }

	
	/*
	 *	进行注册信息的处理 并且 注册成功 返回cookie和对应的网页
	 * 
	 * 	@Validated ？？
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/register.do")
	public String Register(@Validated User user, String userType, HttpServletRequest req, HttpSession session) {

		
		Logger.getRootLogger().log(Priority.INFO, "GoIn");
	
		if (user == null) {

			return "../error";
		}
		if (user.getUsertype() == UserType.DRIVER) {
			User user2 = new Driver();
			user2 = user;
			userService.save(user);
			return "redirect:/";
		}
		if (user.getUsertype() == UserType.OWNER) {
			User user2 = new Owner();
			user2 = user;
			userService.save(user);
			return "redirect:/";
		} else {
			return "../error";
		}
//		Redirect
	}

	/*
	 * 判断用户邮箱是否已经注册 
	 * 返回可以使用jsonp
	 */
	@RequestMapping(value = "/userexist.do")
	@ResponseBody
	public String userexist(HttpSession session) {

		// htmlobj=$.ajax({url:"/jquery/test1.txt",async:false});

		// return "{\"message\",\"fail\"}";
		return "{\"message\":\"" + session.getAttribute("validationCode") + "\"}";

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
	@RequestMapping(value = "/reg_next.do" ,method=RequestMethod.GET)
//	public String dealUserType(@RequestParam(value = "cust_kind") String cust_kind,RedirectAttributes redirectAttrs,Model model) 
	
	public String dealUserType(@RequestParam(value = "cust_kind") String cust_kind,RedirectAttributes redirectAttrs,Model model) 
	
	{
		
		//@ModelAttribute 并不是存在session里边
		
		System.err.println(""+cust_kind);
//		,BindingResult result
//		if (result.hasErrors()) {
////		     return "accounts/new";
//			Logger.getRootLogger().log(Priority.ERROR, "HasError");
//		   }
		
		switch (cust_kind) {
		
		case "1":
			redirectAttrs.addFlashAttribute("usertype", "1");
			break;
		case "2":
			redirectAttrs.addFlashAttribute("usertype", "2");
			break;
		default:
			break;
		}
		return "redirect:../User/redirect_reg_next.do";//默认为forward模式  
	}
	@RequestMapping(value = "redirect_reg_next.do" ,method=RequestMethod.GET)
	public String dealUserTypeAndRedirect(@ModelAttribute("usertype") String form,RedirectAttributesModelMap redirectAttrs,ModelAndView model) 
	{
		return "forward:///User/register_step2.jsp";
	}
	
}
