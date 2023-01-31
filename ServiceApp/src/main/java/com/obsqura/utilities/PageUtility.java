package com.obsqura.utilities;

	import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class PageUtility {
	public static void clickOnElement(WebElement element) {
	element.click();
	}

	public static WebElement enterText(WebElement element, String value) {
	element.sendKeys(value);
	return element;
	}

	public static String getElementText(WebElement element) {
	return element.getText();
	}
	
	public static int getElementRowSize(List<WebElement> element) {
	return element.size();
	}
	
	public static int getElementColumnSize(List<WebElement> element) {
	return element.size();
	}

	public static void clickAndHoldOnElement(WebElement element, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.clickAndHold(element).build().perform();
	}

	public static void selectDropdownbyText(WebElement element, String text) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
	}

	public static void selectDropdownbyIndex(WebElement element, int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
	}
	
	public static void selectDropdownbyValue(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByValue(value);
	}
	
	public static WebElement enterIntValue(WebElement element, CharSequence[] value) {
	element.sendKeys(value);
	return element;
	}
	
	public static WebElement enterStringValue(WebElement element, String value) {
	element.sendKeys(value);
	return element;
	}
	
	public static Boolean isElementDisplayed(WebElement element) {
	return element.isDisplayed();
	}
	
	public static Boolean isElementEnabled(WebElement element) {
	return element.isEnabled();
	}
	
	public static Boolean isElementSelected(WebElement element) {
	return element.isSelected();
	}
	public void mediumDelay(int x) throws InterruptedException {
	  Thread.sleep(x);
	}
	
	public static void ScrollBy(WebDriver driver) {
	JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	Js1.executeScript("window.scrollBy(0,1000)");
	}

	public static void stopPageRefresh(WebDriver driver) {
	JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	Js1.executeScript("window.stop();");

	}
	public static void selectElementFromListUsingGetText(List<WebElement> element,String value) {
		for(WebElement menu:element) {
			String text=menu.getText();
		if(text.contentEquals(value)) {
			menu.click();
		    break;
        }	
		}
	}
	public static void selectElementFromListUsingGetAttribute(List<WebElement> element,String attri,String value) {
		
	
		for(WebElement menu:element) {
			String attribute =menu.getAttribute(attri);
			if(attribute.contentEquals(value)) {
				menu.click();
		        break;
			}
			}
	}
	}


