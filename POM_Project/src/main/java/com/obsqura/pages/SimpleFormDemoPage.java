package com.obsqura.pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.obsqura.utilities.ExcelUtility;

public class SimpleFormDemoPage {	
	WebDriver driver;
	public SimpleFormDemoPage(WebDriver driver) {
	this.driver = driver;
	}
	By inputField = By.xpath("//input[@id='single-input-field']");
	By showMessageButton = By.xpath("//button[@id='button-one']");
	By yourMessage = By.xpath("//div[@id='message-one']");
	By enterValueAField = By.xpath("//input[@id='value-a']");
	By enterValueBField = By.xpath("//input[@id='value-b']");
	By getTotalButton = By.xpath("//button[@id='button-two']");
	By getTotalMsg = By.xpath("//div[@id='message-two']");
	
	public void verifyenterMessageFields() throws IOException {
	String actualMsg;
	String inputMsg = ExcelUtility.getString(0, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","sheet1");
	String expectedMsg = ExcelUtility.getString(0, 3, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "sheet1")+ExcelUtility.getString(0, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","sheet1");
	driver.findElement(inputField).sendKeys(inputMsg);	
	driver.findElement(showMessageButton).click();
	actualMsg = driver.findElement(yourMessage).getText();
    Assert.assertEquals(actualMsg,expectedMsg,"Both messages are not equal");
	}
	public void verifymultipleInputFields() throws IOException {	
	String valueA,valueB,actualMsg,expectedMessage;
	int entervalueA,entervalueB,total; 
	valueA = ExcelUtility.getNumeric(1, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","Sheet1");
	valueB = ExcelUtility.getNumeric(1, 3, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","Sheet1");
	entervalueA = Integer.parseInt(valueA);
	entervalueB = Integer.parseInt(valueB);
    total = entervalueA+entervalueB;
	expectedMessage = ExcelUtility.getString(1, 4, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","Sheet1")+total;
	driver.findElement(enterValueAField).sendKeys(valueA);
    driver.findElement(enterValueBField).sendKeys(valueB);
    driver.findElement(getTotalButton).click();
    actualMsg = driver.findElement(getTotalMsg).getText();
    Assert.assertEquals(actualMsg, expectedMessage,"Both messages are not equal");
	}
}



