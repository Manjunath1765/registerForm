package neogrowth.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("NeoGrowth web Automation");
		reporter.config().setDocumentTitle("NeoGrowth Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
		
	}

}
