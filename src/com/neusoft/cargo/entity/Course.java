package com.neusoft.cargo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

//@Entity
public class Course {
	private int id;
	@NotNull
	private String title;
	
	
	@Id
	@SequenceGenerator(name = "generator",sequenceName="seq_student")
	@GeneratedValue(generator="generator")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
//	
//	private Set<Student> teachers;
//	
//	   @ManyToMany(mappedBy="students")  
//	    public Set<Student> getTeachers() {  
//	        return teachers;  
//	    }  
//	    public void setTeachers(Set<Student> student) {  
//	        this.teachers = teachers;  
//	    } 
//	    
//	    
//	
}
