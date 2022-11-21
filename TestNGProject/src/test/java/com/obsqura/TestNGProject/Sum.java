package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sum extends Base {
	@Test
	public void singleInputFileVerification2() {
		int a = 20;
		int b = 30;
		int t = a+b;
		String sa = Integer.toString(a);
		String sb = Integer.toString(b);
		String st = Integer.toString(t);
		String expectedMessage = "Total A + B : "+t;
		String actualMessage;
	    driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys(sa);
		driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys(sb);
		driver.findElement(By.xpath("//button[@id='button-two']")).click();
		actualMessage = driver.findElement(By.xpath("//div[@id='message-two']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);	
	}

}
