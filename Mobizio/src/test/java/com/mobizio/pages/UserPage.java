package com.mobizio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mobizio.datamodel.UserModel;
import com.mobizio.constant.GlobalConstants.Constant;
import com.mobizio.selenium.framework.BasePage;

public class UserPage extends BasePage{

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//li[contains(text(),'Users')]")
	private WebElement usersPage;
	
	@FindBy(xpath = "//a[@id='addNewUserBtn']/span")
	private WebElement newUserBtn;
	
	@FindBy(xpath = "//a[@id='editUserBtn']")
	private WebElement editBtn;
	
	@FindBy(xpath = "//a[@id='lnkEditPassword']")
	private WebElement editPasswordBtn;
	
	@FindBy(xpath = "//span[text()='Edit Password']")
	private WebElement editPassword;
	
	@FindBy(xpath = "//li[contains(text(),'New User')]")
	private WebElement newUserPage;
	
	@FindBy(xpath = "//input[@id='usernameValueInput']")
	private WebElement userNameInput;
	
	@FindBy(xpath = "//input[@id='emailValueInput']")
	private WebElement emailIdInput;
	
	@FindBy(xpath = "//input[@id='passwordValueInput']")
	private WebElement passwordInput;

	@FindBy(xpath = "//input[@id='confirmPasswordValueInput']")
	private WebElement confirmPasswordInput;

	@FindBy(xpath = "//input[@id='firstNameValueInput']")
	private WebElement firstNameInput;

	@FindBy(xpath = "//input[@id='lastNameValueInput']")
	private WebElement lastNameInput;
	
	@FindBy(xpath = "//select[@id='roleValueInput']")
	private WebElement userTypeInput;
	
	@FindBy(xpath = "//input[@id='tenantCarerIdValueInput']")
	private WebElement tenantUserIdInput;
	
	@FindBy(xpath = "//div[contains(@id,'branchNameInput')]")
	private WebElement branchInput;
	
	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	private WebElement branchNameInput;
	
