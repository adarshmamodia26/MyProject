package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;




import com.mobizio.constant.GlobalConstants.Constant;

import com.mobizio.datamodel.RoleModel;
import com.mobizio.selenium.framework.BasePage;

public class RolePage extends BasePage {

	@FindBy(xpath = "//a[@id='addNewServiceRoleBtn']")
	private WebElement newRoleBtn;
	
	@FindBy(xpath = "//span[text()='New Service Role']")
	private WebElement newServiceRolePage;
	
	@FindBy(xpath = "//input[@id='serviceRoleName']")
	private WebElement roleNameField;
	
	@FindBy(xpath = "//input[@id='s2id_autogen1']")
	private WebElement usersTextBox;
	
	@FindBy(xpath = "//*[@class='select2-match']")
	private WebElement searchedText;
	
	@FindBy(xpath = "//textarea[@id='serviceRoleDescription']")
	private WebElement descriptionField;
	
	@FindBy(xpath = "//*[@id='rbacMatrix']/thead/tr[2]/th[1]/div/ins")
	private WebElement create;
	
	@FindBy(xpath = "//*[@id='rbacMatrix']/thead/tr[2]/th[2]/div/ins")
	private WebElement read;
	
	@FindBy(xpath = "//*[@id='rbacMatrix']/thead/tr[2]/th[3]/div/ins")
	private WebElement update;
	
	@FindBy(xpath = "//*[@id='rbacMatrix']/thead/tr[2]/th[4]/div/ins")
	private WebElement delete;
	
	@FindBy(xpath = "//input[@id='allCases']/../ins")
	private WebElement allcases;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement bt_submit;
	
	@FindBy(xpath = "//*[@id='btnSave']")
	private WebElement bt_create;
	
	@FindBy(xpath = "//*[@id='serviceRolesTable_filter']/label/input")
	private WebElement search;
	
	@FindBy(xpath = "//*[@id='serviceRolesTable']/tbody/tr[1]/td[1]")
	private WebElement role;
	
	@FindBy(xpath = "//span[text()='Roles']")
	private WebElement rolesPage;
	
	private String createRole="//*[@id='addNewServiceRoleBtn']";
	
	public RolePage(WebDriver driver) {
		super(driver);
	}

	/*
	 * click on add new branch button
	 */
	public void clickOnNewRole() {
		clickOn(newRoleBtn);
		_waitForJStoLoad();
	}
	
	/*
	 * verify roles page
	 */
	public void verifyRolesPage()
	{
		waitForElement(rolesPage);
		Assert.assertEquals(rolesPage.getText(), Constant.RolesPage.toString());
	}
	
	/*
	 * verify new service roles page
	 */
	public void verifyNewServiceRolePage()
	{
		waitForElement(newServiceRolePage);
		Assert.assertEquals(newServiceRolePage.getText(), Constant.NewServiceRolePage.toString());
	}
	
	/*
	 * enter a new role details
	 */
	public void enterRoleDetails(RoleModel roleModel){
		
		clickOn(roleNameField);
		inputText(roleNameField,roleModel.getName());
		
		clickOn(descriptionField);
		inputText(descriptionField,roleModel.getDescription());
		
		clickOn(usersTextBox);
		inputText(usersTextBox,roleModel.getUser());
		waitForElement(searchedText);
		usersTextBox.sendKeys(Keys.ENTER);
	
		clickOn(create);
		clickOn(read);
		clickOn(update);
		clickOn(delete);
		waitForElement(bt_create);
		clickOn(bt_create);
		_waitForJStoLoad();
		clickOn(allcases);
		clickOn(bt_submit);
		waitForElementPresent(ByLocator(createRole),60);
		_waitForJStoLoad();
		
	}
	
	/*
	 * verify that new role has been created
	 */
	public void verifyNewRole(RoleModel roleModel){
		waitForElement(search);
		clickOn(search);
		inputText(search,roleModel.getName());
		search.sendKeys(Keys.ENTER);
		_waitForJStoLoad();
		waitForElementPresent(ByLocator(createRole),60);
		Assert.assertEquals(role.getText(), roleModel.getName());
	}

	
}
