package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.Base;
import Utilities.ExtentReportGenerator;

public class MyListeners extends Base implements ITestListener{

	ExtentReports report = ExtentReportGenerator.getExtentReport();//Static method -- static keyword use krte hai method me taki class name se sath dot(.) method name
																	//extend ho jaye or agr static keywork ka use nhi krte to object create krna pdta then extend kr pate child class me
	ExtentTest eTest;

	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		eTest = report.createTest(testName);
		eTest.log(Status.INFO,testName+" execution Started");
	}

	
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		eTest.log(Status.PASS,testName+" Test Passed");
	}


	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		eTest.log(Status.FAIL,testName+ " gotFailed");
		WebDriver driver = null;
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eTest.addScreenCaptureFromPath(takeScreenshot(testName,driver),testName);
	}

	
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		eTest.log(Status.SKIP,testName+" Test Skipped");
	}



	public void onFinish(ITestContext context) {
		report.flush();
	}

}
