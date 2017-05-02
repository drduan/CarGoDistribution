package com.neusoft.cargo.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.UserAuthInfo;

@Repository("UserAuthDao")
public class UserAuthDao extends AbstractHibernateDAO<UserAuthInfo> {

	public void save(UserAuthInfo UserAuthInfo) {
		try {
			// this.getHibernateTemplate().saveOrUpdate(entity);

			this.getHibernateTemplate().save(UserAuthInfo);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
