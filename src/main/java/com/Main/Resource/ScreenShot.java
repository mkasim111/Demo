package com.Main.Resource;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	WebDriver driver;
	public ScreenShot(WebDriver driver) throws IOException {
		this.driver= driver;
		
	}
	
	public String takesScreenShot() throws IOException {
		String timeStamp;
		String destination= System.getProperty("user.dir")+"\\output\\";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		FileUtils.copyFile(src, new File(destination+"test"+timeStamp+".jpg"));
		return destination+"test.jpg";
		
	}
	
	
}
