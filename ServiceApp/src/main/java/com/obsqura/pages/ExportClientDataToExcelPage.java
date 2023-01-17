package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class ExportClientDataToExcelPage {
	WebDriver driver;
	public ExportClientDataToExcelPage(WebDriver driver) {
		this.driver = driver;
	}
    @FindBy(xpath="//input[@id='identity']")
	private WebElement userName;
      
    @FindBy(xpath="//input[@id='password']")
 	private WebElement password;
 	 
 	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
 	private WebElement loginButton;
 	 
 	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement clientMoreInfo;
 	 
 	@FindBy(xpath="//a[@class='dropdown-toggle btn-round btn btn-default']")
	private WebElement actionButton;
 	
 	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers/export_csv']")
	private WebElement exportToExcelButton;
 	 
 	
  public void clientDataConvertToExcelVerification() throws IOException {
	  String username = ExcelUtility.getString(1, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\ServiceApp.xlsx", "Sheet1");
	  String pass = ExcelUtility.getString(2, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\ServiceApp.xlsx", "Sheet1");
	  PageUtility.enterStringValue(userName, username);
	  PageUtility.enterStringValue(password, pass);
	  PageUtility.clickOnElement(loginButton);
	  PageUtility.clickOnElement(clientMoreInfo);
	  PageUtility.clickOnElement(actionButton);
      WebElement ExcelFile =exportToExcelButton;
      PageUtility.clickOnElement(ExcelFile);
          
  }
}
