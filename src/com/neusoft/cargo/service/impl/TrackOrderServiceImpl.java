package com.neusoft.cargo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.TrackOrderDao;
import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.service.TrackOrderService;

@Service
public class TrackOrderServiceImpl implements TrackOrderService {
	@Resource
	private TrackOrderDao trackOrderDao;

	@Override
	public void save(TrackOrder car) {

		trackOrderDao.save(car);

	}

	@Override
	public TrackOrder find(String uuid) {
		// TODO Auto-generated method stub
		return trackOrderDao.findByUUID(uuid);
	}

	@Override
	public boolean update(TrackOrder order) {
		// TODO Auto-generated method stub
		return trackOrderDao.update(order);
	}

}
