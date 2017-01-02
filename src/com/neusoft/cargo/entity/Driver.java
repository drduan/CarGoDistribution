package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name = "driver")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Driver extends User  implements Serializable{

	private String CarType;

	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
	}
	
	
	
	
}
