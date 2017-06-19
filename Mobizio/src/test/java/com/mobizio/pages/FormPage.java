package com.mobizio.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.mobizio.datamodel.FormModel;
import com.mobizio.selenium.framework.BasePage;



public class FormPage extends BasePage {

	@FindBy(xpath = "//*[@id='addNewFormBtn']/span")
	private WebElement newForm;
	
	@FindBy(xpath = "//*[@id='left']/ul/li[1]/a")
	private WebElement fields;
	
	@FindBy(xpath = "//*[@id='0']/li")
	private WebElement untitledForm;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[1]/div/input[1]")
	private WebElement textField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[2]/div/input[1]")
	private WebElement numberField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[3]/div/input")
	private WebElement paragraphField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[4]/div/input[1]")
	private WebElement decimalField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[5]/div/input")
	private WebElement multiSelectField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[6]/div/input")
	private WebElement dropDownField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[7]/div/input[1]")
	private WebElement timeField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[8]/div/input[1]")
	private WebElement dateField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[9]/div/input[1]")
	private WebElement radioButtonField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[10]/div/input[1]")
	private WebElement checkBoxField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[11]/div/input[1]")
	private WebElement signatureField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[12]/div/input[1]")
	private WebElement photoField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[13]/div/input[1]")
	private WebElement barcodeField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[14]/div/input")
	private WebElement hyperlinkField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[15]/div/input")
	private WebElement labelField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[16]/div/input[1]")
	private WebElement customerPickerField;
	
	@FindBy(xpath = "//*[@id='BasicMenu']/li[17]/div/input[1]")
	private WebElement userPickerField;
	
	@FindBy(xpath = "//*[@id='addTable']/button")
	private WebElement tableField;
	
	@FindBy(xpath = "//*[@id='addSection']/button")
	private WebElement sectionField;
	
	
	@FindBy(xpath = "//*[@id='actionD']")
	private WebElement action;
	
	@FindBy(xpath = "//*[@id='ruleD']")
	private WebElement rule;
	
	@FindBy(xpath = "//*[@id='li_1']")
	private WebElement textFieldInUntitledForm;
	
	@FindBy(xpath = "//*[@id='li_2']")
	private WebElement numberFieldInUntitledForm;
	
	@FindBy(xpath = "//*[@id='li_3']")
	private WebElement paragraphFieldInUntitledForm;
	
	@FindBy(xpath = "//*[@id='label']")
	private WebElement labelOfTextField;
	
	@FindBy(xpath = "//*[@id='helptext']")
	private WebElement instructionOfTextField;
	
	@FindBy(xpath = "//*[@id='default']")
	private WebElement defaultValueOfTextField;
	
	@FindBy(xpath = "//*[@id='required']")
	private WebElement isRequiredTextField;
	
	@FindBy(xpath = "//*[@id='left']/ul/li[3]/a")
	private WebElement formSetting;
	
	@FindBy(xpath = "//*[@id='nameValueInput']")
	private WebElement formName;
	
	@FindBy(xpath = "//*[@id='headerValueInput']")
	private WebElement formHeader;
	
	@FindBy(xpath = "//*[@id='instructionsValueInput']")
	private WebElement formInstruction;
	
	@FindBy(xpath = "//*[@id='requiredValueInput']")
	private WebElement requiredForm;
	
	@FindBy(xpath = "//*[@id='btnActionSave']")
	private WebElement bt_save;
	
	@FindBy(xpath = "//*[@id='btnActionPublish']")
	private WebElement bt_publish;
	
	@FindBy(xpath = "//*[@id='formsTable']/tbody/tr[1]/td[1]")
	private WebElement formNameOnFormDetailPage;
	
	@FindBy(xpath = "//*[@id='formsTable_filter']/label/input")
	private WebElement searchFormOnFormDetailPage;
	
	@FindBy(xpath = "//*[@id='formsTable']/tbody/tr/td[1]/a")
	private WebElement searchFormLink;
	
	@FindBy(xpath = "//*[@id='content']/section/div[2]/a[2]")
	private WebElement editForm;
	
	public FormPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * click on add new branch button
	 */
	public void clickOnNewForm() {
		_waitForJStoLoad();
		waitForElement(newForm);
		clickOn(newForm);
		_waitForJStoLoad();
	}
	
