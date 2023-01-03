package com.tutorials.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'My Account')]") 
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement enterSearch;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searChButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
				
	}
	
	//actions
	
	public void Search(String productText)
	{
		enterSearch.sendKeys(productText);
		searChButton.click();		
		
	}
	
	public void clickOnSearchButton()
	{	
		searChButton.click();
		
	}
	
	public void enterSearchoption(String productText)
	{
		enterSearch.sendKeys(productText);
	}
	
	public void clickonMyAccountdropmenu()
	{
		myAccountDropMenu.click();
	}
	
	public void selectLoginOption()
	{
		loginOption.click();
	}
	
	public void selectRegisterOption()
	{
		registerOption.click();
	}
	
}
