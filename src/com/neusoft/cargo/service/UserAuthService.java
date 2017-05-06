package com.neusoft.cargo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.UserAuthInfo;

@Service
public interface UserAuthService {

	public void save(UserAuthInfo person);

	public List<UserAuthInfo> findAll();

	public UserAuthInfo find(long id);

}
