package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.CargoResourceDao;
import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.CargoResourceService;

@Service
public class CargoResourceServiceImpl implements CargoResourceService {
	@Resource
	// private DepretedUserDao userDao;
	private UserDao userDao;
	@Resource
//	private CarDao carDao;
	private CargoResourceDao cargoResourceDao;

	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	public List<CargoResource> findAll() {
		return cargoResourceDao.findAll();
	}

	public void save(CargoResource person) {

		logger.info("message" + "执行User Save" + person.getId());

		logger.log(Priority.DEBUG, person.toString() + "person ID" + person.getId());
		try {
			cargoResourceDao.save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public void remove(int id) {
//		User person = userDao.find(id);
//		if (person != null) {
//			// em.remove(person);
//		}
//	}

//	public CargoResource find(int id) {
//		// return em.find(User.class, id);
//		// return userDao.findById(id);
//		return cargoResourceDao.findOne(id);
//	}

	public User findBymail(String email) {

		// User u_result = userDao.findByName(name);
		return userDao.findByMail(email);
	}

	public List<Car> GetCarList(User entity) {
		return userDao.GetCarList(entity);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CargoResource find(int id) {
		// TODO Auto-generated method stub
//		return null;
		return cargoResourceDao.findOne(id);
	}

	
	public List<CargoResource> getAll()
	{
		return cargoResourceDao.findAll();
	}
	
//	@Override
//	public void addCarToUser(User user, CargoResource car) {
//		// TODO Auto-generated method stub
//
//		cargoResourceDao.addCarToUser(user, car);
//	}

}
