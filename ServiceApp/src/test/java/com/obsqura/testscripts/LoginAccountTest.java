package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.LoginAccountPage;

public class LoginAccountTest extends Base {
	LoginAccountPage obj;
	
	@Test(priority=1)
	public void verifyUserIsAbleToLogin() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginAccountVerification();
	}
	@Test(priority=2)
	public void verifyLoginWithWrongPassword() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginWithWrongPassword();
	}
	@Test(priority=3)
	public void verifyLoginWithWrongUsername() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginWithWrongUserName();
	}
	
	@Test(priority=4)
	public void verifyForgotPassword() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.forgotPasswordVerification();
	}
	@Test(priority=5)
	public void verifyBackToLogin() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.backToLoginVerification();
	}
	@Test(priority=6)
	public void verifyUserIsAbleToLogOut() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginAccountVerification();
		obj.logoutVerification();
	}

}
