package com.swaglabs.utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

	
	public static void takePicture(WebDriver driver) throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filepath = ".//screenshots//" + timestamp + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File image = ts.getScreenshotAs(OutputType.FILE);

        File destFile = new File(filepath);
        FileUtils.copyFile(image, destFile);

       
        attachScreenshot(destFile);
    }

    @Attachment(value = "Step Screenshot", type = "image/png")
    public static byte[] attachScreenshot(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
	
}
