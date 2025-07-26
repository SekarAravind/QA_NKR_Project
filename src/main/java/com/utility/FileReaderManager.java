package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	
	public static FileInputStream fileInputStream;
	public static Properties property;
	
	public static void setProperty() throws IOException {
		File file = new File("C:\\Selenium Practice\\MavenNaukri\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
			
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR : OCCURED DURING FILE LOADING");
		}catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING FILE READING");
		}
	}
	
	public static String getDataProperty(String dataValue) throws IOException {
		setProperty();
		String data = property.getProperty(dataValue);
		return data;		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getDataProperty("url"));
	}

}
