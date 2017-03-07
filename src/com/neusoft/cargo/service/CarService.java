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
public interface CarService {

	 public List<Car> findAll();
	 
	    public void save(Car person);
	 
	    public void remove(int id);
	 
	    
	    public Car find(int id);
}
