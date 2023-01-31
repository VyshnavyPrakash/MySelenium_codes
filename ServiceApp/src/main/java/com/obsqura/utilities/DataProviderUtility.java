package com.obsqura.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	public static void sentKeyValue(WebDriver driver,WebElement element,String newString) {
		element.sendKeys(newString);
	}
		@DataProvider(name="searchProvider")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] {
	    	{"Amalu","ust","xyzzz kottayam","amalu123@gmail.com","Client: Amalu"}
	    };
		}
}


	
