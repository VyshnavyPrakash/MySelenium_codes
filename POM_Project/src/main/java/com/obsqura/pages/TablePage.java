package com.obsqura.pages;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;

public class TablePage {
	WebDriver driver;
	public TablePage(WebDriver driver) {
	this.driver = driver;
}
	
	By rowsNumber = By.xpath("//tr[@class='even' or @class = 'odd']");
	By columnsNumber = By.xpath("//th[@class='th-sm sorting_disabled']");
	
	public void verifyTable() throws IOException {
        String actualMsg= null ,expectedMsg = ExcelUtility.getString(0, 1,  System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","Sheet5");
        boolean compareElement;
        
		List<WebElement> TableRowCount = driver.findElements(rowsNumber);
		List<WebElement> TableColumnCount = driver.findElements(columnsNumber);
		int rowCount = TableRowCount.size();
		int columnCount = TableColumnCount.size();
		for(WebElement row:TableRowCount) {
			actualMsg =row.getText();
			compareElement = actualMsg.contentEquals(expectedMsg);
			if(compareElement) {
			
			  break;
			  
			}
		}
   Assert.assertEquals(actualMsg, expectedMsg,"content not equals");

		
	}
}
		


