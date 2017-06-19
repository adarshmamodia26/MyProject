package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.constant.GlobalConstants.Constant;

import com.mobizio.datamodel.CustomerModel;
import com.mobizio.selenium.framework.BasePage;

public class CustomerPage extends BasePage {

	@FindBy(xpath = "//li[contains(text(),'Customers')]")
	private WebElement customerPage;

	@FindBy(xpath = "//a[@id='addNewCustomerBtn']/span")
	private WebElement newCustomerBtn;

	@FindBy(xpath = "//li[contains(text(),'New Customer')]")
	private WebElement newCustomerPage;

	@FindBy(xpath = "//input[@id='usernameValueInput']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='emailValueInput']")
	private WebElement emailIdField;

	@FindBy(xpath = "//input[@id='passwordValueInput']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='confirmPasswordValueInput']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@id='firstNameValueInput']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@id='lastNameValueInput']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@id='tenantCustomerIdValueInput']")
	private WebElement customerIdField;

	@FindBy(xpath = "//div[contains(@id,'branchNameInput')]")
	private WebElement searchSelectTextBox;

	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	private WebElement branchNameField;

	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	private WebElement AuthorizedUserNameField;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement createBtn;

	@FindBy(xpath = "//span[@class='select2-match']")
	private WebElement selectValueFromBranchDropdown;

