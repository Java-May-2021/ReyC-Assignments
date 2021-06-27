package com.reymer.events.services;

import org.springframework.stereotype.Service;

import com.reymer.events.models.Event;
import com.reymer.events.models.Message;
import com.reymer.events.models.User;
import com.reymer.events.repositories.MessageRepository;

@Service
public class MessageService {
	private final MessageRepository messageRepo;

	public MessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	
	public Message createMessage(Message message) {
		return this.messageRepo.save(message);
	}
	
	public void comment(User user, Event event, String content) {
		this.messageRepo.save(new Message(user, event, content));
	}
}
