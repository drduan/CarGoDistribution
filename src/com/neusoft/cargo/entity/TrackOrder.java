package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "trackorder")
public class TrackOrder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private CargoResource cResource;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_order_id")
	private Car car;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToMany
	private List<Comment> comment;

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	private boolean drivercommented;
	private boolean ownercommented;

	public boolean isDrivercommented() {
		return drivercommented;
	}

	public void setDrivercommented(boolean drivercommented) {
		this.drivercommented = drivercommented;
	}

	public boolean isOwnercommented() {
		return ownercommented;
	}

	public void setOwnercommented(boolean ownercommented) {
		this.ownercommented = ownercommented;
	}

}
