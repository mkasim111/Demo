package com.Main.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Main.Resource.ScreenShot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	WebDriver driver;
	ExtentTest test;
	ScreenShot ss;

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		 PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='user_email']")
	public WebElement emailTextBox;

	public void writeEmailinTextBox(String email) throws IOException {
		ss = new ScreenShot(driver);
		waitMethod(By.xpath("//*[@id='user_email']"));
		emailTextBox.sendKeys(email);
		String imagepath = test.addScreenCapture(ss.takesScreenShot());
		test.log(LogStatus.INFO, "click Honda", imagepath);
	}

	public void waitMethod(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
