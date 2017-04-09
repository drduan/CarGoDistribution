package com.neusoft.cargo.service;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.UserAuthInfo;

@Service
public interface UserAuthService {

	public void save(UserAuthInfo person);
}
