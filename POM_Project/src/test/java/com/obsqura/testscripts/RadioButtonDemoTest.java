package com.obsqura.testscripts;

import org.testng.annotations.Test;

import com.obsqura.POM_Project.Base;
import com.obsqura.pages.RadioButtonDemoPages;

public class RadioButtonDemoTest extends Base {
	RadioButtonDemoPages obj;
	@Test
	public void verifyRadioBuutonSelectedAndGetTheMsg() {
		obj = new RadioButtonDemoPages(driver);
		obj.verifyRadioButtonSelected();
	}
	@Test
	public void verifyGroupRadioButtonIsSelectedAndGetMsg() {
		obj = new RadioButtonDemoPages(driver);
		obj.verifyGroupRadioButtonSelected();
	}
}

	
		
	

