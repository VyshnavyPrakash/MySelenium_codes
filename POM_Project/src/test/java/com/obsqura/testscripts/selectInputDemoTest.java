package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.HeaderPage;
import com.obsqura.pages.SelectInputDemoPages;
import com.obsqura.pom_project.Base;

public class selectInputDemoTest extends Base {
	HeaderPage obj1;
	SelectInputDemoPages obj;
	@Test
	public void  verifySelectInputColorUsingVisibleText() throws IOException {
		obj1 = new HeaderPage(driver);
		obj1.list("Select Input");
		obj = new SelectInputDemoPages(driver);
		obj.verifySelectInputByVisibleText();
	}
	@Test
	public void verifySelectInputColorUsingIndex() throws IOException {
		obj1 = new HeaderPage(driver);
		obj1.list("Select Input");
		obj = new SelectInputDemoPages(driver);
		obj.verifySelectInputByIndex();
	}
	@Test
	public void verifySelectInputColorUsingValue() throws IOException {
		obj1 = new HeaderPage(driver);
		obj1.list("Select Input");
		obj = new SelectInputDemoPages(driver);
		obj.verifySelectInputByValue();
	}
	@Test
	public void verifyTwoInputFieldColorAndGetMsg() throws IOException {
		obj1 = new HeaderPage(driver);
		obj1.list("Select Input");
		obj = new SelectInputDemoPages(driver);
		obj.verifyTwoInputField();
	}

}
