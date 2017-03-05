package com.neusoft.cargo.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.Role;
import com.neusoft.cargo.entity.User;

import javassist.compiler.ast.NewExpr;

@Service
@Transactional

public class MyShiro extends AuthorizingRealm {

	@Resource
	private UserDao userDao;
	private Logger logger = Logger.getLogger(MyShiro.class);

	public MyShiro() {
		setName("DefaultRealm");// This name must match the name in the User
	}

	/**
	 * 权限认证 授权信息 分配角色 权限 资源
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 获取登录时输入的用户名
		logger.debug("开始\t PrincipalCollection \t认证 ");
		String loginName = (String) principalCollection.getPrimaryPrincipal();
		// User admin = userDao.getUniqueByProperty("username", loginName);
		User user = userDao.findByMail(loginName);
	
		
		//
		// List<Role> lr = new ArrayList<Role>();
		// lr.add(new Role("admin"));
		//
		// user.setRoleList(lr);

		if (user != null) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			Set<String> sr = new HashSet<String>();
			sr.add("user");
			info.setRoles(sr);
			
		
			// info.setRoles(user.getRolesName());
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
			// Set <Role> roleList = user.getRoleList();
			// for (Role role : roleList) {
			//// info.addStringPermission(role.getRole());
			// info.addRole(role.getRole());
			// }
			//
			for (String role : info.getRoles()) {

				logger.error("userrole"+role.toString());
			}
			return info;
		}
		return null;
	}

	/*
	 * 身份验证 登陆
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.
	 * apache.shiro.authc.AuthenticationToken) 1、如果Realm是AuthenticatingRealm子类，
	 * 则提供给AuthenticatingRealm内部使用的CredentialsMatcher进行凭据验证；（
	 * 如果没有继承它需要在自己的Realm中自己实现验证）； 2、提供给SecurityManager来创建Subject（提供身份信息）；
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// UsernamePasswordToken对象用来存放提交的登录信息

		logger.debug("开始\t UsernamePasswordToken \t认证 ");

		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// String password = String.valueOf(token.getPassword());
		User user = userDao.findByMail(token.getPrincipal().toString());

		if (user != null) {

			// Set<Role> lRoles = user.getRoleList();
			// 若存在，将此用户存放到登录认证info中
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
			return new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), getName());

		}
		return null;
	}

}
