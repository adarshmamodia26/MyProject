package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mobizio.selenium.framework.BasePage;

public class CaseListPage extends BasePage {

	@FindBy(xpath = "//*[@id='addNewServiceCaseListBtn']")
	private WebElement configure;
	
	@FindBy(xpath = "//*[@id='addFieldButton']")
	private WebElement bt_addField;
	
	@FindBy(xpath = "//*[@class='select2-choice']")
	private WebElement addField;
	
	@FindBy(xpath = "(//*[@id='table_fields']//input)[2]")
	private WebElement addLabel;
	
	@FindBy(xpath = "//label[@class='btn btn-success toggle-on']")
	private WebElement bt_on;
	
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	private WebElement search;
	
	@FindBy(xpath = "//*[@id='select2-result-label-79']")
	private WebElement searchedText;
	
	public CaseListPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * click on configure button
	 */
	public void clickOnConfigure() {
		waitForElement(configure);
		clickOn(configure);
		_waitForJStoLoad();
	}
	
	/*
	 * click on add field button
	 */
	public void clickOnAddField() {
		waitForElement(bt_addField);
		clickOn(bt_addField);
		_waitForJStoLoad();
	}
	
	/*
	 * add a field
	 */
	public void addAField() throws InterruptedException {
		waitForElement(addField);
		clickOn(addField);
		Thread.sleep(3000);
		clickOn(search);
		inputText(search,"Service");
		search.sendKeys(Keys.ENTER);
		inputText(addLabel,"Service");
		clickOn(bt_on);
		_waitForJStoLoad();
	}
	
	
}
