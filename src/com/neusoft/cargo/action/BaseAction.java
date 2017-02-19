package com.neusoft.cargo.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Priority;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

@Controller
public class BaseAction {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BaseAction.class);

	@RequestMapping(value="home.do", method = RequestMethod.GET)
	public String index() {

		return "views/layout/index";
	}
	
	
	

//	protected Logger logger = LoggerFactory.getLogger(getClass());

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

	/* 获取登录用户ID */
	public int getLoginUserId() {
		return 0;
	}

	/* 获取登录用户名 */
	public String getLoginUserName() {
		// }
		return null;
	}


}
