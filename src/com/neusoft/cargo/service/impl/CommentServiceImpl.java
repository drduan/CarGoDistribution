package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.CommentDao;
import com.neusoft.cargo.entity.Comment;

@Service
public class CommentServiceImpl {

	@Resource
	private CommentDao commentDao;

	private Logger logger = Logger.getLogger(CarServiceImpl.class);

	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	public void save(Comment comment) {
		// TODO Auto-generated method stub

		commentDao.save(comment);

	}
}
