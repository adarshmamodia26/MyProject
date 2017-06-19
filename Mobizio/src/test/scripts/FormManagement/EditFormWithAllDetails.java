package FormManagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.mobizio.constant.FileName.FileNames;

import com.mobizio.datamodel.FormModel;
import com.mobizio.dataproviders.DataProviders;

import com.mobizio.selenium.framework.BaseTest;
import com.mobizio.selenium.framework.Configuration;
import com.mobizio.selenium.framework.Utilities;

public class EditFormWithAllDetails extends BaseTest {
	
	private Configuration propertyReader;
	private FormModel formModel;
	private static String formname;
	
	@Factory(dataProvider = "Config", dataProviderClass=DataProviders.class)
	public EditFormWithAllDetails(String browser) {
		super(browser);
	}
	
	@BeforeMethod
	public void initiData() throws Exception{
		String randomString = Utilities.randomString(4).toLowerCase();
		formModel=new FormModel();
		propertyReader = new Configuration(FileNames.FormProperties.toString());
		formModel.setName(propertyReader.readApplicationData("name"));
		formModel.setDescription(propertyReader.readApplicationData("description"));
		formModel.setDefaultValue(propertyReader.readApplicationData("defaultValue"));
		formModel.setHide(propertyReader.readApplicationData("hide"));
		formModel.setCalculate(propertyReader.readApplicationData("calculate"));
		formModel.setFormName(propertyReader.readApplicationData("formName")+randomString);
		formModel.setFormHeader(propertyReader.readApplicationData("formHeader"));
		formModel.setFormInstruction(propertyReader.readApplicationData("formInstruction"));
		
	}
	
	@Test (description = "CreateForm")
	public void createNewFormWithAllDetails() throws Exception 
	{
		reportLog("Login with user name "+userName+" and password " +password);
		dashBoardPage = loginPage.login(userName, password);
		
		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		
		reportLog("Click on Hamburger Menu");
		dashBoardPage.clickOnHamburgerIcon();
		
		reportLog("Click on Configuration Menu");
		dashBoardPage.clickOnConfiguration();
			
		reportLog("Click on form");
		formPage=dashBoardPage.clickOnForm();
		
		reportLog("Click on newform");
		formPage.clickOnNewForm();
		
		reportLog("Click on newform");
		formPage.clickOnFields();
		
		reportLog("add text field to form");
		formPage.dragAndDropTextField();
		
		reportLog("click on added text field");
		formPage.clickOnTextField();
		
		reportLog("fill details of added text field");
		formPage.fillDetailsInTextField(formModel);
		
		reportLog("Click on newform");
		formPage.clickOnFields();
		
		reportLog("add number field to form");
		formPage.dragAndDropNumberField();
		
		reportLog("click on number field");
		formPage.clickOnNumberField();
		
		reportLog("select action for number field");
		formPage.selectValueInActionFieldForHide(formModel);
		
		reportLog("select value in rule field");
		String hideValue="form_component_1"+"="+"Yes";
		formPage.enterValueInRuleField(hideValue);
		
		reportLog("Click on fields");
		formPage.clickOnFields();
		
		reportLog("add paragraph field to form");
		formPage.dragAndDropParagraphField();
		
		reportLog("click on paragraph field");
		formPage.clickOnParagraphField();
		
		reportLog("select action for number field");
		formPage.selectValueInActionFieldForCalculate(formModel);
		
		reportLog("select value in rule field");
		String calculateValue="form_component_2"+"1";
		formPage.enterValueInRuleField(calculateValue);
		
		reportLog("click On form setting");
		formPage.clickOnFormSettings();
		
		reportLog("enter value of form name");
		formPage.enterValueInFormName(formModel);
		
		reportLog("enter value of form header");
		formPage.enterValueInFormHeader(formModel);
		
		reportLog("enter value of form instruction");
		formPage.enterValueInFormInstruction(formModel);
		
		reportLog("enter value of required");
		formPage.enterValueInRequiredForm();
		
		reportLog("click On save button");
		formPage.clickOnSave();
		
		reportLog("click On publish button");
		formPage.clickOnPublish();
		
		reportLog("verified created form name");
		formname=formPage.getCreatedFormOnFormPage();
		
		reportLog("searched created form name");
		formPage.searchCreatedFormOnFormPage(formname);
		
		reportLog("open searched form on form page");
		formPage.openSearchedFormOnFormPage();
		
		reportLog("edit searched form on form page");
		formPage.editSearchedFormOnFormPage();
		
		reportLog("edit form name on form page");
		formPage.editValueOfFormName(formModel);
		
		reportLog("edit form header on form page");
		formPage.editValueOfFormHeader(formModel);
		
		reportLog("edit form instruction on form page");
		formPage.editValueOfFormInstruction(formModel);
		
		reportLog("click on paragraph field");
		formPage.clickOnParagraphField();
		
		reportLog("select action for number field");
		formPage.selectValueInActionFieldForHide(formModel);
		
		reportLog("select value in rule field");
		String hideEditedValue="form_component_1"+"="+"Yes";
		formPage.enterValueInRuleField(hideEditedValue);
		
		reportLog("click On save button");
		formPage.clickOnSave();
		
		reportLog("click On publish button");
		formPage.clickOnPublish();
		
		reportLog("Logout from application");		
		loginPage = dashBoardPage.logOut();
		
		reportLog("verify logout successfully");
		loginPage.verifyLoginPage();
	}
}
