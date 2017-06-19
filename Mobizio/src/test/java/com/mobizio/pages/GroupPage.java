package com.mobizio.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.constant.GlobalConstants.Constant;

import com.mobizio.datamodel.GroupModel;
import com.mobizio.selenium.framework.BasePage;

public class GroupPage extends BasePage {

	public GroupPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//li[contains(text(),'Groups')]")
	private WebElement groups;
	
	@FindBy(xpath = "//a[@id='addUserGroupBtn']/span")
	private WebElement newGroupButton;
	
	@FindBy(xpath = "//input[@id='nameValueInput']")
	private WebElement name;
	
	@FindBy(xpath = "//li[contains(text(),'New Group')]")
	private WebElement newGroup;
	
	@FindBy(xpath = "//div[@id='s2id_userNameInput']")
	private WebElement searchSelectTextBox;
	
	@FindBy(xpath = "//div[@id='s2id_userNameInput']//input")
	private WebElement usersName;
	
	@FindBy(xpath = "//div[@id='s2id_userGroupNameInput']")
	private WebElement groupSearchSelectTextBox;
	
	@FindBy(xpath = "//div[@id='s2id_userGroupNameInput']//input")
	private WebElement groupName;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement createButton;
	
	@FindBy(xpath = "//table[@id='userGroupsTable']/tbody/tr[1]//a")
	private WebElement newlyCreatedGroup;
	
	/*
	 *Verify Groups Page 
	 */
	public void verifyGroupPage()
	{
		_waitForJStoLoad();
		String groupPageText= groups.getText();
		Assert.assertEquals(Constant.Groups.toString(), groupPageText);
	}
	
	/*
	 * click on new group button
	 */
	public void clickOnNewGroupButton()
	{
		waitForElement(newGroupButton);
		clickOn(newGroupButton);
	}
	
	/*
	 * Verify new group page
	 */
	public void verifyNewGroupPage()
	{
		_waitForJStoLoad();
		String groupPageText= newGroup.getText();
		Assert.assertEquals(Constant.NewGroup.toString(), groupPageText);
	}
	
	/*
	 * click on create button 
	 */
	public void clickOnCreateButton() {
		waitForElement(createButton);
		clickOn(createButton);
	}
	
	/*
	 * verify newly created group
	 */
	public void verifyCreatedGroupOnGroupPage(String expectedGroupName) {
		String groupName = newlyCreatedGroup.getText();
		Assert.assertEquals(groupName, expectedGroupName);
	}
	
	/*
	 * enter new group details
	 */
	public void enterNewGroupDetails(GroupModel groupModel)
	{
		clickOn(name);
		inputText(name, groupModel.getName());
		
		waitForElement(searchSelectTextBox);
		clickOn(searchSelectTextBox);
		inputText(usersName, groupModel.getUser1());
		verifyNewGroupPage();
		usersName.sendKeys(Keys.ENTER);
		
		waitForElement(groupSearchSelectTextBox);
		clickOn(groupSearchSelectTextBox);
		inputText(groupName, groupModel.getGroup1());
		verifyNewGroupPage();
		groupName.sendKeys(Keys.ENTER);
		
		waitForElement(searchSelectTextBox);
		clickOn(searchSelectTextBox);
		inputText(usersName, groupModel.getUser2());
		verifyNewGroupPage();
		usersName.sendKeys(Keys.ENTER);
		
		waitForElement(groupSearchSelectTextBox);
		clickOn(groupSearchSelectTextBox);
		inputText(groupName, groupModel.getGroup2());
		verifyNewGroupPage();
		groupName.sendKeys(Keys.ENTER);
		
		
		
	}
	

}
