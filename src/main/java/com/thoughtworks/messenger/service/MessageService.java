package com.thoughtworks.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thoughtworks.messenger.database.DatabaseClass;
import com.thoughtworks.messenger.exception.DataNotFoundException;
import com.thoughtworks.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Technical Architect", "Gagan Bhatnagar"));
		messages.put(2L, new Message(2, "Sr Apps Developer", "Rajat Bhatnagar"));
		//System.out.println("*********** Creating the map with size " + messages.size() +" *********************");
	}

	public List<Message> getAllMessages(){
		List<Message> list = new ArrayList<Message>();
		list.addAll(messages.values());
		return list;
	}
	
	//Enhancing this method to throw a custom DataNotFoundException if nothing is found
	public Message getMessage(long id){
		Message message = messages.get(id);
		//If a message is not found, throw a runtime exception
		if(message == null){
			throw new DataNotFoundException("Message with id :: "+id+ " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message){
		message.setID(messages.size() + 1);
		messages.put(message.getID(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		System.out.println("*********** UPDATING the ID *********************");
		if(message.getID() == 0){
			return null;
		}
		messages.put(message.getID(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		System.out.println("*********** DELETING the ID *********************");
		return messages.remove(id);
		
	}
	
}
