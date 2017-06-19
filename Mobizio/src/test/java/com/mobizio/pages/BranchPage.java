package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.datamodel.BranchModel;
import com.mobizio.selenium.framework.BasePage;

public class BranchPage extends BasePage {

	@FindBy(xpath = "//*[@id='addNewBranchBtn']/span")
	private WebElement newBranchBtn;
	
	@FindBy(xpath = "//*[@id='nameValueInput']")
	private WebElement nameInput;
	
	@FindBy(xpath = "//*[@id='tenantBranchIdValueInput']")
	private WebElement tenantBranchIDInput;
	
	@FindBy(xpath = "//*[@id='primaryTelephoneValueInput']")
	private WebElement primaryTelephoneInput;
	
	@FindBy(xpath = "//*[@id='secondaryTelephoneValueInput']")
	private WebElement secondaryTelephoneInput;
	
	@FindBy(xpath = "//*[@id='firstLineValueInput']")
	private WebElement addressLine1Input;
	
	@FindBy(xpath = "//*[@id='secondLineValueInput']")
	private WebElement addressLine2Input;
	
	@FindBy(xpath = "//*[@id='cityValueInput']")
	private WebElement cityInput;
	
	@FindBy(xpath = "//*[@id='stateValueInput']")
	private WebElement countyInput;
	
	@FindBy(xpath = "//*[@id='countryValueInput']")
	private WebElement countryInput;

	@FindBy(xpath = "//*[@id='postcodeValueInput']")
	private WebElement postcodeInput;

	@FindBy(xpath = "//*[@id='faxValueInput']")
	private WebElement faxInput;
	
	@FindBy(xpath = "//*[@id='activeValueInput']")
	private WebElement isActiveCheckbox;
	
	@FindBy(xpath = "//*[@id='alertNotificationEmailsValueInput']")
	private WebElement alertNotificationEmailInput;
	
	@FindBy(xpath = "//*[@id='alertNotificationPhoneNumbersValueInput']")
	private WebElement alertNotificationPhoneNumberInput;
	
	@FindBy(xpath = "//*[@id='btnSave']")
	private WebElement createBranchBtn;
	
	@FindBy(xpath = "(//input[@type='search'])[1]")
	private WebElement searchBranchInput;
	
	@FindBy(xpath = "//table[@id='branchesTable']/tbody/tr/td[1]/a")
	private WebElement searchedBranchLink;
	
	@FindBy(xpath = "//*[@id='btnSave']")
	private WebElement updateBranchBtn;
	
	@FindBy(xpath = "//*[@id='branchesTable']/tbody/tr[1]/td[1]")
	private WebElement branchListFirstEntryName;
	
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
	 * click on add new branch button
	 */
	public void clickOnNewBranch() {
		_waitForJStoLoad();
		waitForElement(newBranchBtn);
		clickOn(newBranchBtn);
		_waitForJStoLoad();
	}

	/*
	 * enter branch details in branch page
	 */
	public void enterNewBranchDetail(BranchModel branchModel) {
		
		waitForElement(nameInput);
		clickOn(nameInput);
		inputText(nameInput, branchModel.getName());
		
		waitForElement(tenantBranchIDInput);
		clickOn(tenantBranchIDInput);
		inputText(tenantBranchIDInput, branchModel.getTenantBranchID());
		
		waitForElement(primaryTelephoneInput);
		clickOn(primaryTelephoneInput);
		inputText(primaryTelephoneInput, branchModel.getPrimaryTelephone());
		
		waitForElement(secondaryTelephoneInput);
		clickOn(secondaryTelephoneInput);
		inputText(secondaryTelephoneInput, branchModel.getSecondaryTelePhone());
		
		waitForElement(addressLine1Input);
		clickOn(addressLine1Input);
		inputText(addressLine1Input, branchModel.getAddressLine1());
		
		waitForElement(addressLine2Input);
		clickOn(addressLine2Input);
		inputText(addressLine2Input, branchModel.getAddressLine2());
		
		waitForElement(cityInput);
		clickOn(cityInput);
		inputText(cityInput, branchModel.getCity());
		
		waitForElement(countyInput);
		clickOn(countyInput);
		inputText(countyInput, branchModel.getCounty());
		
		waitForElement(countryInput);
		clickOn(countryInput);
		inputText(countryInput, branchModel.getCountry());
		
		waitForElement(postcodeInput);
		clickOn(postcodeInput);
		inputText(postcodeInput, branchModel.getPostcode());
		
		waitForElement(faxInput);
		clickOn(faxInput);
		inputText(faxInput, branchModel.getFax());
		
		
		waitForElement(alertNotificationEmailInput);
		clickOn(alertNotificationEmailInput);
		inputText(alertNotificationEmailInput, branchModel.getAlertNotificationEmail());
		
		waitForElement(alertNotificationPhoneNumberInput);
		clickOn(alertNotificationPhoneNumberInput);
		inputText(alertNotificationPhoneNumberInput, branchModel.getAlertNotificationPhoneNumber());
		
		waitForElement(createBranchBtn);
		clickOn(createBranchBtn);
		_waitForJStoLoad();
	}
	
