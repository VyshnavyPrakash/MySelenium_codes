package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
 
public class HeaderPage {
	WebDriver driver;
	public HeaderPage(WebDriver driver) {
	this.driver = driver;
}
	By driverNavigate = By.xpath("//ul[@class='list-group list-group-flush']//li");
	By collapseNavBar = By.xpath("//ul[@class='navbar-nav']//li");
	
	public void list(String menuOption ) {
		List<WebElement> menuList=driver.findElements(driverNavigate);

			for(WebElement menu:menuList) {
			String text=menu.getText();
			if(text.contentEquals(menuOption)) {
				menu.click();
				break;
			}
			}
		}
	
	public void list2(String menuOption ) {
		List<WebElement> menuList=driver.findElements(collapseNavBar);

			for(WebElement menu:menuList) {
			String text=menu.getText();
			if(text.equalsIgnoreCase(menuOption)) {
				menu.click();
				break;
			}
			}
		}
	
}
