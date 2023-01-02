package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.HeaderPage;
import com.obsqura.pages.RadioButtonDemoPages;
import com.obsqura.pom_project.Base;

public class RadioButtonDemoTest extends Base {
	RadioButtonDemoPages obj;
	HeaderPage obj1;
	@Test
    public void verifyRadioButtonSelectedAndGetTheMsg() throws IOException {
    	obj = new RadioButtonDemoPages(driver);
    	obj1 = new HeaderPage(driver);
    	obj1.list("Radio Buttons Demo");
    	obj.verifyRadioButtonSelected();
    	
    }
	@Test
	public void verifyGroupRadioButtonAndGetTheMsg() throws IOException {
		obj1 = new HeaderPage(driver);
		obj = new RadioButtonDemoPages(driver);
		obj1.list("Radio Buttons Demo");
		obj.verifyGroupRadioButtonSelected();
	}
}

	
		
	

 