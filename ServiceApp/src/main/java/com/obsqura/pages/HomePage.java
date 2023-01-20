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
	    private WebElement sentButton;
	   
	    @FindBy(xpath="//input[@id='emailto_']")
	    private WebElement emailFileld;
	   
	    @FindBy(xpath="//input[@id='subject_']")
	    private WebElement subjectFileld;
	   
	    @FindBy(xpath="//textarea[@id='body_']")
	    private WebElement msgFileld;
	   
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
		private WebElement EmailIdField ;
		
		@FindBy(xpath="//input[@id='subject_']")
		private WebElement subjectField ;
		
		@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[1]")
		private WebElement sendButton ;
		
		@FindBy(xpath="//ul[@id='parsley-id-9']")
		private WebElement MsgField ;
		
		@FindBy(xpath="//button[@class='fc-agendaWeek-button fc-button fc-state-default']")
		private WebElement weekButton ;
		
		@FindBy(xpath="//button[@class='fc-agendaDay-button fc-button fc-state-default fc-corner-right']")
		private WebElement dayButton ;
		
		@FindBy(xpath="//button[@class='fc-today-button fc-button fc-state-default fc-corner-left fc-corner-right fc-state-disabled']")
		private WebElement todayButton ;
	        
	 public void quickSMSSentVerification() throws IOException {	
          boolean sentButtonDisplayed,sentButtonEnabled;
		  String num = ExcelUtility.getNumeric(1, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet2");
		  String smsMsg = ExcelUtility.getString(2, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet2");
	      PageUtility.enterStringValue(number, num);
	      PageUtility.enterStringValue(sms, smsMsg);
	      sentButtonDisplayed = sentButton.isDisplayed();
	      sentButtonEnabled = sentButton.isEnabled();
	      if(sentButtonEnabled) {
	      PageUtility.clickOnElement(sentButton);	      
	      }	 
	      Assert.assertTrue(sentButtonDisplayed);
	      Assert.assertTrue(sentButtonEnabled);
	      }
	 
	 public void quickEmailSentVerification() throws IOException {	 
		  boolean emailSentButtonDisplayed,emailSentButtonEnabled;
		  String email = ExcelUtility.getString(6, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet2");
		  String subject = ExcelUtility.getString(7, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet2");
		  String msg =ExcelUtility.getString(8, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet2");
	      PageUtility.enterStringValue(emailFileld, email);
	      PageUtility.enterStringValue(subjectFileld, subject);
	      PageUtility.enterStringValue(msgFileld, msg);
	      emailSentButtonDisplayed = emailSentButton.isDisplayed();
	      emailSentButtonEnabled = emailSentButton.isEnabled();
	      if(emailSentButtonEnabled) {
	      PageUtility.clickOnElement(emailSentButton);
	      }
	      Assert.assertTrue(emailSentButtonDisplayed,"Email sent button is not displayed");
	      Assert.assertTrue(emailSentButtonEnabled,"Email sent button is not enabled");
	      }
	 
	 public void quickemailFieldWithoutMsg() throws IOException {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("window.scrollBy(0,750)", "");
		 String Email_Id =ExcelUtility.getString(6, 2, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet1");
		 String sms= ExcelUtility.getString(7, 2, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet1");
		 String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet1");
		 String actualMsg = null;
		 PageUtility.enterText(EmailIdField, Email_Id);
		 PageUtility.enterText(subjectField, sms);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=MsgField.getText();
		 Assert.assertEquals(expectedMsg,actualMsg,"Message not send");
		 }
	 
	 public void quickemailFieldWithoutSubject() throws IOException {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("window.scrollBy(0,750)", "");
		 String Email_Id =ExcelUtility.getString(6, 2, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");
		 String sub= ExcelUtility.getString(7, 2, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 String expectedMsg= ExcelUtility.getString(9, 2, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet2");
		 String actualMsg = null;
		 PageUtility.enterText(EmailIdField, Email_Id);
	     PageUtility.enterStringValue(subjectFileld, sub);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=MsgField.getText();
		 Assert.assertEquals(expectedMsg,actualMsg,"Message not send");
	     } 
	 
	 public void navigateToQualityAlertVerification() {
		 String actualMsg=null, expectedMsg = "Ip013 Iphone 13 1.0000 2.0000";	 
		 boolean qualityAlertIconDisplayed = qualityAlertIcon.isDisplayed();
		 Assert.assertTrue(qualityAlertIconDisplayed);
		 boolean qualityAlertIconEnabled = qualityAlertIcon.isEnabled();
		 Assert.assertTrue(qualityAlertIconEnabled);
		 PageUtility.clickOnElement(qualityAlertIcon);
		 boolean qualityAlertNavigationaIconisEnabled = qualityAlertNavigationaIcon.isEnabled();
		 Assert.assertTrue(qualityAlertNavigationaIconisEnabled);
		 PageUtility.clickOnElement(qualityAlertNavigationaIcon);
		 for(WebElement row:rowList) {
		 actualMsg =row.getText();
		 boolean compareElement = actualMsg.contentEquals(expectedMsg);
		  if(compareElement) {			
			  break;	  
		  }
		  Assert.assertEquals(actualMsg, expectedMsg,"content not equals");	
		  }	 
	     }
	 
	 public void calenderViewVerification() {
		  boolean weekButtonIsDisplayed= weekButton.isDisplayed();
		  boolean weekButtonIsEnabled =  weekButton.isEnabled();
		  if(weekButtonIsEnabled) {
			 weekButton.click();
		  }
		  boolean dayButtonDisplayed = dayButton.isDisplayed();
		  boolean dayButtonEnabled = dayButton.isEnabled();
		  if(dayButtonEnabled) {
			 dayButton.click();
	      }
		  Assert.assertTrue(weekButtonIsDisplayed,"button not displayed");
		  Assert.assertTrue(weekButtonIsEnabled,"button not enabled");
		  Assert.assertTrue(dayButtonDisplayed,"button not displayed");
		  Assert.assertTrue(dayButtonEnabled,"button not enabled");
        }
      }
