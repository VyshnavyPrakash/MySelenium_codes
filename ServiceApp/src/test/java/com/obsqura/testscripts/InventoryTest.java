package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.InventoryPage;
import com.obsqura.pages.LoginAccountPage;

public class InventoryTest extends Base{
	InventoryPage obj;
	LoginAccountPage obj1;
	@Test  
	public void verifyAddInventoryProduct() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.addInventoryProduct();
	}
	@Test
	public void verifyDelectingInventory() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.delectInventoryVerification();
	}
	@Test
	public void verifyrowCountWithSameName() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.rowCountWithSameNameVerification();
	}
	@Test
	public void verifyUserIsAbleToNavigateToNextPageOnClickingNextOption() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.navigateToNextPageOnClickingNextOptionVerification();
	}

}
