package BranchManagement;

import com.mobizio.constant.GlobalConstant.FileNames;
import com.mobizio.datamodel.BranchModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class VerifyThatTenantAdminRedirectToBranchAdminPageAfterCreateNewBranch extends BaseTest {

	private Configuration propertyReader;
	private BranchModel branchModel;


	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public VerifyThatTenantAdminRedirectToBranchAdminPageAfterCreateNewBranch(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void  initiData() throws Exception{
		String randomString = Utilities.randomString(3).toLowerCase();
		int minimum=10;
		int maximum=100;
		int randomNum = minimum + (int)(Math.random() * maximum);
		branchModel=new BranchModel();
		propertyReader = new Configuration(FileNames.BranchProperties.toString());
		branchModel.setName(propertyReader.readApplicationData("name")+randomString);
		branchModel.setTenantBranchID(propertyReader.readApplicationData("tenantBranchID")+randomNum);
		branchModel.setPrimaryTelephone(propertyReader.readApplicationData("primaryTelephone"));
		branchModel.setSecondaryTelephone(propertyReader.readApplicationData("secondaryTelePhone"));
		branchModel.setAddressLine1(propertyReader.readApplicationData("addressLine1"));
		branchModel.setAddressLine2(propertyReader.readApplicationData("addressLine2"));
		branchModel.setCity(propertyReader.readApplicationData("city"));
		branchModel.setCounty(propertyReader.readApplicationData("county"));
		branchModel.setCountry(propertyReader.readApplicationData("country"));
		branchModel.setPostcode(propertyReader.readApplicationData("postcode"));
		branchModel.setFax(propertyReader.readApplicationData("fax"));
		branchModel.setAlertNotificationEmail(propertyReader.readApplicationData("name")+randomString+propertyReader.readApplicationData("alertNotificationEmail"));
		branchModel.setAlertNotificationPhoneNumber(propertyReader.readApplicationData("alertNotificationPhoneNumber"));
	}
	
	/**
	 * MB-3774:Verify tenant admin is able to create a branch.
	 */
	
	@Test (description = "create new branch with all fields")
	public void VerifyThatTenantAdminRedirectToBranchAdminPageAfterCreateNewBranch() throws Exception
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
		branchPage.clickOnNewBranch();
		
		reportLog("enter new branch details");
		branchPage.enterNewBranchDetail(branchModel);
		
		reportLog("verify new branch, it also verify that we are on branch management page.");
		branchPage.verifyCreatedBranchOnBranchPage(branchModel.getName());
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
		
		reportLog("*************************TEST PASSED*****************************************");
	}
}
