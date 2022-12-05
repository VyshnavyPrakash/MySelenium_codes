package com.obsqura.TestNGProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class selectClass extends Base {
	@Test
	public void visibleText() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		obj.selectByVisibleText("Red");
		obj.selectByVisibleText("Yellow");
		obj.selectByVisibleText("Green");
	}
	@Test
	public void selectByIndex() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		obj.selectByIndex(0);
		obj.selectByIndex(1);
		obj.selectByIndex(2);
		obj.selectByIndex(3);
	}	
	@Test
	public void selectByValue() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		obj.selectByValue("Red");
		obj.selectByValue("Yellow");
		obj.selectByValue("Green");
	}
	@Test
	public void getOption() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		List<WebElement> option = obj.getOptions();
		int count = option.size();
		
	}
	@Test
	public void isMultiple() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objMultiple = new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		boolean isMultipleFlag = objMultiple.isMultiple();
		Assert.assertTrue(isMultipleFlag,"Multiple selection is not possible");
		objMultiple.selectByVisibleText("Red");
		objMultiple.selectByVisibleText("Yellow");
		objMultiple.deselectAll();	
}
	@Test
	public void SingleValueSelect() {
		String color = "Red";
		String actualMsg,expectedMsg = "Selected Color : Red";
	    driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-one']"));
		obj.selectByValue(color);
		actualMsg = msg.getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both are not equal");		 			
	}
   @Test
   public void selectAllValue() {
	    String actualMsg,expectedMsg="All selected colors are : Red,Yellow,Green";
	    driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");   
		Select objMultiple = new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		WebElement button = driver.findElement(By.xpath("//button[@id='button-all']"));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-two']"));
		boolean isMultipleFlag = objMultiple.isMultiple();
		Assert.assertTrue(isMultipleFlag,"Multiple selection is not possible");
	    objMultiple.selectByVisibleText("Red");
		objMultiple.selectByVisibleText("Yellow");
		objMultiple.selectByVisibleText("Green");
		button.click();
		actualMsg = msg.getText();
		Assert.assertEquals(actualMsg, expectedMsg,"Both the messages are not same");
  }
	@Test
	public void diselectAllValuePrgm() {   
		String actualMsg,expectedMsg = "All selected colors are : ";
		boolean isMultipleFlag;
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");   
		Select objMultiple = new Select(driver.findElement(By.xpath("//select[@id='multi-select-field']")));
		WebElement selectAllMsgButton = driver.findElement(By.xpath("//button[@id='button-all']"));
		WebElement msg = driver.findElement(By.xpath("//div[@id='message-two']"));
		isMultipleFlag = objMultiple.isMultiple();
		objMultiple.selectByValue("Red");
		objMultiple.selectByValue("Yellow");
		objMultiple.selectByValue("Green");
		objMultiple.deselectAll();
		selectAllMsgButton.click();
		actualMsg = msg.getText();
		Assert.assertTrue(isMultipleFlag,"Multiple selection is not possible");
		Assert.assertEquals(actualMsg, expectedMsg,"Both the messages are not same");
		
	
	}
	
}
