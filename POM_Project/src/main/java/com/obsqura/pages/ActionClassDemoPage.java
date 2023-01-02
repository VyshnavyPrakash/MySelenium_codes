package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemoPage {
	WebDriver driver;
	
	public ActionClassDemoPage(WebDriver driver) {
	this.driver = driver;
}
	By element = By.xpath("//a[@href='dynamic-load.php']");
	By buttonUser = By.xpath("//button[@id='save']");
	By draggableItem = By.xpath("//span[@draggable='true'][1]");
	By destination = By.xpath("//div[@id='mydropzone']");
	
 public void actionClassSample() {
	 WebElement elementMenu,buttonMenu,dragElement,dropElement;
	 Actions action = new Actions(driver); 
	 elementMenu = driver.findElement(element);
	// buttonMenu = driver.findElement(buttonUser);
    // action.moveToElement(element).click().perform();
    // action.contextClick(element).build();
	 dragElement = driver.findElement(draggableItem);
	 dropElement = driver.findElement(destination);
     action.dragAndDrop(dragElement, dropElement).perform();
     action.moveToElement(dragElement).perform();       //mouse over 
	 
 }
}
