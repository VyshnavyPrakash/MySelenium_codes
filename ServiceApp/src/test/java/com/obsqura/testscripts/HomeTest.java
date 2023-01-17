package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginAccountPage;

public class HomeTest extends Base {
	HomePage obj;
	LoginAccountPage obj1;
	@Test
	public void verifyThatWeCanSentQuickSMS() throws IOException {
		obj = new HomePage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.quickSMSSentVerification();
	}
	@Test
	public void verifyThatWeCanSentQuickEmail() throws IOException {
		obj = new HomePage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.quickEmailSentVerification();
	}
	
	public void verifyQuickEmailFieldWithoutMsg() throws IOException {
		obj = new HomePage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.quickemailFieldWithoutMsg();
	}
	@Test
    public void verifyQuickEmailFieldWithoutSubject() throws IOException {
	obj = new HomePage(driver);
	obj1 = new LoginAccountPage(driver);
	obj1.loginAccountVerification();
	obj.quickemailFieldWithoutSubject();
}
	@Test
	public void verifyThatUserIsAbleToNavigateToQualityAlertPage() throws IOException {
		obj = new HomePage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.navigateToQualityAlertVerification();
	}
	@Test
	public void verifyCalenderViewIcons() throws IOException {
		obj = new HomePage(driver);
		obj1 = new LoginAccountPage(driver);
		obj1.loginAccountVerification();
		obj.calenderViewVerification();
	}
}
