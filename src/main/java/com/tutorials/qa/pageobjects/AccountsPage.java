package com.tutorials.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement accountSuccessMsg;
	
	
public AccountsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public String getTitle()
{
	
	
	String strTitle=driver.getTitle();
	return strTitle;
	
	
}

public String accountSucessVerifyPage ()
{
	String strSuccess=accountSuccessMsg.getText();
	return strSuccess;
}


}
