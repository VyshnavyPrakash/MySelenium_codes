package com.obsqura.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.WaitUtility;

public class RadioButtonDemoPages {
	WebDriver driver;
	public RadioButtonDemoPages(WebDriver driver) {
	this.driver = driver;
	}
    By maleRadioButton = By.xpath("//input[@id='inlineRadio1']");
    By showSelectValueButton = By.xpath("//button[@id='button-one']");
    By msg = By.xpath("//div[@id='message-one']");
    By patientGender = By.xpath("//input[@id='inlineRadio21']");
    By patientAgeGroup = By.xpath("//input[@id='inlineRadio23']");
    By getResultButton = By.xpath("//button[@id='button-two']");
    By groupRadioButtonMsg = By.xpath("//div[@id='message-two']");
    
	public void verifyRadioButtonSelected() throws IOException {
		boolean isMaleRadioButtonSelected;
		String actualMsg,expectedMsg = ExcelUtility.getString(0, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","Sheet2");
		driver.findElement(maleRadioButton).click();
	    WaitUtility.waitForVisibilityOfAllElementsLocatedBy(driver, maleRadioButton);
		isMaleRadioButtonSelected = driver.findElement(maleRadioButton).isSelected();
		if(isMaleRadioButtonSelected) {
		WebElement button = driver.findElement(showSelectValueButton);
		WaitUtility.waitForElementClickable(driver, button);
		button.click();
		actualMsg = driver.findElement(msg).getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not equal");
	 }
  }
	 
	public void verifyGroupRadioButtonSelected() throws IOException {
		String actualMsg,expectedMsg = ExcelUtility.getString(1, 2, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx", "Sheet2");
		boolean isgenderselected,isAgeSelected;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WaitUtility.waitForElementClickable(driver, patientGender);
		driver.findElement(patientGender).click();
		WaitUtility.waitForElementClickable(driver, patientAgeGroup);
		driver.findElement(patientAgeGroup).click();
		WaitUtility.waitForElementToBeSelected(driver,patientGender);
		isgenderselected = driver.findElement(patientGender).isSelected();
		WaitUtility.waitForElementToBeSelected(driver, patientAgeGroup);
		isAgeSelected = driver.findElement(patientAgeGroup).isSelected();
		if(isgenderselected&&isAgeSelected) {
		WaitUtility.waitForElementClickable(driver, getResultButton);	
		driver.findElement(getResultButton).click();
		actualMsg = driver.findElement(groupRadioButtonMsg).getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not equal");
		}
	}
}
