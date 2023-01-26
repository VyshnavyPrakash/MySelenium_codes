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
		 
		 @FindBy(xpath="//select[@class='form-control input-sm select input-xs' and @aria-controls='dynamic-table-completed']")
		 private WebElement showDropDown;
		 
		 @FindBy(xpath="//a[@href='#CompletedRepairs']")
	     private WebElement completeRepair;
		 
		 @FindBy(xpath="//a[@href='#CompletedRepairs']")
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
		 
	  public void rowNumberInShowButtonVerification() throws IOException {
	
		  int actualNumber;
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
		  PageUtility.clickOnElement(ExcelFileDownloadIcon);	  
		  Assert.assertTrue(excelFileIconPresent,"icon not present");
		  Assert.assertTrue(excelFileIconEnabled,"is not enabled");
	  }
	  
	  public void columnVisibilityVerification() {
		  PageUtility.clickOnElement(reperationMoreInfoIcon);	
		  int columnCount = tableColumnCount.size();
		  PageUtility.clickOnElement(columnVisibility);
		  for(WebElement column:columnButtons) {
				String text=column.getText();
				if(text.contentEquals("Name")) {
					column.click();
		           break;
	        }
		  }
		int columnCountAfter = tableColumnCount.size();
	  }
	  
	  public void rowCountWithSameNameVerification() {
		  int expectedNumber=38,actualNumber;
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  PageUtility.clickOnElement(searchButton);
		  PageUtility.enterStringValue(searchButton, "kiran1");
		  actualNumber = rowCount.size();
		  Assert.assertEquals(actualNumber, expectedNumber,"Both are not same");
	  }
	  
	  public void totalCompletedRepairRows() {
		  int expectedNumb = 38,actualNumber;
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  PageUtility.clickOnElement(completeRepair);
		  PageUtility.selectDropdownbyValue(showDropDown, "-1");
		  actualNumber = rowsNumber.size();
		  Assert.assertEquals(actualNumber, expectedNumb,"both numbers are not same");
		  
}
}
