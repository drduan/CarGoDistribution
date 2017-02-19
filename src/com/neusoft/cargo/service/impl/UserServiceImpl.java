package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.DepretedUserDao;
import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
//	private DepretedUserDao userDao;
	private UserDao userDao;
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void save(User person) {
		if (person.getId() == null) {
			try {
				userDao.save(person);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			
		}
		
	}

	public void remove(int id) {
		User person = find(id);
		if (person != null) {
	//		em.remove(person);
		}
	}

	public User find(int id) {
	//	return em.find(User.class, id);
//		return userDao.findById(id);
		return userDao.findOne(id);
	}
	
	
	
	public User findByName(String name)
	{
		
//		User u_result =  userDao.findByName(name);
		return userDao.findByName(name);
	}
}
