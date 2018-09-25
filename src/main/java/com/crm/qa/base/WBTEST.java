package com.crm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WBTEST {

	
	@Test
	public void wbTest()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("www.facebook.com");
		//driver.get("http://www.gmail.com");
	}
}
