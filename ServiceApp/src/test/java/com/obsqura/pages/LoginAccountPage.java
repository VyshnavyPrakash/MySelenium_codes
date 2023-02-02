package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

 public class LoginAccountPage {
	   WebDriver driver;
 public LoginAccountPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
		}
	 @FindBy(xpath="//input[@id='identity']")
	 private WebElement userName;
	
	 @FindBy(xpath="//input[@id='password']")
	 private WebElement password;
	 
	 @FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	 private WebElement loginButton;
	
	 @FindBy(xpath="//p[text()='Logged In Successfully'] ")
	 private WebElement LoginSuccessfulMsg;
	 
	 @FindBy(xpath="//a[text()='Back to home page']")
	 private WebElement backToLogin;
	 
	 @FindBy(xpath="//i[@class='fa fa-exclamation-triangle']")
	 private WebElement alertIcon;
	 
	 @FindBy(xpath="//span[text()='Joe Jacobs' and@class='hidden-xs']")
	 private WebElement userImage;
	 
	 @FindBy(xpath="//a[@class='btn btn-default btn-flat']")
	 private WebElement signOut;
	 
	 @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service//panel/login/forgot_password']")
	 private WebElement forgotPassword;
	 
	 @FindBy(xpath="//input[@id = 'identity']")
	 private WebElement resetEmail;
	 
	 @FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	 private WebElement resetEmailSubmitButton;
	  
	 @FindBy(xpath="//div[@id ='infoMessage']")
	 private WebElement infoMsg;
	 
	 @FindBy(xpath="//a[text()=' ← Back to login!']")
	 private WebElement backToLoginOption;
	 
	 @FindBy(xpath="//div[@id ='infoMessage']")
	 private WebElement signoutMsg;
	 
  public void loginAccountVerification() throws IOException {
	  String actualMsg,expectedMsg = ExcelUtility.getString(3, 3, System.getProperty("user.dir")+ Constants.Constants.EXCELFILE, "Sheet1");
	  String username = ExcelUtility.getString(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String pass = ExcelUtility.getString(2, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.enterStringValue(userName, username);
	  PageUtility.enterStringValue(password, pass);
	  boolean isLoginButtonEnabled = PageUtility.isElementEnabled(loginButton);
	  Assert.assertTrue(isLoginButtonEnabled,"login button is not enabled");
	  PageUtility.clickOnElement(loginButton);
	  boolean isLoginSuccessfulMsgDisplayed = PageUtility.isElementDisplayed(LoginSuccessfulMsg);
	  Assert.assertTrue(isLoginSuccessfulMsgDisplayed,"login successful msg is not displayed" );
	  actualMsg = PageUtility.getElementText(LoginSuccessfulMsg);
      Assert.assertEquals(actualMsg, expectedMsg,"Login Successful message is not correct");    
      }
  
  public void loginWithWrongPassword() throws IOException {
	  String username = ExcelUtility.getString(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String Wrongpass = ExcelUtility.getString(4, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String expectedMsg = ExcelUtility.getString(6, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.enterStringValue(userName, username);
	  PageUtility.enterStringValue(password, Wrongpass);
	  boolean isloginButtonEnabled = PageUtility.isElementEnabled(loginButton);
	  Assert.assertTrue(isloginButtonEnabled,"login button is not enabled");
	  PageUtility.clickOnElement(loginButton);
	  boolean isBackToLoginTextDisplayed = PageUtility.isElementDisplayed(backToLogin);
	  Assert.assertTrue(isBackToLoginTextDisplayed);
	  String actualMsg = PageUtility.getElementText(backToLogin);
	  Assert.assertEquals(actualMsg, expectedMsg,"Back to home Page not happened");
      }
  
  public void loginWithWrongUserName() throws IOException {
	  String wrongUsername = ExcelUtility.getString(8, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String pass = ExcelUtility.getString(9, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String expectedUrl = ExcelUtility.getString(10, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.enterStringValue(userName, wrongUsername);
	  PageUtility.enterStringValue(password, pass);
	  boolean isloginButtonEnabled = PageUtility.isElementEnabled(loginButton);
	  Assert.assertTrue(isloginButtonEnabled,"login button is not enabled");
	  WaitUtility.waitForElementClickable(driver, loginButton);
	  PageUtility.clickOnElement(loginButton);
	  String actualUrl = driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl, expectedUrl,"Not in the login page");
      }
  
  public void forgotPasswordVerification() throws IOException {
	  String actualMsg,expectedMsg=ExcelUtility.getString(12, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String email = ExcelUtility.getString(13, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  boolean isforgotPasswordOptionAvailable = PageUtility.isElementDisplayed(forgotPassword);
	  Assert.assertTrue(isforgotPasswordOptionAvailable,"forgot password option is not available");
	  PageUtility.clickOnElement(forgotPassword);
	  PageUtility.enterStringValue(resetEmail,email);
	  PageUtility.clickOnElement(resetEmailSubmitButton);
	  actualMsg = PageUtility.getElementText(infoMsg);
	  Assert.assertEquals(actualMsg, expectedMsg,"An info message didn't appeared while senting email for reseting");
      }
  
  public void backToLoginVerification() throws IOException {
	  String expectedPage = ExcelUtility.getString(15, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.clickOnElement(forgotPassword);
	  PageUtility.clickOnElement(backToLoginOption);
	  String actualPage = driver.getCurrentUrl();
	  Assert.assertEquals(actualPage, expectedPage,"didn't navigated to home page");
      }
  
  public void logoutVerification() throws IOException {
	  String expectedMsg = ExcelUtility.getString(17, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.clickOnElement(userImage);
	  boolean issignOutButtonAvailable = PageUtility.isElementDisplayed(signOut);
	  Assert.assertTrue(issignOutButtonAvailable,"signout button not Displayed");
	  boolean isSignOutButtonEnabled = PageUtility.isElementEnabled(signOut);
	  Assert.assertTrue(isSignOutButtonEnabled,"Signout button is not enabled");
      PageUtility.clickOnElement(signOut); 
      boolean isSignoutMsgDisplayed = PageUtility.isElementDisplayed(signoutMsg);
      Assert.assertTrue(isSignoutMsgDisplayed,"Signout message is not displayed");
      String actualMsg = PageUtility.getElementText(signoutMsg);
	  Assert.assertEquals(actualMsg, expectedMsg,"Logout message is not displayed");
      }
  
  }
 
     
		
  	
		
		
  
  

