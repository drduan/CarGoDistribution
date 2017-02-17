package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	public  User(String username,String password,String phone,String email,String ID_NUM,String TRUE_NAME) {
		
		this.password = password;
		this.phone = phone;
		this.username = username;
		this.email = email;
		this.ID_NUM = ID_NUM;
		this.TRUE_NAME =TRUE_NAME;
	}
	
//	@Valid
//	private List<@ValidPart String> parts = new ArrayList<>();
	
	
  
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

	@NotNull
	private String username;
	@NotNull
	@Size(min = 11, max = 15)
	private String phone;
	@NotNull
	private String password;
	@NotNull
	private String email;
	@Enumerated(EnumType.STRING)
	private UserType usertype;

	// 新添加 身份证号 和真实姓名


	@Size(min = 15, max = 18)
	private String ID_NUM;
	
	public String getID_NUM() {
		return ID_NUM;
	}
	public void setID_NUM(String iD_NUM) {
		ID_NUM = iD_NUM;
	}
	public String getTRUE_NAME() {
		return TRUE_NAME;
	}
	public void setTRUE_NAME(String tRUE_NAME) {
		TRUE_NAME = tRUE_NAME;
	}

	@Column(name = "TRUE_NAME", nullable = true, length=32)
	private String TRUE_NAME;





	
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
