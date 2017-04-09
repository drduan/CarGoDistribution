package com.neusoft.cargo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

//@Entity
//@Table(name = "sys_permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String permission; // 权限标识 程序中判断使用,如"user:create"
	private String description; // 权限描述,UI界面显示使用
//	private Boolean available = Boolean.FALSE; 是否可用,如果不可用将不会添加给用户

	@OneToOne(targetEntity = Resource.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "resource_id", referencedColumnName = "id")
	private Resource resource;
	
	 @ManyToMany(targetEntity = Operation.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	    @JoinTable(name = "sys_permission_operation", joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id") )
	    private Set<Operation> operations = new HashSet<>();

	public Permission() {
	}

	public Permission(String permission, String description) {
		this.permission = permission;
		this.description = description;
//		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Boolean getAvailable() {
//		return available;
//	}
//
//	public void setAvailable(Boolean available) {
//		this.available = available;
//	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Permission role = (Permission) o;

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
		return "Role{" + "id=" + id + ", permission='" + permission + '\'' + ", description='" + description + '\''
				+ ", available=" + "true" + '}';
	}
}
