package com.sri.test.kafka.root.config;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
//@PropertySource("classpath:application.properties")
public class KafkaProducerConfig {

	/*@Value("${kafka.producer.bootStrapServe}")
	private String bootStrapServer;*/
	
	@Bean
	public KafkaTemplate<String, Object> getKafkaTemplate() {
		return new KafkaTemplate<String, Object>(kafkaProdFactory());
	}
	
	private ProducerFactory<String, Object> kafkaProdFactory() {
		return new DefaultKafkaProducerFactory<String, Object>(getKafkaProdConfig());
	}
	
	private Map<String, Object> getKafkaProdConfig() {
		Map<String, Object> kafkaProdConfig = new HashMap<String, Object>();
		kafkaProdConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		kafkaProdConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		kafkaProdConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		//kafkaProdConfig.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1000);
		kafkaProdConfig.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 3000);
		kafkaProdConfig.put(ProducerConfig.CLIENT_ID_CONFIG, ManagementFactory.getRuntimeMXBean().getName());
		
		
		/*kafkaProdConfig.put(key, value);
		kafkaProdConfig.put(key, value);
		kafkaProdConfig.put(key, value);
		kafkaProdConfig.put(key, value);
		kafkaProdConfig.put(key, value);*/
		/*producrConfig.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "TEXT_FORMAT");
		producrConfig.put(SaslConfigs.SASL_KERBEROS_SERVICE_NAME, serviceName);
		if(CustStringUtil.isRequired(authType) && authType.equalsIgnoreCase("Basic")) {
			kafkaProdConfig.put("UserName", userName);
			kafkaProdConfig.put("password", password);
			kafkaProdConfig.put("authenticationMode", Authentication.ANY);
			kafkaProdConfig.put("authenticationEnvConfig", env);
		}
		else {
			kafkaProdConfig.put("authenticationMode", Authentication.aNULL);
		}
		
		producrConfig.put("SchemaRegistryUrl", "schemaregUrl");
		producrConfig.put("SchemaRegMaxSizeCacheConfig", 3000);
		producrConfig.put("schemaRegMaxRetries", 2);
		producrConfig.put("schemaRegMaxAuthRetiesConfig", 2);
		producrConfig.put("schemaRegBaseWaitDuration", 10);
		producrConfig.put("schemaRegRetryWaitDurationIntervalConfig", 1.5);
		
		*/
		
		return kafkaProdConfig;
	}
}
