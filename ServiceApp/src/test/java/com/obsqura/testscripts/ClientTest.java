package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.LoginAccountPage;

public class ClientTest extends Base {
	ClientPage obj;
	LoginAccountPage obj1;
	@Test
	public void verifyThatUserIsAbleToAddClient() throws IOException, InterruptedException {
		obj = new ClientPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.addingClientDetails();
	}
	@Test
	public void verifyUserIsableToAddClientDetailsWithoutClientName() throws IOException {
		obj = new ClientPage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.addingClientDetailsWithoutClientName();
	}
	@Test
	 public void verifyingShowButtonGivesCorrectNumberOfRows() throws IOException, InterruptedException {
		 obj = new ClientPage(driver);
		 obj1 = new LoginAccountPage(driver);
		 obj1.loginAccountVerification();
		 obj.clientShowButtonVerification();
	 }
	
	@Test
	public void vrifyUserIsAbleToNavigateToNextPageOnClickingNextOptionVerification() throws IOException {
		 obj = new ClientPage(driver);
		 obj1 = new LoginAccountPage(driver);
		 obj1.loginAccountVerification();
		 obj.navigateToNextPageOnClickingNextOptionVerification();
	}
}
