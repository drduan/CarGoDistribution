package com.neusoft.cargo.service;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.TrackOrder;

@Service
public interface TrackOrderService {

	public void save(TrackOrder person);

	public TrackOrder find(String uuid);

	public boolean update(TrackOrder order);
}
