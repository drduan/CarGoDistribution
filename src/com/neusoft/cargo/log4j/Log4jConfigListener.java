package com.neusoft.cargo.log4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import bsh.This;

public class Log4jConfigListener implements ServletContextListener {

	public static final String CONFIG_LOCATION_PARAM = "log4jConfigLocation";
	public static final String XML_FILE_EXTENSION = ".xml";

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		LogManager.shutdown();
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
		
		String location = event.getServletContext().getInitParameter(
				CONFIG_LOCATION_PARAM);
		
		System.out.println(getClass()+"log4j初始化");
		if (location != null) {
			if (!location.startsWith("/")) {
				location = "/" + location;
			}
			location = event.getServletContext().getRealPath(location);

			// 如果是xml结尾就用DOM解析，否则就用properties解析
			if (location.toLowerCase().endsWith(XML_FILE_EXTENSION)) {
				DOMConfigurator.configure(location);
			} else {
				PropertyConfigurator.configure(location);
			}
		}
	}
}
