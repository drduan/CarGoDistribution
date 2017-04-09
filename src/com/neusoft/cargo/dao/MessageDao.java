package com.neusoft.cargo.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Message;

@Repository("MessageDao")
public class MessageDao extends AbstractHibernateDAO<Message> {

	public void save(Message msg) {
		try {

			this.getHibernateTemplate().save(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