	/*
	 * verify newly created branch on branch page
	 */
	public void verifyCreatedBranchOnBranchPage(String expectedBranchName) {
		String branch = branchListFirstEntryName.getText();
		Assert.assertEquals(branch, expectedBranchName);
	}
	
	
	/*
	 *  Verify branch details on branch page
	 */
	public void verifyBranchDetailsOnBranchPage(BranchModel branchModel)
	{
		String branchNameText="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getName()+"']";
		Assert.assertEquals(findElement(ByLocator(branchNameText)).getText(), branchModel.getName());
		
		String tenantBranchIdText="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getTenantBranchID()+"']";
		Assert.assertEquals(findElement(ByLocator(tenantBranchIdText)).getText(), branchModel.getTenantBranchID());
		
		String primaryTelephoneText="//label[contains(text(),'Primary Telephone')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(primaryTelephoneText)).getText(), branchModel.getPrimaryTelephone());
		
		String secondaryTelephoneText="//label[contains(text(),'Secondary Telephone')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(secondaryTelephoneText)).getText(), branchModel.getSecondaryTelePhone());
		
		String addressLine1Text="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getAddressLine1()+"']";
		Assert.assertEquals(findElement(ByLocator(addressLine1Text)).getText(), branchModel.getAddressLine1());
		
		String addressLine2Text="//label[contains(text(),'Address Line2')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(addressLine2Text)).getText(), branchModel.getAddressLine2());
		
		String city="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getCity()+"']";
		Assert.assertEquals(findElement(ByLocator(city)).getText(), branchModel.getCity());
		
		String county="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getCounty()+"']";
		Assert.assertEquals(findElement(ByLocator(county)).getText(), branchModel.getCounty());
		
		String country="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getCountry()+"']";
		Assert.assertEquals(findElement(ByLocator(country)).getText(), branchModel.getCountry());
		
		String postcode="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getPostcode()+"']";
		Assert.assertEquals(findElement(ByLocator(postcode)).getText(), branchModel.getPostcode());
		
		String fax="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getFax()+"']";
		Assert.assertEquals(findElement(ByLocator(fax)).getText(), branchModel.getFax());
		
		String isActive="//label[contains(text(),'Is Active?')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(isActive)).getText(), "Yes");
		
		String alertNotificationEmail="//*[@id='psmobile-container']//div[text()="+"'"+branchModel.getAlertNotificationEmail()+"']";
		Assert.assertEquals(findElement(ByLocator(alertNotificationEmail)).getText(), branchModel.getAlertNotificationEmail());
		
		String alertNotificationPhoneNumber="//label[contains(text(),'Alert Notification Phone Number')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(alertNotificationPhoneNumber)).getText(), branchModel.getAlertNotificationPhoneNumber());
		
	}
	
