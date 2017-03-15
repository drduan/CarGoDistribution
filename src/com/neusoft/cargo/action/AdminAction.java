package com.neusoft.cargo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;

@Controller("AdminAction")
@RequestMapping("/admins")
public class AdminAction extends Base{

	private Logger logger = Logger.getLogger(AdminAction.class);
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "home.do")
	public String Home() {

		// logger.info("进入AdminAction");
		// Subject subject = SecurityUtils.getSubject();
		// logger.error("hasrole"+subject.hasRole("admin"));
		// Assert.assertEquals("\n user has role admin \n ", true,
		// subject.hasRole("admin"));
		return "views/layout/admins/index";
	}

	@RequestMapping(value = "adminprofile.do")
	public String AdminProfile(Model model) {

		// logger.info("进入AdminAction");
		// Subject subject = SecurityUtils.getSubject();
		// logger.error("hasrole"+subject.hasRole("admin"));
		// Assert.assertEquals("\n user has role admin \n ", true,
		// subject.hasRole("admin"));
		List<CargoResource> cargoResources = ((User) SecurityUtils.getSubject().getSession().getAttribute("user"))
				.getCargoResources();
		model.addAttribute("cargoResources", cargoResources);
		// logger.info("cargoResources" + cargoResources.size());

		return "views/layout/admins/profile";
	}

	@RequestMapping(value = "logout.do")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/";
	}

	@RequestMapping(value = "publishgoods.do", method = RequestMethod.GET)
	public String publishgoods() {
		return "views/layout/admins/publishgoods";
	}

	@RequestMapping(value = "publishgoods.do", method = RequestMethod.POST)
	public String publishgoodsPost(CargoResource resource) {

		logger.debug("message");
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		List<CargoResource> cargoResources = new ArrayList<>();
		cargoResources.add(resource);
		user.setCargoResources(cargoResources);
		userservice.save(user);
		return "redirect:adminprofile.do";
	}

	@RequestMapping(value = "GetUserCargoResource.json")
	@ResponseBody
	public List<CargoResource> GetUserCargoResource() {
		List<CargoResource> result = userservice.GetCargoResourceList(getUser());
		logger.info("message"+result.size());
		return result;
	}

}
