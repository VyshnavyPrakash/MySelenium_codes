package com.obsqura.testscripts;

import org.testng.annotations.Test;

import com.obsqura.POM_Project.Base;
import com.obsqura.pages.SimpleFormDemoPage;


public class SimpleFormDemoTest extends Base {
	SimpleFormDemoPage obj;
	
	@Test
	public void enterMessageandVerifySingleInputField() {
		obj = new SimpleFormDemoPage(driver);
		obj.verifyenterMessageFields();
	}
	@Test
	public void enterMessageandVerifymultipleInputField() {
		obj = new SimpleFormDemoPage(driver);
		obj.verifymultipleInputFields();
	}
	
		
}
