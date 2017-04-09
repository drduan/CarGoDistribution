package com.neusoft.cargo.service.impl;

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

}
