package com.Test.Practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Main.Practice.LoginPage;
import com.Main.Practice.PracticePage;
import com.Main.Resource.ExtentFormatter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBrowserInvokation2{
	WebDriver driver;
	
	PracticePage pp;
	LoginPage lp;
	ExtentReports report;
	ExtentTest test;
	
	private static final Logger log = LogManager.getLogger(TestBrowserInvokation2.class.getName());
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		report= ExtentFormatter.getInstance();
		test = report.startTest("Starting test One");
		String Path = System.getProperty("user.dir") + "\\Additional Jars\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://learn.letskodeit.com/p/practice");
		test.log(LogStatus.INFO, "URL is opened");
		String title = driver.getTitle();
		log.info("Printing the title of the page "+title);
		
	}
	
	@Test
	public void testOne() throws Exception {
		
		pp.clickRadioButton();
		lp= pp.clickLoginButton();
		lp.writeEmailinTextBox("testEmail");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		report.endTest(test);
		report.flush();
		driver.close();
	}

}
