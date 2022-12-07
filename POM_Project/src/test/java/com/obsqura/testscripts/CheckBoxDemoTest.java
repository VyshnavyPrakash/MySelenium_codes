package com.obsqura.testscripts;

import org.testng.annotations.Test;

import com.obsqura.POM_Project.Base;
import com.obsqura.pages.CheckBoxDemoPage;

public class CheckBoxDemoTest extends Base {
	CheckBoxDemoPage obj;
	@Test
	public void verifyTheCheckBoxAndGetMsg() {
		obj = new CheckBoxDemoPage(driver);
		obj.verifySingleCheckBoxSelected();
	}
	@Test
	public void verifyMultipleCheckBox() {
		obj = new CheckBoxDemoPage(driver);
		obj.verifyMultipleCheckBoxselected();
	}

}
