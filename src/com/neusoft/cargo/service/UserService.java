/**
 * 
 */
package com.neusoft.cargo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.User;

/**
 * @author xudong
 *
 */
@Service
public interface UserService {

	public List<User> findAll();

	public void save(User person);

	public void remove(int id);

	public User find(int id);

	List<Car> GetCarList(User user);

	public void addCarToUser(User user, Car car);
	
}
