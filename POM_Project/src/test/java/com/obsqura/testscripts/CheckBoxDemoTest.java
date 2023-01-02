package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.CheckBoxDemoPage;
import com.obsqura.pages.HeaderPage;
import com.obsqura.pom_project.Base;

public class CheckBoxDemoTest extends Base {
	HeaderPage obj1;
	CheckBoxDemoPage obj;
	
	@Test
	public void verifyTheCheckBoxAndGetMsg() throws IOException {
		obj1 = new HeaderPage(driver);
		obj1.list("Checkbox Demo");
		obj = new CheckBoxDemoPage(driver);
		obj.verifySingleCheckBoxSelected();
	}
	@Test
	public void verifyMultipleCheckBox() throws IOException {
		obj1 = new HeaderPage(driver);
		obj1.list("Checkbox Demo");
		obj = new CheckBoxDemoPage(driver);
		obj.verifyMultipleCheckBoxselected();
	}

}
