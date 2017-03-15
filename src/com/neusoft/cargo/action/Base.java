package com.neusoft.cargo.action;

import org.apache.shiro.SecurityUtils;

import com.neusoft.cargo.entity.User;

public class Base {

	
	
	
	
	
	
	public User	 getUser() {
		
		return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
//		return null;
	}
}
