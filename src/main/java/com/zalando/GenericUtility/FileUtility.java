package com.zalando.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	Properties property;

	/**
	 * this method is use to get the data from property file
	 * 
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key) {
		String value = property.getProperty(key).trim();
		return value;

	}

	/**
	 * 
	 * this method is initialize the property file
	 */

	public void initializePropertyFile(String propertypath) throws IOException {
		FileInputStream fis = new FileInputStream(propertypath);
		property = new Properties();
		property.load(fis);

	}
}
