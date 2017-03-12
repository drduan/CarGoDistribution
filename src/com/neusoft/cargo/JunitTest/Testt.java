package com.neusoft.cargo.JunitTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.neusoft.cargo.dao.CarDao;
import com.neusoft.cargo.dao.RoleDao;
import com.neusoft.cargo.dao.UserDao;
import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-hibernate.xml", "classpath:spring-mvc.xml",
		"classpath:spring.xml", })
@TransactionConfiguration(defaultRollback = true)
public class Testt extends AbstractTransactionalJUnit4SpringContextTests {

//	@Autowired
//	private UserServiceImpl userserviceimpl;
	@Inject
	private RoleDao roleDao;

	@Inject
	private CarDao carDao;

	@Inject
	private UserDao userDao;

	@Inject
	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		logger.error("Before");
	}

	@After
	public void tearDown() throws Exception {

		logger.error("After");

	}

	@Test
	@Rollback(false)
	public void testSaveUser() {

		Car car = new Car();
		User user = new User();
		car.setCarHost("ajjbd");
//		car.setUser(user);
		car.setCarNumber("sadasjjd");
		carDao.save(car);
		
		Set<Car> stockDailyRecords = new HashSet<>(0);
		stockDailyRecords.add(car);
		user.setStockDailyRecords(stockDailyRecords);
	
		userDao.save(user);

		// Score user = new Score();

		// Session session = sessionFactory.getCurrentSession().getSession();
		//
		// List<Role> roleList = new ArrayList();
		// roleList = roleDao.findAll();
		// User user1 = new User();
		// Set<Role> list = new HashSet<Role>(roleList);
		//
		// user1.setRoleList(list);
		// user1.setUsername("22");
		// user1.setPassword("passwor1d22");
		// user1.setPhone("11231232212");
		// user1.setEmail("em2ai1l");
		// userDao.save(user1);

		// session.beginTransaction();
		// Course instance = (Course)
		// session.get("com.neusoft.cargo.entity.Course", 52);
		// Logger.getRootLogger().error("" + instance.getTitle());
		// Student instance1 = (Student)
		// sessionFactory.getCurrentSession().get("com.neusoft.cargo.entity.Student",
		// 1);
		// user.setCourse(instance);
		// user.setScore(90);
		// user.setStudent(instance1);
		// user.setAge(12);
		// try {
		// studentdao.save(user);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	// @Test
	public void testGetUserById() {
		List roles = roleDao.findAll();
		logger.error(roles.size());
	}

}