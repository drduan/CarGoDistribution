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
	public void remove(Long id) {
		// TODO Auto-generated method stub
		carDao.delete(find(id));
	}

	@Override
	public Car find(Long id) {
		// TODO Auto-generated method stub
		return carDao.findOne(id);
	}

	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub
		carDao.update(car);
	}
}
