package com.neusoft.cargo.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.entity.UserAuthInfo;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.MessageService;
import com.neusoft.cargo.service.UserAuthService;
import com.neusoft.cargo.service.UserService;
import com.neusoft.cargo.util.AddressUtils;
import com.neusoft.cargo.util.MailUtil;
import com.neusoft.cargo.util.Md5Util;

@Controller("BaseAction")
public class BaseAction extends Base {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BaseAction.class);


	@Autowired
	public CargoResourceService cargoResourceService;

	@Autowired
	public UserService userservice;

	@Autowired
	public UserAuthService userAuthService;

	@Autowired
	private MessageService messageservice;

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String index(Model model, String addr) {
		String address = null;
		if (addr != null) {

			AddressUtils adu = new AddressUtils();
			try {
				address = adu.getAddresses("ip=" + addr, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("client ip" + address);

		}

		// 辽宁省

		model.addAttribute("messagecount", getMessageCount());
		List<CargoResource> cargoResources = cargoResourceService.getAll();
		// 将没有在订单中的货物加载到页面中
		List<CargoResource> wcargoResources = new ArrayList<>();
		for (CargoResource cargoResource : cargoResources) {
			if (cargoResource.getStatus() == 0) {

				// 此段代码 为匹配用户所在方位
				int x = cargoResource.getDeparturePlace().indexOf("省");
				if (address != null) {

					String temp = cargoResource.getDeparturePlace().substring(0, x + 1);

					if (address.equals(temp)) {
						logger.info("\"message");
						wcargoResources.add(cargoResource);
					}
				} else {
					wcargoResources.add(cargoResource);
				}
			}
		}

		model.addAttribute("resource", wcargoResources);
		return "views/layout/index";

	}

	@RequestMapping(value = "/loginform.do", method = RequestMethod.GET)
	public String loginform() {
		return "views/layout/login";
	}

	@RequestMapping(value = "logout.do")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/";
	}

	@RequestMapping(value = "admin.do")
	public String admin(Model model) {

		model.addAttribute("messagecount", getMessageCount());
		return "views/layout/admin/index.jsp";
	}

	@RequestMapping(value = "user.do")
	public String user(Model model) {
		
		model.addAttribute("messagecount", getMessageCount());
		return "views/layout/user/index.jsp";
	}

	@RequestMapping(value = "manager.do")
	public String manager() {

		return "views/layout/manager/manager";
	}

	@RequestMapping(value = "settings.do")
	public String Settings(Model model) {
		return "/views/layout/settings";
	}

	@RequestMapping(value = "authentication.do")
	public String auth(Model model) {
		return "/views/layout/uploadFileToAuth";
	}

//	@RequestMapping(value = "authenticationstatus.do")
//	public String authenticationstatus() {
//		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
//		user.setHasauthentication(true);
//		userservice.save(user);
//
//		if (user.getUsertype().equals(UserType.OWNER)) {
//			return "redirect:/admins/adminprofile.do";
//		} else {
//			return "redirect:/User/profile.do";
//		}
//
//	}

	/*
	 * 
	 * 处理上传文件
	 */
	@RequestMapping(value = "/upload.do")
	public String upload(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request,
			ModelMap model, @RequestParam(value = "t_name") String t_name, @RequestParam(value = "t_id") String t_id) {

		if (files[0].isEmpty() || files[1].isEmpty()) {
			model.addAttribute("message", "空文件");
			return "/views/layout/SuccessMessage";
		} else {

			logger.info("filessize" + files.length);
			String[] path = new String[2];

			File filedir = new File(
					request.getSession().getServletContext().getRealPath("/") + "upload/" + getUser().getEmail());
			if (!filedir.exists()) {
				filedir.mkdirs();
			}

			for (int i = 0; i < files.length; i++) {
				if (!files[i].isEmpty()) {
					logger.info(request.getSession().getServletContext().getRealPath("/"));
					logger.info(request.getSession().getServletContext().getContextPath());
					path[i] = request.getSession().getServletContext().getRealPath("/") + "upload/"
							+ getUser().getEmail() + "/" + files[i].getOriginalFilename();

					try {
						files[i].transferTo(new File(path[i]));

					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			UserAuthInfo userAuthInfo = new UserAuthInfo();
			userAuthInfo.setUser(getUser());
			userAuthInfo.setAddress1(
					path[0].replace("/Users/xudong/Downloads/apache-tomcat-8.5.8/wtpwebapps/CarGoDistribution/", ""));
			userAuthInfo.setAddress2(
					path[1].replace("/Users/xudong/Downloads/apache-tomcat-8.5.8/wtpwebapps/CarGoDistribution/", ""));
			userAuthService.save(userAuthInfo);
			getUser().setTRUE_NAME(t_name);
			getUser().setID_NUM(t_id);
			userservice.save(getUser());
			model.addAttribute("message", "等待审核");
			return "redirect:home.do";
		}
	}

	@RequestMapping("sysmsglist.do")
	public String SysMsgList(Model model) {
		model.addAttribute("messagecount", getMessageCount());
		List<Message> lmsg = messageservice.findAll();
		List<Message> selflmsg = new ArrayList<Message>(0);
		for (Message message : lmsg) {

			if (message.getToperson().equals(getUser())) {
				selflmsg.add(message);
			}
		}

		model.addAttribute("msglist", selflmsg);
		return "views/layout/sysmsglist";
	}

	@RequestMapping(value = "forgetPwd.do", method = RequestMethod.GET)
	public String forgetPwd(Model model) {

		return "views/layout/forgetpwd";
	}

	@RequestMapping(value = "forgetPwd.do", method = RequestMethod.POST)
	public String nextforgetPwd(Model model, @RequestParam("mail") String mail, @RequestParam("passwd") String pwd) {
		User user = userservice.findByMail(mail);
		user.setPassword(Md5Util.md5Encode(pwd));
		userservice.save(user);
		return "redirect:home.do";
	}

	@RequestMapping("getmailcode.do")
	@ResponseBody
	public String getmailcode(Model model, @RequestParam("mail") String mail) throws MessagingException {
		int randomcode = (int) ((Math.random() * 9 + 1) * 100000);

		MailUtil.sendEmail("smtp.163.com", mail, "空车配货信息系统重置密码邮件", "验证码为" + randomcode+"\n 打死都不要告诉别人哦！ \n 系统管理团队 \n", "dxd19930902@163.com", "dxd19930902",
				"19930902dxd");
		return String.valueOf(randomcode);
	}

	/*
	 * 更改运品运费
	 */
	@RequestMapping(value = "updatefreight.do", method = RequestMethod.POST)
	@ResponseBody
	public String updatefreight(long sourceid, double rate) {
		CargoResource cargoResource = cargoResourceService.find(sourceid);
		cargoResource.setWeightFate(""+rate);
		cargoResourceService.update(cargoResource);
		return "success";
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
