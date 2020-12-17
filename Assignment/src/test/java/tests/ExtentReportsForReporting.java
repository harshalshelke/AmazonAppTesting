package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsForReporting {
	ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;

	@BeforeSuite
	public void reportStatus() {

		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\Harshal Shelke\\eclipse-workspace\\Assignment\\src\\test\\resources\\EbayAppReport.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@AfterSuite
	public void reportTearDown() {

		extent.flush();

	}
}
