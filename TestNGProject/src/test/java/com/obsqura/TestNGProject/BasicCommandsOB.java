package com.obsqura.TestNGProject;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BasicCommandsOB extends Base {
	@Test
	public void singleInputFileldVerification() {
		String  inputMessage = "Hello", actualMessage;
		String expectedMessage = "Your Message :"+inputMessage;
		driver.findElement(By.id("single-input-field")).sendKeys(inputMessage);
	    driver.findElement(By.xpath("//button[@id='button-one']")).click();
	    actualMessage = driver.findElement(By.id("message-one")).getText();
	    Assert.assertEquals(actualMessage,expectedMessage,"Messages are not equal" );
	}
	
}
