package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;

public class SelectInputDemoPages {
	WebDriver driver;
	public SelectInputDemoPages(WebDriver driver) {
		this.driver = driver;
	}
	By selectColor = By.xpath("//select[@id='single-input-field']");
	By msg    = By.xpath("//div[@id='message-one']");
	By MultipleInputField = By.xpath("//select[@id='multi-select-field']");
	By firstSelectedButton = By.xpath("//button[@id='button-first']");
	By firstSelectedButtonMsg = By.xpath("//div[@id='message-two']");
    public void verifySelectInputByVisibleText() throws IOException {
    	String actualMsg,expectedMsg=ExcelUtility.getString(0, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "Sheet4");
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(selectColor));	
    	obj.selectByVisibleText("Red");
    	actualMsg = driver.findElement(msg).getText(); 
        Assert.assertEquals(actualMsg, expectedMsg,"Both are not same");
    }
    public void verifySelectInputByIndex() throws IOException {
    	String actualMsg,expectedMsg=ExcelUtility.getString(1, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "Sheet4");
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(selectColor));	
    	obj.selectByIndex(2);
    	actualMsg = driver.findElement(msg).getText(); 
        Assert.assertEquals(actualMsg, expectedMsg,"Both are not same");
    }
    public void verifySelectInputByValue() throws IOException {
    	String actualMsg,expectedMsg=ExcelUtility.getString(2, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "Sheet4");
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(selectColor));	
    	obj.selectByValue("Green");
    	actualMsg = driver.findElement(msg).getText(); 
        Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not same");
    }
    public void verifyTwoInputField() throws IOException {
    	boolean isMultipleFlag;
    	String actualMsg,expectedMsg=ExcelUtility.getString(3, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "Sheet4");
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(MultipleInputField))	;
    	isMultipleFlag = obj.isMultiple();
    	obj.selectByValue("Yellow");
    	obj.selectByValue("Red");
    	obj.selectByValue("Green");
    	driver.findElement(firstSelectedButton).click();
    	actualMsg = driver.findElement(firstSelectedButtonMsg).getText();
        Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not same");
    }
    }

