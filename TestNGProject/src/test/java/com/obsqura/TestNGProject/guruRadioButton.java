package com.obsqura.TestNGProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class guruRadioButton extends Base{
	
    
	@Test
	public void radioButtonDislikeByDefault() {
		boolean yesButton,noButton;
		String actualMsg, expectedMsg = "Radio button is Not checked";
		WebElement yesRadioButton =driver.findElement(By.xpath("//input[@id='yes']"));
		WebElement noRadioButton = driver.findElement(By.xpath("(//input[@name='name'])[2]"));
		WebElement checkButton = driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		WebElement reset = driver.findElement(By.xpath("//input[@type='reset']"));
		WebElement msg = driver.findElement(By.xpath("//p[@class='radiobutton']"));
		yesButton = yesRadioButton.isSelected();
		noButton = noRadioButton.isSelected();
		if(yesButton==false&&noButton==false) {
			checkButton.click();
		}
		else {
			reset.click();
			checkButton.click();
			
		}
		actualMsg = msg.getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Radio button is checked and it's value is Yes");
		
	}
	@Test
	public void clickRadioButtonNo() {
		String actualMsg, expectedMsg = "Radio button is checked and it's value is No";
		WebElement noRadioButton = driver.findElement(By.xpath("(//input[@name='name'])[2]"));
		WebElement checkButton = driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		WebElement msg = driver.findElement(By.xpath("//p[@class='radiobutton']"));
		noRadioButton.click();
		if(noRadioButton.isSelected()) {
			checkButton.click();
		}
		actualMsg = msg.getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both the values are not same");
		
	}
	 
}
