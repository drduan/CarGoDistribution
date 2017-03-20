package com.neusoft.cargo.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.TrackOrder;

@Repository("TrackOrderDao")
public class TrackOrderDao extends AbstractHibernateDAO<TrackOrder> {

	public void save(TrackOrder entity) {
		try {
			// this.getHibernateTemplate().saveOrUpdate(entity);

			this.getHibernateTemplate().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
