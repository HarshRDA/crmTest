package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest()
	{
		super();
	}
	
	//Test Cases should be independent
	//Before every test, user will be logged in fresh in fresh browser instance
	//@test- execute test case
	//after each test case close the browser
	@BeforeMethod
	public void setup() throws InterruptedException 
	{
		 initialization();
	
		 loginPage = new LoginPage();
		 testUtil = new TestUtil();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 contactsPage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String str= homePage.verifyHomePageTitle();
		Assert.assertEquals(str, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUserLabel());
		
	}
	

	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame("mainpanel");
		
		contactsPage= homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
