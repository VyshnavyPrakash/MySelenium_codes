package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.InventoryPage;
import com.obsqura.pages.LoginAccountPage;

public class InventoryTest extends Base{
	InventoryPage inventorytest;
	LoginAccountPage loginpage;
	@Test  
	public void verifyAddInventoryProduct() throws IOException {
		inventorytest = new InventoryPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		inventorytest.addInventoryProduct();
	}
	
	@Test
	public void verifyrowCountWithSameName() throws IOException {
		inventorytest = new InventoryPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		inventorytest.rowCountWithSameNameVerification();
	}
	
	@Test
	public void verifyUserIsAbleToNavigateToNextPageOnClickingNextOption() throws IOException {
		inventorytest = new InventoryPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		inventorytest.navigateToNextPageOnClickingNextOptionVerification();
	}
	@Test
	public void verifyuserIsAbleToEditInventoryProduct() throws IOException {
		inventorytest = new InventoryPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		inventorytest.UserIsAbleToEditInventoryProductVerification();
	}
	@Test
	public void verifyExportFileWithoutSelectingProduct() throws IOException {
		inventorytest = new InventoryPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		inventorytest.exportToExcelFileWithoutSelectingProduct();
	}
	public void verifyExportToPdfFileWithoutSelectingProduct() throws IOException {
		inventorytest = new InventoryPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		inventorytest.exportToPdfFileWithoutSelectingProduct();
	}
	

}
