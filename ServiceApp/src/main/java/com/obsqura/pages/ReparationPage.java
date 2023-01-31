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
import com.obsqura.utilities.WaitUtility;

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
		 
		 @FindBy(xpath="//select[@class='form-control input-sm select input-xs' and @aria-controls ='dynamic-table']")
		 private WebElement showNumberOfTables;
		 
		 @FindBy(xpath="//select[@class='form-control input-sm select input-xs' and @aria-controls='dynamic-table-completed']")
		 private WebElement showDropDown;
		 
		 @FindBy(xpath="//a[@href='#CompletedRepairs']")
	     private WebElement completeRepair;
		 
		 @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation/export?'] ")
	     private WebElement ExcelFileDownloadIcon;
		 
		 @FindBy(xpath="//div[@class='dt-button-collection fixed two-column']//button")
	     private List<WebElement> columnButtons;
		 
		 @FindBy(xpath="//th[@aria-controls='dynamic-table']")
	     private List<WebElement> tableColumnCount;
		 
		 @FindBy(xpath="(//span[text()='Column visibility'])[1]")
		 private WebElement columnVisibility;
		 
		 @FindBy(xpath="//div[@class='dt-button-background']")
		 private WebElement buttonBackaGround;
		 
		 @FindBy(xpath="//input[@class='form-control input-sm input-xs' and @aria-controls='dynamic-table']  ")
		 private WebElement searchButton;
		 
		 @FindBy(xpath="//tr[@class='invoice_link']")
		 private List<WebElement> rowCount;
		 
		 @FindBy(xpath="//th[@class='sorting' and @aria-controls='dynamic-table']")
		 private List<WebElement> columnNumb;
		 
	  public void rowNumberInShowButtonVerification() throws IOException, InterruptedException {
		  String expectedNumber = ExcelUtility.getNumeric(0, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  Thread.sleep(1000);
		  PageUtility.clickOnElement(completeRepair);
		  Select obj = new Select(showNumberOfTables);
		  obj.selectByValue("100");
		  int size = rowsNumber.size();
		  String actualNumber = Integer.toString(size);
		  Assert.assertEquals(expectedNumber, actualNumber,"Both the numbers are not same");  
	   }
	  
	  public void downloadingReparationExcelSheet() { 
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  PageUtility.clickOnElement(completeRepair);
		  boolean excelFileIconPresent = ExcelFileDownloadIcon.isDisplayed();
		  Assert.assertTrue(excelFileIconPresent,"icon not present");
		  boolean excelFileIconEnabled = ExcelFileDownloadIcon.isEnabled();
		  Assert.assertTrue(excelFileIconEnabled,"is not enabled");
		  PageUtility.clickOnElement(ExcelFileDownloadIcon);	  
	   }
	  
	  public void columnVisibilityVerification() throws IOException, InterruptedException {
		  String textContent = ExcelUtility.getString(4, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String expectedCount = ExcelUtility.getNumeric(5, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);	
		  WaitUtility.waitForElementClickable(driver, columnVisibility);
		  PageUtility.clickOnElement(columnVisibility);
		 Thread.sleep(1000);
		  PageUtility.selectElementFromListUsingGetText(columnButtons, textContent);
		  int columnCountAfter = PageUtility.getElementColumnSize(tableColumnCount);
		  String actualCount = Integer.toString(columnCountAfter);
		  Assert.assertEquals(actualCount, expectedCount,"Column count is not as expected");
	   }
	  
	  public void rowCountWithSameNameVerification() throws IOException, InterruptedException {
		  String textContent = ExcelUtility.getString(7, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String expectedCount = ExcelUtility.getNumeric(8, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, searchButton);
		  PageUtility.clickOnElement(searchButton);
		  PageUtility.enterStringValue(searchButton, textContent);
		  Thread.sleep(1000);
		  int count = PageUtility.getElementRowSize(rowCount);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"row count are not same");
	   }
	  
	  public void totalCompletedRepairRows() throws IOException, InterruptedException {
		  String value = ExcelUtility.getNumeric(10, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String expectedCount = ExcelUtility.getNumeric(11, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, completeRepair);
		  PageUtility.clickOnElement(completeRepair);
		  Thread.sleep(2000);
		  PageUtility.selectDropdownbyValue(showDropDown, value);
		  int count = PageUtility.getElementRowSize(rowsNumber);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"both numbers are not same");	  
       }
	  
	  public void columnNumberVerification() throws IOException, InterruptedException {
		  String expectedCount = ExcelUtility.getNumeric(2, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  Thread.sleep(2000);
		  int count = PageUtility.getElementColumnSize(columnNumb);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"both the column count are same");
	  }
	  public void rowNumberInShowButtonVerificationForPendingRepairs() throws IOException, InterruptedException {
		  String expectedNumber = ExcelUtility.getNumeric(0, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  Thread.sleep(1000);
		  Select obj = new Select(showNumberOfTables);
		  obj.selectByValue("25");
		  int size = rowsNumber.size();
		  String actualNumber = Integer.toString(size);
		  Assert.assertEquals(expectedNumber, actualNumber,"Both the numbers are not same");  
	   }
	  
	 
	   }
	  
       
     
