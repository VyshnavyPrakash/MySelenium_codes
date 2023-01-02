package com.obsqura.testscripts;

import org.testng.annotations.Test;

import com.obsqura.pages.JavaScriptExecuterDemoPage;
import com.obsqura.pom_project.Base;

public class JavaScriptExecuterDemoTest extends Base {
	JavaScriptExecuterDemoPage obj;
	@Test
	public void javaScriptExecters() {
		obj = new JavaScriptExecuterDemoPage(driver);
		obj.javaScript();
	}
}
