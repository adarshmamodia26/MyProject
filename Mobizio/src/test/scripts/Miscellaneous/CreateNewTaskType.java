package Miscellaneous;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;
import com.mobizio.datamodel.TaskTypeModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateNewTaskType extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateNewTaskType(String browser) {
		super(browser);
	}
	
	Configuration propertyReader ;
	TaskTypeModel taskTypeModel; 
	String randomString= Utilities.randomString(4).toLowerCase();
	
	@BeforeMethod
	public void initiData() throws Exception{		
		propertyReader = new Configuration(FileNames.TaskTypeProperties.toString());
		taskTypeModel=new TaskTypeModel();
		
		taskTypeModel.setName(propertyReader.readApplicationData("name")+ randomString);
		taskTypeModel.setFormName(propertyReader.readApplicationData("formName"));
		taskTypeModel.setTaskTypes(propertyReader.readApplicationData("taskTypePage"));
		taskTypeModel.setNewTaskTypes(propertyReader.readApplicationData("newTaskTypePage"));
		}
	
	@Test (description = "create new group")
	public void createNewTaskType()
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration");
		dashBoardPage.clickOnConfiguration();
		
		reportLog("Click on task types");
		taskTypePage=dashBoardPage.clickOnTaskType();
		
		
		reportLog("verify task type page");
		taskTypePage.verifyTaskTypePage();
		
		reportLog("click on new task type button");
		taskTypePage.clickOnNewTaskTypeButton();
		
		reportLog("verify new task type page");
		taskTypePage.verifyNewTaskTypePage();
		
		reportLog("enter name to create new task type");
		taskTypePage.enterName(taskTypeModel);
		
		reportLog("Associate forms to new task type");
		taskTypePage.associateForm(taskTypeModel);
		
		reportLog("click on create button");
		taskTypePage.clickOnCreateButton();
		
		reportLog("verify task type page");
		taskTypePage.verifyTaskTypePage();
		
		reportLog("verify newly created task type");
		taskTypePage.verifyNewlyCreatedTasktype(taskTypeModel);
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
		
		
		
	}

}
