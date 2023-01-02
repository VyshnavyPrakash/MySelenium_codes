package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecuterDemoPage {
WebDriver driver;
	
	public JavaScriptExecuterDemoPage(WebDriver driver) {
	this.driver = driver;
}
	By button = By.xpath("//button[@id='button-one']");
	By msgBox = By.xpath("//input[@id='single-input-field']");
public void javaScript() {
    	WebElement showMessageButton = driver.findElement(button);
    	driver.findElement(msgBox).sendKeys("hello");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(button));
		executor.executeScript("window.scrollBy(0,250)", "");
		executor.executeScript("window.scrollBy(0,-250)", "");
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		executor.executeScript("arguments[0].scrollIntoView();", showMessageButton);
	}


}
