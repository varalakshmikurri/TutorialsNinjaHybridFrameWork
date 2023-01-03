package com.tutorials.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorials.qa.utils.ExtentReporter;
import com.tutorials.qa.utils.Utilities;

public class MyListeners implements ITestListener{

	ExtentReports extentReports;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		
		 extentReports = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+" started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, "test executed successfuly"+result.getName());
		
	}
		

	@Override
	public void onTestFailure(ITestResult result) {
	
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) 
			{
	
			e.printStackTrace();
		    }
		
		 String destScreenshotPath=Utilities.captureScreenshot(driver, result.getName());
		 extentTest.addScreenCaptureFromPath(destScreenshotPath);
		 extentTest.log(Status.INFO,result.getThrowable());
		 extentTest.log(Status.FAIL, result.getName()+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		

		
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+"got failed");
		
		System.out.println("test got skipped"+result.getName());
		
		System.out.println("test got skipped"+result.getThrowable());
		
		
	}
			

	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
		String pathOfExtentReport=System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html";
		
		File extentReport=new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	

}
