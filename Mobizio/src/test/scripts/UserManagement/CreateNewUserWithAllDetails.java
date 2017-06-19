package UserManagement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.GlobalConstant.FileNames;
import com.mobizio.datamodel.UserModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.pages.UserPage;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;


public class CreateNewUserWithAllDetails extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateNewUserWithAllDetails(String browser) {
		super(browser);
	}

	Configuration propertyReader ;
	UserModel userModel; 
	private UserPage userPage;
	String randomString= Utilities.randomString(4).toLowerCase();
	
	@BeforeMethod
	public void initiData() throws Exception{		
		propertyReader = new Configuration(FileNames.UserProperties.toString());
		userModel=new UserModel();
		userModel.setFirstName(propertyReader.readApplicationData("firstName"));
		userModel.setUserName(userModel.getFirstName() + randomString);
		userModel.setLastName(propertyReader.readApplicationData("lastName"));
		userModel.setEmail(userModel.getFirstName()+userModel.getLastName()+"@gmail.com");
		userModel.setPassword(propertyReader.readApplicationData("password"));
		userModel.setConfirmPassword(propertyReader.readApplicationData("confirmPassword"));
		userModel.setBranch(propertyReader.readApplicationData("branchName"));
		userModel.setUserType(propertyReader.readApplicationData("userType"));
		userModel.setTenantUserId(propertyReader.readApplicationData("tenantUserId")+ randomString);
		userModel.setTitle(propertyReader.readApplicationData("title"));
		userModel.setDob(propertyReader.readApplicationData("dob"));
		userModel.setGender(propertyReader.readApplicationData("gender"));
		userModel.setAddressLine1(propertyReader.readApplicationData("addressLine1"));
		userModel.setAddressLine2(propertyReader.readApplicationData("addressLine2"));
		userModel.setPostCode(propertyReader.readApplicationData("postcode"));
		userModel.setCounty(propertyReader.readApplicationData("county"));
		userModel.setCountry(propertyReader.readApplicationData("country"));
		userModel.setLatitude(propertyReader.readApplicationData("latitude"));
		userModel.setLongitude(propertyReader.readApplicationData("longitude"));
		userModel.setPrimaryTelephone(propertyReader.readApplicationData("primaryTelephone"));
		userModel.setSecondaryTelephone(propertyReader.readApplicationData("secondaryTelephone"));
		userModel.setCity(propertyReader.readApplicationData("city"));
	}

	@Test (description = "create new user with all details")
	public void createNewUserWithAllDetails() throws Exception
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration");
		dashBoardPage.clickOnConfiguration();
		
		reportLog("Click on Users");
		userPage = dashBoardPage.clickOnUsers();
		
		reportLog("click on new user button");
		userPage.clickOnNewUserButton();
		
		reportLog("verify new user page");
		userPage.verifyNewUserPage();
		
		reportLog("enter new user details");
		userPage.enterNewUserDetails(userModel);
		
		reportLog("click on create button");
		userPage.clickOnCreateButton();
		
		reportLog("verify new user page");
		userPage.verifyUserPage();
		
		reportLog("verify newly created user on user page ");
		userPage.verifyCreatedUserOnUserPage(userModel.getUserName());
		
		userPage.editUser(userModel);
		
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
		
		}
	
}

