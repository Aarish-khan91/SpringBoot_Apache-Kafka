package com.nt.storemsg;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.springframework.stereotype.Component;

@Component
public class MessageStore {

	private List<String> messagesList = new ArrayList<>();

	public void addMessage(String message) {
		
		messagesList.add(message);
	}

	public List<String> showAllMessages() {
		return messagesList;
	}
}
