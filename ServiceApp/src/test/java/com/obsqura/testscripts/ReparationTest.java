package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.LoginAccountPage;
import com.obsqura.pages.ReparationPage;

public class ReparationTest extends Base {
	ReparationPage obj;
	LoginAccountPage obj1;
	@Test
	public void verifyCorrectNumberOfRowsAreShownOnSelectingShowButton() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.rowNumberInShowButtonVerification();	
	}
	@Test
	public void verifyThatauserIsAbleTodownloadReparationExcelSheet() throws IOException {
		obj = new ReparationPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.downloadingReparationExcelSheet();
	}
}
