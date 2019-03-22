package com.bravenet.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BraveNetHomePage extends BasePage {

	@FindBy(how = How.LINK_TEXT, linkText = "Upgrade")
	WebElement suggestionTxt;
	
	@FindBy(how = How.LINK_TEXT, linkText=("click here"))
	@CacheLookup
	WebElement emailSentMsg;

	
	public BraveNetHomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public boolean suggestionTxt() {
		waitForVisible(driver, suggestionTxt, 100);
		return suggestionTxt.isDisplayed();
	}
	
	public boolean emailSentMessage()
	{	waitForVisible(driver, emailSentMsg, 150);
		return emailSentMsg.isDisplayed();
		 
	}
}
