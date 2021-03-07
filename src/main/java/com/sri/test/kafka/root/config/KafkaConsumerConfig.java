package com.sri.test.kafka.root.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerFactory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
		kafkaListenerFactory.setConcurrency(1);
		kafkaListenerFactory.setConsumerFactory(kafkaConsumerFacory());
		return kafkaListenerFactory;
	}
	
	private ConsumerFactory<String, Object> kafkaConsumerFacory() {
		return new DefaultKafkaConsumerFactory<String, Object>(kafkaConsConfig());
	}
	
	private Map<String, Object> kafkaConsConfig() {
		Map<String, Object> consConfig = new HashMap<String, Object>();
		consConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		consConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "SriniKTG");
		consConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		consConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		
		consConfig.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
		consConfig.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE);
		consConfig.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, Integer.MAX_VALUE);
		
		/*consConfig.put(ConsumerConfig.SECURITY_PROVIDERS_CONFIG, "TEXT_FORMAT");
		consConfig.put(SaslConfigs.SASL_KERBEROS_SERVICE_NAME, serviceName);*/
		
		
		return consConfig;
	}
}
