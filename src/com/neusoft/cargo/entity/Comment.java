package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Comment")
@Entity
public class Comment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String uuid;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	private String Content;
	@ManyToOne
	private TrackOrder order;
	private String flag;//
	// @ManyToOne
	// private User owner;
	
	private String rate;
	
public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	//	private int rate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public TrackOrder getOrder() {
		return order;
	}
	public void setOrder(TrackOrder order) {
		this.order = order;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
//	public int getRate() {
//		return rate;
//	}
//	public void setRate(int rate) {
//		this.rate = rate;
//	}
	
	
}
