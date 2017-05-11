package com.neusoft.cargo.dao;

import java.util.List;

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
	@Override
	public List<Complaints> findAll() {
		// TODO Auto-generated method stub
		//try {
			return  (List<Complaints>) this.getHibernateTemplate().find("from Complaints", null);
		// } catch (Exception e) {
		// e.printStackTrace();
		// // TODO: handle exception
		// }
		// (List<TrackOrder>) (List<TrackOrder>) (List<TrackOrder>) 
//	return super.findAll();
	}

}
