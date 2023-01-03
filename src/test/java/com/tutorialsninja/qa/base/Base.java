package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorials.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base()
	{
		  prop=new Properties();
		  
		  
		  //System.out.println("user directoty path"+System.getProperty("user.dir"));
		  File propfile=new File(System.getProperty("user.dir")+"/src/main/java/com/tutorials/qa/config/ config.properties");
		  //System.out.println("file path address"+propfile.getPath());
		  
		  dataprop=new Properties();
		  
		  File propfile1=new File(System.getProperty("user.dir")+"/src/main/java/com/tutorials/qa/testdata/testdata.properties");
		  		  		  
		  
		  try {
			  FileInputStream fis =new FileInputStream(propfile);
			  prop.load(fis);
		  } 
		  catch(Exception e)
		  {
			  e.printStackTrace();  
		  }
			  
			  try {
			  FileInputStream datafile=new FileInputStream(propfile1) ;
			  dataprop.load(datafile);
			  }
			   catch(Exception e)
			  {
			  e.printStackTrace();  
			  }
		  
	}

	public WebDriver intializeBrowserAndOpenApp(String strBrowser)
	{
		
		
		if (strBrowser.equalsIgnoreCase("chrome"))			
		{
			driver=new ChromeDriver();
		} 
		else if(strBrowser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(strBrowser.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		else 
		{
			driver=new EdgeDriver();	
		}				
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.WAIT_TIME));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_wait_time));
		 driver.get(prop.getProperty("url")); 
		 
		 return driver;
		
	} 
	
}
