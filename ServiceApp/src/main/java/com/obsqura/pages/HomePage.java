package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.FakerUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	  }
	    @FindBy(xpath="//input[@id='phone_number']")
	    private WebElement number;
	 
	    @FindBy(xpath="//textarea[@placeholder='SMS Text']")
	    private WebElement sms;
	 
	    @FindBy(xpath="//button[@class='pull-right btn btn-default' and @form='send_quicksms']")
	    private WebElement sentButtonSMS;
	   
	    @FindBy(xpath="//input[@id='emailto_']")
	    private WebElement emailFileld;
	   
	    @FindBy(xpath="//input[@id='subject_']")
	    private WebElement subjectFileld;
	   
	    @FindBy(xpath="//textarea[@id='body_']")
	    private WebElement msgFileldQuickEmail;
	   
	    @FindBy(xpath="//button[@form='send_email_form']")
	    private WebElement emailSentButton;
	   
	    @FindBy(xpath="//a[@class='btn blightOrange tip']")
	    private WebElement qualityAlertIcon;
	   
	    @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reports/quantity_alerts']")
	    private WebElement qualityAlertNavigationaIcon;
	   
	    @FindBy(xpath="//input[@class='form-control input-sm input-xs']")
	    private WebElement searchBox;
	   
	    @FindBy(xpath="//tr[@class='odd' or @class='even']")
	    private List<WebElement> rowList;
	    
	    @FindBy(xpath="//input[@id='emailto_']")
		private WebElement EmailIdField;
		
		@FindBy(xpath="//input[@id='subject_']")
		private WebElement subjectField;
		
		@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[1]")
		private WebElement sendButton;
		
		@FindBy(xpath="//ul[@id='parsley-id-9']")
		private WebElement MsgField;
		
		@FindBy(xpath="//button[@class='fc-agendaWeek-button fc-button fc-state-default']")
		private WebElement weekButton;
		
		@FindBy(xpath="//button[@class='fc-agendaDay-button fc-button fc-state-default fc-corner-right']")
		private WebElement dayButton;
		
		@FindBy(xpath="//button[@class='fc-today-button fc-button fc-state-default fc-corner-left fc-corner-right fc-state-disabled']")
		private WebElement todayButton;
		
		@FindBy(xpath="//a[@ href='https://qalegend.com/mobile_service/panel/inventory']")
	    private WebElement inventoryProductMoreInfoOption;
	    
		@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation'] ")
		private WebElement reperationMoreInfoIcon;
		
		@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
		private WebElement clientMoreInfo;
		
		@FindBy(xpath="//li[text()='This value is required.']")
		private WebElement notSentalert;
		
		@FindBy(xpath="//li[@class='parsley-required']")
		private WebElement alertMsgSMS;
		
		
		  
	 public void quickemailFieldWithoutMsg() throws IOException {
		 PageUtility.ScrollBy(driver);
		 String actualMsg;
		 String Email_Id =FakerUtility.fakeValuesServiceEmail();
		 String sub= ExcelUtility.getString(7, 3, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 String expectedMsg= ExcelUtility.getString(9, 3, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 PageUtility.enterText(EmailIdField, Email_Id);
		 PageUtility.enterStringValue(subjectFileld, sub);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=PageUtility.getElementText(notSentalert);
		 Assert.assertEquals(expectedMsg,actualMsg,"No alert message obtained");
		 }
	 
	 public void quickemailFieldWithoutSubject() throws IOException {
		 PageUtility.ScrollBy(driver);
		 String actualMsg;
		 String Email_Id =FakerUtility.fakeValuesServiceEmail();
		 String msg= FakerUtility.cityName();
		 String expectedMsg= ExcelUtility.getString(9, 3, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 PageUtility.enterText(EmailIdField, Email_Id);
		 PageUtility.enterStringValue(msgFileldQuickEmail, msg);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=PageUtility.getElementText(notSentalert);
		 Assert.assertEquals(expectedMsg,actualMsg,"not alert message obtained");
	     } 
	 
	 public void quickemailFieldWithoutEmail() throws IOException {
		 PageUtility.ScrollBy(driver);
		 String msg =ExcelUtility.getString(8, 3, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");
		 String sub= ExcelUtility.getString(7, 3, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 String expectedMsg= ExcelUtility.getString(9, 3, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 String actualMsg = null;
	     PageUtility.enterStringValue(subjectFileld, sub);
	     PageUtility.enterStringValue(msgFileldQuickEmail, msg);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=PageUtility.getElementText(notSentalert);
		 Assert.assertEquals(expectedMsg,actualMsg,"Message not send");
	     } 
	 
	 public void navigateToQualityAlertVerification() throws IOException, InterruptedException {
		 String actualMsg, expectedMsg = ExcelUtility.getString(11, 3, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");;	 
		 WaitUtility.waitForElementClickable(driver, qualityAlertIcon);
		 PageUtility.clickOnElement(qualityAlertIcon);
		 boolean qualityAlertNavigationaIconisEnabled = qualityAlertNavigationaIcon.isEnabled();
		 Assert.assertTrue(qualityAlertNavigationaIconisEnabled);
		 WaitUtility.waitForElementClickable(driver, qualityAlertNavigationaIcon);
		 PageUtility.clickOnElement(qualityAlertNavigationaIcon);
		 Thread.sleep(1000);
		 for(WebElement row:rowList) {
		 actualMsg =row.getText();
		 boolean compareElement = actualMsg.contentEquals(expectedMsg);
		 Assert.assertTrue(compareElement,"actual and expected message contents are not same");			
		 Assert.assertEquals(actualMsg, expectedMsg,"content not equals");
		 break;
		 }	 
	    }
	 
	 public void navigateToInventoryPageVerification() throws IOException {
		 String expectedPage = ExcelUtility.getString(14, 3, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");
		 PageUtility.clickOnElement(inventoryProductMoreInfoOption);
		 String actualPage = driver.getCurrentUrl();
		 Assert.assertEquals(expectedPage, actualPage,"Navigation didn't occur");
	    }
	 
	 public void clientPageVerification() throws IOException {
		 String expectedPage = ExcelUtility.getString(15, 3, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");
		 PageUtility.clickOnElement(clientMoreInfo);
		 String actualPage = driver.getCurrentUrl();
		 Assert.assertEquals(expectedPage, actualPage,"Navigation didn't occur");
	    }
	 
	 public void reparationPageVerification() throws IOException {
		 String expectedPage = ExcelUtility.getString(16, 3, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");
		 PageUtility.clickOnElement(reperationMoreInfoIcon);
		 String actualPage = driver.getCurrentUrl();
		 Assert.assertEquals(expectedPage, actualPage,"Navigation didn't occur");
	    }
       

     public void quickSMSFieldWithoutMsg() throws IOException {
    	 String numb = FakerUtility.cellPhone();
    	 String expectedMsg = ExcelUtility.getString(20, 3, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");
    	 PageUtility.enterStringValue(number, numb);
    	 PageUtility.clickOnElement(sentButtonSMS);
    	 String actualAlertMsg = PageUtility.getElementText(alertMsgSMS);
    	 Assert.assertEquals(actualAlertMsg, expectedMsg,"alert message is not correct");
    	 
     }
}
