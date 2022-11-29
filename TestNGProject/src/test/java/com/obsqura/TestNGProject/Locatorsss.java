package com.obsqura.TestNGProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

    public class Locatorsss extends Base{
	@Test
    public void idLocator() {
	driver.findElement(By.id("twotabsearchtextbox"));	   
      }
	@Test
	public void nameLocator() {
    driver.findElement(By.name("field-keywords"));
	  }
	@Test
	public void cssSelector() {
	driver.findElement(By.cssSelector("input#twotabsearchtextbox"));	
	 }
	
	
	 }
   
	
	
	   

