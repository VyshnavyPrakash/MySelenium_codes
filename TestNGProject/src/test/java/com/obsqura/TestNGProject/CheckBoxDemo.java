package com.obsqura.TestNGProject;

import static org.testng.Assert.assertTrue;

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
	
    @Test
	public void multipleCheckBoxSelect2() {
		boolean box1Select,box2Select;
		String actualButtonValue,expectedButtonValue = "Select All";
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='button-two']"));
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		checkBox1.click();
		checkBox2.click();
		actualButtonValue = selectAllButton.getAttribute("Value");
		box1Select = checkBox1.isSelected();
		box2Select = checkBox2.isSelected();
		Assert.assertEquals(actualButtonValue, expectedButtonValue,"Both values are not same");
		Assert.assertTrue(box1Select,"Is not selected");
		Assert.assertTrue(box2Select,"Is not selected");	
	}
	@Test
	public void multipleCheckBoxSelectAll() {
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		boolean box1,box2,box3,box4;
		String actualButtonValue,expectedButtonValue = "Unselect All";
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='button-two']"));
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='check-box-three']"));
		WebElement checkBox4 = driver.findElement(By.xpath("//input[@id='check-box-four']"));
		selectAllButton.click();
		actualButtonValue = selectAllButton.getAttribute("Value");
		box1 = checkBox1.isSelected();
		box2 = checkBox2.isSelected();
		box3 = checkBox3.isSelected();
		box4 = checkBox4.isSelected();
		Assert.assertTrue(box1,"Not selected");
		Assert.assertTrue(box2,"Not selected");
		Assert.assertTrue(box3,"Not selected");
		Assert.assertTrue(box4,"Not selected");
		Assert.assertEquals(actualButtonValue, expectedButtonValue,"both values are not same");
		
		
		
	}
}
