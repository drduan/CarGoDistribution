package com.neusoft.cargo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.TrackOrderDao;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.service.TrackOrderService;
@Service
public class TrackOrderServiceImpl implements TrackOrderService{
	@Resource
	private TrackOrderDao trackOrderDao;

	// TrackOrderDao
	@Override
	public void save(TrackOrder car) {
		// TODO Auto-generated method stub

		trackOrderDao.save(car);

	}

}
