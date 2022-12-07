package com.obsqura.testscripts;

import org.testng.annotations.Test;
import com.obsqura.POM_Project.Base;
import com.obsqura.pages.SelectInputDemoPages;

public class selectInputDemoTest extends Base {
	SelectInputDemoPages obj;
	@Test
	public void verifySelectInputColorUsingVisibleText() {
		obj = new SelectInputDemoPages(driver);
		obj.verifySelectInputByVisibleText();
	}
	@Test
	public void verifySelectInputColorUsingIndex() {
		obj = new SelectInputDemoPages(driver);
		obj.verifySelectInputByIndex();
	}
	@Test
	public void verifySelectInputColorUsingValue() {
		obj = new SelectInputDemoPages(driver);
		obj.verifySelectInputByValue();
	}
	@Test
	public void verifyTwoInputFieldColorAndGetMsg() {
		obj = new SelectInputDemoPages(driver);
		obj.verifyTwoInputField();
	}

}
