package CustomerManagement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.GlobalConstant.FileNames;
import com.mobizio.datamodel.CustomerModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;


public class CreateNewCustomerWithMandatoryDetails extends BaseTest {
	
	Configuration propertyReader ;
	CustomerModel customerModel; 
	String randomString= Utilities.randomString(4).toLowerCase();
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateNewCustomerWithMandatoryDetails(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{		
		propertyReader = new Configuration(FileNames.CustomerProperties.toString());
		customerModel=new CustomerModel();
		customerModel.setFirstName(propertyReader.readApplicationData("firstName"));
		customerModel.setUserName(customerModel.getFirstName() + randomString);
		customerModel.setLastName(propertyReader.readApplicationData("lastName"));
		customerModel.setEmail(customerModel.getFirstName()+customerModel.getLastName()+"@gmail.com");
		customerModel.setPassword(propertyReader.readApplicationData("customerPassword"));
		customerModel.setConfirmPassword(propertyReader.readApplicationData("confirmPassword"));
		customerModel.setCustomerId(propertyReader.readApplicationData("customerId")+ Utilities.getRandomInteger(100000, 999999));
		customerModel.setBranch(propertyReader.readApplicationData("branchName"));
	}
	
	@Test (description = "create new customer with all mandatory fields")
	public void createNewCustomerWithMandatoryDetails() throws Exception 
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Customer");
		customerPage =dashBoardPage.clickOnCustomer();
		
		reportLog("verify Customer Page");
		customerPage.verifyCustomerPage();
		
		reportLog("click on new customer button");
		customerPage.clickOnAddNewCustomer();
		
		reportLog("verify new customer page");
		customerPage.verifyNewCustomerPage();
		
		reportLog("enter new customer details");
		customerPage.enterNewCustomerDetails(customerModel);
		
		reportLog("click on create customer button");
		customerPage.clickOnCreateButton();
		
		reportLog("verify Customer Page");
		customerPage.verifyCustomerPage();
		
		reportLog("verify newly created customer on customer page ");
		customerPage.verifyCreatedCustomerOnCustomerPage(customerModel.getFirstName() + randomString);
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
