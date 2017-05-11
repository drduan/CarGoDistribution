package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.ComplaintsDao;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.Complaints;

@Service
public class ComplaintServiceImpl {

	@Resource
	private ComplaintsDao carDao;

	private Logger logger = Logger.getLogger(ComplaintServiceImpl.class);

	public List<Complaints> findAll() {
		return carDao.findAll();
	}

	public void save(Complaints complaints) {
		carDao.save(complaints);

	}

	public void remove(Long id) {
		// TODO Auto-generated method stub
		carDao.delete(find(id));
	}

	public Complaints find(Long id) {
		// TODO Auto-generated method stub
		return carDao.findOne(id);
	}

	public void update(Complaints car) {
		// TODO Auto-generated method stub
		carDao.update(car);
	}
}
