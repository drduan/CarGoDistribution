package com.neusoft.cargo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.UserAuthDao;
import com.neusoft.cargo.entity.UserAuthInfo;
import com.neusoft.cargo.service.UserAuthService;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	@Autowired
	public UserAuthDao useerAuthDao;

	@Override
	public void save(UserAuthInfo person) {
		// TODO Auto-generated method stub
		useerAuthDao.save(person);
	}

	@Override
	public List<UserAuthInfo> findAll() {
		// TODO Auto-generated method stub
		return useerAuthDao.findAll();
	}

	@Override
	public UserAuthInfo find(long id) {
		// TODO Auto-generated method stub
		return useerAuthDao.findOne(id);
	}

}
