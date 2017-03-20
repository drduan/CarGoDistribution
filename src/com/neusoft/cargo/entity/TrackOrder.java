package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TrackOrder  implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
//	private UUID uuid;
	
	private String uuid;
	
	// 运输状态
	private String  mstatus;
	
	
	public String getMstatus() {
		return mstatus;
	}
	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}
	public CargoResource getcResource() {
		return cResource;
	}
	public void setcResource(CargoResource cResource) {
		this.cResource = cResource;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		  UUID _uuid = UUID.randomUUID();
		  this.uuid = _uuid.toString();
	}
	@ManyToOne
	private  CargoResource  cResource;
	
	@ManyToOne
	private  Car car;
	
	
	
	
	
	
	
}
