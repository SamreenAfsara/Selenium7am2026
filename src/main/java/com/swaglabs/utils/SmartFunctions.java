package com.swaglabs.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartFunctions {
	private ReadLocator readlocator;
	private WebDriver driver;
	
	public SmartFunctions(WebDriver driver,String pagename)
	{
		 readlocator = new ReadLocator(pagename);
		this.driver=driver;
	}
	
	
	private By getLocator(String elementname)
	{
		String locatorvalue=readlocator.getProperty(elementname);
		String values[]=locatorvalue.split(":",2);
		By locator;
		switch(values[0])
		{
		case "id": locator=By.id(values[1]);
		break;
		case "name": locator=By.name(values[1]);
		break;
		case "class": locator=By.className(values[1]);
		break;
		case "xpath": locator=By.xpath(values[1]);
		break;
		case "css": locator=By.cssSelector(values[1]);
		break;
		default: locator =null;
		}
		
		return locator;
	}
	
	
	
	protected WebElement getElement(String elementname)
	{
		return driver.findElement(getLocator(elementname));
	}
	
	protected List<WebElement> getElements(String elementname)
	{
		return driver.findElements(getLocator(elementname));
	}
	
	protected void enterText(String elementname,String data)
	{
		getElement(elementname).sendKeys(data);
	}
	protected void click(String elementname)
	{
		getElement(elementname).click();
	}
	protected String getText(String elementname)
	{
		return getElement(elementname).getText();
	}
	
	protected boolean isVisible(String elementname)
	{
		try
		{
			return getElement(elementname).isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

}
