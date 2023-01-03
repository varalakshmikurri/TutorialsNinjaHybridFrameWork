package com.tutorials.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	
	public static final int WAIT_TIME=10;
	public static final int page_wait_time=10;

 public static String generateNewEmailWithTimeStamp()
	 
	 {
		 	Date date=new Date();
			String strDate=date.toString().replace(" ","_" ).replace(":","_" );
			System.out.println(strDate);
			return "varalakshmi"+strDate+"@gmail.com";
	 } 
 
 
public static Object[][] getTestDataFromExcel(String sheetName)
{
	File file=new File(System.getProperty("user.dir"+"src/main/java/com/tutorials/qa/testdata/TutorialsNinjaTestData.xlsx"));
	XSSFWorkbook workbook=null;
	try {
		
		FileInputStream fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	}
		
	XSSFSheet sheet=workbook.getSheet(sheetName);
	int rows=sheet.getLastRowNum(); 
	int cols=sheet.getRow(0).getLastCellNum();
	
	Object[][] data= new Object[rows][cols];
	
	for(int i=0;i<rows;i++)
	{
		 XSSFRow xssRow = sheet.getRow(i+1);
		 
		 for(int j=0;j<cols;j++)
		 {
			 XSSFCell cell = xssRow.getCell(j);
			 
			 CellType cellType = cell.getCellType();
			  switch(cellType) 
			  {
			  
			  case STRING: 
				   
				data[i][j]=cell.getStringCellValue();
				  break;
				  
			  case NUMERIC:	  
				  data[i][j]=Integer.toString((int)cell.getNumericCellValue()); 
				  break;
				  				  
			case BOOLEAN:
				
				data[i][j]=cell.getStringCellValue();
				
			  	}
		 } 
		 
	}
	return data;
}

public static String captureScreenshot(WebDriver driver,String testName)
{
	 File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	 String destScreenshotPath=System.getProperty("user.dir")+"/Screenshots/"+testName+".png";
	  
	 try {
		FileHandler.copy(srcScreenshot, new File(destScreenshotPath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return destScreenshotPath;
}


}	

