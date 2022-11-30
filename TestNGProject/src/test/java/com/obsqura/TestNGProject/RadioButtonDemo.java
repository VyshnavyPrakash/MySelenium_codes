package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonDemo extends Base {
	@Test
	public void radioButtonSample() {
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		boolean isMaleButnSelected,isFemaleButnSelected;
		String expectedMessage ="Radio button is Not checked",actualMessage;
		WebElement male = driver.findElement(By.id("inlineRadio1"));
		WebElement female = driver.findElement(By.id("inlineRadio2"));
		WebElement button = driver.findElement(By.xpath("//button[@id='button-one']"));
	    WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
		isMaleButnSelected = male.isSelected();
		isFemaleButnSelected = female.isSelected();
        if(isMaleButnSelected==false&&isFemaleButnSelected==false) {
        button.click();
        actualMessage = msg.getText();
        Assert.assertEquals(actualMessage, expectedMessage,"Not displayed");
            }   
	   }
	@Test
	public void maleRadioButton() {
		String expectedMessage ="Radio button 'Male' is checked",actualMessage;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement maleButton = driver.findElement(By.id("inlineRadio1"));
		WebElement showSelectButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
		if(maleButton.isEnabled()) {
		maleButton.click();	
		}
		if(maleButton.isSelected()) {
		 showSelectButton.click();
		 actualMessage = msg.getText();
		 Assert.assertEquals(actualMessage, expectedMessage);
		   }	
	  }
	@Test
	public void femaleRadioButton() {
		 String expectedMessage ="Radio button 'Female' is checked",actualMessage;
		 driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		 WebElement femaleButton = driver.findElement(By.id("inlineRadio2"));
		 WebElement showSelectButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		 WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
		 if(femaleButton.isEnabled()) {
		    femaleButton.click();
		 }
		 if(femaleButton.isSelected()) {
			showSelectButton.click();
			actualMessage = msg.getText();
			Assert.assertEquals(actualMessage, expectedMessage);	
		}	
	}
	@Test
	public void malePatientGenderAge() {
		boolean gender,age;
		String actualMsg,expectedMsg = "Gender : Male\nAge group: 1 to 18";
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement maleGender = driver.findElement(By.xpath("//input[@id='inlineRadio11']"));
		WebElement maleAgeGroup = driver.findElement(By.xpath("//input[@id='inlineRadio22']"));
		WebElement getResult = driver.findElement(By.xpath("//button[@id='button-two']"));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-two']"));
		maleGender.click();
		maleAgeGroup.click();
		gender = maleGender.isSelected();
		age = maleAgeGroup.isSelected();
		if(gender&&age) {
			getResult.click();
			actualMsg = msg.getText();
			Assert.assertEquals(actualMsg,expectedMsg);	
	   }	
	}
	@Test
	public void femalepatientGenderage() {
		boolean gender,age;
		String actualMsg,expectedMsg= "Gender : Female\nAge group: 19 to 44";
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement femaleGender = driver.findElement(By.xpath("//input[@id='inlineRadio21']")) ;
		WebElement femaleAgegroup = driver.findElement(By.xpath("//input[@id='inlineRadio23']"));
		WebElement getResult = driver.findElement(By.xpath("//button[@id='button-two']"));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-two']"));
		femaleGender.click();
		femaleAgegroup.click();
		gender = femaleGender.isSelected();
		age = femaleAgegroup.isSelected();
		if(gender&&age) {
			getResult.click();
			actualMsg = msg.getText();
			Assert.assertEquals(actualMsg, expectedMsg);
		}
	}
	
		
		
	
}
