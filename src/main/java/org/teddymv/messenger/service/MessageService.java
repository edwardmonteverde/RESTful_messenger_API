package org.teddymv.messenger.service;

import java.util.*;

import org.teddymv.messenger.database.DatabaseClass;
import org.teddymv.messenger.model.Message;

public class MessageService {

	// retrieve all the existing messages into new map 'messages'
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Fuck you this is message 1", "Teddy"));
		messages.put(2L, new Message(1, "Eat a dick this is message 2", "Teddy"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	// method to return a specifc msg by id
	public Message getMessage(long id) {
		return messages.get(id);
	}

	// add a msg
	public Message addMessage(Message msg) {
		// set id of new msg to the size of map + 1
		msg.setId(messages.size() + 1);

		// set date as current date and time
		msg.setCreated(new Date());

		// add msg to map by newly found id and msg contents
		messages.put(msg.getId(), msg);

		return msg;
	}

	public Message updateMessage(Message msg) {
		if (msg.getId() <= 0)
			return null;
		messages.put(msg.getId(), msg);
		return msg;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
