package com.obsqura.Automationcourse;

import org.junit.Assert;

public class GroceryStoreTitleAndUrl extends GroceryStore {
	

	public void getTitle() {
		
		String expectedTitle = "Grocerystore";
		String title = driver.getTitle();
		Assert.assertEquals(expectedTitle, title);
	}
	
	public void getURL() {
		driver.getCurrentUrl();
	}

	public static void main(String[] args) {
		GroceryStoreTitleAndUrl obj = new GroceryStoreTitleAndUrl();
		obj.initializeBrowser();
		obj.getTitle();
		obj.getURL();
		obj.browserClose();
		

	}

}