	/*
	 * click on fields
	 */
	public void clickOnFields() {
		_waitForJStoLoad();
		waitForElement(fields);
		clickOn(fields);
		_waitForJStoLoad();
	}
	
	/*
	 * click on form setting
	 */
	public void clickOnFormSettings() {
		waitForElement(formSetting);
		clickOn(formSetting);
		_waitForJStoLoad();
	}
	

	/*
	 * click on save button
	 */
	public void clickOnSave() {
		_waitForJStoLoad();
		waitForElement(bt_save);
		clickOn(bt_save);
		_waitForJStoLoad();
	}
	
	/*
	 * click on publish button
	 */
	public void clickOnPublish() {
		_waitForJStoLoad();
		waitForElement(bt_publish);
		clickOn(bt_publish);
		_waitForJStoLoad();
	}
	
	/*
	 * enter value in form name
	 */
	public void enterValueInFormName(FormModel formModel) {
		waitForElement(formName);
		inputText(formName,formModel.getFormName());
	}
	
	/*
	 * enter value in form header
	 */
	public void enterValueInFormHeader(FormModel formModel) {
		waitForElement(formHeader);
		inputText(formHeader,formModel.getFormHeader());
	}
	
	/*
	 * enter value in instruction
	 */
	public void enterValueInFormInstruction(FormModel formModel) {
		waitForElement(formInstruction);
		inputText(formInstruction,formModel.getFormInstruction());
	}
	
	/*
	 * enter value in required
	 */
	public void enterValueInRequiredForm() {
		waitForElement(requiredForm);
		clickOn(requiredForm);
	}
	
	

	public void dragAndDropTextField()
	{
		dragAndDrop(textField,untitledForm);
		
	}
	
	public void dragAndDropNumberField()
	{
		dragAndDrop(numberField,untitledForm);
		
	}
	
	public void dragAndDropParagraphField()
	{
		dragAndDrop(paragraphField,untitledForm);
		
	}
	
	public void dragAndDropDecimalField()
	{
		dragAndDrop(decimalField,untitledForm);
		
	}
	
	public void dragAndDropMultiSelectField()
	{
		dragAndDrop(multiSelectField,untitledForm);
		
	}
	
	public void dragAndDropDropDownField()
	{
		dragAndDrop(dropDownField,untitledForm);
		
	}
	
	public void dragAndDropTimeField()
	{
		dragAndDrop(timeField,untitledForm);
		
	}
	
	public void dragAndDropDateField()
	{
		dragAndDrop(dateField,untitledForm);
		
	}
	
	public void dragAndDropRadioButtonField()
	{
		dragAndDrop(radioButtonField,untitledForm);
		
	}
	
	public void dragAndDropCheckboxField()
	{
		dragAndDrop(checkBoxField,untitledForm);
		
	}
	
	public void dragAndDropSignatureField()
	{
		dragAndDrop(signatureField,untitledForm);
		
	}
	
	public void dragAndDropPhotoField()
	{
		dragAndDrop(photoField,untitledForm);
		
	}
	
	public void dragAndDropBarcodeField()
	{
		dragAndDrop(barcodeField,untitledForm);
		
	}
	
	public void dragAndDropHyperlinkField()
	{
		dragAndDrop(hyperlinkField,untitledForm);
		
	}
	
	public void dragAndDropLabelField()
	{
		dragAndDrop(labelField,untitledForm);
		
	}
	public void dragAndDropCustomerPickerField()
	{
		dragAndDrop(customerPickerField,untitledForm);
		
	}
	public void dragAndDropUserPickerField()
	{
		dragAndDrop(userPickerField,untitledForm);
		
	}
	
	public void dragAndDropTableField()
	{
		dragAndDrop(tableField,untitledForm);
		
	}
	
	public void dragAndDropSectionField()
	{
		dragAndDrop(sectionField,untitledForm);
		
	}
	
	
	
	/*
	 * click on fields
	 */
	public void clickOnTextField() {
		waitForElement(textFieldInUntitledForm);
		clickOn(textFieldInUntitledForm);
	}
	
	/*
	 * click on fields
	 */
	public void clickOnNumberField() {
		waitForElement(numberFieldInUntitledForm);
		clickOn(numberFieldInUntitledForm);
	}
	
