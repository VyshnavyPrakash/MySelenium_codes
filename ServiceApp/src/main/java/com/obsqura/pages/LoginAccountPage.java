package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

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
	 private WebElement LoginSucessfullMsg;
	 
	 @FindBy(xpath="//i[@class='fa fa-exclamation-triangle']")
	 private WebElement alertIcon;
	 
	 @FindBy(xpath="//img[@class='user-image']")
	 private WebElement userImage;
	 
	 @FindBy(xpath="//a[@class='btn btn-default btn-flat']")
	 private WebElement signOut;
	
	 
  public void loginAccountVerification() throws IOException {
	  String expectedMsg,actualMsg = ExcelUtility.getString(3, 2, System.getProperty("user.dir")+ Constants.Constants.EXCELFILE, "Sheet1");
	  String username = ExcelUtility.getString(1, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String pass = ExcelUtility.getString(2, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.enterStringValue(userName, username);
	  PageUtility.enterStringValue(password, pass);
	  PageUtility.clickOnElement(loginButton);
      expectedMsg = LoginSucessfullMsg.getText();
      Assert.assertEquals(actualMsg, expectedMsg,"Login Unsucessfull");
      
  }
  public void loginWithWrongPassword() throws IOException {
	
	  String username = ExcelUtility.getString(1, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  String Wrongpass = ExcelUtility.getString(4, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet1");
	  PageUtility.enterStringValue(userName, username);
	  PageUtility.enterStringValue(password, Wrongpass);
	  PageUtility.clickOnElement(loginButton);
	  boolean loginButtonDisplayed = loginButton.isDisplayed();
	  Assert.assertTrue(loginButtonDisplayed,"Navigated to next page");
	  
  }
  
  public void logoutVerification() {
	  
	  PageUtility.clickOnElement(userImage);
	  boolean signOutDisplayed =  signOut.isDisplayed();
	  boolean signOutEnabled = signOut.isEnabled();
	  if(signOutEnabled) {
		  PageUtility.clickOnElement(signOut); 
	  }
    }
  
  }
		
  	
		
		
  
  

