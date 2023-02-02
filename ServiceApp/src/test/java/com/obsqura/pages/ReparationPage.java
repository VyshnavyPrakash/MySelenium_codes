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
		 @FindBy(xpath="//tr[@class='warranty_row odd' or @class='warranty_row even']")
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
		 
		 @FindBy(xpath="//tr[@class='invoice_link' and@role='row']")
		 private List<WebElement> rowNumbPendingRepair;
		 
		 @FindBy(xpath="//select[@name='dynamic-table-completed_length']")
		 private WebElement showButtonCompletedRepair;
		 
	  public void rowNumberInShowButtonVerification() throws IOException {
		  String expectedNumber = ExcelUtility.getNumeric(0, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String value = ExcelUtility.getNumeric(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, completeRepair);
		  PageUtility.clickOnElement(completeRepair);
		  PageUtility.selectDropdownbyValue(showButtonCompletedRepair, value);
		  int size = PageUtility.getElementRowSize(rowsNumber);
		  String actualNumber = Integer.toString(size);
		  Assert.assertEquals(expectedNumber, actualNumber,"When selecting showButton, the right amount of rows will not appear");  
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
	  
	  public void columnVisibilityVerification() throws IOException {
		  String textContent = ExcelUtility.getString(4, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String expectedCount = ExcelUtility.getNumeric(5, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);	
		  WaitUtility.waitForElementClickable(driver, columnVisibility);
		  PageUtility.clickOnElement(columnVisibility);
		  PageUtility.selectElementFromListUsingGetText(columnButtons, textContent);
		  int columnCountAfter = PageUtility.getElementColumnSize(tableColumnCount);
		  String actualCount = Integer.toString(columnCountAfter);
		  Assert.assertEquals(actualCount, expectedCount,"Column count after removing name is not as expected");
	   }
	  
	  public void rowCountWithSameNameVerification() throws IOException {
		  String textContent = ExcelUtility.getString(7, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String expectedCount = ExcelUtility.getNumeric(8, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, searchButton);
		  PageUtility.clickOnElement(searchButton);
		  PageUtility.enterStringValue(searchButton, textContent);
		  int count = PageUtility.getElementRowSize(rowCount);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"row count of person with same name are not as expected");
	   }
	  
	  public void totalCompletedRepairRows() throws IOException {
		  String value = ExcelUtility.getNumeric(10, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String expectedCount = ExcelUtility.getNumeric(11, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, completeRepair);
		  PageUtility.clickOnElement(completeRepair);
		  PageUtility.selectDropdownbyValue(showDropDown, value);
		  int count = PageUtility.getElementRowSize(rowsNumber);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"total Completed Repair Rows count is not as expected");	  
       }
	  
	  public void columnNumberVerification() throws IOException {
		  String expectedCount = ExcelUtility.getNumeric(2, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  int count = PageUtility.getElementColumnSize(columnNumb);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"column count of pending repairs is not as expected");
	  }
	  public void rowNumberInShowButtonVerificationForPendingRepairs() throws IOException {
		  String expectedNumber = ExcelUtility.getNumeric(0, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  String value = ExcelUtility.getNumeric(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE, "Sheet5");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  PageUtility.selectDropdownbyValue(showNumberOfTables, value);
		  int size = PageUtility.getElementRowSize(rowNumbPendingRepair);
		  String actualNumber = Integer.toString(size);
		  Assert.assertEquals(expectedNumber, actualNumber,"When selecting showButton, the right amount of rows will not appear");  
	   }
	  
	 
	   }
	  
       
     
