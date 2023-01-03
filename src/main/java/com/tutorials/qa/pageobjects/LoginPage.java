  package com.tutorials.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailAddrField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton; 
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')] ")
	private WebElement loginEmailPwdNotMatchMsg;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void login(String emailID,String pwdTxt )
	{
		emailAddrField.sendKeys(emailID);
		passwordField.sendKeys(pwdTxt);
		loginButton.click();
		
	}
	
	public void enterEmailId(String emailID)
	{
		emailAddrField.sendKeys(emailID);
	}

	public void enterPassword(String pwdTxt)
	{
		passwordField.sendKeys(pwdTxt);

	}
	public void clickOnLoginButton()
	{
		loginButton.click();

	}
	
	public String retrieveEmailPwdNotMatchErrMsg()
	
	{
		String warningTxt= loginEmailPwdNotMatchMsg.getText(); 
		
		return warningTxt;
		
	}
}
