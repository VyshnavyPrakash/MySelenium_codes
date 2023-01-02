package com.obsqura.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.WaitUtility;

public class CheckBoxDemoPage {
	
	WebDriver driver;
	public CheckBoxDemoPage(WebDriver driver) {
    this.driver = driver;
	}
	By singleCheckBox = By.xpath("//input[@id='gridCheck']");
	By msg = By.xpath("//div[@id='message-one']");
	By checkBoxOne = By.xpath("//input[@id='check-box-one']");
	By checkBoxTwo = By.xpath("//input[@id='check-box-two']");
	By checkBoxThree = By.xpath("//input[@id='check-box-three']");
	By checkboxFour = By.xpath("//input[@id='check-box-four']");
	By selectAllButton = By.xpath("//input[@id='button-two']");
	public void verifySingleCheckBoxSelected() throws IOException {
	    boolean isSelectedSingleCheckBox; 
	    String actualMsg,expectedMsg= ExcelUtility.getString(0, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","Sheet3");
	    Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(NoSuchElementException.class);
	    fluentWait.until(ExpectedConditions.elementToBeClickable(singleCheckBox));
        driver.findElement(singleCheckBox).click();	
        
	    isSelectedSingleCheckBox = driver.findElement(singleCheckBox).isSelected();
	    if(isSelectedSingleCheckBox) {
	    actualMsg = driver.findElement(msg).getText();
	    Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not equal");
	    }	
	}
	public void verifyMultipleCheckBoxselected() throws IOException {
		boolean box1,box2,box3,box4;
		WebElement selectAllbutton;
		String actualButtonValue,expectedButtonValue =ExcelUtility.getString(1, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "Sheet3");
		WaitUtility.waitForElementClickable(driver, checkBoxOne);
		driver.findElement(selectAllButton).click();
		WaitUtility.waitForElementClickable(driver, checkBoxOne);
		box1 = driver.findElement(checkBoxOne).isSelected();
		WaitUtility.waitForElementClickable(driver, checkBoxTwo);
		box2 = driver.findElement(checkBoxTwo).isSelected();
		WaitUtility.waitForElementClickable(driver, checkBoxThree);
		box3 = driver.findElement(checkBoxThree).isSelected();
		WaitUtility.waitForElementClickable(driver, checkboxFour);
		box4 = driver.findElement(checkboxFour).isSelected();
	    selectAllbutton= driver.findElement(selectAllButton);
	    actualButtonValue = selectAllbutton.getAttribute("Value");
		Assert.assertTrue(box1);
		Assert.assertTrue(box2);
		Assert.assertTrue(box3);
		Assert.assertTrue(box4);
		Assert.assertEquals(actualButtonValue, expectedButtonValue);
		
	}

}
