package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.Screenshot;
import com.swaglabs.utils.SmartFunctions;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Loginpage extends SmartFunctions {

	WebDriver driver;
	public Loginpage(WebDriver driver, String pagename) {
		super(driver, pagename);
		this.driver=driver;
	}
	
	
	
	public void enterUsername(String username)
	{
		Allure.step("Enter username");
		enterText("username", username);
		 Screenshot.takePicture(driver);
	}

	
	public void enterPassword(String password)
	{
		Allure.step("Enter password");
		enterText("password", password);
		 Screenshot.takePicture(driver);

	}
	
	public void clickonLoginbtn()
	{
		Allure.step("Click on login btn");
		click("loginbtn");
		 Screenshot.takePicture(driver);

	}
	
	public String getErrorMsg()
	{
		Allure.step("get error msg");
		 Screenshot.takePicture(driver);
		return getText("errormsg");
		

	}
	
	

}
