package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Complaints")
@Entity
public class Complaints implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private User LaunchMan;

	@OneToOne
	private User relateMan;

	private String ypbm;

	public String getYpbm() {
		return ypbm;
	}

	public void setYpbm(String ypbm) {
		this.ypbm = ypbm;
	}

	// 订单号
	private long uuid;

	// 运品链接

	private long complaintsid;
	private String Content;
	// 0 1 2
	private int comptype;

	private String result;
	@Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Timestamp add_time;

	public Timestamp getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Timestamp add_time) {
		this.add_time = add_time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getLaunchMan() {
		return LaunchMan;
	}

	public void setLaunchMan(User launchMan) {
		LaunchMan = launchMan;
	}

	public long getComplaintsid() {
		return complaintsid;
	}

	public void setComplaintsid(long complaintsid) {
		this.complaintsid = complaintsid;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getComptype() {
		return comptype;
	}

	public void setComptype(int comptype) {
		this.comptype = comptype;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public User getRelateMan() {
		return relateMan;
	}

	public void setRelateMan(User relateMan) {
		this.relateMan = relateMan;
	}

}
