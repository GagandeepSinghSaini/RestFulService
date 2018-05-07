package org.javabrains.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javabrains.database.DatabaseClass;
import org.javabrains.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		System.out.println("Updating MessageId: "+message.getId());
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public String removeMessage(Message message) {
		System.out.println("MesageService: Delete Starts: "+message.getId());
		messages.remove(message.getId());
		System.out.println("Messages: "+messages);
		return "Message Deleted Successfully";
	}
}
