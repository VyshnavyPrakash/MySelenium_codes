package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.ServiceApp.Base;
import com.obsqura.pages.ExportClientDataToExcelPage;

public class ExportClientDataToExcelTest extends Base {
	ExportClientDataToExcelPage obj;
	@Test
	public void verifyThatUserIsAbleToExportClientDataToExcel() throws IOException {
		obj = new ExportClientDataToExcelPage(driver);
		obj.clientDataConvertToExcelVerification();
	}

}
