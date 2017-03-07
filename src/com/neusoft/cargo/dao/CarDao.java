package com.neusoft.cargo.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Car;

@Repository("CarDao")
public class CarDao extends AbstractHibernateDAO<Car> {

	public void save(Car entity) {
		try {
			this.getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}


}
