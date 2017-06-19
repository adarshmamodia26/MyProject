package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.mobizio.datamodel.DeviceModel;
import com.mobizio.selenium.framework.BasePage;

public class DevicePage extends BasePage {

	@FindBy(css = "#addNewDeviceBtn>span")
	private WebElement newDevice;
	
	@FindBy(xpath = "//*[@id='uuidValueInput']")
	private WebElement uuid;
	
	@FindBy(xpath = "(//*[@id='nameValueInput'])[1]")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id='osValueInput']")
	private WebElement operatingSystem;
	
	@FindBy(xpath = "//*[@id='modelValueInput']")
	private WebElement model;
	
	@FindBy(xpath = "(//*[@id='nameValueInput'])[2]")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//*[@id='s2id_autogen1']")
	private WebElement searchAssigneeTextBox;
	
	@FindBy(xpath = "//*[@id='s2id_branchNameInput']/a")
	private WebElement searchBranchDropDownBox;
	
	@FindBy(xpath = "//span[contains(@class,'select2-match')]")
	private WebElement waitForSearchSelectTextBox;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	private WebElement createButton;

	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	private WebElement searchBranchBox;

	@FindBy(xpath = "//*[@id='devicesTable']/tbody/tr[1]/td[1]/a")
	private WebElement deviceName;

	public DevicePage(WebDriver driver) {
		super(driver);
	}

	/*
	 * click on add new customer button
	 */
	public void clickOnNewDevice() {
		_waitForJStoLoad();
		waitForElement(newDevice);
		clickOn(newDevice);
		_waitForJStoLoad();
	}

	/*
	 * create a device with its details
	 */
	public void enterNewDeviceDetail(DeviceModel deviceModel) {
		
		waitForElement(uuid);
		clickOn(uuid);
		inputText(uuid, deviceModel.getUUID());
		
		waitForElement(name);
		clickOn(name);
		inputText(name, deviceModel.getName());
		
		waitForElement(operatingSystem);
		clickOn(operatingSystem);
		selectDropDownByText(operatingSystem, deviceModel.getOperatingSystem());
		
		waitForElement(model);
		clickOn(model);
		inputText(model, deviceModel.getModel());
		
		waitForElement(phoneNumber);
		clickOn(phoneNumber);
		inputText(phoneNumber, deviceModel.getPhoneNumber());
		
		waitForElement(searchAssigneeTextBox);
		clickOn(searchAssigneeTextBox);
		inputText(searchAssigneeTextBox, deviceModel.getAssignee());
		waitForElement(waitForSearchSelectTextBox);
		searchAssigneeTextBox.sendKeys(Keys.ENTER);
		
		waitForElement(searchBranchDropDownBox);
		clickOn(searchBranchDropDownBox);
		inputText(searchBranchBox, deviceModel.getBranch());
		waitForElement(waitForSearchSelectTextBox);
		searchBranchBox.sendKeys(Keys.ENTER);
		
		waitForElement(createButton);
		clickOn(createButton);
		_waitForJStoLoad();
	}
	
	/*
	 * verify newly created device 
	 */
	public void verifyCreatedDeviceOnDevicePage(String expectedDeviceName) {
		String device = deviceName.getText();
		Assert.assertEquals(device, expectedDeviceName);
	}
}
