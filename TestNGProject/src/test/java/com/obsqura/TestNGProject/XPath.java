package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class XPath extends Base {
	@Test
	public void xpathLocator() {
		
	driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']"));
	driver.findElement(By.xpath("//div[@id='main-content']"));
	driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
	driver.findElement(By.xpath("//div[@id='nav-flyout-anchor']"));
	driver.findElement(By.xpath("//span[@class='icp-color-base']"));
	driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")); 
	}
	@Test
	public void indexPath() {
	driver.findElement(By.xpath("(//a[@class='a-carousel-goto-nextpage'])[1]"));
	driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
	driver.findElement(By.xpath("(//a[@class='nav-a  '])[1]"));
	}
	
	

}
