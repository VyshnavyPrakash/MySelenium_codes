package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.LoginAccountPage;

public class ClientTest extends Base {
	ClientPage clientpage;
	LoginAccountPage loginpage;
	@Test(priority = 1)
	public void verifyThatUserIsAbleToAddClient() throws IOException {
		clientpage = new ClientPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		clientpage.addingClientDetails();
	}
	@Test(priority = 2)
	public void verifyUserIsableToAddClientDetailsWithoutClientName() throws IOException {
		clientpage = new ClientPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		clientpage.addingClientDetailsWithoutClientName();
	}
	@Test(priority = 3)
	 public void verifyingShowButtonGivesCorrectNumberOfRows() throws IOException {
		clientpage = new ClientPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		clientpage.clientShowButtonVerification();
	 }
	
	@Test(priority = 4)
	public void vrifyUserIsAbleToNavigateToNextPageOnClickingNextOptionVerification() throws IOException {
		clientpage = new ClientPage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		clientpage.navigateToNextPageOnClickingNextOptionVerification();
	}
}
