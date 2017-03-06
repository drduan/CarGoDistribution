package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "sys_role")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String role; // 角色标识 程序中判断使用,如"admin"
	private String description; // 角色描述,UI界面显示使用
	// private Boolean available = Boolean.FALSE;  是否可用,如果不可用将不会添加给用户
	
	
	@OneToMany(targetEntity = Permission.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "sys_role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	private List<Permission> permissions = new ArrayList<>();

	public Role() {
	}

	public Role(String role, String description) {
		this.role = role;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Role role = (Role) o;

		if (id != null ? !id.equals(role.id) : role.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", role='" + role + '\'' + ", description='" + description + '\'' + ", available="
				+ "true" + '}';
	}

}
