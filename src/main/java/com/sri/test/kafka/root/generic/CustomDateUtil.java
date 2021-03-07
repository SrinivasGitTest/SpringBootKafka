package com.sri.test.kafka.root.generic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateUtil {

	public static Date getUtilDate(String strDate) throws Exception {
		
		if(CustStringUtil.isRequired(strDate)) return null;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
			return dateFormat.parse(strDate);
	}
	
}
