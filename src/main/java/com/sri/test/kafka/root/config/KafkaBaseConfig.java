package com.sri.test.kafka.root.config;

import org.springframework.beans.factory.annotation.Value;

public class KafkaBaseConfig {

	@Value("external.kafka.msg.bootStrapServer.config")
	String bootStrapServer;
	
	@Value("external.kafka.eventbus.consumer.group")
	String producerGrpId;
	
	@Value("external.kafka.eventbus.servicename")
	String serviceName;
	
	@Value("app.kafka.authentication.type")
	String authType;
	
	@Value("app.client.username")
	String userName;
	
	@Value("app.client.password=")
	String password;
	
	@Value("env")
	String env;
	
}
