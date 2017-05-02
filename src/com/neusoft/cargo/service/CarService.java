/**
 * 
 */
package com.neusoft.cargo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.Car;

/**
 * @author xudong
 *
 */
@Service
public interface CarService {

	public List<Car> findAll();

	public void save(Car person);

	public void remove(Long id);

	public Car find(Long id);

	public void update(Car car);
}
