package com.sri.test.kafka.root.Listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	
    //@KafkaListener(topics = "Srinivas_Test", groupId = "console-consumer-91521")
    @KafkaListener(topics = "Srinivas_Test", groupId = "SriniKTG")
    public void consumerMsg(@Payload String msgData, @Header(KafkaHeaders.RECEIVED_PARTITION_ID)int partitionId, @Header(KafkaHeaders.OFFSET)long offSetId,
			//@Header(KafkaHeaders.CORRELATION_ID)String correlationId, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY)String msgKeyId 
			@Header(KafkaHeaders.GROUP_ID)String groupId) {

		System.out.println(String.format("partitionId=:", msgData, ":==offSetId==:"+offSetId,":==groupId==:"+groupId));
		logger.info(String.format("#### -> Consumed message -> %s", msgData));
	
	}
	
	/*@KafkaListener(topics = "Srinivas_Test", groupId = "SriniKTG")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }*/
}
