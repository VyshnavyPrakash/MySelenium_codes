package com.obsqura.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	    public static final ExtentReports extentReports = new ExtentReports();
		public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("Sample Extent Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Blog Name", "Obsqura");
		extentReports.setSystemInfo("Author", "Vyshnavy Prakash");
		return extentReports;
		}
}
