package com.mobizio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobizio.selenium.framework.BasePage;

public class DashboardPage extends BasePage {

	@FindBy(id = "usernameMenu")
	private WebElement userMenu;
	
	@FindBy(xpath = "//div[@class='navbar-header']/button")
	private WebElement HamburgerIcon;
	
	@FindBy(xpath = "//li[@id='configurationMenu']")
	private WebElement configuration;
	
	@FindBy(xpath = "//*[@id='tasksMenu']/a")
	private WebElement visit;
	
	@FindBy(xpath = "//*[@id='devicesConfigMenu']/a/span[2]")
	private WebElement device;
	
	@FindBy(xpath = "//li[@id='branchesConfigMenu']")
	private WebElement branch;
	
    @FindBy(xpath = "//*[@id='profile-picture']")
	private WebElement profilePic;

	@FindBy(xpath = "//*[@id='user-dropdown-menu']//span[text()='Log Out']")
	private WebElement logOutLink;
	
	@FindBy(xpath = "//li[@id='customersMenu']/a/span[1]")
	private WebElement customer;
	
	@FindBy(xpath = "//*[@id='formsConfigMenu']/a")
	private WebElement form;
	
	@FindBy(xpath = "//li[@id='usersConfigMenu']/a/span[1]")
	private WebElement user;
	
	@FindBy(xpath = "//li[@id='groupsConfigMenu']/a/span[1]")
	private WebElement groups;
	
	@FindBy(xpath = "//li[@id='taskTypesConfigMenu']/a/span[contains(text(),'Task Types')]")
	private WebElement taskTypes;
	
	@FindBy(xpath = "//li[@id='servicesConfigMenu']/a/span[contains(text(),'Services')]")
	private WebElement services;
	
	

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public DashboardPage verifyLoginSuccess() {
		_waitForJStoLoad();
		Assert.assertTrue(isElementPresent(userMenu), "User not login");
		Assert.assertTrue(isElementPresent(profilePic), "User not login");
		return this;
	}
	
	/*
	 * click On Hamburger Icon 
	 */
	public void clickOnHamburgerIcon()
	{
		clickOn(HamburgerIcon);
	}
	
	/*
	 * click On Configuration
	 */
	public void clickOnConfiguration()
	{
		clickOn(configuration);
	}
	
	/*
	 * click On visit
	 */
	public TaskPage clickOnVisit()
	{
		waitForElement(visit);
		clickOn(visit);
		return PageFactory.initElements(getDriver(), TaskPage.class);
	}
	
	/*
	 * click On Device
	 */
	public DevicePage clickOnDevice()
	{
		waitForElement(device);
		clickOn(device);
		return PageFactory.initElements(getDriver(), DevicePage.class);
	}
	
	/*
	 * click On Branches
	 */
	public BranchPage clickOnBranch()
	{
		clickOn(branch);
		return PageFactory.initElements(getDriver(), BranchPage.class);
	}
	
	/*
	 * click On form
	 */
	public FormPage clickOnForm()
	{
		waitForElement(form);
		clickOn(form);
		return PageFactory.initElements(getDriver(), FormPage.class);
	}
	
	
	/*
	 * click On Customer
	 */
	public CustomerPage clickOnCustomer()
	{
		waitForElement(customer);
		clickOn(customer);
		return PageFactory.initElements(getDriver(), CustomerPage.class);
	}
	
	/*
	 * logout from the application
	 */
	public LoginPage logOut() {
		clickOn(userMenu);
		clickOn(logOutLink);
		return PageFactory.initElements(getDriver(), LoginPage.class);
	}
	
	public UserPage clickOnUsers()
	{
		waitForElement(user);
		clickOn(user);
		return PageFactory.initElements(getDriver(), UserPage.class);
	}

	public TaskTypePage clickOnTaskType()
	{
		waitForElement(taskTypes);
		clickOn(taskTypes);
		return PageFactory.initElements(getDriver(), TaskTypePage.class);
	}
	
	public ServicesPage clickOnServices()
	{
		waitForElement(services);
		clickOn(services);
		return PageFactory.initElements(getDriver(), ServicesPage.class);
	}
	
	public GroupPage clickOnGroups()
	{
		waitForElement(groups);
		clickOn(groups);
		return PageFactory.initElements(getDriver(), GroupPage.class);
	}
	
}
