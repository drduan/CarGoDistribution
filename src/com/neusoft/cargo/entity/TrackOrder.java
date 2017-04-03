package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="trackorder")
public class TrackOrder  implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrderId")
	private long id;
	
	@Enumerated(EnumType.STRING)
	private OrderType orderType;
	
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	private String uuid;
	
	
	  /**注册时间**/
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());
   
	

	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
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
	
	
	/*
	 * 后加的字段
	 */

//	private User owner;
//
	
//	@ManyToOne
//	private User driver;
	
//	 @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER,optional=true)  
//     @JoinColumn(name="ownerid",referencedColumnName="userid",insertable=false,updatable=false)
//	public User getOwner() {
//		return owner;
//	}
//	public void setOwner(User owner) {
//		this.owner = owner;
//	}
//	public User getDriver() {
//		return driver;
//	}
//	public void setDriver(User driver) {
//		this.driver = driver;
//	}
	
	
	
	
	
}
