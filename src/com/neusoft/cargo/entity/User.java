package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.sf.oval.constraint.NotEmpty;

// 用户为guest 存着基础信息
@Entity
@Table(name = "sys_user", uniqueConstraints = { @UniqueConstraint(columnNames = "id"),
		// @UniqueConstraint(columnNames = "Phone") phone 独立主键
})
public class User implements Serializable {

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String phone, String email, String ID_NUM, String TRUE_NAME) {

		this.password = password;
		this.phone = phone;
		this.username = username;
		this.email = email;
		this.ID_NUM = ID_NUM;
		this.TRUE_NAME = TRUE_NAME;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	// Auto 主键由程序控制
	// IDENTITY 主键由数据库自动生成（主要是自动增长型）
	// SEQUENCE 根据底层数据库的序列来生成主键，条件是数据库支持序列
	// Table 使用一个特定的数据库表格来保存主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "用户名不能为空")
	@Column(unique = true)
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
	private String salt;
	private Boolean locked = Boolean.FALSE;
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();

	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>(); // 一个用户具有多个角色

	public Set<Role> getRoleList() {
		return roles;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roles = roles;
	}

	@Transient
	public Set<String> getRolesName() {
		Set<Role> roles = getRoleList();
		Set<String> set = new HashSet<String>();
		for (Role role : roles) {
			set.add(role.getRole());
		}
		return set;
	}

	// 新添加 身份证号 和真实姓名

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Boolean getLocked() {
		return locked;
	}

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

	@Column(name = "TRUE_NAME", nullable = true, length = 32)
	private String TRUE_NAME;

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public static enum UserType {
		DRIVER, OWNER
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// @Override
	// public int hashCode() {
	// // TODO Auto-generated method stub
	// return super.hashCode();
	// }
	//

	private boolean rememberMe;

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	// @Override
	// public String toString() {
	// // TODO Auto-generated method stub
	// return
	// "user"+username+email+usertype+phone+password+"rememberMe:"+rememberMe;
	// }
	//
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", salt='"
				+ salt + '\'' + ", locked=" + locked + '}';
	}

}
