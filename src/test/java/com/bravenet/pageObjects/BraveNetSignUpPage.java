package com.bravenet.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class BraveNetSignUpPage extends BasePage{
	
	
	@FindBy(how=How.ID, id="full_name")
	WebElement fullName;
	
	@FindBy(how=How.ID, id="email")
	WebElement email;
	
	@FindBy(how=How.ID, id="username")
	WebElement username;
	
	@FindBy(how=How.ID, id="password")
	WebElement password;
		
	@FindBy(how=How.ID, id="password_validation")
	WebElement confimPwd;
		
	@FindBy(how=How.XPATH, xpath="//span[contains(text(),'Create Account')]")
	WebElement createbutton;
	
	public BraveNetSignUpPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void getfullName(String fullname)
	{	
		waitForVisible(driver, fullName,25);
		fullName.sendKeys(fullname);
	}
	
	public void emailId(String eId)
	{	
		waitForVisible(driver, email, 25);
		email.sendKeys(eId);
	}
	
	public void passwordKey(String pwd)
	{	waitForVisible(driver, password,25);
		password.sendKeys(pwd);
	}
	
	public void passwordConfirm(String pwd)
	{
		waitForVisible(driver, confimPwd,25);
		confimPwd.sendKeys(pwd);
	}
	
	public void userName(String usrnme) 
	{	waitForVisible(driver, username,25);
		username.sendKeys(usrnme);
	}
	
	public BraveNetHomePage createAccountButton() 
	{	
		waitForVisible(driver, createbutton,25);
		createbutton.click();
		return new BraveNetHomePage(driver);
	}
	
}
