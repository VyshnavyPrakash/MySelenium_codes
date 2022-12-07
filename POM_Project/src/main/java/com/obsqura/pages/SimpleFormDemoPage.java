package com.obsqura.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

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
	
	public void verifyenterMessageFields() {
	String actualMsg;
	String inputMsg = "ABC";
	String expectedMsg = "Your Message : "+inputMsg;
	driver.findElement(inputField).sendKeys(inputMsg);	
	driver.findElement(showMessageButton).click();
	actualMsg = driver.findElement(yourMessage).getText();
    Assert.assertEquals(actualMsg,expectedMsg);
	}
	public void verifymultipleInputFields() {	
	int a = 20;
	int b = 30;
	int t = a+b;
	String actualMsg, expectedMessage = "Total A + B : "+t;
	driver.findElement(enterValueAField).sendKeys(Integer.toString(a));
    driver.findElement(enterValueBField).sendKeys(Integer.toString(b));
    driver.findElement(getTotalButton).click();
    actualMsg = driver.findElement(getTotalMsg).getText();
    Assert.assertEquals(actualMsg, expectedMessage,"Both messages are not equal");
	}
}



