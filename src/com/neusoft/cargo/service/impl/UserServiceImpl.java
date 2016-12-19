package com.neusoft.cargo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		//Query query = userDao.fin;
//		return query.getResultList();
		return userDao.findAll();
	}

	public void save(User person) {
		if (person.getId() != null) {
			try {
				userDao.save(person);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// new
		//	em.persist(person);
		} else {
			// update
		//	em.merge(person);
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
		return userDao.findById(id);
	}
}
