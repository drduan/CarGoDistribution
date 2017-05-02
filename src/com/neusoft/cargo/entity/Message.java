package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "message")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6513533485888445354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public User getToperson() {
		return toperson;
	}

	public void setToperson(User toperson) {
		this.toperson = toperson;
	}

	private String fromperson = "System";

	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@ManyToOne
	private User toperson;

	@Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Date add_date = new Date();;
	// 限制 140个字
	private String Content;

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
