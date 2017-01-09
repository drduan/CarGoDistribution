package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


// 用户为guest 存着基础信息
@Entity
@Table(name = "user",uniqueConstraints={
		@UniqueConstraint(columnNames= "id"),
		@UniqueConstraint(columnNames = "Phone")
})
public class User implements Serializable{

	public User() {  
        super();  
    }  
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	// Auto 主键由程序控制
	// IDENTITY 主键由数据库自动生成（主要是自动增长型）
	//SEQUENCE 根据底层数据库的序列来生成主键，条件是数据库支持序列
	// Table 使用一个特定的数据库表格来保存主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	private String username;
	private String phone;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private UserType usertype;
	
	public UserType getUsertype() {
		return usertype;
	}
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public static enum UserType {
		DRIVER,
		OWNER
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
