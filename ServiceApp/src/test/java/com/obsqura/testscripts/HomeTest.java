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
	public void verifyQuickEmailFieldWithoutEmail() throws IOException {
		 obj = new HomePage(driver);
	     obj1 = new LoginAccountPage(driver);
		 obj1.loginAccountVerification();
		 obj.quickemailFieldWithoutEmail();
	}
	@Test
	public void verifyThatUserIsAbleToNavigateToQualityAlertPage() throws IOException, InterruptedException {
	   obj = new HomePage(driver);
	   obj1 = new LoginAccountPage(driver);
	   obj1.loginAccountVerification();
	   obj.navigateToQualityAlertVerification();
	}
	@Test
	public void verifyUserIsAbleTNavigateToInventoryPage() throws IOException {
	   obj = new HomePage(driver);
	   obj1 = new LoginAccountPage(driver);
	   obj1.loginAccountVerification();
	   obj.navigateToInventoryPageVerification();
	}
	@Test
	public void verifyUserIsAbleTNavigateToClientPage() throws IOException {
		   obj = new HomePage(driver);
		   obj1 = new LoginAccountPage(driver);
		   obj1.loginAccountVerification();
		   obj.clientPageVerification();
    }
	@Test
	public void verifyUserIsAbleTNavigateToReparationPage() throws IOException {
		   obj = new HomePage(driver);
		   obj1 = new LoginAccountPage(driver);
		   obj1.loginAccountVerification();
		   obj.reparationPageVerification();
	}
	@Test
	public void verifyQuickSMSFieldWithoutMsg() throws IOException {
		   obj = new HomePage(driver);
		   obj1 = new LoginAccountPage(driver);
		   obj1.loginAccountVerification();
		   obj.quickSMSFieldWithoutMsg();
	}
	
}
