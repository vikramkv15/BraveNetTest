package com.bravenet.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.bravenet.utilities.ReadConfig;
import com.bravenet.utilities.TempConfig;

public class BaseClass {

	// Creating reference variables for the configuration file.
	ReadConfig readconfig = new ReadConfig();
	TempConfig tempconfig = new TempConfig();

	// All the values reading from the properties file

	public String baseURL = readconfig.getSignUpURL();
	public String email = readconfig.getEmail();
	public String password = readconfig.getPassword();
	public String username = readconfig.getUserName();
	public String gmUrl = readconfig.getGmailURL();
	public String emailSub = readconfig.getEmailSubject();
	public String loginurl = readconfig.getLoginURL();
	public String logopath = readconfig.getLogoPath();
	public String emailsenttext = readconfig.getEmailSentText();
	public String Loginusrnme = tempconfig.getLoginUsrName();
	public String lastName = readconfig.getLastName();
	public String birthDate = readconfig.getDateOfBirth();
	public String fulname = readconfig.getFirstName();

	public static WebDriver driver;

	public static Logger logger;
	Date date = new Date();
	long time = date.getTime();

	// Creating a random unique email id based on the time to register to the
	// website.
	String gmailParent = email + "@gmail.com";
	String signupemailId = email + "+" + time + "@gmail.com";

	// Creating random unique user name for each mail id
	String usrname = username + randomNum();

	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("IMGBB WebSite");
		PropertyConfigurator.configure("Log4j.properties");

		// Driver Initiation
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		logger.info("Chrome Driver is initiated");
		
		// Load the Sign up url
		driver.get(baseURL);
		logger.info("Signup Url is opened.");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Method to create a screenshot and save in the Screenshots folder
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}

	// Method to create a random string.
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	// Method to create a random numbers for user name.
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
