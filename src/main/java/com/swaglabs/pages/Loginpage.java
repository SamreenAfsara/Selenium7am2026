package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.Screenshot;
import com.swaglabs.utils.SmartFunctions;

import io.qameta.allure.Step;

public class Loginpage extends SmartFunctions {

	WebDriver driver;
	public Loginpage(WebDriver driver, String pagename) {
		super(driver, pagename);
		this.driver=driver;
	}
	
	
	@Step("Enter username")
	public void enterUsername(String username)
	{
		enterText("username", username);
		 Screenshot.takePicture(driver);
	}

	@Step("Enter password")
	public void enterPassword(String password)
	{
		enterText("password", password);
		 Screenshot.takePicture(driver);

	}
	@Step("click loginbtn")
	public void clickonLoginbtn()
	{
		click("loginbtn");
		 Screenshot.takePicture(driver);

	}
	@Step("Get Errormsg")
	public String getErrorMsg()
	{
		 Screenshot.takePicture(driver);
		return getText("errormsg");
		

	}
	
	

}
