package Miscellaneous;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;
import com.mobizio.datamodel.DeviceModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.pages.DevicePage;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateDeviceWithAllDetail extends BaseTest {
	
	private Configuration propertyReader;
	private DeviceModel deviceModel;
	private DevicePage devicePage;
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateDeviceWithAllDetail(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{
		String randomString = Utilities.randomString(4).toLowerCase();
		deviceModel=new DeviceModel();
		propertyReader = new Configuration(FileNames.DeviceProperties.toString());
		deviceModel.setName(propertyReader.readApplicationData("name"));
		deviceModel.setOperatingSystem(propertyReader.readApplicationData("operatingSystem"));
		deviceModel.setUUID(propertyReader.readApplicationData("uuid")+randomString);
		deviceModel.setModel(propertyReader.readApplicationData("model"));
		deviceModel.setPhoneNumber(propertyReader.readApplicationData("phoneNumber"));
		deviceModel.setAssignee(propertyReader.readApplicationData("assignee"));
		deviceModel.setBranch(propertyReader.readApplicationData("branch"));
	}
	
	@Test (description = "create new device with all fields")
	public void createNewCustomerWithAllDetails() throws Exception 
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration Menu");
		dashBoardPage.clickOnConfiguration();
			
		reportLog("Click on Device");
		devicePage =dashBoardPage.clickOnDevice();
		
		reportLog("click on new device button");
		devicePage.clickOnNewDevice();
		
		reportLog("enter device details");
		devicePage.enterNewDeviceDetail(deviceModel);
		
		reportLog("verify device name");
		devicePage.verifyCreatedDeviceOnDevicePage(deviceModel.getUUID());
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
