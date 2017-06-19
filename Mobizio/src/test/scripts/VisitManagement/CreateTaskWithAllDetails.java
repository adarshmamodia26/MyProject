package VisitManagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;

import com.mobizio.datamodel.TaskModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateTaskWithAllDetails extends BaseTest {
	
	private Configuration propertyReader;
	private TaskModel taskModel;
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateTaskWithAllDetails(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{
		String randomString = Utilities.randomString(4).toLowerCase();
		taskModel=new TaskModel();
		propertyReader = new Configuration(FileNames.TaskProperties.toString());
		taskModel.setName(propertyReader.readApplicationData("name"));
		taskModel.setTaskType(propertyReader.readApplicationData("taskType"));
		taskModel.setStartTime(propertyReader.readApplicationData("startTime"));
		taskModel.setEndTime(propertyReader.readApplicationData("endTime"));
		taskModel.setStatus(propertyReader.readApplicationData("status"));
		taskModel.setAssignee(propertyReader.readApplicationData("assignee"));
		taskModel.setCustomer(propertyReader.readApplicationData("customer"));
		taskModel.setBranch(propertyReader.readApplicationData("branch"));
		taskModel.setAssociatedCase(propertyReader.readApplicationData("associatedCase"));
		taskModel.setActivities(propertyReader.readApplicationData("activities"));
		taskModel.setCarePlanId(propertyReader.readApplicationData("carePlanId"));
		taskModel.setAddressLine1(propertyReader.readApplicationData("addressLine1"));
		taskModel.setAddressLine2(propertyReader.readApplicationData("addressLine2"));
		taskModel.setCity(propertyReader.readApplicationData("city"));
		taskModel.setCounty(propertyReader.readApplicationData("county"));
		taskModel.setCountry(propertyReader.readApplicationData("country"));
		taskModel.setPostcode(propertyReader.readApplicationData("postcode"));
		taskModel.setLatitude(propertyReader.readApplicationData("latitude"));
		taskModel.setLongitude(propertyReader.readApplicationData("longitude"));
	}
	
	@Test (description = "create new device with all fields")
	public void createTaskWithAllDetails() throws Exception 
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
			
		reportLog("Click on visit");
		taskPage =dashBoardPage.clickOnVisit();;
		
		reportLog("click on new task");
		taskPage.clickOnNewVisit();
		
		reportLog("enter visit details and create the visit");
		taskPage.enterNewVisitDetail(taskModel);
		
		reportLog("verify visit name");
		taskPage.verifyCreatedTaskOnTaskPage(taskModel.getName());
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
