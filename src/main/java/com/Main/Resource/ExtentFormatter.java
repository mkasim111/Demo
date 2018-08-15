package com.Main.Resource;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFormatter {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		String timeStamp;
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		String Path = System.getProperty("user.dir")+"\\target\\report "+timeStamp+".html";
		extent = new ExtentReports(Path, false);
		return extent;
	}
	
}
