/**
 * 
 */
package com.neusoft.cargo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;

/**
 * @author xudong
 *
 */
@Service
public interface UserService {

	public List<User> findAll();

	public void save(User user);

	public void remove(long id);

	public User find(long id);

	List<Car> GetCarList(User user);
	
	List<CargoResource> GetCargoResourceList(User user);

	public void addCarToUser(User user, Car car);
	
}
