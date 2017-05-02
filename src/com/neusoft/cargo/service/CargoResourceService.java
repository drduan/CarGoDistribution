package com.neusoft.cargo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.CargoResource;

@Service
public interface CargoResourceService {

	public List<CargoResource> findAll();

	public void save(CargoResource cargoResource);

	public void remove(int id);

	public void update(CargoResource cargoResource);

	public CargoResource find(long id);

	public List<CargoResource> getAll();
}
