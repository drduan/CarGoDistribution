package com.neusoft.cargo.JunitTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration({ "/spring-hibernate.xml" })
// @Configuration
// @Transactional
// @EnableTransactionManagement
// @ComponentScan({ "com.neusoft.cargo" })
public class UserServiceTest {
	// @Autowired
	// private static UserServiceImpl userService;
	private static final Logger logger = LogManager.getLogger(UserServiceTest.class);

	public static void main(String[] args) {

		logger.trace("Entering application.");
		// Bar bar = new Bar();
		if (true) {
			logger.error("Didn't do it.");
		}
		logger.trace("Exiting application.");

		// User person = new User();
		// person.setUsername("a");
		// userService.save(person);
		// TODO: handle exception
	}

}
