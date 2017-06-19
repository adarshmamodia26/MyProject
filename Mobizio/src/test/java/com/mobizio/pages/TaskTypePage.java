package com.mobizio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.mobizio.constant.GlobalConstant.FileNames;
import com.mobizio.datamodel.TaskTypeModel;
import com.mobizio.selenium.framework.BasePage;


public class TaskTypePage extends BasePage{

	public TaskTypePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//li[contains(text(),'Task Types')]")
	private WebElement taskTypes;
	
	@FindBy(xpath="//a[@id='addNewTaskTypeBtn']/span")
	private WebElement newTaskTypeButton;
	
	@FindBy(xpath="//li[contains(text(),'New Task Type')]")
	private WebElement newTaskType;
	
	@FindBy(xpath="//input[@id='nameValueInput']")
	private WebElement name;
	
	@FindBy(xpath="//div[@id='associated-forms']/span")
	private List<WebElement> associatedForms;
	
	@FindBy(xpath="//button[@id='btnSave']")
	private WebElement createButton;
	
	@FindBy(xpath="//table[@id='taskTypesTable']/tbody/tr[1]//a")
	private WebElement newlyCreatedTaskType;
	
	
	/*
	 * verify task type page
	 */
	public void verifyTaskTypePage()
	{
		_waitForJStoLoad();
		String taskTypePageText=taskTypes.getText();
		Assert.assertEquals(FileNames.TaskTypePage.toString(), taskTypePageText);
	}
	
	/*
	 * click on new task type button
	 */
	public void clickOnNewTaskTypeButton()
	{
		waitForElement(newTaskTypeButton);
		clickOn(newTaskTypeButton);
	}
	
	/*
	 * verify new task type page
	 */
	public void verifyNewTaskTypePage()
	{
		_waitForJStoLoad();
		String newTaskTypePageText=newTaskType.getText();
		Assert.assertEquals(FileNames.NewTaskTypePage.toString(), newTaskTypePageText);
	}
	
	/*
	 * enter name to create new task type
	 */
	public void enterName(TaskTypeModel taskTypeModel)
	{
		waitForElement(name);
		clickOn(name);
		inputText(name, taskTypeModel.getName());
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
	 * verify newly created task type
	 */
	public void verifyNewlyCreatedTasktype(TaskTypeModel taskTypeModel)
	{
		String newTaskType=newlyCreatedTaskType.getText();
		Assert.assertEquals(newTaskType, taskTypeModel.getName());
	}
	
	/*
	 * Associate forms to new task type
	 */
	public void associateForm(TaskTypeModel taskTypeModel)
	{
		int count=associatedForms.size();
		for(int i=1;i<=count;i++)
		{
			WebElement formName=getDriver().findElement(By.xpath("//div[@id='associated-forms']/span["+i+"]/label"));
			String fName=formName.getText();
			if(fName.equals(taskTypeModel.getFormName()))
			{
				clickOn(formName);
				break;
			}
		
			
		}
	}

}
