package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.SimpleFormDemoPage;
import com.obsqura.pom_project.Base;

public class SimpleFormDemoTest extends Base {
	SimpleFormDemoPage obj;
	@Test
	public void enterMessageAndVerifySingleInputPage() throws IOException {
		obj = new SimpleFormDemoPage(driver);
		obj.verifyenterMessageFields();
		
	}
	@Test
	public void enterMessageAndVerifyMultipleInputField() throws IOException {
		obj = new SimpleFormDemoPage(driver);
		obj.verifymultipleInputFields();
	}
	

}
