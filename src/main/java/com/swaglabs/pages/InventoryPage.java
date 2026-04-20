package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.Screenshot;
import com.swaglabs.utils.SmartFunctions;

import io.qameta.allure.Step;

public class InventoryPage extends SmartFunctions {

	WebDriver driver;
	public InventoryPage(WebDriver driver, String pagename) {
		super(driver, pagename);
		this.driver=driver;
	}
	
	@Step("checking title is visible")
	public boolean isProductTitleVisible()
	{
	    Screenshot.takePicture(driver);
		return isVisible("productTitle");
	}

}
