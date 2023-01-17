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

public class ClientPage {
	WebDriver driver;
   public ClientPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	 
	  @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	  private WebElement clientMoreInfo;
	 
	  @FindBy(xpath="//button[@class='add_c btn btn-primary']")
	  private WebElement AddClientButton;
	 
	  @FindBy(xpath="//input[@id='name1']")
	  private WebElement clientName;
	 
	  @FindBy(xpath="//input[@id='company1']")
	  private WebElement clientCompany;
	 
	  @FindBy(xpath="//input[@id='route']")
	  private WebElement address;
	 
	  @FindBy(xpath="//input[@id='email1']")
	  private WebElement Clientemail;
	 
	  @FindBy(xpath="//button[@id='submit']")
	  private WebElement submitButton;
	 
	  @FindBy(xpath="//body[@class='sidebar-mini skin-red skin-custom']")
	  private WebElement goBackButton;
	 
	  @FindBy(xpath="//input[@class='form-control input-sm input-xs']")
	  private WebElement clientSearch;
	 
	  @FindBy(xpath="//span[@class='caret']")
	  private WebElement blueActionButton;
	 
	  @FindBy(xpath="//a[@id='delete_client']")
	  private WebElement delectClientButton;
	
	  @FindBy(xpath="//a[@id='delete_client']")
	  private WebElement delectClientConformation;
	
	  @FindBy(xpath="//select[@class='form-control input-sm select input-xs']")
	  private WebElement cleintShowButton;
	  
	  @FindBy(xpath="//tr[@class='even' or @class='odd']")
	  private List<WebElement> rowsNumber;
	  
	  @FindBy(xpath="//a[@class='dropdown-toggle btn-round btn btn-default']")
	  private WebElement mainActionButton;
	  
	  @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers/export_csv']")
	  private  WebElement exportToExcelFile;
	  
	  @FindBy(xpath="//a[@id='excel']")
	  private WebElement exportToPdfFile;
	  
	 public void addingClientDetails() throws IOException {
		
		 String name = ExcelUtility.getString(1, 3, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\ServiceApp.xlsx", "Sheet3");
		 String company = ExcelUtility.getString(2, 3, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\ServiceApp.xlsx", "Sheet3");
		 String addrs = ExcelUtility.getString(3, 3, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\ServiceApp.xlsx", "Sheet3");
		 String email = ExcelUtility.getString(4, 3, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\ServiceApp.xlsx", "Sheet3");		 
		 PageUtility.clickOnElement(clientMoreInfo);
		 PageUtility.clickOnElement(AddClientButton);
		 PageUtility.enterStringValue(clientName, name);
		 PageUtility.enterStringValue(clientCompany, company);
		 PageUtility.enterStringValue(address, addrs);
		 PageUtility.enterStringValue(Clientemail, email);
		 PageUtility.clickOnElement(submitButton);
		 PageUtility.clickOnElement(goBackButton); 
	 }
	 
	public void delectingClientDetails() throws IOException {				
	     PageUtility.clickOnElement(clientMoreInfo);
	     PageUtility.enterStringValue(clientSearch, "Vyshnavy1");
		 PageUtility.clickOnElement(blueActionButton);
		 PageUtility.clickOnElement(delectClientButton);
	     PageUtility.clickOnElement(delectClientConformation);		 		 
	 }	 
	
	public void clientShowButtonVerification() throws IOException {
		  int expectedNumber=10,actualNumber;
		  PageUtility.clickOnElement(clientMoreInfo);	
		  Select obj = new Select(cleintShowButton);
		  obj.selectByValue("10");
		  actualNumber = rowsNumber.size();
		  Assert.assertEquals(expectedNumber, actualNumber,"Both the numbers are not same");
	
	}
	public void clientdetailsExportToExcelFile() {
		PageUtility.clickOnElement(clientMoreInfo);
		PageUtility.clickOnElement(mainActionButton);
		String sourceLocation = exportToExcelFile.getAttribute("href");
	    String wget_command = "cmd /c C:\\Wget\\wget.exe -P C:\\SeleniumDownload --no-check-certificate" +sourceLocation;

	        try {
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        } catch (InterruptedException | IOException ex) {
	        System.out.println(ex.toString());
	        }
	        driver.close();
	        }
	public void clientDetailsExportToPdfFile() {
		 PageUtility.clickOnElement(clientMoreInfo);
		 PageUtility.clickOnElement(mainActionButton);
		 String sourceLocation = exportToPdfFile.getAttribute("href");
	     String wget_command = "cmd /c C:\\Wget\\wget.exe -P C:\\SeleniumDownload --no-check-certificate" +sourceLocation;

	        try {
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        } catch (InterruptedException | IOException ex) {
	        System.out.println(ex.toString());
	        }
	        driver.close();
	        }
	public void userFindBySearchingClientName() {
		
		
	}
	}
		
	

