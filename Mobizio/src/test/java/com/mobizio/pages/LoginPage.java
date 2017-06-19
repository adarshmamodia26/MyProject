package com.mobizio.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobizio.constant.ValidationMessage.Validation;
import com.mobizio.selenium.framework.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "txtUserName")
	private WebElement userNameField;

	@FindBy(id = "txtPassword")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[@class='btn-cancel btn-cancel-login']")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//div[text()='Login Failed! Invalid username or password!']")
	private WebElement loginFailedMessage;
	
	@FindBy(xpath = "//label[@id='recaptcha-anchor-label']")
	private WebElement captcha;
	
	@FindBy(xpath = "//div[@class='form-group']/div")
	private WebElement forgotPasswordMessage;
	
	/*
	 * login into the application
	 */
	public DashboardPage login(String userName, String password) {
		_waitForJStoLoad();
		inputText(userNameField, userName);
		inputText(passwordField, password);
		clickOn(loginButton);
		return PageFactory.initElements(getDriver(), DashboardPage.class);
	}
	
	/*
	 * verify login page
	 */
	public LoginPage verifyLoginPage(){
		waitForElement(userNameField);
		Assert.assertTrue(isElementPresent(userNameField), "User is not panding on login page");
		Assert.assertTrue(isElementPresent(loginButton), "User is not panding on login page");
		Assert.assertTrue(isElementPresent(passwordField), "User is not panding on login page");
		return this;
	}
	
	/*
	 * verify login failed after three wrong attempts
	 */
	public void verifyLoginFailed()
	{
		waitForElement(loginFailedMessage);
		Assert.assertEquals(loginFailedMessage.getText(), Validation.LoginFailedMessage.toString());
		Assert.assertTrue(isElementPresent(captcha), "Captcha not present");
	}
	
	/*
	 * verify forgot password
	 */
	public void verifyForgotPassword(String alertMessage)
	{
		_waitForJStoLoad();
		javascriptButtonClick(forgotPasswordLink);
		_waitForJStoLoad();
		Assert.assertEquals(forgotPasswordMessage.getText(), alertMessage);
		Assert.assertTrue(isElementPresent(userNameField), "Username field is not present");
	}
}
