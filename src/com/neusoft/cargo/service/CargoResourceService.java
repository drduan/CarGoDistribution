package com.neusoft.cargo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.neusoft.cargo.entity.CargoResource;

@Service
public interface CargoResourceService {

	public List<CargoResource> findAll();

	public void save(CargoResource person);

	public void remove(int id);

	public CargoResource find(int id);

	
	public List<CargoResource> getAll();
}
