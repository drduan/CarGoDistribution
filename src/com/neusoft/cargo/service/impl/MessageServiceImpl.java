package com.neusoft.cargo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.dao.MessageDao;
import com.neusoft.cargo.entity.Message;
import com.neusoft.cargo.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	
	@Resource
	private MessageDao msgdao;
	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return msgdao.findAll();
	}

	@Override
	public void save(Message msg) {
		// TODO Auto-generated method stub
		msgdao.save(msg);
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMsgAsRead(int id) {
		// TODO Auto-generated method stub
		Message message = msgdao.findOne(id);
		message.setStatus(true);
		return msgdao.update(message);
	}


}
