package com.neusoft.cargo.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.UserService;

@Controller("AdminAction")
@RequestMapping("/admins")
public class AdminAction extends Base{

	private Logger logger = Logger.getLogger(AdminAction.class);
	@Autowired
	private UserService userservice;
	@Autowired
	private CargoResourceService carResourceService;
	@RequestMapping(value = "home.do")
	public String Home() {

		// Assert.assertEqualsGetUserCargoResource.json("\n user has role admin \n ", true,
		// subject.hasRole("admin"));
		return "views/layout/admins/index";
	}

	@RequestMapping(value = "adminprofile.do")
	public String AdminProfile(Model model) {
		List<CargoResource> cargoResources = ((User) SecurityUtils.getSubject().getSession().getAttribute("user"))
				.getCargoResources();
		model.addAttribute("cargoResources", cargoResources);
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

		logger.error("message"+user.getId());
		User user2 = userservice.find(user.getId());
		//		user.getCargoResources().add(resource);
//		userservice.save(user);
		
		resource.setUser(user2);
		carResourceService.save(resource);
		return "redirect:adminprofile.do";
	}

	@RequestMapping(value = "GetUserCargoResource.json")
	@ResponseBody
	public List<CargoResource> GetUserCargoResource() {
		List<CargoResource> result = userservice.GetCargoResourceList(getUser());
		return result;
	}

}
