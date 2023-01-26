package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsqura.utilities.DataProviderUtility;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class ClientPage {
	WebDriver driver;
   public ClientPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	} 
	  @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	  private WebElement clientMoreInfo;
	 
	  @FindBy(xpath="//button[@class='add_c btn btn-primary']")
	  private WebElement AddClientButton;
	 
	  @FindBy(xpath="//input[@id='name1']")
	  private WebElement clientName;
	 
	  @FindBy(xpath="//input[@id='company1']")
	  private WebElement clientCompany;
	 
	  @FindBy(xpath="//input[@id='route']")
	  private WebElement address;
	 
	  @FindBy(xpath="//input[@id='email1']")
	  private WebElement Clientemail;
	 
	  @FindBy(xpath="//button[@id='submit']")
	  private WebElement submitButton;
	  
	  @FindBy(xpath="//div[@id='titoloclienti']")
	  private WebElement clientNameTitle;
	  
	  @FindBy(xpath="//body[@class='sidebar-mini skin-red skin-custom']")
	  private WebElement goBackButton;
	 
	  @FindBy(xpath="//input[@class='form-control input-sm input-xs']")
	  private WebElement clientSearch;
	 
	  @FindBy(xpath="//button[@class='btn btn-default btn-xs btn-primary dropdown-toggle']")
	  private WebElement blueActionButton;
	 
	  @FindBy(xpath="//a[@id='delete_client']")
	  private WebElement delectClientButton;
	
	  @FindBy(xpath="//button[@data-bb-handler='confirm']")
	  private WebElement delectClientConformation;
	
	  @FindBy(xpath="//select[@class='form-control input-sm select input-xs']")
	  private WebElement cleintShowButton;
	  
	  @FindBy(xpath="//tr[@class='even' or @class='odd']")
	  private List<WebElement> rowsNumber;
	  
	  @FindBy(xpath="//a[@class='dropdown-toggle btn-round btn btn-default']")
	  private WebElement mainActionButton;
	  
	  @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers/export_csv']")
	  private  WebElement exportToExcelFile;
	  
	  @FindBy(xpath="//a[@id='excel']")
	  private WebElement exportToPdfFile;
	  	 
	  @FindBy(xpath="//a[@class='dropdown-toggle btn-round btn btn-default']")
	  private WebElement actionButton;
	 	
	  @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers/export_csv']")
	  private WebElement exportToExcelButton;
	 	 
	  @FindBy(xpath ="//a[text()='Next > ']")
	  private WebElement nextButton;
	    
	  @FindBy(xpath ="//div[@id='dynamic-table_info']")
	  private WebElement entryMsg;
	  
	 public void addingClientDetails() throws IOException {
		 boolean submitButtonDisplayed,submitButtonEnabled;
		 String name = ExcelUtility.getString(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String company = ExcelUtility.getString(2, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String addrs = ExcelUtility.getString(3, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String email = ExcelUtility.getString(4, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String msg =ExcelUtility.getString(5, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 PageUtility.clickOnElement(clientMoreInfo);
		 PageUtility.clickOnElement(AddClientButton);
		 PageUtility.enterStringValue(clientName, name);
		 PageUtility.enterStringValue(clientCompany, company);
		 PageUtility.enterStringValue(address, addrs);
		 PageUtility.enterStringValue(Clientemail, email);
		 WaitUtility.waitForElement(driver, submitButton);
		 submitButtonDisplayed = PageUtility.isElementDisplayed(submitButton);
		 Assert.assertTrue(submitButtonDisplayed);
		 submitButtonEnabled = PageUtility.isElementEnabled(submitButton);
		 Assert.assertTrue(submitButtonEnabled);
		 PageUtility.clickOnElement(submitButton);
		 WaitUtility.waitForElement(driver, clientNameTitle);
		 String actualMsg = PageUtility.getElementText(clientNameTitle);
		 String expectedMsg = msg;
		 Assert.assertEquals(actualMsg, expectedMsg,"Not Submitted");
		
		 
	 }
	 
	/* public void addingClientDetails2(String name,String company,String addrs,String email,String msg)  {
		 boolean submitButtonDisplayed,submitButtonEnabled;
		 PageUtility.clickOnElement(clientMoreInfo);
		 PageUtility.clickOnElement(AddClientButton);
		 DataProviderUtility.sentKeyValue(driver, clientName, name);
		 DataProviderUtility.sentKeyValue(driver, clientCompany, company);
		 DataProviderUtility.sentKeyValue(driver, address, addrs);
		 DataProviderUtility.sentKeyValue(driver, Clientemail, email);
		 WaitUtility.waitForElement(driver, submitButton);
		 submitButtonDisplayed = PageUtility.isElementDisplayed(submitButton);
		 submitButtonEnabled = PageUtility.isElementEnabled(submitButton);
		 if(submitButtonEnabled) {
		 PageUtility.clickOnElement(submitButton);
		 }
		 WaitUtility.waitForElement(driver, clientNameTitle);
		 String actualMsg = PageUtility.getElementText(clientNameTitle);
		 String expectedMsg = msg;
		 Assert.assertEquals(actualMsg, expectedMsg,"Not Submitted");
		 Assert.assertTrue(submitButtonDisplayed);
		 Assert.assertTrue(submitButtonEnabled);
	 }*/
	 
	public void delectingClientDetails() throws IOException {	
		 boolean blueActionButtonDisplayed,blueActionButtonEnabled,delectClientButtonDisplayed,delectClientButtonEnabled;
	     PageUtility.clickOnElement(clientMoreInfo);
	     PageUtility.enterStringValue(clientSearch, "vyshnavy3");
	     blueActionButtonDisplayed = PageUtility.isElementDisplayed(blueActionButton);
	     Assert.assertTrue(blueActionButtonDisplayed,"Not displayed");
	     blueActionButtonEnabled = PageUtility.isElementEnabled(blueActionButton);
	     if(blueActionButtonEnabled) {
		 PageUtility.clickOnElement(blueActionButton);
	     }
	     WaitUtility.waitForElement(driver, delectClientButton);
	     delectClientButtonDisplayed = PageUtility.isElementDisplayed(delectClientButton);
	     Assert.assertTrue(delectClientButtonDisplayed,"client button is not displayed");
	     delectClientButtonEnabled = PageUtility.isElementEnabled(delectClientButton);
	     if(delectClientButtonEnabled) {
		 PageUtility.clickOnElement(delectClientButton);
	     }
	     PageUtility.clickOnElement(delectClientConformation);	
	 }	 
	
	public void clientShowButtonVerification() throws IOException {
		 String value = ExcelUtility.getNumeric(7, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 int expectedNumber=10,actualNumber;
		 PageUtility.clickOnElement(clientMoreInfo);
		 PageUtility.selectDropdownbyValue(cleintShowButton, value);
		 actualNumber =rowsNumber.size();
		 Assert.assertEquals(actualNumber, expectedNumber,"Both numbers are not same");
	}

	public void clientdetailsExportToExcelFile() {
		  boolean mainActionButtonDisplayed,mainActionButtonEnabled,exportToExcelButtonDisplayed,exportToExcelButtonEnabled;
		  PageUtility.clickOnElement(clientMoreInfo);
		  mainActionButtonDisplayed=PageUtility.isElementDisplayed(mainActionButton);
		  Assert.assertTrue(mainActionButtonDisplayed);
		  mainActionButtonEnabled = PageUtility.isElementEnabled(mainActionButton);
		  Assert.assertTrue(mainActionButtonEnabled); 
		  PageUtility.clickOnElement(mainActionButton);
	      exportToExcelButtonDisplayed = PageUtility.isElementDisplayed(exportToExcelButton);
		  exportToExcelButtonEnabled = PageUtility.isElementEnabled(exportToExcelButton);
		  Assert.assertTrue(exportToExcelButtonEnabled);
		  PageUtility.clickOnElement(exportToExcelButton);
	      }
		   
	public void clientDetailsExportToPdfFile() {
	     boolean mainActionButtonDisplayed,mainActionButtonEnabled,exportToPdfFileDisplayed,exportToPdfFileEnabled;
		 PageUtility.clickOnElement(clientMoreInfo);
		 WaitUtility.waitForElement(driver, mainActionButton);
		 mainActionButtonDisplayed=mainActionButton.isDisplayed();
		 Assert.assertTrue(mainActionButtonDisplayed);
		 mainActionButtonEnabled = mainActionButton.isEnabled();
		 Assert.assertTrue(mainActionButtonEnabled);
		 PageUtility.clickOnElement(mainActionButton);
		 exportToPdfFileDisplayed = exportToPdfFile.isDisplayed();
		 Assert.assertTrue(exportToPdfFileDisplayed);
		 exportToPdfFileEnabled = exportToPdfFile.isEnabled();
		 Assert.assertTrue(exportToPdfFileEnabled);
		 PageUtility.clickOnElement(exportToPdfFile);
		 
	     }
	
	public void navigateToNextPageOnClickingNextOptionVerification() {
		boolean nextButtonIsDisplayed,nextButtonIsEnabled;
    	PageUtility.clickOnElement(clientMoreInfo);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("window.scrollBy(0,750)", "");
    	nextButtonIsDisplayed = PageUtility.isElementDisplayed(nextButton);
        nextButtonIsEnabled = PageUtility.isElementEnabled(nextButton);
    	PageUtility.clickOnElement(nextButton); 
    	String actualMsg = entryMsg.getText();
    	String expectedMsg = actualMsg;
    	Assert.assertTrue(nextButtonIsDisplayed);
    	Assert.assertTrue(nextButtonIsEnabled);
    	Assert.assertEquals(actualMsg, expectedMsg,"Both Messages are not Equal");
    	
}
}
		
	

