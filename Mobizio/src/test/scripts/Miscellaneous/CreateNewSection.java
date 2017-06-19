package Miscellaneous;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;
import com.mobizio.datamodel.SectionModel;
import com.mobizio.datamodel.ServiceModel;
import com.mobizio.dataproviders.DataProviders;
import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class CreateNewSection extends BaseTest{

	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public CreateNewSection(String browser) {
		super(browser);
	}
	
	ServiceModel serviceModel;
	SectionModel sectionModel;
	String randomString= Utilities.randomString(4).toLowerCase();

	@BeforeMethod
	public void initiData() throws Exception{		
		Configuration servicePropertyReader = new Configuration(FileNames.ServiceProperties.toString());
		Configuration sectionPropertyReader = new Configuration(FileNames.SectionProperties.toString());
		serviceModel= new ServiceModel();
		sectionModel=new SectionModel();
		
		serviceModel.setServiceName(servicePropertyReader.readApplicationData("serviceName"));
		sectionModel.setName(sectionPropertyReader.readApplicationData("sectionName")+ randomString);
	}
	
	@Test (description = "create new section")
	public void createNewSection()throws Exception
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration");
		dashBoardPage.clickOnConfiguration();
		
		reportLog("Click on services");
		dashBoardPage.clickOnServices();
		
		reportLog("Click on service name");
		servicesPage.clickOnService(serviceModel);
		
		reportLog("click on sections");
		servicesPage.clickOnSections();
		
		reportLog("click on new section button");
		sectionPage.clickOnNewSection();
		
		reportLog("enter new section name");
		sectionPage.enterNewSectionName(sectionModel);
		
		reportLog("click on create button");
		sectionPage.clickOnCreateButton();
		
		reportLog("verify newly created section");
		sectionPage.verifyNewlyCreatedSection(sectionModel);
		
		reportLog("Logout from application");		
		dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
