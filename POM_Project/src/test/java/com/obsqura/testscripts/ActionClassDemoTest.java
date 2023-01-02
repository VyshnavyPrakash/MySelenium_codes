package com.obsqura.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.obsqura.pages.ActionClassDemoPage;
import com.obsqura.pages.HeaderPage;
import com.obsqura.pom_project.Base;

public class ActionClassDemoTest extends Base {
	ActionClassDemoPage obj;
	HeaderPage obj1;
	
	@Test
	public void actionClassDemoSample() {
		obj = new ActionClassDemoPage(driver);
		obj1 = new HeaderPage(driver);
		obj1.list2("Others");
		obj.actionClassSample();
		
	}
	
}
