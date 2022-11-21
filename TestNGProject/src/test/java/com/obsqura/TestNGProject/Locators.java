package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Locators extends Base {
	@Test
	public void idLocator() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	@Test
	public void nameLocator() {
		driver.findElement(By.name("glow-validation-token"));
	}
	@Test
	public void cssSelector() {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	}
	@Test
	public void cssClass() {
		driver.findElement(By.cssSelector("span.hm-icon-label"));
	}
	@Test
	public void cssAttribute() {
		driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));
	}
	@Test
	public void xmlPath() {
		driver.findElement(By.xpath("//input[@id ='twotabsearchtextbox']"));
	}
	@Test
	public void xpathIndex() {
		driver.findElement(By.xpath("(//div[@id ='nav-xshop'])[1]"));
	} 
	}
	



