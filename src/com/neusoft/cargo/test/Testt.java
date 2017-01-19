package com.neusoft.cargo.test;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.neusoft.cargo.dao.ScoreDao;
import com.neusoft.cargo.entity.Course;
import com.neusoft.cargo.entity.Score;
import com.neusoft.cargo.entity.Student;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(
		  locations={
		    "classpath:spring-hibernate.xml",    
		    "classpath:spring-mvc.xml",
		    "classpath:spring.xml",
		  } 
		  )
@TransactionConfiguration(defaultRollback = true)
public class Testt extends  AbstractTransactionalJUnit4SpringContextTests {

	
	   @Autowired  
	private ScoreDao studentdao;
	   @Inject
	  private SessionFactory sessionFactory ;
	   
	@Before
	 public void setUp() throws Exception {
	 }
	 
	 
	 @After
	 public void tearDown() throws Exception {
	 }
	 
	 @Test
	 @Rollback(false)
	 public void testSaveUser() {
	  
	  Score user=new Score();
	  
Session session = sessionFactory.getCurrentSession().getSession();
	  
//session.beginTransaction();
		Course instance = (Course) session.get("com.neusoft.cargo.entity.Course", 52);
		Logger.getRootLogger().error(""+instance.getTitle());
		Student instance1 = (Student) sessionFactory.getCurrentSession().get("com.neusoft.cargo.entity.Student", 1);
		
	  user.setCourse(instance);
	  user.setScore(90);
	  
	  user.setStudent(instance1);
	  
	  
	  
//	  user.setAge(12);
	  try {
		studentdao.save(user);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 }
	 
	 
	 @Test
	 public void testGetUserById() {	 }
	 

}