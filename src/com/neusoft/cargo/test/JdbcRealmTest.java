package com.neusoft.cargo.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.cargo.entity.Role;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.impl.UserServiceImpl;

import sun.util.logging.resources.logging;

public class JdbcRealmTest {

	@Autowired
	UserServiceImpl userserviceimpl;
	Logger logger = Logger.getLogger(JdbcRealmTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test

	public void Test1() {
		// 1.获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
//		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
//		// 2.获取SecurityManager实例，并绑定到SecurityUtils
//		SecurityManager sm = factory.getInstance();
//		SecurityUtils.setSecurityManager(sm);
//
//		DefaultPasswordService passwordService = new DefaultPasswordService();
//		String pwd = "chrismao";
//		String newpwd = passwordService.encryptPassword(pwd);
//		String username = "chris.mao@emerson.com";
//		User user = new User(username, username, username, username, username, username);
//		user.setUsername(username);
//		user.setPassword(newpwd);
//		user.setEmail("dasasd@q.c");
//		user.setPhone("123123123122");
//		user.setID_NUM("234");
//		// user.setPassword(newpwd);
//		// userService.save(user);
//		userserviceimpl = new UserServiceImpl();
//		userserviceimpl.save(user);
	}

	@Test
	public void test() {
		// 1.获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
//		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		// 2.获取SecurityManager实例，并绑定到SecurityUtils
//		SecurityManager sm = factory.getInstance();
//		SecurityUtils.setSecurityManager(sm);

		// 3.得到Subject
//		Subject subject = SecurityUtils.getSubject();
		// 4.创建用户登录凭证
//		User user = new User();
//		user.setEmail("1@q.c");
//		user.setPassword("827ccb0eea8a706c4c34a16891f84e7b");
//		
//		User user = userserviceimpl.find(1);
	
		
		return;
//		UsernamePasswordToken token = new UsernamePasswordToken("1@q.c", "827ccb0eea8a706c4c34a16891f84e7b");
		// 5.登录，如果登录失败会抛出不同的异常，根据异常输出失败原因
//		try {
//			subject.login(token);
//			// 6.判断是否成功登录
////			List<Role> = subject.getPrincipal()
////			assertEquals(true, subject.isAuthenticated());
////			 assertEquals(true, subject.hasRole("admin"));  
//			System.out.println("登录成功！！");
//			// 7.注销用户
////			subject.logout();
//		} catch (IncorrectCredentialsException e) {
//			System.out.println("登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.");
//		} catch (ExcessiveAttemptsException e) {
//			System.out.println("登录失败次数过多");
//		} catch (LockedAccountException e) {
//			System.out.println("帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");
//		} catch (DisabledAccountException e) {
//			System.out.println("帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");
//		} catch (ExpiredCredentialsException e) {
//			System.out.println("帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");
//		} catch (UnknownAccountException e) {
//			System.out.println("帐号不存在. There is no user with username of " + token.getPrincipal());
//		}
	}

}
