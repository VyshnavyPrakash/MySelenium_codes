package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class selectClass extends Base {
	@Test
	public void visibleText() {
		String actualColour;
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='single-input-field']")));
		obj.selectByVisibleText("Red");
		obj.selectByVisibleText("Yellow");
		obj.selectByVisibleText("Green");
		obj.selectByIndex(0);
		obj.selectByIndex(1);
		obj.selectByIndex(2);
		obj.selectByIndex(3);
		obj.selectByValue("Red");
		obj.selectByValue("Yellow");
		obj.selectByValue("Green");
		
	
	
		
		
		
	}

}
