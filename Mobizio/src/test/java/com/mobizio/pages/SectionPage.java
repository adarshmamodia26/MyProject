package com.mobizio.pages;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.mobizio.datamodel.SectionModel;
import com.mobizio.selenium.framework.BasePage;


public class SectionPage extends BasePage {

	public SectionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@id='addNewServiceDataGroupBtn']")
	private WebElement newSectionButton;
	
	@FindBy(xpath="//input[@id='labelInput']")
	private WebElement name;
	
	@FindBy(xpath="//button[@id='btnSave']")
	private WebElement createButton;
	
	@FindBy(xpath="//tbody[@id='service_data_group_list_tbody']/tr/td[2]/span")
	private List<WebElement> sections;
	
	/*
	 * click on new section button
	 */
	public void clickOnNewSection()
	{
		_waitForJStoLoad();
		clickOn(newSectionButton);
	}
	
	/*
	 * enter new section name
	 */
	public void enterNewSectionName(SectionModel sectionModel)
	{
		_waitForJStoLoad();
		clickOn(name);
		System.out.println(sectionModel.getName());
		inputText(name, sectionModel.getName());
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
	 * verify newly created section
	 */
	public void verifyNewlyCreatedSection(SectionModel sectionModel)
	{
		_waitForJStoLoad();
		boolean status=false;
		int count=sections.size();
		for(int i=1;i<=count;i++)
		{
			WebElement sectionName=getDriver().findElement(By.xpath("//tbody[@id='service_data_group_list_tbody']/tr["+i+"]/td[2]/span"));
			String labelName= sectionName.getText();
			if(labelName.equals(sectionModel.getName()))
			{
				status=true;
			}
		}
		Assert.assertTrue(status, "Section not found");
		
		
	}

}
