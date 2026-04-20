package com.swaglabs.testscripts;

import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.utils.Browser;
import com.swaglabs.utils.DataConfig;
import com.swaglabs.utils.ReadData;
import com.swaglabs.utils.Screenshot;

import io.qameta.allure.Allure;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.*;
public class LoginpageTest extends Browser {

	public int n=1;
	
	@Parameters({"browsername"})
	@BeforeMethod
	public void setup(@Optional("chrome")String bname) throws IOException
	{
		launchBrowser(bname);
		openURL();
		Screenshot.takePicture(driver);
	}
	
	@AfterMethod
	public void teardown() throws IOException
	{
		closeBrowser();

	}
	
	
	@Test
	public void verifyLoginBtnFunctionalityWithBlankUsernameAndPassword() throws InterruptedException, IOException
	{
		Loginpage loginpage= new Loginpage(driver,"loginpage");
		loginpage.clickonLoginbtn();
		Screenshot.takePicture(driver);

		String actualmsg=loginpage.getErrorMsg();
		System.out.println(actualmsg);
		Thread.sleep(10000);
		Assert.assertEquals(actualmsg, DataConfig.BLANK_USERNAME_ERRORMSG);
	}
	
	@Test
	public void verifyLoginBtnFunctionalityWithBlankPassword() throws InterruptedException, IOException
	{
		ReadData readData = new ReadData("loginpage");
		String uname=readData.getData(1, 0);
		Loginpage loginpage= new Loginpage(driver,"loginpage");
		loginpage.enterUsername(uname);
		Screenshot.takePicture(driver);

		loginpage.clickonLoginbtn();
		Screenshot.takePicture(driver);

		String actualmsg=loginpage.getErrorMsg();
		System.out.println(actualmsg);
		//Thread.sleep(10000);
		Assert.assertEquals(actualmsg, DataConfig.BLANK_PASSWORD_ERRORMSG);
	}
	
	@Test
	public void verifyLoginBtnFunctionalityWithInvalidCredentials() throws InterruptedException, IOException
	{
		ReadData readData = new ReadData("loginpage");
		List<String>testdata=readData.getData(8);
		Loginpage loginpage= new Loginpage(driver,"loginpage");
		loginpage.enterUsername(testdata.get(0));
		Screenshot.takePicture(driver);

		loginpage.enterPassword(testdata.get(1));
		Screenshot.takePicture(driver);

		loginpage.clickonLoginbtn();
		Screenshot.takePicture(driver);

		String actualmsg=loginpage.getErrorMsg();
		System.out.println(actualmsg);
		//Thread.sleep(10000);
		Assert.assertEquals(actualmsg, DataConfig.INVALID_USERNAME_PASSWORD_ERRORMSG);
	}
	
	@Test
	public void verifyLoginBtnFunctionalityWithValidCredentials() throws InterruptedException, IOException
	{
		ReadData readData = new ReadData("loginpage");
		List<String>testdata=readData.getData(2);
		Loginpage loginpage= new Loginpage(driver,"loginpage");
		loginpage.enterUsername(testdata.get(1));
		Screenshot.takePicture(driver);

		loginpage.enterPassword(testdata.get(2));
		Screenshot.takePicture(driver);

		loginpage.clickonLoginbtn();
		Screenshot.takePicture(driver);

		
		InventoryPage inventoryPage = new InventoryPage(driver,"inventory");
		boolean status =inventoryPage.isProductTitleVisible();
		Assert.assertTrue(status, "Test script failed as product title is not visible");
			}
	
	@Test(dataProvider="loginCredentials")
	public void verifyLoginBtnFunctionalityWithValidCredentials(String sino,String uname,String pass) throws InterruptedException
	{
		
		
		
		Allure.getLifecycle().updateTestCase(testCase->
		{
			testCase.setName("Login test - "+sino);
		});
		
		
		Allure.parameter("username", uname);
		
		Loginpage loginpage= new Loginpage(driver,"loginpage");
		loginpage.enterUsername(uname);
		loginpage.enterPassword(pass);
		loginpage.clickonLoginbtn();
		
		InventoryPage inventoryPage = new InventoryPage(driver,"inventory");
		boolean status =inventoryPage.isProductTitleVisible();
		Assert.assertTrue(status, "Test script failed as product title is not visible");
			}
	
	
	@DataProvider(name="loginCredentials")
	public String[][] logindata()
	{
		ReadData readData = new ReadData("loginpage");
		return readData.getData();
	}
}

/*
 
 download and install git in local system
 
 Configure git:
 
 git config --global user.name="yourname"
  git config --global user.email="emailid"
 
 */

