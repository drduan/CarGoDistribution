package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.jpamodelgen.xml.jaxb.PersistenceUnitValidationModeType;


@Entity
@Table(name = "sys_cargoresource", uniqueConstraints = { @UniqueConstraint(columnNames = "id")})
public class CargoResource implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	public double getWeightFate() {
		return weightFate;
	}
	public void setWeightFate(double weightFate) {
		this.weightFate = weightFate;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	private String destPlace;
	@Column(nullable=true,columnDefinition="timestamp default current_timestamp")
	private Date addDate;
	private String contact;
	private String Phone;
	private double weight;
	private double weightFate;
	private double capacity;
	private boolean status;
	
	
	private String goodName;
	
	
	
	
	
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	@ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
