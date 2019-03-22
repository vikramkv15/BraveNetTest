package com.bravenet.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class BraveNetLoginPage extends BasePage {
	
	
	@FindBy(how=How.ID, id="userid")
	@CacheLookup
	WebElement loginusrid;
	
	@FindBy(how=How.ID, id="password")
	@CacheLookup
	WebElement loginpwd;
	
	@FindBy(how=How.CSS, css="span.md-button-content")
	@CacheLookup
	WebElement submitbtn;
	
	public BraveNetLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void userName(String usname)
	{
		loginusrid.sendKeys(usname);
	}
	
	public void passwordKey(String pwd)
	{
		loginpwd.sendKeys(pwd);
	}
	
	public BraveNetHomePage clickSubmitButton() 
	{
		submitbtn.click();
		return new BraveNetHomePage(driver);
	}
}