	/*
	 *  Verify edited branch details on branch page
	 */
	public void verifyEditedBranchDetailsOnBranchPage(BranchModel branchModel)
	{
		String branchNameText="//label[contains(text(),'Name')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(branchNameText)).getText(), branchModel.getName()+"edited");
		
		String primaryTelephoneText="//label[contains(text(),'Primary Telephone')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(primaryTelephoneText)).getText(), branchModel.getPrimaryTelephone()+"1");
		
		String secondaryTelephoneText="//label[contains(text(),'Secondary Telephone')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(secondaryTelephoneText)).getText(), branchModel.getSecondaryTelePhone()+"1");
		
		String addressLine1Text="//label[contains(text(),'Address Line1')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(addressLine1Text)).getText(), branchModel.getAddressLine1()+"edited");
		
		String addressLine2Text="//label[contains(text(),'Address Line2')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(addressLine2Text)).getText(), branchModel.getAddressLine2()+"edited");
		
		String city="//label[contains(text(),'City')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(city)).getText(), branchModel.getCity()+"A");
		
		String county="//label[contains(text(),'County')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(county)).getText(), branchModel.getCounty()+"A");
		
		String country="//label[contains(text(),'Country')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(country)).getText(), branchModel.getCountry()+"A");
		
		String postcode="//label[contains(text(),'Postcode')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(postcode)).getText(), branchModel.getPostcode()+"a");
		
		String fax="//label[contains(text(),'Fax')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(fax)).getText(), branchModel.getFax()+"1");
		
		String isActive="//label[contains(text(),'Is Active?')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(isActive)).getText(), "Yes");
		
		String alertNotificationEmail="//label[contains(text(),'Alert Notification Email')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(alertNotificationEmail)).getText(), branchModel.getAlertNotificationEmail()+"A");
		
		String alertNotificationPhoneNumber="//label[contains(text(),'Alert Notification Phone Number')]/following-sibling::div";
		Assert.assertEquals(findElement(ByLocator(alertNotificationPhoneNumber)).getText(), branchModel.getAlertNotificationPhoneNumber()+"1");
		
	}
	
	/*
	 *  get created branch 
	 */
	public String getCreatedBranchOnBranchPage()
	{
		return branchListFirstEntryName.getText();
	}
	
	/*
	 * search created branch on branch page
	 */
	public void searchCreatedBranchOnBranchPage(String branchName)
	{
	  clickOn(branchListFilterInput);
	  inputText(branchListFilterInput,branchName);
	  branchListFilterInput.sendKeys(Keys.ENTER);
	  _waitForJStoLoad();
	  
	}
	
    /*
     * click on created branch
     */
	public void clickOnSearchedBranchOnBranchPage()
	{
	  clickOn(branchListFirstEntryHyperlink);
	  _waitForJStoLoad();
	}
	
	/*
	 * click on edit branch button on branch page
	 */
	public void clickOnEditBranchOnBranchPage()
	{
	  clickOn(editBranchBtn);
	  _waitForJStoLoad();
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
		inputText(primaryTelephoneInput, branchModel.getPrimaryTelephone()+"1");
		
		waitForElement(secondaryTelephoneInput);
		Assert.assertEquals(secondaryTelephoneInput.getAttribute("readonly"),null);
		clickOn(secondaryTelephoneInput);
		secondaryTelephoneInput.clear();
		inputText(secondaryTelephoneInput, branchModel.getSecondaryTelePhone()+"1");
		
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
		inputText(cityInput, branchModel.getCity()+"A");
		
		waitForElement(countyInput);
		clickOn(countyInput);
		Assert.assertEquals(countyInput.getAttribute("readonly"),null);
		countyInput.clear();
		inputText(countyInput, branchModel.getCounty()+"A");
		
		waitForElement(countryInput);
		clickOn(countryInput);
		Assert.assertEquals(countryInput.getAttribute("readonly"),null);
		countryInput.clear();
		inputText(countryInput, branchModel.getCountry()+"A");
		
		waitForElement(postcodeInput);
		clickOn(postcodeInput);
		Assert.assertEquals(postcodeInput.getAttribute("readonly"),null);
		postcodeInput.clear();
		inputText(postcodeInput, branchModel.getPostcode()+"a");
		
		waitForElement(faxInput);
		clickOn(faxInput);
		Assert.assertEquals(faxInput.getAttribute("readonly"),null);
		faxInput.clear();
		inputText(faxInput, branchModel.getFax()+"1");
		
		
		waitForElement(alertNotificationEmailInput);
		clickOn(alertNotificationEmailInput);
		Assert.assertEquals(alertNotificationEmailInput.getAttribute("readonly"),null);
		alertNotificationEmailInput.clear();
		inputText(alertNotificationEmailInput, branchModel.getAlertNotificationEmail()+"A");
		
		waitForElement(alertNotificationPhoneNumberInput);
		clickOn(alertNotificationPhoneNumberInput);
		Assert.assertEquals(alertNotificationPhoneNumberInput.getAttribute("readonly"),null);
		alertNotificationPhoneNumberInput.clear();
		inputText(alertNotificationPhoneNumberInput, branchModel.getAlertNotificationPhoneNumber()+"1");
		
		waitForElement(updateBranchBtn);
		clickOn(updateBranchBtn);
		_waitForJStoLoad();
	}
}
