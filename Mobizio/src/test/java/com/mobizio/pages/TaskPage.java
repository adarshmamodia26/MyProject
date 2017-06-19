package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.datamodel.TaskModel;
import com.mobizio.selenium.framework.BasePage;

public class TaskPage extends BasePage {

	@FindBy(xpath = "//*[@id='tasknameValueInput']")
	private WebElement visitName;
	
	@FindBy(xpath = "//*[@id='taskTypeValueInput']")
	private WebElement taskTypeDropDown;
	
	@FindBy(xpath = "//*[@id='startDateTimeValueInput']")
	private WebElement startTime;
	
	
	@FindBy(xpath = "//*[@id='endDateTimeValueInput']")
	private WebElement endTime;
	
	@FindBy(xpath = "//select[@name='status']")
	private WebElement status;
	
	@FindBy(xpath = "//*[@id='select2-chosen-1']")
	private WebElement assignee;
	
	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	private WebElement assigneeSearch;
	
	@FindBy(xpath = "//*[@id='s2id_customerNameInput']/a")
	private WebElement customer;
	
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	private WebElement customerSearch;
	
	@FindBy(xpath = "//*[@id='s2id_branchNameInput']/a")
	private WebElement branch;
	
	@FindBy(xpath = "//*[@id='s2id_autogen3_search']")
	private WebElement branchSearch;
	
	@FindBy(xpath = "//*[@id='caseValueInput']")
	private WebElement associatedCase;
	
	@FindBy(xpath = "//*[@id='activitiesInput']")
	private WebElement activities;
	
	@FindBy(xpath = "//*[@id='tenantWorkplanId']")
	private WebElement carePlanId;
	
	@FindBy(xpath = "//*[@id='firstLineValueInput']")
	private WebElement addressLine1;
	
	@FindBy(xpath = "//*[@id='secondLineValueInput']")
	private WebElement addressLine2;
	
	@FindBy(xpath = "//*[@id='cityValueInput']")
	private WebElement city;
	
	@FindBy(xpath = "//*[@id='stateValueInput']")
	private WebElement county;
	
	@FindBy(xpath = "//*[@id='postcodeValueInput']")
	private WebElement postcode;
	
	@FindBy(xpath = "//*[@id='countryValueInput']")
	private WebElement country;
	
	@FindBy(xpath = "//a[contains(text(),'Autofill Latitude & Longitude')]")
	private WebElement autoFillLatitudeLongitude;
	
	@FindBy(xpath = "//*[@id='latitudeValueInput']")
	private WebElement latitude;
	
	@FindBy(xpath = "//*[@id='longitudeValueInput']")
	private WebElement longitude;
	
	@FindBy(xpath = "//*[@id='addNewTaskBtn']/span")
	private WebElement newVisit;
	
	@FindBy(xpath = "//*[@id='btnSaveTask']")
	private WebElement bt_create;
	
	@FindBy(xpath = "//*[@id='tasksTable']/tbody/tr[1]/td[1]")
	private WebElement taskName;
	
	@FindBy(xpath = "//*[@id='advanceSearchButton']")
	private WebElement search;
	
	@FindBy(xpath = "//*[@id='taskNameSearchInput']")
	private WebElement visitSearch;
	
	@FindBy(xpath = "//*[@id='searchButton']")
	private WebElement bt_search;
	
	@FindBy(xpath = "//*[@id='tasksTable']/tbody/tr/td[1]/a")
	private WebElement searchedTask;
	
	@FindBy(xpath = "//*[@id='editTaskBtn']")
	private WebElement bt_edit;
	
	@FindBy(xpath = "//*[@id='btnSave']")
	private WebElement bt_save;
	
	@FindBy(xpath = "//input[contains(@aria-activedescendant,'select2-result')]")
	private WebElement waitForSearchSelectTextBox;
	
	private String taskname="//*[@id='tasknameValueInput']";
	
	
	public TaskPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * click on add new branch button
	 */
	public void clickOnNewVisit() {
		_waitForJStoLoad();
		waitForElement(newVisit);
		clickOn(newVisit);
		_waitForJStoLoad();
	}

