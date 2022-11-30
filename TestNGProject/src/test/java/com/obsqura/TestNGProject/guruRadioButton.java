package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class guruRadioButton{
	public WebDriver driver;
	@BeforeMethod
    public void InitializeBrowser(){
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\TestNGProject\\src\\main\\java\\Resources\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://demo.guru99.com/test/ajax.html");
        }
    
	@Test
	public void guruRadioButton() {
		boolean yesButton,noButton;
		WebElement yes =driver.findElement(By.xpath("//input[@id='yes']"));
		WebElement no = driver.findElement(By.xpath("(//input[@name='name'])[2]"));
		Assert.assertFalse(yes.isSelected());
		Assert.assertFalse(no.isSelected());
		no.click();
		no.isSelected();
		
	}
	 @AfterMethod
	    public void browserClose() {
	      	driver.close();
	        }
}
