package com.Main.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Main.Resource.ScreenShot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PracticePage {
	WebDriver driver;
	ExtentTest test;
	ScreenShot ss;

	public PracticePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		 PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"hondaradio\"]")
	public WebElement HondaRadioButton;

	@FindBy(xpath = "/html/body/header/div[@class='navbar navbar-fedora navbar-fixed-top bs-docs-nav is-not-signed-in is-at-top']//a[contains(text(),'Login')]")
	public WebElement LoginButton;

	public void clickRadioButton() throws IOException {
		ss = new ScreenShot(driver);
		waitMethod(By.xpath("//*[@id=\"hondaradio\"]"));
		HondaRadioButton.click();
		String imagepath = test.addScreenCapture(ss.takesScreenShot());
		test.log(LogStatus.INFO, "click Honda", imagepath);
	}

	public LoginPage clickLoginButton() throws IOException {
		ss = new ScreenShot(driver);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1900);");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1900);");
		LoginButton.click();
		String imagepath = test.addScreenCapture(ss.takesScreenShot());
		test.log(LogStatus.INFO, "click Honda", imagepath);
		return new LoginPage(driver, test);
	}

	public void waitMethod(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
