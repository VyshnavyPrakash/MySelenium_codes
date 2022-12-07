package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
    
	public void verifyRadioButtonSelected() {
		boolean isMaleRadioButtonSelected;
		String actualMsg,expectedMsg ="Radio button 'Male' is checked";
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(maleRadioButton).click();
		isMaleRadioButtonSelected = driver.findElement(maleRadioButton).isSelected();
		if(isMaleRadioButtonSelected) {
		driver.findElement(showSelectValueButton).click();
		actualMsg = driver.findElement(msg).getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not equal");
	 }
  }
	 
	public void verifyGroupRadioButtonSelected() {
		String actualMsg,expectedMsg = "Gender : Female\nAge group: 19 to 44";
		boolean isgenderselected,isAgeSelected;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(patientGender).click();
		driver.findElement(patientAgeGroup).click();
		isgenderselected = driver.findElement(patientGender).isSelected();
		isAgeSelected = driver.findElement(patientAgeGroup).isSelected();
		if(isgenderselected&&isAgeSelected) {
		driver.findElement(getResultButton).click();
		actualMsg = driver.findElement(groupRadioButtonMsg).getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both messages are not equal");
		}
		Assert.assertTrue(isAgeSelected);
		Assert.assertTrue(isgenderselected);
		
	}
}
