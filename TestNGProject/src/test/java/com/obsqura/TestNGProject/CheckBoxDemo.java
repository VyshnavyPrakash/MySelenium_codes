package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo extends Base {
	@Test
	public void singleCheckBox() {
		String expectedMsg="Success - Check box is checked",actualMsg;
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
		checkBox.click();
		Assert.assertTrue(checkBox.isSelected(),"Is not Selected");
		actualMsg = msg.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}

}
