package com.obsqura.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

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
	    
	    @FindBy(xpath ="//a[@class='bpo']")
	    private WebElement delectButton;
		 	 
	    
	    
	    public void addInventoryProduct() throws IOException {
	    	String type = ExcelUtility.getString(8, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String name = ExcelUtility.getString(1, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String path = ExcelUtility.getString(2, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	    	String catg = ExcelUtility.getNumeric(3, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String model= ExcelUtility.getNumeric(7, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String quality= ExcelUtility.getNumeric(4, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String supplier = ExcelUtility.getString(9, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String unit= ExcelUtility.getNumeric(5, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        String price= ExcelUtility.getNumeric(6, 2, System.getProperty("user.dir")+Constants.Constants.EXCELFILE,"Sheet4");
	        
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	PageUtility.clickOnElement(actionsIcon);
	    	PageUtility.clickOnElement(addProduct);
	    	for(WebElement menu:productType) {
				String text=menu.getText();
				if(text.contentEquals(type)) {
					menu.click();
					continue;
	        }	
          }
	    	PageUtility.enterStringValue(productName, name)	;
	    	PageUtility.clickOnElement(productCode);
	    	Select obj = new Select(category);
	    	obj.selectByValue(catg);
	    	Select obj1 = new Select(productModel);
	    	obj1.selectByValue(model);
	    	PageUtility.enterStringValue(productQuality,quality);
	    	Select obj2 = new Select(productSupplier);
	    	obj2.selectByVisibleText(supplier);
	    	PageUtility.enterStringValue(productUnit, unit);
	    	PageUtility.enterStringValue(productPrice, price);
	    	PageUtility.enterStringValue(productImage, path);
	    	PageUtility.clickOnElement(submit);
	    	
	    }   
	    
	    public void delectInventoryVerification() {
	    	String actualMsg,expectedMsg="37";
	    	boolean compareElement;
	    
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	for(WebElement row:rowNumber) {
				actualMsg =row.getAttribute("id");
				compareElement = actualMsg.contentEquals("37");
				if(compareElement) {
			    row.click();
			    continue;
				}
				PageUtility.clickOnElement(delectButton);
		
				
	    	}
	    }
}
