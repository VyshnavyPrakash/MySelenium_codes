package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.LoginAccountPage;
import com.obsqura.pages.ReparationPage;

public class ReparationTest extends Base {
	ReparationPage obj;
	LoginAccountPage obj1;
	@Test(priority=1)
	public void verifyCorrectNumberOfRowsAreShownOnSelectingShowButton() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.rowNumberInShowButtonVerification();	
	}
	@Test(priority=2)
	public void verifyThatauserIsAbleTodownloadReparationExcelSheet() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.downloadingReparationExcelSheet();
	}
	@Test(priority=3)
	public void verifycolumnVisibility() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.columnVisibilityVerification();
	}
	@Test(priority=4)
	public void verifyRowCountWithSameName() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.rowCountWithSameNameVerification();
	}
	@Test(priority=5)
	public void verifyTotalCompletedRepairRows() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.totalCompletedRepairRows();
	}
	@Test(priority=6)
	public void verifycolumnNumber() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.columnNumberVerification();
	}
	@Test(priority=7)
	public void rowNumberInShowButtonVerificationForPendingRepairs() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.rowNumberInShowButtonVerificationForPendingRepairs();
	}
	
	
}
