package com.neusoft.cargo.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Complaints;

@Repository("ComplaintsDao")
public class ComplaintsDao extends AbstractHibernateDAO<Complaints> {

	public ComplaintsDao() {
		setClazz(Complaints.class);
	}

	public void save(Complaints entity) {
		try {
			this.getHibernateTemplate().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
