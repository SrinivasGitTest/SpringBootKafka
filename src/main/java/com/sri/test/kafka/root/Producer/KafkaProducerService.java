package com.sri.test.kafka.root.Producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC = "Srinivas_Test";
    
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;
    
    public void sendMessage(Object message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
     //   this.kafkaTemplate.send(TOPIC, message);
        
        ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send(TOPIC, message);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

			public void onSuccess(SendResult<String, Object> result) {
				System.out.println("******************************************");
				System.out.println(result.getRecordMetadata());
				System.out.println("*****************************");
				logger.info("Sent message=[ {} ] with offset=[ {} ]", result.getProducerRecord().headers(), result.getRecordMetadata().offset());
				
			}

			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    
    /*public SendResult<String, Object> publishMessage(String eventId, String topicName, Integer partitionId, SpecificRecord actualMsg) throws Exception {
		SendResult<String, Object> sendResults = kafkaTemplate.send(topicName, partitionId, (new Date()).getTime(), eventId, actualMsg).get();
		return sendResults;
	}*/
	
}
