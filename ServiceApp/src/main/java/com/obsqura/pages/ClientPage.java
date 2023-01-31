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
import com.obsqura.utilities.FakerUtility;
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
	  
	  @FindBy(xpath="//input[@id='telephone']")
	  private WebElement telephoneNumb;
	 
	  @FindBy(xpath="//button[@id='submit']")
	  private WebElement submitButton;
	  
	  @FindBy(xpath="//li[@class='parsley-required']")
	  private WebElement alertMsgButton;
	  
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
	    
	  @FindBy(xpath ="//ul[@class='pagination pagination-sm']//li")
	  private List<WebElement> nextPageNum;
	
	 public void addingClientDetails() throws IOException, InterruptedException {
		 boolean submitButtonDisplayed,submitButtonEnabled;
		 String name = ExcelUtility.getString(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String company = ExcelUtility.getString(2, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String addrs = ExcelUtility.getString(3, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String email = ExcelUtility.getString(4, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String expectedMsg =ExcelUtility.getString(5, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 WaitUtility.waitForElementClickable(driver, clientMoreInfo);
		 PageUtility.clickOnElement(clientMoreInfo);
		 WaitUtility.waitForElementClickable(driver, AddClientButton);
		 PageUtility.clickOnElement(AddClientButton);
		 PageUtility.enterStringValue(clientName, name);
		 PageUtility.enterStringValue(clientCompany, company);
		 PageUtility.enterStringValue(address, addrs);
		 PageUtility.enterStringValue(Clientemail, email);
		 WaitUtility.waitForElementClickable(driver, submitButton);
		 submitButtonEnabled = PageUtility.isElementEnabled(submitButton);
		 Assert.assertTrue(submitButtonEnabled);
		 PageUtility.clickOnElement(submitButton);
		 WaitUtility.waitForElement(driver, clientNameTitle);
		 String actualMsg = PageUtility.getElementText(clientNameTitle);
		 Assert.assertEquals(actualMsg, expectedMsg,"client details not Submitted");
	 }
	  
	 public void addingClientDetailsWithoutClientName() throws IOException {
		 String addrs = FakerUtility.address();
		 String email = FakerUtility.fakeValuesServiceEmail();
		 String telephone = FakerUtility.fakeValuesServiceMobile();
		 String expectedMsg =ExcelUtility.getString(13, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 PageUtility.clickOnElement(clientMoreInfo);
		 PageUtility.clickOnElement(AddClientButton);
		 PageUtility.enterStringValue(address, addrs);
		 PageUtility.enterStringValue(Clientemail, email);
		 PageUtility.enterStringValue(telephoneNumb, telephone);
		 boolean submitButtonEnabled = PageUtility.isElementEnabled(submitButton);
		 Assert.assertTrue(submitButtonEnabled);
		 WaitUtility.waitForElement(driver, submitButton);
		 PageUtility.clickOnElement(submitButton);
		 String actualMsg = PageUtility.getElementText(alertMsgButton);
		 Assert.assertEquals(actualMsg, expectedMsg,"Alert msg for client name not found");
	 }
	
	public void clientShowButtonVerification() throws IOException, InterruptedException{
		 String value = ExcelUtility.getNumeric(7, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 String expectedNumber = ExcelUtility.getNumeric(8, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		 WaitUtility.waitForElementClickable(driver, clientMoreInfo);
		 PageUtility.clickOnElement(clientMoreInfo);
		 Thread.sleep(2000);
		 PageUtility.selectDropdownbyValue(cleintShowButton, value);
		 int count = PageUtility.getElementRowSize(rowsNumber);
		 String actualNumber = Integer.toString(count);
		 Assert.assertEquals(actualNumber, expectedNumber,"row count is not same");
	}

	public void navigateToNextPageOnClickingNextOptionVerification() throws IOException {
		String pageNum = ExcelUtility.getNumeric(10, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		String expectedNum = ExcelUtility.getNumeric(11, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet3");
		boolean nextButtonIsDisplayed,nextButtonIsEnabled;
		WaitUtility.waitForElementClickable(driver, clientMoreInfo);
    	PageUtility.clickOnElement(clientMoreInfo);
    	PageUtility.ScrollBy(driver);
    	nextButtonIsDisplayed = PageUtility.isElementDisplayed(nextButton);
    	Assert.assertTrue(nextButtonIsDisplayed,"nextButtonIs not Displayed");
        nextButtonIsEnabled = PageUtility.isElementEnabled(nextButton);
        Assert.assertTrue(nextButtonIsEnabled,"nextButton Is not Enabled");
    	PageUtility.clickOnElement(nextButton); 
    	for(WebElement menu:nextPageNum) {
			String actualText=PageUtility.getElementText(menu);
			if(actualText.contentEquals(pageNum)) {
			Assert.assertEquals(actualText, expectedNum,"didn't naviagted to next page on clicking nextOption ");
				break;
	  } 
	 }
   }
 }

		
	

