package com.ab.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetUp extends BaseTestEbay implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
	 try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
	
		
		
		e.printStackTrace();
	} 
	String path =getScreenShot(driver,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		
	}
	
	

}
