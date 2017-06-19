package GroupManagement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;
import com.mobizio.datamodel.GroupModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateNewGroup extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateNewGroup(String browser) {
		super(browser);
	}
	
	Configuration propertyReader ;
	GroupModel groupModel; 
	String randomString= Utilities.randomString(4).toLowerCase();
	
	@BeforeMethod
	public void initiData() throws Exception{		
		propertyReader = new Configuration(FileNames.GroupProperties.toString());
		groupModel=new GroupModel();
		
		groupModel.setName(propertyReader.readApplicationData("name")+ randomString);
		groupModel.setUser1(propertyReader.readApplicationData("user1"));
		groupModel.setUser2(propertyReader.readApplicationData("user2"));
		groupModel.setGroup1(propertyReader.readApplicationData("group1"));
		groupModel.setGroup2(propertyReader.readApplicationData("group2"));
	}
	
	@Test (description = "create new group")
	public void createNewGroup()throws Exception
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration");
		dashBoardPage.clickOnConfiguration();
		
		reportLog("Click on Groups");
		groupPage = dashBoardPage.clickOnGroups();
		
		reportLog("verify Groups Page");
		groupPage.verifyGroupPage();
		
		reportLog("click on new group button");
		groupPage.clickOnNewGroupButton();
		
		reportLog("verify new Group Page");
		groupPage.verifyNewGroupPage();
		
		reportLog("enter new group details");
		groupPage.enterNewGroupDetails(groupModel);
		
		reportLog("click on create button");
		groupPage.clickOnCreateButton();
		
		reportLog("verify Groups Page");
		groupPage.verifyGroupPage();
		
		reportLog("verify newly created group");
		groupPage.verifyCreatedGroupOnGroupPage(groupModel.getName());
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
		
		
		
		
	}

}
