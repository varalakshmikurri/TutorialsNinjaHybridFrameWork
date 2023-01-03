package com.tutorialninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorials.qa.pageobjects.AccountsPage;
import com.tutorials.qa.pageobjects.HomePage;
import com.tutorials.qa.pageobjects.LoginPage;
import com.tutorials.qa.utils.Utilities;
import com.tutorialsninja.qa.base.Base;

//login test cases

public class LoginTest extends Base{
	
	public LoginTest()
	{
		super();
	}
	
	public WebDriver driver; 
	
	@BeforeMethod
	public void setUp()
	{
		
		 driver=intializeBrowserAndOpenApp(prop.getProperty("browser"));
		 
		 HomePage homepage=new HomePage(driver);
		 
		 homepage.clickonMyAccountdropmenu();
		 homepage.selectLoginOption();
		 //driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		 //driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	}
	  
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
	
	 @Test(priority=1,dataProvider="supplyTestData")
	public void loginWithValidCredentials(String email, String pwd)
	 {		 		 
		
		 LoginPage loginpage=new LoginPage(driver);
		 loginpage.login(email, pwd);
		 AccountsPage AP=new AccountsPage(driver);
		 String strActualMsg=AP.getTitle();
			
		//String strTitle=driver.getTitle();
		//System.out.println("TItle"+strTitle);
		
		//AccountsPage ap=new AccountsPage(driver);
		
		
		Assert.assertEquals(strActualMsg, "My Account");
	
	 }
	 
	 @DataProvider     
	 public Object[][] supplyTestData()
	 {
		// Object[][] data= Utilities.getTestDataFromExcel("Login");
		 
		 Object[][] data= {{"amotooricap9@gmail.com","12345"},
				 			{"amotooricap1@gmail.com","12345"},
				 			{"amotooricap5@gmail.com","12345"}};
		 
		 return data;
	 }
	 
	 
	 
	 @Test(priority=2)
	 public void loginWithInValidCredentials()
	 {
		 
		 LoginPage loginpage=new LoginPage(driver);
		 loginpage.login(Utilities.generateNewEmailWithTimeStamp(),dataprop.getProperty("invalidPassword"));		
		 String str2=loginpage.retrieveEmailPwdNotMatchErrMsg();
		
		 String expectedErrMsg= dataprop.getProperty("emailPwdNoMatchWarningMsg");
		
		 Assert.assertEquals(str2,expectedErrMsg);
	
	 }
	 
	 @Test(priority=3)
	 public void loginWithNoCredentials()
	 {
		
		 LoginPage loginpage=new LoginPage(driver);
		 loginpage.clickOnLoginButton();
		 String str2=loginpage.retrieveEmailPwdNotMatchErrMsg();
		
		//String str2=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')] ")).getText();;
			
		String expectedErrMsg= dataprop.getProperty("emailPwdNoMatchWarningMsg");
		
		Assert.assertEquals(str2,expectedErrMsg);
		
	 }
	

} 
