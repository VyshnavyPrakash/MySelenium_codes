package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class ReparationPage {
	WebDriver driver;
	
	 public ReparationPage(WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
	}
		  
		 @FindBy(xpath="//tr[@class='warranty_row even' or @class ='warranty_row odd']")
		 private List<WebElement> rowsNumber;
		  
		 @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation'] ")
		 private WebElement reperationMoreInfoIcon;
		 
		 @FindBy(xpath="//select[@class='form-control input-sm select input-xs' and @name ='dynamic-table_length']")
		 private WebElement showNumberOfTables;
		 
		 @FindBy(xpath="//a[@href='#CompletedRepairs']")
	     private WebElement completeRepair;
		 
		 @FindBy(xpath="//a[@href='#CompletedRepairs']")
	     private WebElement ExcelFileDownloadIcon;
		 
		
	  public void rowNumberInShowButtonVerification() throws IOException {
		  int expectedNumber=10,actualNumber;
		  PageUtility.clickOnElement(reperationMoreInfoIcon);	
		  PageUtility.clickOnElement(completeRepair);
		  Select obj = new Select(showNumberOfTables);
		  obj.selectByValue("10");
		  actualNumber = rowsNumber.size();
		  Assert.assertEquals(expectedNumber, actualNumber,"Both the numbers are not same");  
	  }
	  public void downloadingReparationExcelSheet() { 
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  PageUtility.clickOnElement(completeRepair);
		  boolean excelFileIconPresent = ExcelFileDownloadIcon.isDisplayed();
		  boolean excelFileIconEnabled = ExcelFileDownloadIcon.isEnabled();
		  Assert.assertTrue(excelFileIconPresent,"icon not present");
		  Assert.assertTrue(excelFileIconEnabled,"is not enabled");
		  PageUtility.clickOnElement(ExcelFileDownloadIcon);	  
	  }
}
