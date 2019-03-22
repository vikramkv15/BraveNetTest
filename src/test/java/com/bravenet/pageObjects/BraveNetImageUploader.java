package com.bravenet.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BraveNetImageUploader extends BasePage {
	
	@FindBy(how = How.LINK_TEXT, linkText = "My Images")
	@CacheLookup
	WebElement upLoadImage;
	
	@FindBy(how = How.NAME, name="files[]")
	@CacheLookup
	WebElement selectImage;
	
	@FindBy(how = How.ID, id="insertbtn")
	@CacheLookup
	WebElement insertBtn;
	
	public BraveNetImageUploader(WebDriver driver) 
	{
		super(driver);
	}
	
	public void upLoadImageContainer(String logopath) 
	{
		upLoadImage.sendKeys(logopath);
	}
	
	public void selectUploadImage() {
		selectImage.click();
	}
	
	public BraveNetProfilePage insertButton() {
		waitForVisible(driver, insertBtn,25);
		insertBtn.isEnabled();
		insertBtn.click();
		return new BraveNetProfilePage(driver);
	}
	
}
