package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.CarDao;
import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;
import com.neusoft.cargo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private CarDao carDao;

	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void save(User person) {

		logger.info("message" + "执行User Save" + person.getId());

		logger.log(Priority.DEBUG, person.toString() + "person ID" + person.getId());
		try {
			userDao.save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void remove(long id) {
		User person = find(id);
		if (person != null) {
		}
	}

	public boolean update(User entity) {

		return userDao.update(entity);
	}

	public User find(long id) {
		return userDao.findOne(id);
	}

	public User findBymail(String email) {

		// User u_result = userDao.findByName(name);
		return userDao.findByMail(email);
	}

	public List<Car> GetCarList(User entity) {
		return userDao.GetCarList(entity);
	}

	@Override
	public List<CargoResource> GetCargoResourceList(User user) {
		return userDao.GetCargoResourceList(user);
	}

	@Override
	public void addCarToUser(User user, Car car) {
		userDao.addCarToUser(user, car);
	}

	public List<TrackOrder> getOrder(User user) {
		return userDao.getOrderList(user);
	}

	@Override
	public boolean delCar(User user, long carid) {
		// TODO Auto-generated method stub
		return userDao.delcar(user, carid);
	}

}
