package com.neusoft.cargo.model;

import java.sql.Timestamp;
import java.util.UUID;

import com.neusoft.cargo.entity.OrderType;

public class Order {

	private long id;

	private OrderType orderType;

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	private String uuid;

	/** 注册时间 **/
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	private String mstatus;

	public String getMstatus() {
		return mstatus;
	}

	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		UUID _uuid = UUID.randomUUID();
		this.uuid = _uuid.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// 区别于 TrackOrder
	private String LicenseNo;
	private String Contact;
	private String Phone;
	private String GoodName;
	private String DepartPlace;
	private String DestPlace;
	private String Price;

	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getGoodName() {
		return GoodName;
	}

	public void setGoodName(String goodName) {
		GoodName = goodName;
	}

	public String getDepartPlace() {
		return DepartPlace;
	}

	public void setDepartPlace(String departPlace) {
		DepartPlace = departPlace;
	}

	public String getDestPlace() {
		return DestPlace;
	}

	public void setDestPlace(String destPlace) {
		DestPlace = destPlace;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

}