	@FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]//a")
	private WebElement newCustomer;

	@FindBy(xpath = "//select[@id='titleValueInput']")
	private WebElement titleField;

	@FindBy(xpath = "//select[@id='genderValueInput']")
	private WebElement genderField;

	@FindBy(xpath = "//input[@id='firstLineValueInput']")
	private WebElement addressLine1Field;

	@FindBy(xpath = "//input[@id='secondLineValueInput']")
	private WebElement addressLine2Field;

	@FindBy(xpath = "//input[@id='cityValueInput']")
	private WebElement cityField;

	@FindBy(xpath = "//input[@id='stateValueInput']")
	private WebElement countyField;

	@FindBy(xpath = "//input[@id='postcodeValueInput']")
	private WebElement postcodeField;

	@FindBy(xpath = "//select[@id='countryValueInput']")
	private WebElement countryField;

	@FindBy(xpath = "//input[@id='latitudeValueInput']")
	private WebElement latitudeField;

	@FindBy(xpath = "//input[@id='longitudeValueInput']")
	private WebElement longitudeField;

	@FindBy(xpath = "//input[@id='primaryTelephoneValueInput']")
	private WebElement primaryTelephoneField;

	@FindBy(xpath = "//input[@id='secondaryTelephoneValueInput']")
	private WebElement secondaryTelephoneField;

	@FindBy(xpath = "//input[@id='nicknameValueInput']")
	private WebElement likesToBeCalledField;

	@FindBy(xpath = "//input[@id='nfcTagIdValueInput']")
	private WebElement nfcTagContentField;

	@FindBy(xpath = "//input[@id='dobValueInput']")
	private WebElement dobField;
	
	@FindBy(xpath = "//input[contains(@aria-activedescendant,'select2-result')]")
	private WebElement waitForSearchSelectTextBox;
	
	@FindBy(xpath = "//a[@id='btnAddRelation']")
	private WebElement addRelationBtn;
	
	@FindBy(xpath = "//a[@id='editUserBtn']")
	private WebElement editCustomerBtn;
	
	@FindBy(xpath = "//a[@id='lnkEditPassword']")
	private WebElement editPasswordBtn;
	
	@FindBy(xpath = "//select[@id='relationValueInput']")
	private WebElement relationship;
	
	@FindBy(xpath = "//span[text()='Authorized User']")
	private WebElement authorizedUserField;

	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Verify Customer Page
	 */
	public void verifyCustomerPage() {
		_waitForJStoLoad();
		waitForElement(customerPage);
		Assert.assertEquals(customerPage.getText(), Constant.Customers.toString());
	}

	/*
	 * Verify New Customer Page
	 */
	public void verifyNewCustomerPage() {
		_waitForJStoLoad();
		waitForElement(newCustomerPage);
		Assert.assertEquals(newCustomerPage.getText(), Constant.NewCustomer.toString());
	}

	/*
	 * click on add new customer button
	 */
	public void clickOnAddNewCustomer() {
		clickOn(newCustomerBtn);
	}

	/*
	 * click on create button on create new customer page
	 */
	public void clickOnCreateButton() {
		clickOn(createBtn);
	}

	/*
	 * enter customer details on create new customer page
	 */
	public void enterNewCustomerDetails(CustomerModel customerModel) {

		clickOn(userNameField);
		inputText(userNameField, customerModel.getUserName());

		clickOn(emailIdField);
		inputText(emailIdField, customerModel.getEmail());

		clickOn(passwordField);
		inputText(passwordField, customerModel.getPassword());

		clickOn(confirmPasswordField);
		inputText(confirmPasswordField, customerModel.getConfirmPassword());

		clickOn(firstNameField);
		inputText(firstNameField, customerModel.getFirstName());

		clickOn(lastNameField);
		inputText(lastNameField, customerModel.getLastName());

		if (customerModel.getDob() != null) {
			clickOn(dobField);
			inputText(dobField, customerModel.getDob());
		}

		if (customerModel.getTitle() != null) {
			selectDropDownByValue(titleField, customerModel.getTitle());
		}

		if (customerModel.getGender() != null) {
			selectDropDownByValue(genderField, customerModel.getGender());
		}

		if (customerModel.getAddressLine1() != null) {
			clickOn(addressLine1Field);
			inputText(addressLine1Field, customerModel.getAddressLine1());
		}

		if (customerModel.getAddressLine2() != null) {
			clickOn(addressLine2Field);
			inputText(addressLine2Field, customerModel.getAddressLine2());
		}

		if (customerModel.getCity() != null) {
			clickOn(cityField);
			inputText(cityField, customerModel.getCity());
		}

		if (customerModel.getCounty() != null) {
			clickOn(countyField);
			inputText(countyField, customerModel.getCounty());
		}

		if (customerModel.getPostCode() != null) {
			clickOn(postcodeField);
			inputText(postcodeField, customerModel.getPostCode());
		}

		if (customerModel.getCountry() != null) {
			selectDropDownByValue(countryField, customerModel.getCountry());
		}

		if (customerModel.getLatitude() != null) {
			clickOn(latitudeField);
			inputText(latitudeField, customerModel.getLatitude());
		}

		if (customerModel.getLongitude() != null) {
			clickOn(longitudeField);
			inputText(longitudeField, customerModel.getLongitude());
		}

		if (customerModel.getPrimaryTelephone() != null) {
			clickOn(primaryTelephoneField);
			inputText(primaryTelephoneField,customerModel.getPrimaryTelephone());
		}

		if (customerModel.getSecondaryTelephone() != null) {
			clickOn(secondaryTelephoneField);
			inputText(secondaryTelephoneField,customerModel.getSecondaryTelephone());
		}

		if (customerModel.getLikesToBeCalled() != null) {
			clickOn(likesToBeCalledField);
			inputText(likesToBeCalledField, customerModel.getLikesToBeCalled());
		}

		if (customerModel.getNfcTagContent() != null) {
			clickOn(nfcTagContentField);
			inputText(nfcTagContentField, customerModel.getNfcTagContent());
		}

		clickOn(searchSelectTextBox);
		inputText(branchNameField, customerModel.getBranch());
		waitForElement(waitForSearchSelectTextBox);
		branchNameField.sendKeys(Keys.ENTER);

		clickOn(customerIdField);
		inputText(customerIdField, customerModel.getCustomerId());

	}

	/*
	 * verify newly created customer on customer page
	 */
	public void verifyCreatedCustomerOnCustomerPage(String customerName) {
		Assert.assertEquals(newCustomer.getText(), customerName);
	}
	
	/*
	 * Add relation between user and other user
	 */
	public void addRelation(CustomerModel customerModel)
	{
		clickOn(newCustomer);
		clickOn(addRelationBtn);
		_waitForJStoLoad();
		selectDropDownByText(relationship,customerModel.getRelationship());
		clickOn(authorizedUserField);
		inputText(AuthorizedUserNameField, "others");
		waitForElement(waitForSearchSelectTextBox);
		AuthorizedUserNameField.sendKeys(Keys.ENTER);
		clickOn(createBtn);
	}

}
