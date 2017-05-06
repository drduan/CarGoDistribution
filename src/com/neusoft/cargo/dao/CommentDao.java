package com.neusoft.cargo.dao;

import org.springframework.stereotype.Repository;

import com.neusoft.cargo.entity.Comment;

@Repository("CommentDao")
public class CommentDao extends AbstractHibernateDAO<Comment> {

	public CommentDao() {
		setClazz(Comment.class);
	}

	public void save(Comment entity) {
		try {
			this.getHibernateTemplate().save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
