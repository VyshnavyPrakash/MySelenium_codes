package com.obsqura.TestNGProject;

import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BasicCommandsOB extends Base {
	@Test
	public void singleInputFileldVerification() {
		 String  inputMessage = "Hello", actualMessage;
		 String expectedMessage = "Your Message :"+inputMessage;
		 driver.findElement(By.id("single-input-field")).sendKeys(inputMessage);
	     driver.findElement(By.xpath("//button[@id='button-one']")).click();
	     actualMessage = driver.findElement(By.id("message-one")).getText();
	     Assert.assertEquals(actualMessage,expectedMessage,"Messages are not equal" );
	     }
	@Test
	public void clearSample() {
		  WebElement enterMsgField = driver.findElement(By.id("single-input-field"));
		  enterMsgField.sendKeys("Hello");
		  enterMsgField.clear();
	      WebElement showMsg = driver.findElement(By.xpath("//button[@id='button-one']"));
		  showMsg.isEnabled();
		  showMsg.isDisplayed();
		  showMsg.isSelected();
	      }
	@Test
	public void Sample2() {
		 boolean isMessageFieldDisplayed,isButtonDisplayed,isMessageFieldEnabled,isButtonEnabled;
		 WebElement msgField = driver.findElement(By.id("single-input-field"));
		 WebElement button = driver.findElement(By.xpath("//button[@id='button-one']"));
		 WebElement msg = driver.findElement(By.id("message-one"));
	     isMessageFieldDisplayed = msgField.isDisplayed();
		 isButtonDisplayed = button.isDisplayed();
		 String expectedMessage = "Your Message : Hello"; 
		 if(isMessageFieldDisplayed&&isButtonDisplayed) {
		 msgField.sendKeys("Hello");
		 }
		 isMessageFieldEnabled = msgField.isEnabled();
	     isButtonEnabled = button.isEnabled(); 
		 if(isButtonEnabled) {
		 button.click();
		 String actualMessage = msg.getText();
		 Assert.assertEquals(actualMessage ,expectedMessage,"Is not enabled");
		 }
		 Assert.assertTrue(isButtonEnabled,"Button is not enabled");
		 Assert.assertTrue(isMessageFieldEnabled,"Message field is not enabled");
		 Assert.assertTrue(isButtonDisplayed,"Button is not displayed");
		 Assert.assertTrue(isMessageFieldDisplayed,"Message field is not displayed");
	     }
	@Test
	public void getAttribute() {
		 String classname = driver.findElement(By.xpath("//button[@id='button-one']")).getAttribute("class");
		 String tagName = driver.findElement(By.xpath("//button[@id='button-one']")).getTagName();
		 String backgroundColour = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("background-color");
		 String fontColour = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("color");
		 String borderColour = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("border-color");
		 String borderRadius = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("border-radius");
		 Dimension buttonSize = driver.findElement(By.xpath("//button[@id='button-one']")).getSize();
		 int buttonHeight = buttonSize.getHeight();
	     }
	@Test
	public void getTotalBoxAttribute() {
		 int expectedButtonHeight=38,actualButtonHeight,expectedButtonWidth=89,actualButtonWidth;
		 String expectedShape="border-box",actualShape,expectedColour="rgba(0, 123, 255, 1)",actualColour,	
		 expectedFontSize="16px",actualFontSize,expectedFontWeight="400",actualFontWeight;
		 actualButtonHeight = driver.findElement(By.xpath("//button[@id='button-two']")).getSize().height;
		 actualButtonWidth  = driver.findElement(By.xpath("//button[@id='button-two']")).getSize().width;
		 actualShape = driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("box-sizing");
		 actualColour = driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("background-color");
		 actualFontSize = driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font-size");
		 actualFontWeight =  driver.findElement(By.xpath("//button[@id='button-two']")).getCssValue("font-weight");
		
		 SoftAssert softassert = new SoftAssert();
		 softassert.assertEquals(expectedButtonHeight,actualButtonHeight);
		 softassert.assertEquals(expectedButtonWidth, actualButtonWidth);
		 softassert.assertEquals(expectedShape,actualShape);
		 softassert.assertEquals(expectedColour, actualColour);
		 softassert.assertEquals(expectedFontSize, actualFontSize);
		 softassert.assertEquals(expectedFontWeight, actualFontWeight);
		 softassert.assertAll();
	     }
	@Test
	public void getLocation() {
		 boolean greater = false;
	     Point showMessage = driver.findElement(By.xpath("//button[@id='button-one']")).getLocation();
	     Point enterMessage = driver.findElement(By.xpath("//input[@id='single-input-field']")).getLocation();
	     int x1 = showMessage.getX(); //305
	     int y1 = showMessage.getY(); //257
	     int x2 = enterMessage.getX(); //305
	     int y2 = enterMessage.getY(); //203 
	     if(y1>y2) {
	    	 greater = true;
	    	 Assert.assertTrue(greater, "Show msg button place is not under enter message field");
	     }	     
	     }
	@Test
	public void List() {
		List<WebElement>menuList = driver.findElements(By.xpath("//ul[@class='list-group list-group-flush']/li"));
		for(WebElement inputMenu : menuList) {
		String text = inputMenu.getText();
		if(text.contentEquals("Radio Buttons Demo")) {
		inputMenu.click();
	    break;
			
		  }	 
		}
	  }
	@Test
	public void List2() {
		List<WebElement>menuList = driver.findElements(By.xpath("//ul[@class='navbar-nav']/li"));
		for(WebElement menu : menuList) {
		String text = menu.getText();
		if(text.contentEquals("DATE PICKERS")) {
		menu.click();
		break;
		}
	  }
		
	}
	
  }	
 
