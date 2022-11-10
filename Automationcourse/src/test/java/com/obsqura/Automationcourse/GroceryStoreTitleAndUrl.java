package com.obsqura.Automationcourse;


public class GroceryStoreTitleAndUrl extends GroceryStore {
	

	public void getTitle() {
		
		
		String title = driver.getTitle();
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
