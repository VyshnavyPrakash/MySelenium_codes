package com.obsqura.Automationcourse;

public class GroceryStoreNavigate extends GroceryStore {
	
	public void navigate() {
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void main(String[] args) {
		GroceryStoreNavigate obj = new GroceryStoreNavigate();
		obj.initializeBrowser();
		obj.navigate();
		
	}

}
