package com.neusoft.cargo.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.entity.UserAuthInfo;
import com.neusoft.cargo.entity.User.UserType;
import com.neusoft.cargo.service.CargoResourceService;
import com.neusoft.cargo.service.UserAuthService;
import com.neusoft.cargo.service.UserService;

@Controller("BaseAction")
public class BaseAction extends Base {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BaseAction.class);

	@Autowired
	public UserService us;

	@Autowired
	public CargoResourceService cargoResourceService;

	@Autowired
	public UserService userservice;
	
	@Autowired
	public UserAuthService userAuthService ;
	
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String index(Model model) {

		List<CargoResource> cargoResources = cargoResourceService.getAll();
		model.addAttribute("resource", cargoResources);

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
	public String admin() {

		return "views/lauout/admin/index.jsp";
	}

	@RequestMapping(value = "user.do")
	public String user() {

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

	@RequestMapping(value = "settings.do", method = RequestMethod.POST)
	public String authentication(Model model) {

		model.addAttribute("message", "请耐心等待审核");
		return "/views/layout/SuccessMessage";
	}

	@RequestMapping(value = "authenticationstatus.do")
	public String authenticationstatus() {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		user.setHasauthentication(true);
		us.save(user);

		if (user.getUsertype().equals(UserType.OWNER)) {
			return "redirect:/admins/adminprofile.do";
		} else {
			return "redirect:/User/profile.do";
		}

	}

	/*
	 * 
	 * 处理上传文件
	 */
	@RequestMapping(value = "/upload.do")
	public String upload(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request,
			ModelMap model, @RequestParam(value = "t_name") String t_name, @RequestParam(value = "t_id") String t_id) {
		String[] path = new String[2];
		
		

		File filedir = new File(request.getSession().getServletContext().getRealPath("/") + "upload/"+getUser().getEmail());
		if (!filedir.exists()) {
			filedir.mkdirs();
		}
		if (files == null || files.length < 0 || files.length > 2) {
			model.addAttribute("message", "空文件");
			return "SuccessMessage";
		}
		else {

			for (int i = 0; i < files.length; i++) {
				if (!files[i].isEmpty()) {
					path[i] = request.getSession().getServletContext().getRealPath("/") + "upload/"+getUser().getEmail()+"/"
							+ files[i].getOriginalFilename();

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
			userAuthInfo.setAddress1(path[0]);
			userAuthInfo.setAddress2(path[1]);
			userAuthService.save(userAuthInfo);
			
			
			
			getUser().setTRUE_NAME(t_name);
			getUser().setID_NUM(t_id);
			userservice.save(getUser());

		}

		// UserAuthInfo userinfo = new UserAuthInfo();
		// userinfo.setUser(getUser());

		return null;
		// String path =
		// request.getSession().getServletContext().getRealPath("upload");
		// String fileName = files.getOriginalFilename();
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
	}

	/***
	 * 保存文件
	 * 
	 * @param file
	 * @return
	 */

	// @Autowired
	// private HttpServletRequest request;
	//
	// private boolean saveFile(MultipartFile file) {
	// // 判断文件是否为空
	// if (!file.isEmpty()) {
	// try {
	// // 文件保存路径
	// String filePath =
	// request.getSession().getServletContext().getRealPath("/") + "upload/"
	// + file.getOriginalFilename();
	// // 转存文件
	// file.transferTo(new File(filePath));
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// return false;
	// }

	// public void OutputJson(Object object, String type) {
	// PrintWriter out = null;
	// HttpServletResponse httpServletResponse =
	// ServletActionContext.getResponse();
	// httpServletResponse.setContentType(type);
	// httpServletResponse.setCharacterEncoding("utf-8");
	// String json = null;
	// try {
	// out = httpServletResponse.getWriter();
	// json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// logger.debug("json:" + json);
	// out.print(json);
	// out.close();
	// }

}
