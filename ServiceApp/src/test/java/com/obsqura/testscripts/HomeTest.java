package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginAccountPage;

public class HomeTest extends Base {
	HomePage homepage;
	LoginAccountPage loginpage;
	
	@Test
	public void verifyQuickEmailFieldWithoutMsg() throws IOException {
		homepage = new HomePage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		homepage.quickemailFieldWithoutMsg();
	}
	@Test
    public void verifyQuickEmailFieldWithoutSubject() throws IOException {
	   homepage = new HomePage(driver);
	   loginpage = new LoginAccountPage(driver);
	   loginpage.loginAccountVerification();
	   homepage.quickemailFieldWithoutSubject();
    }
	@Test
	public void verifyQuickEmailFieldWithoutEmail() throws IOException {
		 homepage = new HomePage(driver);
		 loginpage = new LoginAccountPage(driver);
		 loginpage.loginAccountVerification();
		 homepage.quickemailFieldWithoutEmail();
	}
	@Test
	public void verifyThatUserIsAbleToNavigateToQualityAlertPage() throws IOException {
	   homepage = new HomePage(driver);
	   loginpage = new LoginAccountPage(driver);
	   loginpage.loginAccountVerification();
	   homepage.navigateToQualityAlertVerification();
	}
	@Test
	public void verifyUserIsAbleTNavigateToInventoryPage() throws IOException {
	   homepage = new HomePage(driver);
	   loginpage = new LoginAccountPage(driver);
	   loginpage.loginAccountVerification();
	   homepage.navigateToInventoryPageVerification();
	}
	@Test
	public void verifyUserIsAbleTNavigateToClientPage() throws IOException {
		homepage = new HomePage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		homepage.clientPageVerification();
    }
	@Test
	public void verifyUserIsAbleTNavigateToReparationPage() throws IOException {
		homepage = new HomePage(driver);
		loginpage = new LoginAccountPage(driver);
		loginpage.loginAccountVerification();
		homepage.reparationPageVerification();
	}
	@Test
	public void verifyQuickSMSFieldWithoutMsg() throws IOException {
		   homepage = new HomePage(driver);
		   loginpage = new LoginAccountPage(driver);
		   loginpage.loginAccountVerification();
		   homepage.quickSMSFieldWithoutMsg();
	}
	
}
