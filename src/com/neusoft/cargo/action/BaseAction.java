package com.neusoft.cargo.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping(value="/")
public class BaseAction {

	
	@RequestMapping(method=RequestMethod.POST )
	public  String  index() {
		
		return "index.jsp";
	}
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public void OutputJson(Object object, String type) {
		PrintWriter out = null;
		HttpServletResponse httpServletResponse = ServletActionContext
				.getResponse();
		httpServletResponse.setContentType(type);
		httpServletResponse.setCharacterEncoding("utf-8");
		String json = null;
		try {
			out = httpServletResponse.getWriter();
			json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("json:" + json);
		out.print(json);
		out.close();
	}
	
	/* 获取登录用户ID */
	public int getLoginUserId() {
//		User user = getLoginUser();
//		if (user != null) {
//			//return new Long(((BigDecimal) user.get("userid")).longValue());
//			return user.getUserId();
//		}
		return 0;
	}

	/* 获取登录用户名 */
	public String getLoginUserName() {
		//User user = getLoginUser();
//		if (user != null) {
//			return (String) user.getUserName();
//		}
		return null;
	}

	/* 获取登录用户对象 */
//	public User getLoginUser() {
//		return (User) getSession().getAttribute(Constants.LOGIN_USER);
//	}
	
	
}


