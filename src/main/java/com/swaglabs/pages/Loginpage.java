package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.SmartFunctions;

public class Loginpage extends SmartFunctions {

	public Loginpage(WebDriver driver, String pagename) {
		super(driver, pagename);
	}
	
	
	public void enterUsername(String username)
	{
		enterText("username", username);
	}

	public void enterPassword(String password)
	{
		enterText("password", password);
	}
	
	public void clickonLoginbtn()
	{
		click("loginbtn");
	}
	
	public String getErrorMsg()
	{
		return getText("errormsg");
	}
	
	

}
