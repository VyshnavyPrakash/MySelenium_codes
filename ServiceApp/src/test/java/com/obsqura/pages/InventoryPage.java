package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class InventoryPage {

	WebDriver driver;
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	    @FindBy(xpath="//a[@ href='https://qalegend.com/mobile_service/panel/inventory']")
	    private WebElement inventoryProductMoreInfoOption;
	    
	    @FindBy(xpath="//i[@class='icon fa fa-tasks tip']")
	    private WebElement actionsIcon;
	    
	    @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/inventory/add']")
	    private WebElement addProduct;
	    
	    @FindBy(xpath="//span[@class='select2-results']//li")
	    private List<WebElement> productType;
	    
	    @FindBy(xpath="//input[@id='name']")
	    private WebElement productName;
	    
	    @FindBy(xpath="//i[@class='fa fa-random']")
	    private WebElement productCode;
	    
	    @FindBy(xpath="//select[@id='category']")
	    private WebElement category;
	    
	    @FindBy(xpath="//input[@id='quantity']")
	    private WebElement productQuality;
	    
	    @FindBy(xpath="//select[@id='supplier']")
	    private WebElement productSupplier;
	    
	    @FindBy(xpath="//input[@id='unit']")
	    private WebElement productUnit;
	    
	    @FindBy(xpath="//input[@id='cost']")
	    private WebElement productCost;
	  
	    @FindBy(xpath="//input[@id='price']")
	    private WebElement productPrice;
	       
	    @FindBy(xpath="//select[@id='model']")
	    private WebElement productModel;
	    
	    @FindBy(xpath="//input[@id='product_image']")
	    private WebElement productImage;
	    
	    @FindBy(xpath="//input[@class='btn btn-primary']")
	    private WebElement submit;
	    
	    @FindBy(xpath="//tr[@class='product_link']")
	    private List<WebElement> rowNumber;
	    
	    @FindBy(xpath="//button[@class='btn btn-default btn-xs btn-primary dropdown-toggle']")
		private WebElement blueActionButton;
	    
	    @FindBy(xpath ="//a[@class='tip btn btn-danger bpo'] ")
	    private WebElement delectButton;
	    
	    @FindBy(xpath ="//a[@class='btn btn-danger']")
	    private WebElement delectConformation;
	    
	    @FindBy(xpath ="//section[@class='content-header']")
	    private WebElement homeHeader;
	      
	    @FindBy(xpath ="//input[@class='form-control input-sm input-xs']")
	    private WebElement searchButton;
	    
	    @FindBy(xpath ="//tr[@class='product_link']")
	    private List<WebElement> rowCount;
	    
	    @FindBy(xpath ="//div[@class='alert alert-success']")
	    private WebElement sucessMsg;
	    
	    @FindBy(xpath ="//a[text()='Next > ']")
	    private WebElement nextButton;
	    
	    @FindBy(xpath ="//div[@id='PRData_info']")
	    private WebElement entryMsg;
	    
	    @FindBy(xpath ="//a[@class='tip btn btn-warning tip']")
	    private WebElement editOption;
	    
	    @FindBy(xpath ="//input[@class='btn btn-primary']")
	    private WebElement editProductButton;
	    
	    @FindBy(xpath ="//div[@class='alert alert-success']")
	    private WebElement editUpdateMsg;
	    
	    @FindBy(xpath ="//select[@class='form-control input-sm select input-xs']")
	    private WebElement showButton;
	    
	    @FindBy(xpath ="//ul[@class='pagination pagination-sm']//li")
	    private List<WebElement> nextPageNum;
	    
	    @FindBy(xpath ="//a[@id='excel' and @data-action='export_excel']")
	    private WebElement exportToExcel;
	    
	    @FindBy(xpath =" //div[@class='alert alert-danger']")
	    private WebElement excelAlert;
	    
	    @FindBy(xpath ="//a[@id='excel']")
	    private WebElement exportToPdfFile;
	           
	    public void addInventoryProduct() throws IOException { 	
	    	String type = ExcelUtility.getString(8, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String name = ExcelUtility.getString(1, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String path = ExcelUtility.getString(2, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String catg = ExcelUtility.getNumeric(3, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String model= ExcelUtility.getNumeric(7, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String quality= ExcelUtility.getNumeric(4, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String supplier = ExcelUtility.getString(9, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String unit= ExcelUtility.getNumeric(5, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String cost = ExcelUtility.getNumeric(10, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String price= ExcelUtility.getNumeric(6, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String expectedPage = ExcelUtility.getString(11, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	PageUtility.clickOnElement(actionsIcon);
	    	WaitUtility.waitForElementClickable(driver, addProduct);
	    	PageUtility.clickOnElement(addProduct);
	    	PageUtility.selectElementFromListUsingGetText(productType, type);
	    	PageUtility.enterStringValue(productName, name)	;
	    	PageUtility.clickOnElement(productCode);
	    	PageUtility.selectDropdownbyValue(category, catg);
	    	PageUtility.selectDropdownbyValue(productModel, model);
	    	PageUtility.enterStringValue(productQuality,quality);
	    	PageUtility.selectDropdownbyText(productSupplier, supplier);
	    	PageUtility.enterStringValue(productUnit, unit);
	    	PageUtility.enterStringValue(productCost, cost);
	    	PageUtility.enterStringValue(productPrice, price);
	    	PageUtility.enterStringValue(productImage, path);
	    	WaitUtility.waitForElementClickable(driver, submit);
	    	PageUtility.clickOnElement(submit);
	    	String actualPage = driver.getCurrentUrl();
	    	Assert.assertEquals(actualPage, expectedPage,"Client details are not submitted");
	       }   
	    
	   
	        public void rowCountWithSameNameVerification() throws IOException {
			String expectedNumber=ExcelUtility.getNumeric(26, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
			String searchName=ExcelUtility.getString(27, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
			WaitUtility.waitForElementClickable(driver, inventoryProductMoreInfoOption);
			PageUtility.clickOnElement(inventoryProductMoreInfoOption);
			WaitUtility.waitForElementClickable(driver, searchButton);
			PageUtility.clickOnElement(searchButton);
			PageUtility.enterStringValue(searchButton, searchName);
			
		    int count =PageUtility.getElementRowSize(rowCount);
		    String actualNumber = Integer.toString(count);
		    Assert.assertEquals(actualNumber, expectedNumber,"row count showing is not correct");
		   }
	    
	    public void navigateToNextPageOnClickingNextOptionVerification() throws IOException {
	        String expectedNum = ExcelUtility.getNumeric(28, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String showButtonNum = ExcelUtility.getNumeric(19, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4"); 
	    	String pageNum = ExcelUtility.getNumeric(20, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	PageUtility.selectDropdownbyValue(showButton,showButtonNum);
	    	PageUtility.ScrollBy(driver);
	    	boolean isnextButtonDisplayed = nextButton.isDisplayed();
	    	Assert.assertTrue(isnextButtonDisplayed,"Next button is not displayed");
	    	WaitUtility.waitForElementClickable(driver, nextButton);
	    	PageUtility.clickOnElement(nextButton);
	    	
	    	for(WebElement menu:nextPageNum) {
			String actualText=PageUtility.getElementText(menu);
			if(actualText.contentEquals(pageNum)) {
			Assert.assertEquals(actualText, expectedNum);
			break;
		   } 
		  }
	    }
	    
	    public void UserIsAbleToEditInventoryProductVerification() throws IOException {
	    	String attribute = ExcelUtility.getString(23, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String attributeValue = ExcelUtility.getNumeric(24, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String alertMsg = ExcelUtility.getString(25, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String actualMsg;
	        boolean compareElement;
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	PageUtility.clickOnElement(actionsIcon);
	    	for(WebElement row:rowNumber) {
				actualMsg =row.getAttribute(attribute);
				compareElement = actualMsg.contentEquals(attributeValue);
				if(compareElement) {
				PageUtility.clickOnElement(row);
			    break;
				}
			PageUtility.clickOnElement(editOption);
			PageUtility.clickOnElement(editProductButton);
			String actualAlertMsg = editUpdateMsg.getText();
			String expectedAlertMsg = alertMsg;
			Assert.assertEquals(actualAlertMsg, expectedAlertMsg,"not able to edit inventory product");	
	       }	
	     }
	    
	    public void exportToExcelFileWithoutSelectingProduct() throws IOException {
	       String expectedMsg = ExcelUtility.getString(30, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	       PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	       PageUtility.clickOnElement(actionsIcon);
	       PageUtility.clickOnElement(exportToExcel);
	       String actualMsg =  PageUtility.getElementText(excelAlert);
	       Assert.assertEquals(actualMsg, expectedMsg,"Alert msg for not able to export without selecting didn't appear");
	      }
	    
	    public void exportToPdfFileWithoutSelectingProduct() throws IOException {
	       String expectedMsg = ExcelUtility.getString(30, 3, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	       PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	       PageUtility.clickOnElement(actionsIcon);
	       PageUtility.clickOnElement(exportToPdfFile);
	       String actualMsg =  PageUtility.getElementText(excelAlert);
	       Assert.assertEquals(actualMsg, expectedMsg,"Alert msg for not able to export pdf without selecting didn't appear");
	      } 
        }
