package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.CarDao;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.service.CarService;
@Service
public class CarServiceImpl implements CarService {

	@Resource
	private CarDao carDao;

	private Logger logger = Logger.getLogger(CarServiceImpl.class);

	@Override
	public List<Car> findAll() {
		return null;
	}

	@Override
	public void save(Car car) {
		// TODO Auto-generated method stub

		carDao.save(car);

	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Car find(int id) {
		// TODO Auto-generated method stub
		return carDao.findOne(id);
	}
}
