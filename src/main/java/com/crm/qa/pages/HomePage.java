package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Object Repo
	
	@FindBy(xpath="//td[contains(text(),'User: Harsh kumar')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(linkText="New Contact")
	WebElement newContact;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		String title = driver.getTitle();
		
		return title;
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public boolean verifyUserLabel()
	{
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContact() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(1000);
		newContact.click();
	}
	
}
