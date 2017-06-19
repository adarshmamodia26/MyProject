package Miscellaneous;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.GlobalConstant.FileNames;
import com.mobizio.datamodel.RoleModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.pages.ServicesPage;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateRoleWithDetails extends BaseTest {
	
	private Configuration propertyReader;
	private RoleModel roleModel;
	private ServicesPage servicesPage;
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateRoleWithDetails(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{
		String randomString = Utilities.randomString(4).toLowerCase();
		roleModel=new RoleModel();
		propertyReader = new Configuration(FileNames.RoleProperties.toString());
		roleModel.setName(propertyReader.readApplicationData("name")+randomString);
		roleModel.setUser(propertyReader.readApplicationData("user"));
		roleModel.setDescription(propertyReader.readApplicationData("description"));
	}
	
	@Test (description = "create new branch with all fields")
	public void createNewBranchWithAllDetails() throws Exception 
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration Menu");
		configurationPage=dashBoardPage.clickOnConfiguration();
		
		reportLog("click on services");
		servicesPage=configurationPage.clickOnServices();
		
		reportLog("click on service name");
		servicesPage.clickOnService();
		
		reportLog("click on roles");
		rolePage=servicesPage.clickOnroles();
			
		reportLog("click on new role button");
		rolePage.clickOnNewRole();
		
		reportLog("enter roles details");
		rolePage.enterRoleDetails(roleModel);
		
		reportLog("verify new role created");
		rolePage.verifyNewRole(roleModel);
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
