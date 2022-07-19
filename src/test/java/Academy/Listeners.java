package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporter;

public class Listeners extends Base implements ITestListener{
	ExtentTest test;
	 ExtentReports extent=ExtentReporter.getReportObject();
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>()	;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 test=extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	//get ScreenShot
		extentTest.get().fail(result.getThrowable()); // getThrowable this will retrieve the log from the result 
		WebDriver driver=null;
		String testCaseName=result.getMethod().getMethodName();
		
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testCaseName,driver), result.getMethod().getMethodName());
				getScreenShotPath(testCaseName,driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	extent.flush();
	}

	
	
	
	
	
	
}
