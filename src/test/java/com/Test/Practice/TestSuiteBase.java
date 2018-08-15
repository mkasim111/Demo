package com.Test.Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Main.Practice.LoginPage;
import com.Main.Practice.PracticePage;
import com.Main.Resource.ExtentFormatter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestSuiteBase {
	protected WebDriver driver;
	protected PracticePage pp;
	protected LoginPage lp;
	ExtentReports report;
	ExtentTest test;
	
	
	@Parameters({"platform","browser","url"})
	@BeforeClass(alwaysRun=true)
	public void setUp(String platform, String browser, String url) throws MalformedURLException {
		report= ExtentFormatter.getInstance();
		test = report.startTest("Starting test One");
		driver = getDriverInstance(platform, browser, url);
		
		pp = new PracticePage(driver, test);
		PageFactory.initElements(driver, pp);
		//lp = new LoginPage(driver, test);
		//PageFactory.initElements(driver, lp);
	}
	
	public static WebDriver getDriverInstance(String platform, String browser, String url) throws MalformedURLException
	{
		String nodeUrl ="http://192.168.1.9:5555/wd/hub";
		WebDriver edriver= null;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		if(platform.equalsIgnoreCase("Windows"))
		{
			cap.setPlatform(Platform.WINDOWS);
		}
		if(platform.equalsIgnoreCase("Mac"))
		{
			cap.setPlatform(Platform.MAC);
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			String Path = System.getProperty("user.dir") + "\\Additional Jars\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", Path);
			cap= DesiredCapabilities.chrome();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			ProfilesIni prof = new ProfilesIni();
			String Path = System.getProperty("user.dir") + "\\Additional Jars\\Driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", Path);
			FirefoxProfile fp = prof.getProfile("myProfile");
			cap= DesiredCapabilities.firefox();
			cap.setCapability(FirefoxDriver.PROFILE, fp);
		}
		edriver = new RemoteWebDriver(new URL(nodeUrl),cap);
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		edriver.get(url);
		
		return edriver;
		
		
	}
	

}
