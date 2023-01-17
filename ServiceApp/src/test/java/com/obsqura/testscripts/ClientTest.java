package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.LoginAccountPage;

public class ClientTest extends Base {
	ClientPage obj;
	LoginAccountPage obj1;
	
	public void verifyThatUserIsAbleToAddClient() throws IOException {
		obj = new ClientPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.addingClientDetails();
	}
	@Test
	public void verifyThatUserIsAbleToDelectAClient() throws IOException {
		obj = new ClientPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.delectingClientDetails();
	}
	@Test
	 public void verifyingShowButtonGivesCorrectNumberOfRows() throws IOException {
		 obj = new ClientPage(driver);
		 obj1 = new LoginAccountPage(driver);
		 obj1.loginAccountVerification();
		 obj.clientShowButtonVerification();
	 }
	@Test
	public void verifyClientDetailsExportToExcelFile() throws IOException {
		 obj = new ClientPage(driver);
		 obj1 = new LoginAccountPage(driver);
		 obj1.loginAccountVerification();
		 obj.clientdetailsExportToExcelFile();
	}
	@Test
	public void verifyClientDetailsExportToPdfFile() throws IOException {
		 obj = new ClientPage(driver);
		 obj1 = new LoginAccountPage(driver);
		 obj1.loginAccountVerification();
		 obj.clientDetailsExportToPdfFile();
	}
}
