package com.tutorials.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	@FindBy(linkText="HP LP3065")
	private WebElement productDispalyField;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement noProductErrMsg ;
	
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public Boolean verifyProductDisplayed()
	{
		Boolean strProuctDisplay=productDispalyField.isDisplayed();
		return strProuctDisplay;
	}
	
	public String verifyNoProductErroeMessage()
	{
		String strNoProdErrMsg=noProductErrMsg.getText();
		return strNoProdErrMsg;
	}
}
