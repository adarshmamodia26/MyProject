package com.mobizio.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.mobizio.datamodel.UserModel;
import com.mobizio.selenium.framework.BasePage;

public class UserPage extends BasePage{

	public UserPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//li[contains(text(),'Users')]")
	private WebElement users;
	
	@FindBy(xpath = "//a[@id='addNewUserBtn']/span")
	private WebElement newUserButton;
	
	@FindBy(xpath = "//*[@id='editUserBtn']")
	private WebElement editButton;
	
	@FindBy(xpath = "//*[@id='lnkEditPassword']")
	private WebElement editPasswordButton;
	
	@FindBy(xpath = "//li[contains(text(),'New User')]")
	private WebElement newUser;
	
	@FindBy(xpath = "//input[@id='usernameValueInput']")
	private WebElement inputUserName;
	
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
	
	@FindBy(xpath = "//select[@id='roleValueInput']")
	private WebElement userTypeField;
	
	@FindBy(xpath = "//input[@id='tenantCarerIdValueInput']")
	private WebElement tenantUserIdField;
	
	@FindBy(xpath = "//div[contains(@id,'branchNameInput')]")
	private WebElement searchSelectTextBox;
	
	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	private WebElement branchNameField;
	
	@FindBy(xpath = "//input[contains(@aria-activedescendant,'select2-result')]")
	private WebElement waitForSearchSelectTextBox;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement createButton;
	
