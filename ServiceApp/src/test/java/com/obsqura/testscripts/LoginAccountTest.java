package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.LoginAccountPage;

public class LoginAccountTest extends Base {
	LoginAccountPage obj;
	@Test
	public void verifyUserIsAbleToLogin() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginAccountVerification();
		
	}
	@Test
	public void verifyLoginWithWrongPassword() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginWithWrongPassword();
	}
	
	public void verifyUserIsAbleToLogOut() throws IOException {
		obj = new LoginAccountPage(driver);
		obj.loginWithWrongPassword();
		obj.logoutVerification();
	}

}
