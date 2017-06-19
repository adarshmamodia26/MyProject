package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.datamodel.CustomerModel;
import com.mobizio.selenium.framework.BasePage;

public class CustomerPage extends BasePage {

	@FindBy(xpath = "//li[contains(text(),'Customers')]")
	private WebElement verifyCustomerPage;

	@FindBy(xpath = "//a[@id='addNewCustomerBtn']/span")
	private WebElement addNewCustomerButton;

	@FindBy(xpath = "//li[contains(text(),'New Customer')]")
	private WebElement verifyNewCustomerPage;

	@FindBy(xpath = "//input[@id='usernameValueInput']")
	private WebElement enterUserName;

	@FindBy(xpath = "//input[@id='emailValueInput']")
	private WebElement enterEmailId;

	@FindBy(xpath = "//input[@id='passwordValueInput']")
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@id='confirmPasswordValueInput']")
	private WebElement enterConfirmPassword;

	@FindBy(xpath = "//input[@id='firstNameValueInput']")
	private WebElement enterFirstName;

	@FindBy(xpath = "//input[@id='lastNameValueInput']")
	private WebElement enterLastName;

	@FindBy(xpath = "//input[@id='tenantCustomerIdValueInput']")
	private WebElement enterCustomerId;

	@FindBy(xpath = "//div[contains(@id,'branchNameInput')]")
	private WebElement searchSelectTextBox;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	private WebElement enterBranchName;

	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement clickOnCreateButton;

	@FindBy(xpath = "//span[@class='select2-match']")
	private WebElement selectValueFromBranchDropdown;

	@FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]//a")
	private WebElement newCustomer;

	@FindBy(xpath = "//select[@id='titleValueInput']")
	private WebElement enterTitle;

	@FindBy(xpath = "//select[@id='genderValueInput']")
	private WebElement enterGender;

	@FindBy(xpath = "//input[@id='firstLineValueInput']")
	private WebElement enterAddressLine1;

	@FindBy(xpath = "//input[@id='secondLineValueInput']")
	private WebElement enterAddressLine2;

	@FindBy(xpath = "//input[@id='cityValueInput']")
	private WebElement enterCity;

	@FindBy(xpath = "//input[@id='stateValueInput']")
	private WebElement enterCounty;

	@FindBy(xpath = "//input[@id='postcodeValueInput']")
	private WebElement enterPostcode;

	@FindBy(xpath = "//select[@id='countryValueInput']")
	private WebElement enterCountry;

	@FindBy(xpath = "//input[@id='latitudeValueInput']")
	private WebElement enterLatitude;

	@FindBy(xpath = "//input[@id='longitudeValueInput']")
	private WebElement enterLongitude;

	@FindBy(xpath = "//input[@id='primaryTelephoneValueInput']")
	private WebElement enterPrimaryTelephone;

	@FindBy(xpath = "//input[@id='secondaryTelephoneValueInput']")
	private WebElement enterSecondaryTelephone;

	@FindBy(xpath = "//input[@id='nicknameValueInput']")
	private WebElement enterlikesToBeCalled;

	@FindBy(xpath = "//input[@id='nfcTagIdValueInput']")
	private WebElement enternfcTagContent;

	@FindBy(xpath = "//input[@id='dobValueInput']")
	private WebElement enterDob;
	
	@FindBy(xpath = "//input[contains(@aria-activedescendant,'select2-result')]")
	private WebElement waitForSearchSelectTextBox;

	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Verify Customer Page
	 */
	public void verifyCustomerPage() {
		_waitForJStoLoad();
		waitForElement(verifyCustomerPage);
		String customerPageText = verifyCustomerPage.getText();
		Assert.assertEquals("Customers", customerPageText);
	}

	/*
	 * Verify New Customer Page
	 */
	public void verifyNewCustomerPage() {
		_waitForJStoLoad();
		waitForElement(verifyNewCustomerPage);
		String customerPageText = verifyNewCustomerPage.getText();
		Assert.assertEquals("New Customer", customerPageText);
	}

	/*
	 * click on add new customer button
	 */
	public void clickOnAddNewCustomer() {
		waitForElement(addNewCustomerButton);
		clickOn(addNewCustomerButton);
	}

	/*
	 * click on create button on create new customer page
	 */
	public void clickOnCreateButton() {
		waitForElement(clickOnCreateButton);
		clickOn(clickOnCreateButton);
	}

	/*
	 * enter customer details on create new customer page
	 */
	public void enterNewCustomerDetails(CustomerModel customerModel)
			throws InterruptedException {

		waitForElement(enterUserName);
		clickOn(enterUserName);
		inputText(enterUserName, customerModel.getUserName());

		waitForElement(enterEmailId);
		clickOn(enterEmailId);
		inputText(enterEmailId, customerModel.getEmail());

		waitForElement(enterPassword);
		clickOn(enterPassword);
		inputText(enterPassword, customerModel.getPassword());

		waitForElement(enterConfirmPassword);
		clickOn(enterConfirmPassword);
		inputText(enterConfirmPassword, customerModel.getConfirmPassword());

		waitForElement(enterFirstName);
		clickOn(enterFirstName);
		inputText(enterFirstName, customerModel.getFirstName());

		waitForElement(enterLastName);
		clickOn(enterLastName);
		inputText(enterLastName, customerModel.getLastName());

		if (customerModel.getDob() != null) {
			waitForElement(enterDob);
			clickOn(enterDob);
			inputText(enterDob, customerModel.getDob());
		}

		if (customerModel.getTitle() != null) {
			waitForElement(enterTitle);
			selectDropDownByValue(enterTitle, customerModel.getTitle());
		}

		if (customerModel.getGender() != null) {
			waitForElement(enterGender);
			selectDropDownByValue(enterGender, customerModel.getGender());
		}

		if (customerModel.getAddressLine1() != null) {
			waitForElement(enterAddressLine1);
			clickOn(enterAddressLine1);
			inputText(enterAddressLine1, customerModel.getAddressLine1());
		}

		if (customerModel.getAddressLine2() != null) {
			waitForElement(enterAddressLine2);
			clickOn(enterAddressLine2);
			inputText(enterAddressLine2, customerModel.getAddressLine2());
		}

		if (customerModel.getCity() != null) {
			waitForElement(enterCity);
			clickOn(enterCity);
			inputText(enterCity, customerModel.getCity());
		}

		if (customerModel.getCounty() != null) {
			waitForElement(enterCounty);
			clickOn(enterCounty);
			inputText(enterCounty, customerModel.getCounty());
		}

		if (customerModel.getPostCode() != null) {
			waitForElement(enterPostcode);
			clickOn(enterPostcode);
			inputText(enterPostcode, customerModel.getPostCode());
		}

		if (customerModel.getCountry() != null) {
			waitForElement(enterCountry);
			selectDropDownByValue(enterCountry, customerModel.getCountry());
		}

		if (customerModel.getLatitude() != null) {
			waitForElement(enterLatitude);
			clickOn(enterLatitude);
			inputText(enterLatitude, customerModel.getLatitude());
		}

		if (customerModel.getLongitude() != null) {
			waitForElement(enterLongitude);
			clickOn(enterLongitude);
			inputText(enterLongitude, customerModel.getLongitude());
		}

		if (customerModel.getPrimaryTelephone() != null) {
			waitForElement(enterPrimaryTelephone);
			clickOn(enterPrimaryTelephone);
			inputText(enterPrimaryTelephone,customerModel.getPrimaryTelephone());
		}

		if (customerModel.getSecondaryTelephone() != null) {
			waitForElement(enterSecondaryTelephone);
			clickOn(enterSecondaryTelephone);
			inputText(enterSecondaryTelephone,customerModel.getSecondaryTelephone());
		}

		if (customerModel.getLikesToBeCalled() != null) {
			waitForElement(enterlikesToBeCalled);
			clickOn(enterlikesToBeCalled);
			inputText(enterlikesToBeCalled, customerModel.getLikesToBeCalled());
		}

		if (customerModel.getNfcTagContent() != null) {
			waitForElement(enternfcTagContent);
			clickOn(enternfcTagContent);
			inputText(enternfcTagContent, customerModel.getNfcTagContent());
		}

		waitForElement(searchSelectTextBox);
		clickOn(searchSelectTextBox);
		inputText(enterBranchName, customerModel.getBranch());
		waitForElement(waitForSearchSelectTextBox);
		enterBranchName.sendKeys(Keys.ENTER);

		waitForElement(enterCustomerId);
		clickOn(enterCustomerId);
		inputText(enterCustomerId, customerModel.getCustomerId());

	}

	/*
	 * verify newly created customer on customer page
	 */
	public void verifyCreatedCustomerOnCustomerPage(String expectedCustomerName) {
		String customerName = newCustomer.getText();
		Assert.assertEquals(customerName, expectedCustomerName);
	}

}
