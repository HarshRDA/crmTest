/*
 * @author: Harsh Kumar
 */

package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@type='button' and @value='Next']")
	WebElement nextLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="middle_initial")
	WebElement middleName;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(name="title")
	WebElement titleSelectore;
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	
	
	
	
	public void createNewContact(String title,String ftname, String mdname,String srname,String compny) throws InterruptedException
	{
		WebDriverWait waits = new WebDriverWait(driver, 30);
		WebElement el = waits.until(ExpectedConditions.elementToBeClickable(saveBtn));
		Select seltitle = new Select(driver.findElement(By.name("title")));
		seltitle.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		middleName.sendKeys(mdname);
		surname.sendKeys(srname);
		company.sendKeys(compny);
		Thread.sleep(3000);
		saveBtn.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement cL = wait.until(ExpectedConditions.visibilityOf(nextLabel));
//		
	}

}
