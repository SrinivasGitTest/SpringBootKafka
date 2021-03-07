package com.sri.test.kafka.root.generic;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustStringUtil {
	
	public static boolean isRequired(Object obj) {
		return ((obj == null) || (obj.toString().trim().length() == 0) || ("null".equalsIgnoreCase(obj.toString().trim())) ||
				("undefined".equalsIgnoreCase(obj.toString().trim())));
	}
	
	public static <T> T deserializeMsg(Class<T> toClass, String message ) {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			return objMapper.readValue(message, toClass);
		}
		catch (Exception exp) {
			exp.printStackTrace();
			throw new IllegalStateException("Error during json deoserialization - "+message, exp);
		}
	}

}
