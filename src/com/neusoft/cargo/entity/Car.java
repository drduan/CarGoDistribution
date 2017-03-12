package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sys_car", uniqueConstraints = { @UniqueConstraint(columnNames = "id")})
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	// “车辆类型”
	private String CarType;

	// 号牌号码
	private String CarNumber;


	
	
//	public User getUser() {
//		return this.user;
//	}

	public void setUser(User stock) {
		this.user = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
	}

	public String getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}

	public String getCarHost() {
		return CarHost;
	}

	public void setCarHost(String carHost) {
		CarHost = carHost;
	}

	public double getFreightRates() {
		return FreightRates;
	}

	public void setFreightRates(double freightRates) {
		FreightRates = freightRates;
	}

	private String CarHost;

	private double FreightRates;

	@Override
	public String toString() {
		
		return "Car \t "+"CarHost"+CarHost+"\t CarNumber"+CarNumber+"\t CarType"+CarType;
	}
}
