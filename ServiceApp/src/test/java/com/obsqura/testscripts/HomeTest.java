package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginAccountPage;

public class HomeTest extends Base {
	HomePage obj;
	LoginAccountPage loginpage;
	
	@Test
	public void verifyQuickEmailFieldWithoutMsg() throws IOException {
		obj = new HomePage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		obj.quickemailFieldWithoutMsg();
	}
	@Test
    public void verifyQuickEmailFieldWithoutSubject() throws IOException {
	   obj = new HomePage(driver);
	   loginpage = new LoginAccountPage(driver);
	   loginpage.loginAccountVerification();
	   obj.quickemailFieldWithoutSubject();
    }
	@Test
	public void verifyQuickEmailFieldWithoutEmail() throws IOException {
		 obj = new HomePage(driver);
		 loginpage = new LoginAccountPage(driver);
		 loginpage.loginAccountVerification();
		 obj.quickemailFieldWithoutEmail();
	}
	@Test
	public void verifyThatUserIsAbleToNavigateToQualityAlertPage() throws IOException {
	   obj = new HomePage(driver);
	   loginpage = new LoginAccountPage(driver);
	   loginpage.loginAccountVerification();
	   obj.navigateToQualityAlertVerification();
	}
	@Test
	public void verifyUserIsAbleTNavigateToInventoryPage() throws IOException {
	   obj = new HomePage(driver);
	   loginpage = new LoginAccountPage(driver);
	   loginpage.loginAccountVerification();
	   obj.navigateToInventoryPageVerification();
	}
	@Test
	public void verifyUserIsAbleTNavigateToClientPage() throws IOException {
		   obj = new HomePage(driver);
		   loginpage = new LoginAccountPage(driver);
		   loginpage.loginAccountVerification();
		   obj.clientPageVerification();
    }
	@Test
	public void verifyUserIsAbleTNavigateToReparationPage() throws IOException {
		   obj = new HomePage(driver);
		   loginpage = new LoginAccountPage(driver);
		   loginpage.loginAccountVerification();
		   obj.reparationPageVerification();
	}
	@Test
	public void verifyQuickSMSFieldWithoutMsg() throws IOException {
		   obj = new HomePage(driver);
		   loginpage = new LoginAccountPage(driver);
		   loginpage.loginAccountVerification();
		   obj.quickSMSFieldWithoutMsg();
	}
	
}