	/*
	 * click on fields
	 */
	public void clickOnParagraphField() {
		waitForElement(paragraphFieldInUntitledForm);
		clickOn(paragraphFieldInUntitledForm);
	}
	
	
	
	/*
	 * select value of hide from dropdown
	 */
	public void selectValueInActionFieldForHide(FormModel formModel) {
		waitForElement(action);
		clickOn(action);
		selectDropDownByText(action,formModel.getHide());
	}
	
	/*
	 * select value of calculate from drop down
	 */
	public void selectValueInActionFieldForCalculate(FormModel formModel) {
		waitForElement(action);
		clickOn(action);
		selectDropDownByText(action,formModel.getCalculate());
	}
	
	/*
	 * enter value in rule field for hide and calculate logic
	 */
	public void enterValueInRuleField(String value) throws InterruptedException {
		waitForElement(rule);
		waitForElementClickable(rule,30);
		inputText(rule,value);
	}
	
	
	/*
	 * click on fields
	 */
	public void fillDetailsInTextField(FormModel formModel) {
		waitForElement(labelOfTextField);
		clickOn(labelOfTextField);
		inputText(labelOfTextField,formModel.getName());
		waitForElement(instructionOfTextField);
		clickOn(instructionOfTextField);
		inputText(instructionOfTextField,formModel.getDescription());
		waitForElement(defaultValueOfTextField);
		clickOn(defaultValueOfTextField);
		inputText(defaultValueOfTextField,formModel.getDefaultValue());
		waitForElement(isRequiredTextField);
		clickOn(isRequiredTextField);
	}
	
	/*
	 * verify newly created customer on customer page
	 */
	public void verifyCreatedFormOnFormPage(String expectedFormName) {
		String form = formNameOnFormDetailPage.getText();
		Assert.assertEquals(form, expectedFormName);
	} 
	
	/*
	 * get newly created customer
	 */
	public String getCreatedFormOnFormPage()
	{
		return formNameOnFormDetailPage.getText();
	}
	

	/*
	 * search form
	 */
	public void searchCreatedFormOnFormPage(String formName)
	{
		clickOn(searchFormOnFormDetailPage);
		inputText(searchFormOnFormDetailPage,formName);
		searchFormOnFormDetailPage.sendKeys(Keys.ENTER);
		_waitForJStoLoad();
	}
	
	/*
	 * click on searched form
	 */
	public void openSearchedFormOnFormPage()
	{
		clickOn(searchFormLink);
		_waitForJStoLoad();
	}
	
	/* 
	 * * click on edit form
	 */
	public void editSearchedFormOnFormPage()
	{
		clickOn(editForm);
		_waitForJStoLoad();
	}
	
	/* 
	 * * edit name of form
	 */
	public void editValueOfFormName(FormModel formModel)
	{
		waitForElement(formName);
		Assert.assertEquals(formName.getAttribute("readonly"), null);
		formName.clear();
		String editedFormNameValue=formModel.getFormName()+"edited";
		inputText(formName,editedFormNameValue);
		
	}
	
	/* 
	 * * edit name of form header
	 */
	public void editValueOfFormHeader(FormModel formModel)
	{
		waitForElement(formHeader);
		Assert.assertEquals(formHeader.getAttribute("readonly"), null);
		formHeader.clear();
		String editedFormNameValue=formModel.getFormHeader()+"edited";
		inputText(formHeader,editedFormNameValue);
		
	}
	
	/* 
	 * * edit name of form instruction
	 */
	public void editValueOfFormInstruction(FormModel formModel)
	{
		waitForElement(formInstruction);
		Assert.assertEquals(formInstruction.getAttribute("readonly"), null);
		formInstruction.clear();
		String editedFormNameValue=formModel.getFormInstruction()+"edited";
		inputText(formInstruction,editedFormNameValue);
		
	}
	
	/*
	 * edit value in rule field for hide and calculate logic
	 */
	public void editValueInRuleField(String value) throws InterruptedException {
		waitForElement(rule);
		Assert.assertEquals(rule.getAttribute("readonly"), null);
		Thread.sleep(3000);
		inputText(rule,value);
	}
	
}
