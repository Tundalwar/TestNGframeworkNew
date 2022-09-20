package Com.Demosite.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Com.Demosite.testCases.BaseClass;

public class TestNGListeners extends BaseClass implements ITestListener{
	
	public WebDriver driver;
	

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("*******Test Started : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("*******Test is succesful : " + result.getName());
		
	  
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("*******Test is failed : " + result.getName());
		BaseClass bs = new BaseClass();
		bs.TakesScreen();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("*******Test is skipped : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("*******Test is finished : " + context.getName());
	}

}
