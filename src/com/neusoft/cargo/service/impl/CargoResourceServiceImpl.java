package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
	private UserDao userDao;
	@Resource
	private CargoResourceDao cargoResourceDao;

	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	public List<CargoResource> findAll() {
		return cargoResourceDao.findAll();
	}

	public void save(CargoResource cargoResource) {

		// logger.info("message" + "执行User Save" +
		// cargoResource.getCarresourceid());

		// logger.log(Priority.DEBUG, person.toString() + "person ID" +
		// person.getId());
		try {
			cargoResourceDao.save(cargoResource);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User findBymail(String email) {

		// User u_result = userDao.findByName(name);
		return userDao.findByMail(email);
	}

	public List<Car> GetCarList(User entity) {
		return userDao.GetCarList(entity);
	}

	@Override
	public void delete(CargoResource cargoResource) {
		// TODO Auto-generated method stub
		cargoResourceDao.delete(cargoResource);

	}

	@Override
	public CargoResource find(long id) {
		// TODO Auto-generated method stub
		return cargoResourceDao.findOne(id);
	}

	public List<CargoResource> getAll() {

		return cargoResourceDao.findAll();
	}

	@Override
	public void update(CargoResource cargoResource) {
		// TODO Auto-generated method stub
		cargoResourceDao.update(cargoResource);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CargoResource findByYpbm(String ypbm) {
		// TODO Auto-generated method stub
		return cargoResourceDao.findByYpbm(ypbm);
		
	}

}
