package com.swaglabs.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

	
	
	 @Step("Capture screenshot")
	    @Attachment(value = "Step Screenshot", type = "image/png")
	    public static byte[] takePicture(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
    }
	

