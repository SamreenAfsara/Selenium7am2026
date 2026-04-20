package com.swaglabs.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.ByteArrayInputStream;

public class Screenshot {

	
	
	
	 
	 public static void takePicture(WebDriver driver) {
	        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
	    }
	 
    }
	

