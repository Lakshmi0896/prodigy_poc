package com.prodigy.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.prodigy.driver.Driver;
import com.prodigy.utilities.Log;

public class ContactPages extends Driver{
	
	@FindBy(id = "hs-eu-confirmation-button")
	WebElement accept_cookie;
	
	@FindBy(xpath = "(//a[text()='Contact'])[1]")
	WebElement contact_menuItem;
	
	@FindBy(xpath = "//p[text()='Contact email']/../div[3]/div/h4")
	WebElement emailInfo_text;
	
	@FindBy(xpath = "//p[text()='Visit us at our Office']/../div[4]/div/h4")
	WebElement officeAddress_text;
	
	@FindBy(name = "firstname")
	WebElement firstname_input;
	
	@FindBy(xpath = "//input[contains(@id,'lastname')]")
	WebElement lastname_input;
	
	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement email_input;
	
	@FindBy(xpath = "//label[(text()='Email must be formatted correctly.')]")
	WebElement email_errorMsg_label;
	
	@FindBy(xpath = "//select[contains(@id,'industry')]")
	WebElement industry_select_field;
	
	@FindBy(xpath = "//input[contains(@id,'city')]")
	WebElement city_input;
	
	@FindBy(xpath = "//textarea[contains(@id,'message')]")
	WebElement message_textarea_input;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit_button;
	
	public ContactPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_HomePage(){
		Log.info("Method to navigate to Application URL");
		driver.get(prop.getProperty("APP_URL"));
	}
	
	public void test_contactUsForm() {
		Log.info("Method to Test");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		accept_cookie.click();
		Assert.assertEquals(contact_menuItem.isDisplayed(),true);
		contact_menuItem.click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(emailInfo_text));
		Assert.assertEquals(emailInfo_text.getText(),"info@prodigylabs.net");
		Assert.assertEquals(officeAddress_text.getText(),"80 Richmond St. West, Suite 1401\n" + 
				"Toronto, ON");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		driver.switchTo().frame("hs-form-iframe-0");
		firstname_input.sendKeys("Lakshmi");
		lastname_input.sendKeys("Meghana");
		email_input.sendKeys("abctext@gmail");
		email_input.sendKeys(Keys.TAB);
		Assert.assertEquals(email_errorMsg_label.getText(),"Email must be formatted correctly.");
		email_input.clear();
		email_input.sendKeys("abctext@gmail.com");
		Select select = new Select(industry_select_field);
		select.selectByValue("Banking");
		city_input.sendKeys("Toronto");
		message_textarea_input.sendKeys("Dummy Query for Test");
		submit_button.click();
	}
}
