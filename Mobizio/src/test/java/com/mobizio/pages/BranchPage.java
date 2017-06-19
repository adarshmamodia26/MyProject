package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.constant.GlobalConstants.Constant;
import com.mobizio.datamodel.BranchModel;
import com.mobizio.selenium.framework.BasePage;

public class BranchPage extends BasePage {
	
	@FindBy(xpath = "//li[text()='Branches']")
	private WebElement branchPage;

	@FindBy(xpath = "//a[@id='addNewBranchBtn']/span")
	private WebElement newBranchBtn;
	
	@FindBy(xpath = "//input[@id='nameValueInput']")
	private WebElement nameInput;
	
	@FindBy(xpath = "//input[@id='tenantBranchIdValueInput']")
	private WebElement tenantBranchIDInput;
	
	@FindBy(xpath = "//input[@id='primaryTelephoneValueInput']")
	private WebElement primaryTelephoneInput;
	
	@FindBy(xpath = "//input[@id='secondaryTelephoneValueInput']")
	private WebElement secondaryTelephoneInput;
	
	@FindBy(xpath = "//input[@id='firstLineValueInput']")
	private WebElement addressLine1Input;
	
	@FindBy(xpath = "//input[@id='secondLineValueInput']")
	private WebElement addressLine2Input;
	
	@FindBy(xpath = "//input[@id='cityValueInput']")
	private WebElement cityInput;
	
	@FindBy(xpath = "//input[@id='stateValueInput']")
	private WebElement countyInput;
	
	@FindBy(xpath = "//input[@id='countryValueInput']")
	private WebElement countryInput;

	@FindBy(xpath = "//input[@id='postcodeValueInput']")
	private WebElement postcodeInput;

	@FindBy(xpath = "//input[@id='faxValueInput']")
	private WebElement faxInput;
	
	@FindBy(xpath = "//input[@id='alertNotificationEmailsValueInput']")
	private WebElement alertNotificationEmailInput;
	
	@FindBy(xpath = "//input[@id='alertNotificationPhoneNumbersValueInput']")
	private WebElement alertNotificationPhoneNumberInput;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement createBranchBtn;
	
	@FindBy(xpath = "//*[@id='btnSave']")
	private WebElement updateBranchBtn;
	
	@FindBy(xpath = "//*[@id='branchesTable']/tbody/tr[1]/td[1]")
	private WebElement createdBranch;
	
	@FindBy(xpath = "//*[@id='branchesTable_filter']/label/input")
	private WebElement branchListFilterInput;

	@FindBy(xpath = "//*[@id='branchesTable']/tbody/tr/td[1]/a")
	private WebElement branchListFirstEntryHyperlink;

	@FindBy(xpath = "//*[@id='editBranchBtn']")
	private WebElement editBranchBtn;
	
	public BranchPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * verify branch page
	 */
	public void verifyBranchPage()
	{
		_waitForJStoLoad();
		Assert.assertEquals(branchPage.getText(), Constant.BranchPage.toString());
	}

	/*
	 * click on add new branch button
	 */
	public void clickOnNewBranchButton() 
	{
		clickOn(newBranchBtn);
	}

	/*
	 * create a branch with its details
	 */
	public void enterNewBranchDetail(BranchModel branchModel) 
	{
		waitForElement(nameInput);
		inputText(nameInput, branchModel.getName());
		
		waitForElement(tenantBranchIDInput);
		inputText(tenantBranchIDInput, branchModel.getTenantBranchID());
		
		waitForElement(primaryTelephoneInput);
		System.out.println(branchModel.getPrimaryTelephone());
		inputText(primaryTelephoneInput, branchModel.getPrimaryTelephone());
		
		waitForElement(secondaryTelephoneInput);
		inputText(secondaryTelephoneInput, branchModel.getSecondaryTelePhone());
		
		waitForElement(addressLine1Input);
		inputText(addressLine1Input, branchModel.getAddressLine1());
		
		waitForElement(addressLine2Input);
		inputText(addressLine2Input, branchModel.getAddressLine2());
		
		waitForElement(cityInput);
		inputText(cityInput, branchModel.getCity());
		
		waitForElement(countyInput);
		inputText(countyInput, branchModel.getCounty());
		
		waitForElement(countryInput);
		inputText(countryInput, branchModel.getCountry());
		
		waitForElement(postcodeInput);
		inputText(postcodeInput, branchModel.getPostcode());
		
		waitForElement(faxInput);
		inputText(faxInput, branchModel.getFax());
		
		waitForElement(alertNotificationEmailInput);
		inputText(alertNotificationEmailInput, branchModel.getAlertNotificationEmail());
		
		waitForElement(alertNotificationPhoneNumberInput);
		inputText(alertNotificationPhoneNumberInput, branchModel.getAlertNotificationPhoneNumber());
	}
	