	/*
	 * create a device with its details
	 */
	public void enterNewVisitDetail(TaskModel visitModel) throws InterruptedException {
		
		waitForElement(visitName);
		clickOn(visitName);
		inputText(visitName,visitModel.getName());
		
		waitForElement(taskTypeDropDown);
		clickOn(taskTypeDropDown);
		selectDropDownByText(taskTypeDropDown,visitModel.getTaskType());
		
		waitForElement(startTime);
		clickOn(startTime);
		startTime.clear();
		inputText(startTime,visitModel.getStartTime());
		
		waitForElement(endTime);
		clickOn(endTime);
		endTime.clear();
		inputText(endTime,visitModel.getEndTime());
		
		waitForElement(assignee);
		clickOn(assignee);
		waitForElement(assigneeSearch);
		inputText(assigneeSearch,visitModel.getAssignee());
		waitForElement(waitForSearchSelectTextBox);
		assigneeSearch.sendKeys(Keys.ENTER);
		
		waitForElement(customer);
		clickOn(customer);
		waitForElement(customerSearch);
		inputText(customerSearch,visitModel.getCustomer());
		waitForElement(waitForSearchSelectTextBox);
		customerSearch.sendKeys(Keys.ENTER);
		
		waitForElement(branch);
		clickOn(branch);
		waitForElement(branchSearch);
		inputText(branchSearch,visitModel.getBranch());
		waitForElement(waitForSearchSelectTextBox);
		branchSearch.sendKeys(Keys.ENTER);
		
		waitForElement(associatedCase);
		clickOn(associatedCase);
		Thread.sleep(2000);
		selectDropDownByText(associatedCase,visitModel.getAssociatedCase());
		
		waitForElement(activities);
		clickOn(activities);
		inputText(activities,visitModel.getActivities());
		
		waitForElement(carePlanId);
		clickOn(carePlanId);
		inputText(carePlanId,visitModel.getCarePlanId());
		
		waitForElement(addressLine1);
		clickOn(addressLine1);
		inputText(addressLine1,visitModel.getAddressLine1());
		
		waitForElement(addressLine2);
		clickOn(addressLine2);
		inputText(addressLine2,visitModel.getAddressLine2());
		
		waitForElement(city);
		clickOn(city);
		inputText(city,visitModel.getCity());
		
		waitForElement(county);
		clickOn(county);
		inputText(county,visitModel.getCounty());
		
		waitForElement(country);
		clickOn(country);
		selectDropDownByText(country,visitModel.getCountry());
		
		waitForElement(postcode);
		clickOn(postcode);
		inputText(postcode,visitModel.getPostcode());
		
		waitForElement(latitude);
		clickOn(latitude);
		inputText(latitude,visitModel.getLatitude());

		waitForElement(longitude);
		clickOn(longitude);
		inputText(longitude,visitModel.getLongitude());
		
		waitForElement(bt_create);
		clickOn(bt_create);
		_waitForJStoLoad();
	}
	
	/*
	 * verify newly created customer on customer page
	 */
	public void clickOnSearch()
	{
	 clickOn(search);
	 _waitForJStoLoad();
	}
	
	public void serachByVisitName(String taskName)
	{
		inputText(visitSearch,taskName);
		bt_search.click();
		_waitForJStoLoad();
	}
	
	/*
	 * click On searched task
	 */
	public void clickOnSearchedTask() {
		clickOn(searchedTask);
		_waitForJStoLoad();
		
	}
	
	/*
	 * click On edit button
	 */
	public void clickOnEditButton() throws InterruptedException {
		_waitForJStoLoad();
		clickOn(bt_edit);
		_waitForJStoLoad();
		
	}
	
	/*
	 * click On save button
	 */
	public void clickOnSaveButton() {
		clickOn(bt_save);
		_waitForJStoLoad();
		
	}
	
	/*
	 * change assignee
	 */
	public void changeAssignee(TaskModel visitModel) throws InterruptedException {
		waitForElement(assignee);
		clickOn(assignee);
		waitForElement(assigneeSearch);
		inputText(assigneeSearch,visitModel.getNewAssignee());
		waitForElement(waitForSearchSelectTextBox);
		assigneeSearch.sendKeys(Keys.ENTER);
		
	}
	
	/*
	 * verify newly created customer on customer page
	 */
	public void verifyCreatedTaskOnTaskPage(String expectedTaskName) {
		_waitForJStoLoad();
		String task = taskName.getText();
		Assert.assertEquals(task, expectedTaskName);
	}
	
	/*
	 * get task name
	 */
	public String getCreatedTaskOnTaskPage() {
		_waitForJStoLoad();
		return taskName.getText();
		
	}
	
}
