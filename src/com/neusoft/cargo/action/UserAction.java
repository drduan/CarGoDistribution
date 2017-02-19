package com.neusoft.cargo.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.view.RedirectView;

import com.neusoft.cargo.entity.User;
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
	 * 进行注册信息的处理 并且 注册成功 返回cookie和对应的网页
	 * 
	 * @Validated ？？
	 */
	@RequestMapping(method = RequestMethod.POST, value = "register.do")
	public String Register(User user, String userType, HttpServletRequest req, HttpSession session) {

		System.out.println(user.getEmail());
		User user2 = new User();
		user2 = user;
		userService.save(user);

		session.setAttribute("username", user.getUsername());
		// session.setAttribute(arg0, arg1);
		session.setMaxInactiveInterval(6000);
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
		String string = session.getAttribute("validationCode").toString();
		return "" + string.equals(validationCode);
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
		return "redirect:../User/redirect_reg_next.do";// 默认为forward模式
	}

	@RequestMapping(value = "redirect_reg_next.do", method = RequestMethod.GET)
	public String dealUserTypeAndRedirect(@ModelAttribute("usertype") String form,
			RedirectAttributesModelMap redirectAttrs, ModelAndView model) {
		return "forward:///User/register_step2.jsp";
	}

}