	/*
	 * click on create branch button
	 */
	public void clickOnCreateButton()
	{
		clickOn(createBranchBtn);
	}
	
	public String getCreatedBranchOnBranchPage()
	{
		return createdBranch.getText();
	}
	
	public void searchCreatedBranchOnBranchPage(String branchName)
	{
	  clickOn(branchListFilterInput);
	  inputText(branchListFilterInput,branchName);
	  branchListFilterInput.sendKeys(Keys.ENTER);
	  _waitForJStoLoad();
	  
	}
	

	public void clickOnSearchedBranchOnBranchPage()
	{
	  clickOn(branchListFirstEntryHyperlink);
	  _waitForJStoLoad();
	}
	
	public void clickOnEditBranchOnBranchPage()
	{
	  clickOn(editBranchBtn);
	  _waitForJStoLoad();
	}
	
	/*
	 * verify newly created branch on branch page
	 */
	public void verifyNewlyCreatedBranch(BranchModel branchModel)
	{
		Assert.assertEquals(createdBranch.getText(), branchModel.getName());
	}
	
	/*
	 * create a device with its details
	 */
	public void editNewBranchDetail(BranchModel branchModel) {
		
		waitForElement(nameInput);
		clickOn(nameInput);
		Assert.assertEquals(nameInput.getAttribute("readonly"),null);
		nameInput.clear();
		inputText(nameInput, branchModel.getName()+"edited");
		
		waitForElement(tenantBranchIDInput);
		Assert.assertEquals(tenantBranchIDInput.getAttribute("readonly"),"true");
		
		waitForElement(primaryTelephoneInput);
		clickOn(primaryTelephoneInput);
		Assert.assertEquals(primaryTelephoneInput.getAttribute("readonly"),null);
		primaryTelephoneInput.clear();
		inputText(primaryTelephoneInput, branchModel.getPrimaryTelephone());
		
		waitForElement(secondaryTelephoneInput);
		Assert.assertEquals(secondaryTelephoneInput.getAttribute("readonly"),null);
		clickOn(secondaryTelephoneInput);
		secondaryTelephoneInput.clear();
		inputText(secondaryTelephoneInput, branchModel.getSecondaryTelePhone());
		
		waitForElement(addressLine1Input);
		clickOn(addressLine1Input);
		Assert.assertEquals(addressLine1Input.getAttribute("readonly"),null);
		addressLine1Input.clear();
		inputText(addressLine1Input, branchModel.getAddressLine1()+"edited");
		
		waitForElement(addressLine2Input);
		clickOn(addressLine2Input);
		Assert.assertEquals(addressLine2Input.getAttribute("readonly"),null);
		addressLine2Input.clear();
		inputText(addressLine2Input, branchModel.getAddressLine2()+"edited");
		
		waitForElement(cityInput);
		clickOn(cityInput);
		Assert.assertEquals(cityInput.getAttribute("readonly"),null);
		cityInput.clear();
		inputText(cityInput, branchModel.getCity());
		
		waitForElement(countyInput);
		clickOn(countyInput);
		Assert.assertEquals(countyInput.getAttribute("readonly"),null);
		countyInput.clear();
		inputText(countyInput, branchModel.getCounty());
		
		waitForElement(countryInput);
		clickOn(countryInput);
		Assert.assertEquals(countryInput.getAttribute("readonly"),null);
		countryInput.clear();
		inputText(countryInput, branchModel.getCountry());
		
		waitForElement(postcodeInput);
		clickOn(postcodeInput);
		Assert.assertEquals(postcodeInput.getAttribute("readonly"),null);
		postcodeInput.clear();
		inputText(postcodeInput, branchModel.getPostcode());
		
		waitForElement(faxInput);
		clickOn(faxInput);
		Assert.assertEquals(faxInput.getAttribute("readonly"),null);
		faxInput.clear();
		inputText(faxInput, branchModel.getFax());
		
		
		waitForElement(alertNotificationEmailInput);
		clickOn(alertNotificationEmailInput);
		Assert.assertEquals(alertNotificationEmailInput.getAttribute("readonly"),null);
		alertNotificationEmailInput.clear();
		inputText(alertNotificationEmailInput, branchModel.getAlertNotificationEmail());
		
		waitForElement(alertNotificationPhoneNumberInput);
		clickOn(alertNotificationPhoneNumberInput);
		Assert.assertEquals(alertNotificationPhoneNumberInput.getAttribute("readonly"),null);
		alertNotificationPhoneNumberInput.clear();
		inputText(alertNotificationPhoneNumberInput, branchModel.getAlertNotificationPhoneNumber());
		
		waitForElement(updateBranchBtn);
		clickOn(updateBranchBtn);
		_waitForJStoLoad();
	}
}
