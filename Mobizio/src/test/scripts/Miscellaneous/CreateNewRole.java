//package Miscellaneous;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Factory;
//import org.testng.annotations.Test;
//
//import com.mobizio.constant.FileName.FileNames;
//import com.mobizio.datamodel.RoleModel;
//import com.mobizio.datamodel.ServiceModel;
//import com.mobizio.dataproviders.DataProviders;
//import com.mobizio.pages.ServicesPage;
//import com.mobizio.selenium.framework.BaseTest;
//import com.mobizio.selenium.framework.Configuration;
//import com.mobizio.selenium.framework.Utilities;
//
//public class CreateNewRole extends BaseTest {
//	
//	
//	RoleModel roleModel;
//	ServicesPage servicesPage;
//	ServiceModel serviceModel;
//	
//	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
//	public CreateNewRole(String browser) {
//		super(browser);
//	}
//	
//	@BeforeMethod
//	public void initiData() throws Exception{
//		String randomString = Utilities.randomString(4).toLowerCase();
//		roleModel=new RoleModel();
//		serviceModel= new ServiceModel();
//		Configuration rolesPropertyReader = new Configuration(FileNames.RoleProperties.toString());
//		Configuration servicePropertyReader = new Configuration(FileNames.ServiceProperties.toString());
//		roleModel.setName(rolesPropertyReader.readApplicationData("name")+randomString);
//		roleModel.setUser(rolesPropertyReader.readApplicationData("user"));
//		roleModel.setDescription(rolesPropertyReader.readApplicationData("description"));
//		serviceModel.setServiceName(servicePropertyReader.readApplicationData("serviceName"));
//		System.out.println(serviceModel.getServiceName());
//;	}
//	
//	@Test (description = "create new role")
//	public void createNewRole()
//	{
//		reportLog("Login with user name "+userName+" and password " +password);
//		dashBoardPage = loginPage.login(userName, password);
//		
//		reportLog("verify user login succesfully");
//		dashBoardPage.verifyLoginSuccess();
//		
//		reportLog("Click on Hamburger Menu");
//		dashBoardPage.clickOnHamburgerIcon();
//		
//		reportLog("Click on Configuration Menu");
//		configurationPage=dashBoardPage.clickOnConfiguration();
//		
//		reportLog("click on services");
//		servicesPage=configurationPage.clickOnServices();
//		
//		reportLog("click on service name");
//		servicesPage.clickOnService(serviceModel);
//		
//		reportLog("click on roles");
//		rolePage=servicesPage.clickOnroles();
//		
//		reportLog("verify roles page");
//		rolePage.verifyRolesPage();
//		
//		reportLog("click on new role button");
//		rolePage.clickOnNewRole();
//		
//		reportLog("enter roles details");
//		rolePage.enterRoleDetails(roleModel);
//		
//		reportLog("verify new role created");
//		rolePage.verifyNewRole(roleModel);
//		
//		reportLog("Logout from application");		
//		loginPage = dashBoardPage.logOut();
//		
//		reportLog("verify logout successfully");
//		loginPage.verifyLoginPage();
//	}
//}
