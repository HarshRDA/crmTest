package com.crm.qa.pages;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	//Objec Repo
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	//Initializing page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateImage()
	{
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException 
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(4000);
		//WebDriverWait wait = new WebDriverWait(driver,40);
	//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
		loginBtn.click();
		
		return new HomePage();
	}
	
}
