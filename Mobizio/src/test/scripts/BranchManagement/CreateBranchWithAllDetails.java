package BranchManagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;
import com.mobizio.datamodel.BranchModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateBranchWithAllDetails extends BaseTest {
	
	private Configuration propertyReader;
	private BranchModel branchModel;
	
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateBranchWithAllDetails(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{
		String randomString = Utilities.randomString(4).toLowerCase();
		branchModel=new BranchModel();
		propertyReader = new Configuration(FileNames.BranchProperties.toString());
		branchModel.setName(propertyReader.readApplicationData("name")+randomString);
		branchModel.setTenantBranchID(propertyReader.readApplicationData("tenantBranchID")+randomString);
		branchModel.setPrimaryTelephone(propertyReader.readApplicationData("primaryTelePhone"));
		branchModel.setSecondaryTelephone(propertyReader.readApplicationData("secondaryTelePhone"));
		branchModel.setAddressLine1(propertyReader.readApplicationData("addressLine1"));
		branchModel.setAddressLine2(propertyReader.readApplicationData("addressLine2"));
		branchModel.setCity(propertyReader.readApplicationData("city"));
		branchModel.setCounty(propertyReader.readApplicationData("county"));
		branchModel.setCountry(propertyReader.readApplicationData("country"));
		branchModel.setPostcode(propertyReader.readApplicationData("postcode"));
		branchModel.setFax(propertyReader.readApplicationData("fax"));
		branchModel.setAlertNotificationEmail(propertyReader.readApplicationData("alertNotificationEmail"));
		branchModel.setAlertNotificationPhoneNumber(propertyReader.readApplicationData("alertNotificationPhoneNumber"));
	}
	
	/**
	 * MB-3774:Verify tenant admin is able to create a branch.
	 */
	
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
		dashBoardPage.clickOnConfiguration();
			
		reportLog("Click on Branches");
		branchPage=dashBoardPage.clickOnBranch();
		
		reportLog("Click on NewBranch Button");
		branchPage.clickOnNewBranchButton();
		
		reportLog("enter new branch details");
		branchPage.enterNewBranchDetail(branchModel);
		
		reportLog("verify new branch");
		branchPage.verifyNewlyCreatedBranch(branchModel);
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
		
		reportLog("*************************TEST PASSED*****************************************");
	}
}
