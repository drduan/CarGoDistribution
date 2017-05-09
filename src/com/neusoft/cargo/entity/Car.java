package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "car")
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carid;
	/*
	 * 判断车辆是否可以使用，否则显示“运输中”
	 */
	private boolean carStatus;

	public boolean isCarStatus() {
		return carStatus;
	}

	public void setCarStatus(boolean carStatus) {
		this.carStatus = carStatus;
	}

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<TrackOrder> tock;

	public long getCarid() {
		return carid;
	}

	public void setCarid(long carid) {
		this.carid = carid;
	}

	public List<TrackOrder>  getTock() {
		return tock;
	}

	public void setTock(List<TrackOrder>  tock) {
		this.tock = tock;
	}

	@ManyToOne
	private User user;

	public User getUser() {
		User user1 = new User();
		user1.setUsername(user.getUsername());
		user1.setId(user.getId());
		user1.setCreateDate(user.getCreateDate());
		user1.setEmail(user.getEmail());
		return user1;
	}

	private String CarType;

	// 号牌号码
	// license plate number
	private String CarNumber;

	// 负载
	// operating load
	private String Capicity;

	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCapicity() {
		return Capicity;
	}

	public void setCapicity(String capicity) {
		Capicity = capicity;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return carid;
	}

	public void setId(long id) {
		this.carid = id;
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

}
