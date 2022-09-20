package com.zalando.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import io.opentelemetry.sdk.metrics.data.Data;

public class JavaUtility {
	/**
	 * this mthd use to get the random number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}
	
	public Object convertStringIntoAnyDataType(String data, DataType strategy){
		Object obj=null;
		if(strategy.toString().equalsIgnoreCase("long")) {
			obj=Long.parseLong(data);
		}
		else if(strategy.toString().equalsIgnoreCase("int")) {
			obj=Integer.parseInt(data);
			
		}
		else if(strategy.toString().equalsIgnoreCase("double")) {
			obj=Double.parseDouble(data);
		
	}
		return obj;
	}
	
	public String currentTime()
	{
		Date data =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualData=sdf.format(data);
				return actualData;
	}
}
