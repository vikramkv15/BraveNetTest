package com.bravenet.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BraveNetProfilePage extends BasePage {
	
	@FindBy(how=How.LINK_TEXT, linkText="Edit Avatar")
	@CacheLookup
	WebElement editAvatarBtn;
	
	@FindBy(how=How.ID, id="lastname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(how=How.ID, id="tzone")
	@CacheLookup
	WebElement timeZone;
	
	@FindBy(how=How.ID, id="dob")
	@CacheLookup
	WebElement dateOfBirth;
	
	@FindBy(how=How.ID, id="submit")
	@CacheLookup
	WebElement saveBtn;
	
	public BraveNetProfilePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void getlastName(String lastnme) {
		lastName.sendKeys(lastnme);
	}
	
	public void getdateOfBirth(String dob) {
		dateOfBirth.clear();
		dateOfBirth.sendKeys(dob);
	}
	
	public void gettimeZone() {
		Select tmezne = new Select(timeZone);
		tmezne.selectByValue("-24.00");
	}
	
	public BraveNetHomePage clickSaveBtn() {
		saveBtn.click();
		return new BraveNetHomePage(driver);
	}
	
	public BraveNetImageUploader uploadProfilePic()
	{	
		waitForVisible(driver,editAvatarBtn, 25);
		editAvatarBtn.click();
		return new BraveNetImageUploader(driver);
	}
	
	
	
}
