package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	
	public static ExtentReports getExtentReport() {//Static method -- static keyword use krte hai method me taki class name se sath dot(.) method name
													//extend ho jaye or agr static keywork ka use nhi krte to object create krna pdta then extend kr pate child class me
		ExtentReports report = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReport\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		report.attachReporter(sparkReporter);
		return report; 
	} 
}
