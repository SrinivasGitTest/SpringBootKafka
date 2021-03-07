package com.sri.test.kafka.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sri.test.kafka.root.Producer.KafkaProducerService;

@RestController
@RequestMapping("/sri/test/kafka")
public class KafkaProducerController {

	@Autowired(required=true)
	KafkaProducerService producer;
	
	@RequestMapping(value="/send", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void sendMsg(@RequestParam String msg) {
		producer.sendMessage(msg);
	}
}
