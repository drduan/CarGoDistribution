package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.DepretedUserDao;
import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.Car;
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
		
	
		logger.info("message"+"执行User Save"+person.getId());
		
		logger.log(Priority.DEBUG, person.toString()+"person ID"+person.getId());
			try {
				userDao.save(person);
			} catch (Exception e) {
				e.printStackTrace();
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
	
	
	
	public User findBymail(String email)
	{
		
//		User u_result =  userDao.findByName(name);
		return userDao.findByMail(email);
	}
	
	
	public  List<Car> GetCarList(User entity) {
		return userDao.GetCarList(entity);
	}
}
