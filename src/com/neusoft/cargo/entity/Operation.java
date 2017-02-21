package com.neusoft.cargo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_operation")
public class Operation   implements Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // 编号

	    private String name; // 操作名称

	    @Column(unique = true)
	    private String operation;// 操作标识

	    private String description;  
}
