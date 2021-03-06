package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "cargoresource")
public class CargoResource implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carresourceid;

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User _user;

	private String  ypbm;
	
	
	public String getYpbm() {
		return ypbm;
	}

	public void setYpbm(String ypbm) {
		this.ypbm = ypbm;
	}

	// 备注
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User get_user() {
		User user1 = new User();
		user1.setId(_user.getId());
		user1.setUsername(_user.getUsername());
		user1.setCreateDate(_user.getCreateDate());
		user1.setEmail(_user.getEmail());
		user1.setImg(_user.getImg());
		return user1;

	}

	public void set_user(User _user) {
		this._user = _user;
	}

	private String departurePlace;

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getDestPlace() {
		return destPlace;
	}

	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;

	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWeightFate() {
		return weightFate;
	}

	public void setWeightFate(String weightFate) {
		this.weightFate = weightFate;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	// public boolean isStatus() {
	// return status;
	// }
	//
	// public void setStatus(boolean status) {
	// this.status = status;
	// }

	private String destPlace;
	@Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Date addDate;
	private String contact;
	private String Phone;
	private double weight;
	// 运费
	private String weightFate;
	private double capacity;
	// private boolean status;
	// 0 等待接单
	// 1 运输中
	// 2 运输结束
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private String goodName;

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	@OneToMany(mappedBy = "cResource", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<TrackOrder> order;

	public List<TrackOrder> getOrder() {
		return order;
	}

	public void setOrder(List<TrackOrder> order) {
		this.order = order;
	}

	public long getCarresourceid() {
		return carresourceid;
	}

	public void setCarresourceid(long carresourceid) {
		this.carresourceid = carresourceid;
	}

}
