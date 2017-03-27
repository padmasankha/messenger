package org.padmasankha.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.exceptions.i18n.DatabaseExceptionResource;
import org.padmasankha.jaxrs.messenger.database.DataBaseClass;
import org.padmasankha.jaxrs.messenger.exception.DataNotFoundException;
import org.padmasankha.jaxrs.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> message = DataBaseClass.getMessage();
	
	public MessageService() {
		message.put(1L, new Message(1, "Test_Msg_1", "User"));
		message.put(2L, new Message(2, "Test_Msg_2", "User"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(message.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		ArrayList<Message> msgForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for(Message msg : message.values()){
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				msgForYear.add(msg);
			}
		}		
		return msgForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,  int size) {
		List<Message> list = new ArrayList<Message>(message.values());
		
		if(start + size > list.size()){
			return new ArrayList<Message>();
		}
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message msg = message.get(id);
		if(msg == null){
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return msg;
	}
	
	public Message addMessage(Message msg) {
		msg.setId(message.size() + 1);
		message.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		if(msg.getId() < 0){
			return null;
		}		
		message.put(msg.getId(), msg);		
		return msg;
	}
	
	public Message removeMessage(long id) {
		return message.remove(id);
	}
}
