package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class HeaderPage {
	WebDriver driver;
	public HeaderPage(WebDriver driver) {
	this.driver = driver;
}
	By addButton = By.xpath("//ul[@class='more-list']//span");
	By actionButton = By.xpath("//ul[@class='dropdown-menu pull-right']//li ");
	
	public void list(String menuOption ) {
		List<WebElement> menuList=driver.findElements(addButton);
		for(WebElement menu:menuList) {
			String text=menu.getAttribute("class");
			if(text.contentEquals(menuOption)) {
				menu.click();
				break;
			}
		}
		}
	
	public void blueActionButton(String menuOption) {
		List<WebElement> menuList=driver.findElements(actionButton);
		for(WebElement menu:menuList) {
			String text=menu.getAttribute("class");
			if(text.contentEquals(menuOption)) {
				menu.click();
				break;
			}
		}
	}
	
	
	
}
