package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
    public void verifySelectInputByVisibleText() {
    	String actualMsg,expectedMsg="Selected Color : Red";
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(selectColor));	
    	obj.selectByVisibleText("Red");
    	actualMsg = driver.findElement(msg).getText(); 
        Assert.assertEquals(actualMsg, expectedMsg,"Both are not same");
    }
    public void verifySelectInputByIndex() {
    	String actualMsg,expectedMsg="Selected Color : Yellow";
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(selectColor));	
    	obj.selectByIndex(2);
    	actualMsg = driver.findElement(msg).getText(); 
        Assert.assertEquals(actualMsg, expectedMsg,"Both are not same");
    }
    public void verifySelectInputByValue() {
    	String actualMsg,expectedMsg="Selected Color : Green";
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(selectColor));	
    	obj.selectByValue("Green");
    	actualMsg = driver.findElement(msg).getText(); 
        Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not same");
    }
    public void verifyTwoInputField() {
    	String actualMsg,expectedMsg="First selected color is : Yellow";
    	driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
    	Select obj = new Select(driver.findElement(MultipleInputField))	;
    	obj.selectByValue("Yellow");
    	obj.selectByValue("Red");
    	obj.selectByValue("Green");
    	driver.findElement(firstSelectedButton).click();
    	actualMsg = driver.findElement(firstSelectedButtonMsg).getText();
        Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not same");
    }
    }

