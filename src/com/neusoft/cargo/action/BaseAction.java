package com.neusoft.cargo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Priority;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.UserService;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;



@Controller("BaseAction")
public class BaseAction {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BaseAction.class);

	@Autowired
	public UserService us;
	
	@Autowired
	public CargoResourceService cargoResourceService;
	
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String index(Model model) {
		
		
		List<CargoResource>  cargoResources = cargoResourceService.getAll();
		model.addAttribute("resource",cargoResources);
		
		
		
		return "views/layout/index";
	}
	
	@RequestMapping(value = "/loginform.do", method = RequestMethod.GET)
	public String loginform()
	{
		return "views/layout/login";
	}
	

	@RequestMapping(value = "logout.do")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/";
	}

	
	@RequestMapping(value="admin.do")
	public String admin(){
		
		return "views/lauout/admin/index.jsp";
	}
	
	
	@RequestMapping(value="user.do")
	public String user(){
		
		return "views/layout/user/index.jsp";
	}
	
	@RequestMapping(value="manager.do")
	public String manager(){
		
		return "views/layout/manager/manager";
	}
	
	@RequestMapping(value="authentication.do")
	public String authentication()
	{
		
		return "/views/lauout/uploadFileToAuth";
//		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
//		user.setHasauthentication(true);
//		us.save(user);
//		
//		if (user.getUsertype().equals(UserType.OWNER)) {
//			return "redirect:/admins/adminprofile.do";
//		}
//		else{
//			return "redirect:/User/profile.do";
//		}
		
	}
	
	
	@RequestMapping(value="authenticationstatus.do")
	public String authenticationstatus()
	{
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
		user.setHasauthentication(true);
		us.save(user);
		
		if (user.getUsertype().equals(UserType.OWNER)) {
			return "redirect:/admins/adminprofile.do";
		}
		else{
			return "redirect:/User/profile.do";
		}
		
	}
	
	
	
	public void OutputJson(Object object, String type) {
		PrintWriter out = null;
		HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
		httpServletResponse.setContentType(type);
		httpServletResponse.setCharacterEncoding("utf-8");
		String json = null;
		try {
			out = httpServletResponse.getWriter();
			json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("json:" + json);
		out.print(json);
		out.close();
	}


}
