package com.tutorials.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReports=new ExtentReports();
		
		File extentSparkReportFile=new File(System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html");
		
		System.out.println("filepath"+extentSparkReportFile);
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentSparkReportFile); 
		
		sparkReporter.config().setTheme(Theme.DARK);
		
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
		
		sparkReporter.config().setDocumentTitle("TutorialsNinja Test Report");
		
		sparkReporter.config().setTimeStampFormat("MM/DD/YYYY hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		Properties configfile=new Properties();
		
		File file=new File(System.getProperty("user.dir")+"/src/main/java/com/tutorials/qa/config/ config.properties");
		
		try {
			FileInputStream fisConfigfile=new FileInputStream(file);
			
			configfile.load(fisConfigfile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		extentReports.setSystemInfo("Appliction URL",configfile.getProperty("url"));
		extentReports.setSystemInfo("Browser", configfile.getProperty("browser"));
		extentReports.setSystemInfo("user logged in with", configfile.getProperty("usrName"));
		extentReports.setSystemInfo("user logged in with password", configfile.getProperty("password"));
		
		extentReports.setSystemInfo("operating system", System.getProperty("os.name"));
		extentReports.setSystemInfo("system user name", System.getProperty("user.name"));
		extentReports.setSystemInfo("java version", System.getProperty("java.version"));
		
		return extentReports;
				
	}
	
} 
 