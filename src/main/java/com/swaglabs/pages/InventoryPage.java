package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.swaglabs.utils.Screenshot;
import com.swaglabs.utils.SmartFunctions;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class InventoryPage extends SmartFunctions {

	WebDriver driver;
	public InventoryPage(WebDriver driver, String pagename) {
		super(driver, pagename);
		this.driver=driver;
	}
	
	
	public boolean isProductTitleVisible()
	{
		Allure.step("Product title visible");
	    Screenshot.takePicture(driver);
		return isVisible("productTitle");
	}

}
