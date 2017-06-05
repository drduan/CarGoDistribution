package com.neusoft.cargo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Car;
import com.neusoft.cargo.entity.CargoResource;
import com.neusoft.cargo.entity.User;

@Repository("CargoResourceDao")
public class CargoResourceDao extends AbstractHibernateDAO<CargoResource> {

	private static final Log log = LogFactory.getLog(CargoResourceDao.class);
	// property constants

	public CargoResourceDao() {
		setClazz(CargoResource.class);
	}

	@Override
	public void delete(CargoResource entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	public void save(CargoResource cargoResource) {
		try {
			this.getHibernateTemplate().saveOrUpdate(cargoResource);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// public User findByMail(String email) {
	//
	// //，并且以_ci（大小写不敏感）、_cs（大小写敏感）
	// List<User> result = (List<User>) this.getHibernateTemplate().find("from
	// User u where u.email=?", email);
	// if (result.isEmpty()) {
	//
	// return null;
	//
	// } else {
	//
	// return result.get(0);
	// }
	//
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
			// List<Car> lc = new ArrayList<>(ciUser.getStockDailyRecords());

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;

	}

	public void addCargoResourceToUser(User user1, CargoResource cargoresource) {
		cargoresource.set_user(user1);
		getCurrentSession().save(cargoresource);
		getCurrentSession().saveOrUpdate(user1);

	}

	public CargoResource findByYpbm(String ypbm) {
		List<CargoResource> lc = (List<CargoResource>) this.getHibernateTemplate()
				.find("from cargoresource u where u.ypbm=?", ypbm);
		if (lc.isEmpty() ) {

			return null;
		} else {
			return lc.get(0);
		}
		// CargoResource ciUser = (CargoResource) this.getHibernateTemplate()
		// .find("from cargoresource u where u.ypbm=?", ypbm).get(0);
		// return ciUser;
	}

}
