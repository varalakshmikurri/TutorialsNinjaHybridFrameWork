package com.tutorials.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterField;
	
	@FindBy(name="agree")
	private WebElement agreeField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueField;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddrErrMsg;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyWarningErrMsg;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameErrMsg;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameErrMsg;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailErrMsg;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneErrMsg;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordErrMsg;

	
	 public RegisterPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	 public void Register(String FirstName, String LastName, String emailAddress,String telePhone, String password,String confirmPassword)
	 {
		 firstNameField.sendKeys(FirstName);
		 lastNameField.sendKeys(LastName);
		 emailAddressField.sendKeys(emailAddress);
		 telephoneField.sendKeys(telePhone);
		 passwordField.sendKeys(password);
		 passwordConfirmField.sendKeys(confirmPassword);
		 newsLetterField.click();
		 agreeField.click();
		 ContinueField.click();
		 
	 }
	 
	 public String verifyPasswordErrorMsg()
	 {
		 String strPasswordErrMsg=passwordErrMsg.getText();
		 return strPasswordErrMsg;
	 }
	 
	 public String verifyTelephoneErrorMsg()
	 {
		 String strTelephoneErrMsg=telephoneErrMsg.getText();
		 return strTelephoneErrMsg;
	 }
	 
	 
	 public String verifyEmailErrErrorMsg()
	 {
		 String strEmailErrMsg=emailErrMsg.getText();
		 return strEmailErrMsg;
	 }
	 
	 public String lastNameErrorMsg()
	 {
		 String strLastNameErrMsg=lastNameErrMsg.getText();
		 return strLastNameErrMsg;
	 }
	 
	 public String firstNameErrorMsg()
	 {
		 String strfirstNameErrMsg=firstNameErrMsg.getText();
		 return strfirstNameErrMsg;
	 }
	 
	 
	 
	 public String privacyWarningErrorMsg()
	 {
		 String prvErrMsg=privacyWarningErrMsg.getText();
		 return prvErrMsg;
	 }
	 
	
	 public void enterFirstName(String FirstName)
	 {
		 
		 firstNameField.sendKeys(FirstName);
	 }
	
	 public void enterLastName(String LastName)
	 {
		 
		 lastNameField.sendKeys(LastName);
	 }
	 public void enterEmailAddress(String emailAddress)
	 {
		 
		 emailAddressField.sendKeys(emailAddress);
	 }
	 
	 public void enterTelephone(String telePhone)
	 {
		 
		 telephoneField.sendKeys(telePhone);
	 }

	 public void enterPassword(String password)
	 {
		 
		 passwordField.sendKeys(password);
	 }
	 
	 public void enterConfirmPassword(String confirmPassword)
	 {
		 
		 passwordConfirmField.sendKeys(confirmPassword);
	 }
	 
	 public void enterNewsletter()
	 {
		 
		 newsLetterField.click();
	 }
	 
	 public void enterAgreeField()
	 {
		 
		 agreeField.click();
	 }
	 
	 public void clickContinue()
	 {
		 
		 ContinueField.click();
	 }
	 
	 public String verifyDuplicateEmailErrMsg()
	 {
		 
		 String strDuplicateEmailErrMsg=duplicateEmailAddrErrMsg.getText();
		 return strDuplicateEmailErrMsg;
	 }
}


