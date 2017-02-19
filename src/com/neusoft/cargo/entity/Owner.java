package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
//@Table(name = "owner")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Owner extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140247875878401911L;
	private String enterprise;
	private String enterprise_intro;
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public String getEnterprise_intro() {
		return enterprise_intro;
	}
	public void setEnterprise_intro(String enterprise_intro) {
		this.enterprise_intro = enterprise_intro;
	}
	
}
