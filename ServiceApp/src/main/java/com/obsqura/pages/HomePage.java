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
	        
	
	 public void quickemailFieldWithoutMsg() throws IOException {
		 PageUtility.ScrollBy(driver);
		 String Email_Id =ExcelUtility.getString(6, 2, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet1");
		 String sms= ExcelUtility.getString(7, 2, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet1");
		 String expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir") + Constants.Constants.EXCELFILE,"Sheet1");
		 String actualMsg = null;
		 PageUtility.enterText(EmailIdField, Email_Id);
		 PageUtility.enterText(subjectField, sms);
		 PageUtility.clickOnElement(sendButton);
		 actualMsg=PageUtility.getElementText(MsgField);
		 Assert.assertEquals(expectedMsg,actualMsg,"Message not send");
		 }
	 
	 public void quickemailFieldWithoutSubject() throws IOException {
		 PageUtility.ScrollBy(driver);
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
	 
	 public void navigateToQualityAlertVerification() throws IOException {
		 String actualMsg=null, expectedMsg = ExcelUtility.getString(11, 2, System.getProperty("user.dir") +Constants.Constants.EXCELFILE,"Sheet2");;	 
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
		  Assert.assertTrue(compareElement,"actual and expected message contents are not same");			
		  Assert.assertEquals(actualMsg, expectedMsg,"content not equals");	
		  }	 
	     }
	 
	 public void calenderViewVerification() {
		  boolean isweekButtonIsDisplayed= weekButton.isDisplayed();
		  Assert.assertTrue(isweekButtonIsDisplayed,"weekButton not displayed");
		  PageUtility.clickOnElement(weekButton);
		  boolean isdayButtonDisplayed = dayButton.isDisplayed();
		  Assert.assertTrue(isdayButtonDisplayed,"button not displayed");
		  boolean dayButtonEnabled = dayButton.isEnabled();
		  Assert.assertTrue(dayButtonEnabled,"button not enabled");
		  PageUtility.clickOnElement(dayButton);
	      
		  
        }
      }
