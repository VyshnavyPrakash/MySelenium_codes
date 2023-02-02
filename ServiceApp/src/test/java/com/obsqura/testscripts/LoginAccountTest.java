package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.LoginAccountPage;

public class LoginAccountTest extends Base {
	LoginAccountPage loginpage;
	
	@Test(groups= {"smokeTesting"})
	public void verifyUserIsAbleToLogin() throws IOException {
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
	}
	@Test(priority=2)
	public void verifyLoginWithWrongPassword() throws IOException {
		loginpage = new LoginAccountPage(driver);
		loginpage.loginWithWrongPassword();
	}
	@Test(priority=3)
	public void verifyLoginWithWrongUsername() throws IOException {
		loginpage = new LoginAccountPage(driver);
		loginpage.loginWithWrongUserName();
	}
	
	@Test(priority=4)
	public void verifyForgotPassword() throws IOException {
		loginpage = new LoginAccountPage(driver);
		loginpage.forgotPasswordVerification();
	}
	@Test(priority=5)
	public void verifyBackToLogin() throws IOException {
		loginpage = new LoginAccountPage(driver);
		loginpage.backToLoginVerification();
	}
	@Test(priority=6)
	public void verifyUserIsAbleToLogOut() throws IOException {
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		loginpage.logoutVerification();
	}

}
