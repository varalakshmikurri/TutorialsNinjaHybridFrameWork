 package com.tutorialninja.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.pageobjects.AccountsPage;
import com.tutorials.qa.pageobjects.HomePage;
import com.tutorials.qa.pageobjects.RegisterPage;
import com.tutorials.qa.utils.Utilities;
import com.tutorialsninja.qa.base.Base;

public class RegisterTest extends Base{
	
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver;

	@BeforeMethod
	public void setUp()
	
	{	
		 driver = intializeBrowserAndOpenApp(prop.getProperty("browser")); 
		 
		 HomePage hp=new HomePage(driver);
		 hp.clickonMyAccountdropmenu();
		 hp.selectRegisterOption();		 
		 driver.findElement(By.linkText("Register")).click();
		
	}
	
 
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test(priority=1)
	public void verifyRegisterAccount() throws InterruptedException
	{
		 
		RegisterPage rp= new RegisterPage(driver);
		rp.Register(dataprop.getProperty("firstName"),dataprop.getProperty("lastName"),Utilities.generateNewEmailWithTimeStamp(),dataprop.getProperty("telephineNumber"),prop.getProperty("password"),prop.getProperty("password"));
		
		Thread.sleep(3000);		
		AccountsPage ap=new AccountsPage(driver);
		String actualHeadMsg=ap.accountSucessVerifyPage(); 				 	 
		Assert.assertEquals(actualHeadMsg,dataprop.getProperty("accountSuucessCreationMsg"));
	
	
	}
	
	@Test(priority=2)
	public void verifyRegisterExistingAccount() throws InterruptedException
	{
	
		RegisterPage rp= new RegisterPage(driver);
		rp.Register(dataprop.getProperty("firstName"),dataprop.getProperty("lastName"),prop.getProperty("usrName"),dataprop.getProperty("telephineNumber"),prop.getProperty("password"),prop.getProperty("password"));
		Thread.sleep(3000);			 		 		 
		 
		 String actualHeadMsg=rp.verifyDuplicateEmailErrMsg();
		 Assert.assertTrue(actualHeadMsg.contains(dataprop.getProperty("duplicateEmailErrMsg")),"Duplicate User warning msg not displayed");
		
	
	}
	
	@Test(priority=3)
	public void verifyRegisterWithoutFillingAccount() throws InterruptedException
	{
		 
		RegisterPage rp= new RegisterPage(driver);
		rp.clickContinue();
		  		 
		 String actualPrivacyErrMsg=rp.privacyWarningErrorMsg();
		 Assert.assertTrue(actualPrivacyErrMsg.contains(dataprop.getProperty("privacyPolicyErrMsg")),"Privacy Policy Error msg not displayed");
		 
		 String actuaFirstNameErrMsg=rp.firstNameErrorMsg();
		 Assert.assertTrue(actuaFirstNameErrMsg.contains(dataprop.getProperty("firstNameErrMsg")),"First Name Error msg not displayed" );
		 
		 String actuaLatsNameErrMsg=rp.lastNameErrorMsg();
		 Assert.assertTrue(actuaLatsNameErrMsg.contains(dataprop.getProperty("lastNameErrMsg")),"Last Name Error msg not displayed" );
		 
		 String actualErrMsg=rp.verifyEmailErrErrorMsg();
		 Assert.assertTrue(actualErrMsg.contains(dataprop.getProperty("emailAddressNotValidErrMsg")),"Email Error msg not displayed" );
		 
		 String actualTPErrMsg=rp.verifyTelephoneErrorMsg();
		 Assert.assertTrue(actualTPErrMsg.contains(dataprop.getProperty("teleponeErrMsg")),"Telephone Error msg not displayed" );
		 
		 String actualPWDErrMsg=rp.verifyPasswordErrorMsg();
		 Assert.assertTrue(actualPWDErrMsg.contains(dataprop.getProperty("passwordErrMsg")),"Password Error msg not displayed" );
		 
		
	
	}

}
