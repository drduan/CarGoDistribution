package com.neusoft.cargo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neusoft.cargo.entity.Message;

@Service
public interface MessageService {

	public List<Message> findAll();

	public void save(Message cargoResource);

	public void remove(int id);

	public Message find(int id);

	public boolean updateMsgAsRead(int id);

}
