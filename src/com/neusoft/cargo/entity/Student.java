package com.neusoft.cargo.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

//@Entity
public class Student {
	private int id;
	private String name;
	private int age;
	private Set<Course> courses = new HashSet<Course>();
	
	@Id
	@SequenceGenerator(name = "generator",sequenceName="seq_student")
	@GeneratedValue(generator="generator")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@ManyToMany
	@JoinTable(name = "score",
	joinColumns = {@JoinColumn(name = "stu_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "cou_id", referencedColumnName ="id")})
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}
