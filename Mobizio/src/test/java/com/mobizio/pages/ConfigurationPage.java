package com.mobizio.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobizio.selenium.framework.BasePage;

public class ConfigurationPage extends BasePage {

	public ConfigurationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath= "//span[contains(text(),'Users')]")
	private WebElement users;
	
	@FindBy(xpath= "//*[@id='servicesConfigMenu']/a/span[2]")
	private WebElement services;
	
	/*
	 * click on users
	 */
	public void clickOnUsers()
	{
		waitForElement(users);
		clickOn(users);
	}
	
	/*
	 * click on services
	 */
	public ServicesPage clickOnServices()
	{
		clickOn(services);
		_waitForJStoLoad();
		return PageFactory.initElements(getDriver(), ServicesPage.class);
	}
	
	

}
