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
	public void verifyrowCountWithSameName() throws IOException, InterruptedException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.rowCountWithSameNameVerification();
	}
	
	@Test
	public void verifyUserIsAbleToNavigateToNextPageOnClickingNextOption() throws IOException, InterruptedException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.navigateToNextPageOnClickingNextOptionVerification();
	}
	@Test
	public void verifyuserIsAbleToEditInventoryProduct() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.UserIsAbleToEditInventoryProductVerification();
	}
	@Test
	public void verifyExportFileWithoutSelectingProduct() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.exportToExcelFileWithoutSelectingProduct();
	}
	public void verifyExportToPdfFileWithoutSelectingProduct() throws IOException {
		obj = new InventoryPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.exportToPdfFileWithoutSelectingProduct();
	}
	

}
