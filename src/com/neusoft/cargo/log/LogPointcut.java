package com.neusoft.cargo.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogPointcut {

	@Pointcut("execution(* com.neusoft.cargo.service..*.*(..))")
	public void inServiceLayer() {
	}
	
	@Pointcut("execution(* com.neusoft.cargo.dao..*.*(..))")
	public void inDaoLayer(){
	}
	
	@Pointcut("execution(* com.neusoft.cargo.controller..*.*(..))")
	public void inControllerLayer(){}

}
