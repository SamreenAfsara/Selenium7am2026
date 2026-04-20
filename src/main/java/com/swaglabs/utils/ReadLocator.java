package com.swaglabs.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadLocator {
	private Properties pro;
	public ReadLocator(String filename)
	{
		String filepath="./src/test/resources/locators/"+filename+".properties";
		try {
			FileInputStream instream = new FileInputStream(filepath);
			 pro = new Properties();
			pro.load(instream);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public String getProperty(String elementname)
	{
		
		return pro.getProperty(elementname);
	}
	
	
	public static void main(String[] args) {
		ReadLocator read = new ReadLocator("loginpage");
		String locatorvalue=read.getProperty("errormsg");
		System.out.println(locatorvalue);
	}
	
}
