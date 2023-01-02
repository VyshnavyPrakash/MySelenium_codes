package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.HeaderPage;
import com.obsqura.pages.TablePage;
import com.obsqura.pom_project.Base;

public class TablePageTest extends Base {
	
	TablePage obj;
	HeaderPage obj1;
	@Test
	public void verifyTableDemo() throws IOException {
		obj1 = new HeaderPage(driver);
		obj = new TablePage(driver);
		obj1.list2("Table");
		obj.verifyTable();
	}
}
