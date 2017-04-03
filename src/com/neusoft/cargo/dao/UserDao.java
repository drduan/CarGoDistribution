package com.neusoft.cargo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;

@Repository("UserDao")
public class UserDao extends AbstractHibernateDAO<User> {

	private static final Log log = LogFactory.getLog(UserDao.class);

	public UserDao() {
		setClazz(User.class);
	}

	public void save(User entity) {
		try {
			this.getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User findByMail(String email) {

		// ，并且以_ci（大小写不敏感）、_cs（大小写敏感）
		List<User> result = (List<User>) this.getHibernateTemplate().find("from User u where u.email=?", email);
		if (result.isEmpty()) {

			return null;

		} else {

			return result.get(0);
		}

	}

	// public User getUniqueByProperty(String paramName, String value) {
	// return (User) this.getHibernateTemplate().find("from User u where
	// u.username=?", value).get(0);
	// }

	public List<Car> GetCarList(User entity) {

		try {
			// this.getHibernateTemplate().saveOrUpdate(entity);
			// this.getHibernateTemplate().findByCriteria(null);
			// Session session=Hibernate_Util.getSession();
			// org.hibernate.Session session = this.getCurrentSession();
			// 2.定义查询最大记录数的hql
			// String hql = "from User";
			// //3.定义查询最大记录数的Query对象
			// Query querypage=session.createQuery(hql);
			// //4.查询最大记录数的数据
			// querypage.setMaxResults(page.getPagesize());
			// //5.确定查询起点
			// querypage.setFirstResult(page.getStartrow());
			// //6.分页查询
			// List<Student> list=querypage.list();
			// //7.关闭session
			// Hibernate_Util.closeSession();
			// return querypage.list();
			User ciUser = (User) this.getHibernateTemplate().find("from User u where u.email=?", entity.getEmail())
					.get(0);

			return ciUser.getCars();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<CargoResource> GetCargoResourceList(User entity) {

		try {

			User ciUser = (User) this.getHibernateTemplate().find("from User u where u.email=?", entity.getEmail())
					.get(0);

			return ciUser.getCargoResources();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void addCarToUser(User user1, Car car) {
		car.setUser(user1);
		getCurrentSession().save(car);
		List<Car> sc = new ArrayList<Car>();
		sc.add(car);
		user1.setCars(sc);
		getCurrentSession().saveOrUpdate(user1);

	}

}