	@FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]//a")
	private WebElement newlyCreatedUser;
	
	@FindBy(xpath = "//input[@id='dobValueInput']")
	private WebElement dobField;
	
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
	
	@FindBy(xpath = "//span[text()='Username']/parent::label/following-sibling::div/span")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='userPin']")
	private WebElement pinField;
	

	/*
	 * Verify User Page
	 */
	public void verifyUserPage() {
		_waitForJStoLoad();
		waitForElement(users);
		String customerPageText = users.getText();
		Assert.assertEquals("Users", customerPageText);
	}

	
	/*
	 * Click on new user button
	 */
	public void clickOnNewUserButton()
	{
		waitForElement(newUserButton);
		clickOn(newUserButton);
	}
	
	/*
	 * Verify New User Page
	 */
	public void verifyNewUserPage() {
		_waitForJStoLoad();
		waitForElement(newUser);
		String userPageText = newUser.getText();
		Assert.assertEquals("New User", userPageText);
	}
	
	
	/*
	 * click on create button
	 */
	public void clickOnCreateButton()
	{
		waitForElement(createButton);
		clickOn(createButton);
	}
	
	
	/*
	 * verify Created User On User Page
	 */
	public void verifyCreatedUserOnUserPage(String expectedUserName)
	{
		String UserName= newlyCreatedUser.getText();
		Assert.assertEquals(UserName, expectedUserName);
	}
	
	
	
	/*
	 * enter new user details
	 */
	public void enterNewUserDetails(UserModel userModel)throws InterruptedException {

		waitForElement(inputUserName);
		clickOn(inputUserName);
		inputText(inputUserName, userModel.getUserName());

		waitForElement(emailIdField);
		clickOn(emailIdField);
		inputText(emailIdField, userModel.getEmail());

		waitForElement(passwordField);
		clickOn(passwordField);
		inputText(passwordField, userModel.getPassword());

		waitForElement(confirmPasswordField);
		clickOn(confirmPasswordField);
		inputText(confirmPasswordField, userModel.getConfirmPassword());

		waitForElement(firstNameField);
		clickOn(firstNameField);
		inputText(firstNameField, userModel.getFirstName());

		waitForElement(lastNameField);
		clickOn(lastNameField);
		inputText(lastNameField, userModel.getLastName());
		
		waitForElement(userTypeField);
		selectDropDownByText(userTypeField,userModel.getUserType());
		
		waitForElement(tenantUserIdField);
		clickOn(tenantUserIdField);
		inputText(tenantUserIdField, userModel.getTenantUserId());
		
		clickOn(searchSelectTextBox);
		inputText(branchNameField, userModel.getBranch());
		waitForElement(waitForSearchSelectTextBox);
		branchNameField.sendKeys(Keys.ENTER);
		
		if (userModel.getDob() != null) {
			waitForElement(dobField);
			clickOn(dobField);
			inputText(dobField, userModel.getDob());
		}

		if (userModel.getTitle() != null) {
			waitForElement(titleField);
			selectDropDownByValue(titleField, userModel.getTitle());
		}

		if (userModel.getGender() != null) {
			waitForElement(genderField);
			selectDropDownByValue(genderField, userModel.getGender());
		}

		if (userModel.getAddressLine1() != null) {
			waitForElement(addressLine1Field);
			clickOn(addressLine1Field);
			inputText(addressLine1Field, userModel.getAddressLine1());
		}

		if (userModel.getAddressLine2() != null) {
			waitForElement(addressLine2Field);
			clickOn(addressLine2Field);
			inputText(addressLine2Field, userModel.getAddressLine2());
		}

		if (userModel.getCity() != null) {
			waitForElement(cityField);
			clickOn(cityField);
			inputText(cityField, userModel.getCity());
		}

		if (userModel.getCounty() != null) {
			waitForElement(countyField);
			clickOn(countyField);
			inputText(countyField, userModel.getCounty());
		}

		if (userModel.getPostCode() != null) {
			waitForElement(postcodeField);
			clickOn(postcodeField);
			inputText(postcodeField, userModel.getPostCode());
		}

		if (userModel.getCountry() != null) {
			waitForElement(countryField);
			selectDropDownByValue(countryField, userModel.getCountry());
		}

		if (userModel.getLatitude() != null) {
			waitForElement(latitudeField);
			clickOn(latitudeField);
			inputText(latitudeField, userModel.getLatitude());
		}

		if (userModel.getLongitude() != null) {
			waitForElement(longitudeField);
			clickOn(longitudeField);
			inputText(longitudeField, userModel.getLongitude());
		}

		if (userModel.getPrimaryTelephone() != null) {
			waitForElement(primaryTelephoneField);
			clickOn(primaryTelephoneField);
			inputText(primaryTelephoneField,userModel.getPrimaryTelephone());
		}

		if (userModel.getSecondaryTelephone() != null) {
			waitForElement(secondaryTelephoneField);
			clickOn(secondaryTelephoneField);
			inputText(secondaryTelephoneField,userModel.getSecondaryTelephone());
		}
	}
	
	/*
	 * edit user
	 */
	public void editUser(UserModel userModel) throws InterruptedException
	{
		clickOn(newlyCreatedUser);
		waitForElement(editButton);
		waitForElement(editPasswordButton);
		clickOn(editButton);
		
		//username
		
		waitForElement(emailIdField);
		clickOn(emailIdField);
		Assert.assertEquals(emailIdField.getAttribute("readonly"), null);
		inputText(emailIdField, userModel.getEmail());
		
		Assert.assertTrue(isElementPresent(pinField), "pin field not present");
		
		waitForElement(firstNameField);
		clickOn(firstNameField);
		Assert.assertEquals(firstNameField.getAttribute("readonly"), null);
		inputText(firstNameField, userModel.getFirstName());

		waitForElement(lastNameField);
		clickOn(lastNameField);
		Assert.assertEquals(lastNameField.getAttribute("readonly"), null);
		inputText(lastNameField, userModel.getLastName());
		
		waitForElement(userTypeField);
		Assert.assertEquals(userTypeField.getAttribute("readonly"), null);
		selectDropDownByText(userTypeField,userModel.getUserType());
		
		Assert.assertEquals(tenantUserIdField.getAttribute("disabled"),"true" );
		
		clickOn(searchSelectTextBox);
		Assert.assertEquals(searchSelectTextBox.getAttribute("readonly"), null);
		inputText(branchNameField, userModel.getBranch());
		waitForElement(waitForSearchSelectTextBox);
		branchNameField.sendKeys(Keys.ENTER);
		
		if (userModel.getDob() != null) {
			waitForElement(dobField);
			Assert.assertEquals(dobField.getAttribute("readonly"), null);
			clickOn(dobField);
			inputText(dobField, userModel.getDob());
		}

		if (userModel.getTitle() != null) {
			waitForElement(titleField);
			Assert.assertEquals(titleField.getAttribute("readonly"), null);
			selectDropDownByValue(titleField, userModel.getTitle());
		}

		if (userModel.getGender() != null) {
			waitForElement(genderField);
			Assert.assertEquals(genderField.getAttribute("readonly"), null);
			selectDropDownByValue(genderField, userModel.getGender());
		}

		if (userModel.getAddressLine1() != null) {
			waitForElement(addressLine1Field);
			Assert.assertEquals(addressLine1Field.getAttribute("readonly"), null);
			clickOn(addressLine1Field);
			inputText(addressLine1Field, userModel.getAddressLine1());
		}

		if (userModel.getAddressLine2() != null) {
			waitForElement(addressLine2Field);
			Assert.assertEquals(addressLine2Field.getAttribute("readonly"), null);
			clickOn(addressLine2Field);
			inputText(addressLine2Field, userModel.getAddressLine2());
		}

		if (userModel.getCity() != null) {
			waitForElement(cityField);
			Assert.assertEquals(cityField.getAttribute("readonly"), null);
			clickOn(cityField);
			inputText(cityField, userModel.getCity());
		}

		if (userModel.getCounty() != null) {
			waitForElement(countyField);
			Assert.assertEquals(countyField.getAttribute("readonly"), null);
			clickOn(countyField);
			inputText(countyField, userModel.getCounty());
		}

		if (userModel.getPostCode() != null) {
			waitForElement(postcodeField);
			Assert.assertEquals(postcodeField.getAttribute("readonly"), null);
			clickOn(postcodeField);
			inputText(postcodeField, userModel.getPostCode());
		}

		if (userModel.getCountry() != null) {
			waitForElement(countryField);
			Assert.assertEquals(countryField.getAttribute("readonly"), null);
			selectDropDownByValue(countryField, userModel.getCountry());
		}

		if (userModel.getLatitude() != null) {
			waitForElement(latitudeField);
			Assert.assertEquals(latitudeField.getAttribute("readonly"), null);
			clickOn(latitudeField);
			inputText(latitudeField, userModel.getLatitude());
		}

		if (userModel.getLongitude() != null) {
			waitForElement(longitudeField);
			Assert.assertEquals(longitudeField.getAttribute("readonly"), null);
			clickOn(longitudeField);
			inputText(longitudeField, userModel.getLongitude());
		}

		if (userModel.getPrimaryTelephone() != null) {
			waitForElement(primaryTelephoneField);
			Assert.assertEquals(primaryTelephoneField.getAttribute("readonly"), null);
			clickOn(primaryTelephoneField);
			inputText(primaryTelephoneField,userModel.getPrimaryTelephone());
		}

		if (userModel.getSecondaryTelephone() != null) {
			waitForElement(secondaryTelephoneField);
			Assert.assertEquals(secondaryTelephoneField.getAttribute("readonly"), null);
			clickOn(secondaryTelephoneField);
			inputText(secondaryTelephoneField,userModel.getSecondaryTelephone());
	}
	}
}
