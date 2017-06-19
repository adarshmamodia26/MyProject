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

public class CreateNewCustomerWithAllDetails extends BaseTest {
	
	private Configuration propertyReader;
	private CustomerModel customerModel;
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateNewCustomerWithAllDetails(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{
		String randomString = Utilities.randomString(4).toLowerCase();
		customerModel=new CustomerModel();
		propertyReader = new Configuration(FileNames.CustomerProperties.toString());
		customerModel.setFirstName(propertyReader.readApplicationData("firstName"));
		customerModel.setUserName(customerModel.getFirstName() + randomString);
		customerModel.setLastName(propertyReader.readApplicationData("lastName"));
		customerModel.setEmail(customerModel.getFirstName()+customerModel.getLastName()+"@gmail.com");
		customerModel.setPassword(propertyReader.readApplicationData("customerPassword"));
		customerModel.setConfirmPassword(propertyReader.readApplicationData("confirmPassword"));
		customerModel.setCustomerId(propertyReader.readApplicationData("customerId")+ Utilities.getRandomInteger(10000, 50000));
		customerModel.setBranch(propertyReader.readApplicationData("branchName"));
		customerModel.setTitle(propertyReader.readApplicationData("title"));
		customerModel.setGender(propertyReader.readApplicationData("gender"));
		customerModel.setAddressLine1(propertyReader.readApplicationData("addressLine1"));
		customerModel.setAddressLine2(propertyReader.readApplicationData("addressLine2"));
		customerModel.setPostCode(propertyReader.readApplicationData("postcode"));
		customerModel.setCounty(propertyReader.readApplicationData("county"));
		customerModel.setDob(propertyReader.readApplicationData("dob"));
		customerModel.setCountry(propertyReader.readApplicationData("country"));
		customerModel.setLatitude(propertyReader.readApplicationData("latitude"));
		customerModel.setLongitude(propertyReader.readApplicationData("longitude"));
		customerModel.setPrimaryTelephone(propertyReader.readApplicationData("primaryTelephone"));
		customerModel.setSecondaryTelephone(propertyReader.readApplicationData("secondaryTelephone"));
		customerModel.setLikesToBeCalled(propertyReader.readApplicationData("likesToBeCalled"));
		customerModel.setNfcTagContent(propertyReader.readApplicationData("nfcTagContent"));
		customerModel.setCity(propertyReader.readApplicationData("city"));
	}
	
	@Test (description = "create new customer with all fields")
	public void createNewCustomerWithAllDetails() throws Exception 
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
		customerPage.verifyCreatedCustomerOnCustomerPage(customerModel.getUserName());
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
