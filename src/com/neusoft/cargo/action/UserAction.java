package com.neusoft.cargo.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
// 这是一个pojo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	// @ResponseBody
	//method = RequestMethod.POST
	@RequestMapping(method=RequestMethod.POST, value = "/register.do" )
	public String Register(User user, String userType, HttpServletRequest req, HttpSession session) {

		
//		ModelAndV
		Logger.getRootLogger().log(Priority.INFO, "GoIn");
		// validationCode

		if (user == null) {

			return "ERROR";
		}
		if (user.getUsertype() == UserType.DRIVER) {
			User user2 = new Driver();
			user2 = user;
			userService.save(user);
		}
		if (user.getUsertype() == UserType.OWNER) {
			User user2 = new Owner();
			user2 = user;
			userService.save(user);
		}
	
		
	
		return "redirect:/";
		// return "{\"message\",\"ok\"}";
	}
	
	@RequestMapping(value = "/upload.do")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
  
		if (file.isEmpty()) {
			
			return "error";
			
		}
		//CommonsMultipartFile[] files
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
  
        return "result";  
    }  
	
}
