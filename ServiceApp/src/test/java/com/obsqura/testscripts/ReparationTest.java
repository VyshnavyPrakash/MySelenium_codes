package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.LoginAccountPage;
import com.obsqura.pages.ReparationPage;

public class ReparationTest extends Base {
	ReparationPage reparationpage;
	LoginAccountPage loginpage;
	@Test(priority=1)
	public void verifyCorrectNumberOfRowsAreShownOnSelectingShowButton() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.rowNumberInShowButtonVerification();	
	}
	@Test(priority=2)
	public void verifyThatauserIsAbleTodownloadReparationExcelSheet() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.downloadingReparationExcelSheet();
	}
	@Test(priority=3)
	public void verifycolumnVisibility() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.columnVisibilityVerification();
	}
	@Test(priority=4)
	public void verifyRowCountWithSameName() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.rowCountWithSameNameVerification();
	}
	@Test(priority=5)
	public void verifyTotalCompletedRepairRows() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.totalCompletedRepairRows();
	}
	@Test(priority=6)
	public void verifycolumnNumber() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.columnNumberVerification();
	}
	@Test(priority=7)
	public void rowNumberInShowButtonVerificationForPendingRepairs() throws IOException {
		reparationpage = new ReparationPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		reparationpage.rowNumberInShowButtonVerificationForPendingRepairs();
	}
	
	
}
