package com.nt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.producer.MessageProducer;
import com.nt.storemsg.MessageStore;

@RestController
public class KafkaMessagingOperationsController {

	@Autowired
	private MessageProducer producer;
	@Autowired
	private MessageStore store;

	@GetMapping("/send")
	public ResponseEntity<String> send(@RequestParam("message") String message) {

		// send the message through producer
		String msg = producer.sendMessage(message);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@GetMapping("/readAll")
	public ResponseEntity<List<String>> showAllMessages() {
		List<String> messagesList = store.showAllMessages();
		return new ResponseEntity<List<String>>(messagesList, HttpStatus.OK);

	}

}
