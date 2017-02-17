package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

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
}