	@FindBy(xpath = "//input[contains(@aria-activedescendant,'select2-result')]")
	private WebElement searchSelectTextBox;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]//a")
	private WebElement createdUser;
	
	@FindBy(xpath = "//table[@id='user-table']/tbody/tr")
	private WebElement totalUsers;
	
	@FindBy(xpath = "//input[@id='dobValueInput']")
	private WebElement dobInput;
	
	@FindBy(xpath = "//select[@id='titleValueInput']")
	private WebElement titleInput;

	@FindBy(xpath = "//select[@id='genderValueInput']")
	private WebElement genderInput;

	@FindBy(xpath = "//input[@id='firstLineValueInput']")
	private WebElement addressLine1Input;

	@FindBy(xpath = "//input[@id='secondLineValueInput']")
	private WebElement addressLine2Input;

	@FindBy(xpath = "//input[@id='cityValueInput']")
	private WebElement cityInput;

	@FindBy(xpath = "//input[@id='stateValueInput']")
	private WebElement countyInput;

	@FindBy(xpath = "//input[@id='postcodeValueInput']")
	private WebElement postcodeInput;

	@FindBy(xpath = "//select[@id='countryValueInput']")
	private WebElement countryInput;

	@FindBy(xpath = "//input[@id='latitudeValueInput']")
	private WebElement latitudeInput;

	@FindBy(xpath = "//input[@id='longitudeValueInput']")
	private WebElement longitudeInput;

	@FindBy(xpath = "//input[@id='primaryTelephoneValueInput']")
	private WebElement primaryTelephoneInput;

	@FindBy(xpath = "//input[@id='secondaryTelephoneValueInput']")
	private WebElement secondaryTelephoneInput;
	
	@FindBy(xpath = "//span[text()='Username']/parent::label/following-sibling::div/span")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='userPin']")
	private WebElement pinInput;
	
	@FindBy(xpath = "//a[@id='btnCancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//div[@id='user-table_filter']//input[@type='search']")
	private WebElement searchUser;
	
	@FindBy(xpath = "//div[@id='user-table_length']/label/select")
	private WebElement recordsPerPage;
	
	@FindBy(xpath="//div[@id='user-table_paginate']/ul/li")
	private List<WebElement> totalPage;
	
	@FindBy(xpath="//div[@id='user-table_info']")
	private WebElement totalRecords;

	/*
	 * Verify Users Page
	 */
	public void verifyUsersPage() {
		_waitForJStoLoad();
		waitForElement(usersPage);
		Assert.assertEquals(usersPage.getText(),Constant.UserPage.toString());
	}

	/*
	 * Click on new user button
	 */
	public void clickOnNewUserButton()
	{
		clickOn(newUserBtn);
	}
	
	/*
	 * Verify New User Page
	 */
	public void verifyNewUserPage() {
		_waitForJStoLoad();
		waitForElement(newUserPage);
		Assert.assertEquals(newUserPage.getText(),Constant.NewUserPage.toString());
	}
	
	
	/*
	 * click on create button
	 */
	public void clickOnCreateButton()
	{
		clickOn(createBtn);
	}
	
	/*
	 * verify Created User On User Page
	 */
	public void verifyCreatedUserOnUserPage(UserModel userModel)
	{
		Assert.assertEquals(createdUser.getText(), userModel.getUserName());
	}
	
	/*
	 * enter new user details
	 */
	public void enterNewUserDetails(UserModel userModel) {
		
		waitForElement(userNameInput);
		inputText(userNameInput, userModel.getUserName());
		
		waitForElement(emailIdInput);
		inputText(emailIdInput, userModel.getEmail());
		
		waitForElement(passwordInput);
		inputText(passwordInput, userModel.getPassword());
		
		waitForElement(confirmPasswordInput);
		inputText(confirmPasswordInput, userModel.getConfirmPassword());
		
		waitForElement(firstNameInput);
		inputText(firstNameInput, userModel.getFirstName());
		
		waitForElement(lastNameInput);
		inputText(lastNameInput, userModel.getLastName());
		
		waitForElement(userTypeInput);
		selectDropDownByText(userTypeInput,userModel.getUserType());
		
		waitForElement(tenantUserIdInput);
		inputText(tenantUserIdInput, userModel.getTenantUserId());
		
		waitForElement(branchInput);
		clickOn(branchInput);
		inputText(branchNameInput, userModel.getBranch());
		waitForElement(searchSelectTextBox);
		waitForElement(newUserPage);
		branchNameInput.sendKeys(Keys.ENTER);
		
		if (userModel.getDob() != null) {
			waitForElement(dobInput);
			inputText(dobInput, userModel.getDob());
		}

		if (userModel.getTitle() != null) {
			waitForElement(titleInput);
			selectDropDownByValue(titleInput, userModel.getTitle());
		}

		if (userModel.getGender() != null) {
			waitForElement(genderInput);
			selectDropDownByValue(genderInput, userModel.getGender());
		}

		if (userModel.getAddressLine1() != null) {
			waitForElement(addressLine1Input);
			inputText(addressLine1Input, userModel.getAddressLine1());
		}

		if (userModel.getAddressLine2() != null) {
			waitForElement(addressLine2Input);
			inputText(addressLine2Input, userModel.getAddressLine2());
		}

		if (userModel.getCity() != null) {
			waitForElement(cityInput);
			inputText(cityInput, userModel.getCity());
		}

		if (userModel.getCounty() != null) {
			waitForElement(countyInput);
			inputText(countyInput, userModel.getCounty());
		}

		if (userModel.getPostCode() != null) {
			waitForElement(postcodeInput);
			inputText(postcodeInput, userModel.getPostCode());
		}

		if (userModel.getCountry() != null) {
			waitForElement(countryInput);
			selectDropDownByValue(countryInput, userModel.getCountry());
		}

		if (userModel.getLatitude() != null) {
			waitForElement(latitudeInput);
			inputText(latitudeInput, userModel.getLatitude());
		}

		if (userModel.getLongitude() != null) {
			waitForElement(longitudeInput);
			inputText(longitudeInput, userModel.getLongitude());
		}

		if (userModel.getPrimaryTelephone() != null) {
			waitForElement(primaryTelephoneInput);
			inputText(primaryTelephoneInput,userModel.getPrimaryTelephone());
		}

		if (userModel.getSecondaryTelephone() != null) {
			waitForElement(secondaryTelephoneInput);
			inputText(secondaryTelephoneInput,userModel.getSecondaryTelephone());
		}
	}
	
	/*
	 * edit user
	 */
	public void editUser(UserModel userModel)
	{
		clickOn(createdUser);
		clickOn(editBtn);
		inputText(emailIdInput, userModel.getEmail());
		Assert.assertTrue(isElementPresent(pinInput), "pin Input not present");
		inputText(pinInput, userModel.getPin());
		inputText(firstNameInput, userModel.getFirstName());
		inputText(lastNameInput, userModel.getLastName());
		selectDropDownByText(userTypeInput,userModel.getUserType());
		Assert.assertEquals(tenantUserIdInput.getAttribute("disabled"),"true" );
		
		clickOn(branchInput);
		inputText(branchNameInput, userModel.getBranch());
		waitForElement(searchSelectTextBox);
		branchNameInput.sendKeys(Keys.ENTER);
		
		if (userModel.getDob() != null) {
			inputText(dobInput, userModel.getDob());
		}

		if (userModel.getTitle() != null) {
			selectDropDownByValue(titleInput, userModel.getTitle());
		}

		if (userModel.getGender() != null) {
			selectDropDownByValue(genderInput, userModel.getGender());
		}

		if (userModel.getAddressLine1() != null) {
			inputText(addressLine1Input, userModel.getAddressLine1());
		}

		if (userModel.getAddressLine2() != null) {
			inputText(addressLine2Input, userModel.getAddressLine2());
		}

		if (userModel.getCity() != null) {
			inputText(cityInput, userModel.getCity());
		}

		if (userModel.getCounty() != null) {
			inputText(countyInput, userModel.getCounty());
		}

		if (userModel.getPostCode() != null) {
			inputText(postcodeInput, userModel.getPostCode());
		}

		if (userModel.getCountry() != null) {
			selectDropDownByValue(countryInput, userModel.getCountry());
		}

		if (userModel.getLatitude() != null) {
			inputText(latitudeInput, userModel.getLatitude());
		}

		if (userModel.getLongitude() != null) {
			inputText(longitudeInput, userModel.getLongitude());
		}

		if (userModel.getPrimaryTelephone() != null) {
			inputText(primaryTelephoneInput,userModel.getPrimaryTelephone());
		}

		if (userModel.getSecondaryTelephone() != null) {
			inputText(secondaryTelephoneInput,userModel.getSecondaryTelephone());
			}
	}
	
	/*
	 * verify Edit Password Page
	 */
	public void verifyEditPasswordPage()
	{
		_waitForJStoLoad();
		waitForElement(editPassword);
		Assert.assertEquals(editPassword.getText(),Constant.EditPassword.toString());
	}
	
	/*
	 * edit user password
	 */
	public void editUserPassword(UserModel usermodel)
	{
		clickOn(createdUser);
		clickOn(editPasswordBtn);
		this.verifyEditPasswordPage();
		inputText(passwordInput, usermodel.getPassword());
		inputText(confirmPasswordInput, usermodel.getConfirmPassword());
		clickOn(createBtn);
	}
	
	/*
	 * Records per page functionality
	 */
	public void verifyRecordsPerPage()
	{
		List<WebElement> options= new Select(recordsPerPage).getOptions();
		boolean status=false;
		String str= totalRecords.getText();
		String [] tmp = str.split("f");
		String [] t2 = tmp[1].split(" ");
		String name= t2[1].trim();
		int totalNoOfRecords= Integer.parseInt(name);
		System.out.println(totalNoOfRecords);
		for(int i=0;i<options.size();i++)
		{
			selectDropDownByIndex(recordsPerPage, i);
			String value= options.get(i).getText();
			int values= Integer.parseInt(value);
			System.out.println(values);
			List<WebElement> users= driver.findElements(By.xpath("//table[@id='user-table']/tbody/tr"));
			int count=users.size();
			System.out.println(count);
			if(values==count)
			{
				status= true;
				continue;
			}
			
			else if(totalNoOfRecords==count)
			{
				status= true;
				break;
			}
			
			else
			{
				Assert.assertTrue(status);
				break;
			}
			
		}
		
		}
		
		

		
		
		
	}


