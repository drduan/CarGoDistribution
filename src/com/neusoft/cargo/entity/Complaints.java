package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Complaints")
@Entity
public class Complaints implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private User LaunchMan;
	private long complaintsid;
	private String Content;
	private String title;
	private String result;
	@Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Date add_time;
	

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
