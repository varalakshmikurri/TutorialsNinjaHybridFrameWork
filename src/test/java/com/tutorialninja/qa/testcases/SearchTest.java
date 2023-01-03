package com.tutorialninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.qa.pageobjects.HomePage;
import com.tutorials.qa.pageobjects.SearchPage;
import com.tutorialsninja.qa.base.Base;

public class SearchTest extends Base {

	public SearchTest()
	{
		super();
		
	}
		
	
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = intializeBrowserAndOpenApp(prop.getProperty("browser"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchwithValidProd() {
		
		HomePage Hp=new HomePage(driver);
		Hp.Search(dataprop.getProperty("validProduct"));
		
		//Hp.enterSearchoption(dataprop.getProperty("validProduct"));
		//Hp.clickOnSearchButton();
		SearchPage sp=new SearchPage(driver);
		Boolean verifyLink = sp.verifyProductDisplayed();
		Assert.assertTrue(verifyLink, "HP Link text is not displayed");
	}

	@Test(priority = 2)
	public void verifySearchwithInValidProd() {
		
		HomePage Hp=new HomePage(driver);
		Hp.Search(dataprop.getProperty("inValidProduct"));
		//Hp.enterSearchoption(dataprop.getProperty("inValidProduct"));
		//Hp.clickOnSearchButton();
		SearchPage sp=new SearchPage(driver);
		

		String verifyLink = sp.verifyNoProductErroeMessage();

		Assert.assertEquals(verifyLink,dataprop.getProperty("NoProductSearchErrMsg"),"no prodcut msg in Search result is displayed ");
	}

	@Test(priority = 3)
	public void verifySearchWithOutProd() {
		
		HomePage Hp=new HomePage(driver);
		Hp.Search("HP");
		//Hp.enterSearchoption("");
		//Hp.clickOnSearchButton();
		SearchPage sp=new SearchPage(driver);
		String verifyLink = sp.verifyNoProductErroeMessage();

		Assert.assertEquals(verifyLink,dataprop.getProperty("NoProductSearchErrMsg"),"no prodcut msg in Search result is displayed ");

}}
