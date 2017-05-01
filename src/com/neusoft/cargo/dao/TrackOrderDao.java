package com.neusoft.cargo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.TrackOrder;
import com.neusoft.cargo.entity.User;

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
	
	public  TrackOrder findByUUID(String uuid) {
		
		
		List<TrackOrder> result = (List<TrackOrder>) this.getHibernateTemplate().find("from trackorder u where u.uuid=?", uuid);
		if (result.isEmpty()) {

			return null;

		} else {

			return result.get(0);
		}
	}

}
