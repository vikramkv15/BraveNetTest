package com.bravenet.testCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.bravenet.pageObjects.BraveNetHomePage;
import com.bravenet.pageObjects.BraveNetSignUpPage;
import com.bravenet.pageObjects.GmailLogin;
import com.bravenet.utilities.TempConfig;

public class TC01_RegistrationCheck extends BaseClass {

	@Test(groups = { "A" })
	public void userSignUpCheck() throws Exception {

		/*
		 * Creating a random user name and saving it to temp properties file so that it
		 * can be used while logging in again to website
		 */
		TempConfig writeconfig = new TempConfig();
		String usrname = username + randomNum();
		writeconfig.tempWriteConfiguration(usrname);

		BraveNetSignUpPage signUp = new BraveNetSignUpPage(driver);
		signUp.getfullName(fulname);
		logger.info("Full Name is entered");

		signUp.emailId(signupemailId);
		logger.info(signupemailId + " email Id is entered.");

		signUp.userName(usrname);
		logger.info(usrname + " user name  is entered.");

		signUp.passwordKey(password);
		logger.info("Password is entered");

		signUp.passwordConfirm(password);
		logger.info("confirm password is entered");

		BraveNetHomePage homePage = signUp.createAccountButton();
		logger.info("Waiting for the user to finish the recaptcha ");

		boolean verifylink = homePage.emailSentMessage();
		if (verifylink == true) {
			AssertJUnit.assertTrue(true);
			logger.info("Email sent successfully....");
			logger.info("Test Case Passed....");
		} else {
			logger.info("Email sent is failed...");
			logger.info("Test Case Failed....");
			captureScreen(driver, "userSignUpCheck");
			AssertJUnit.assertTrue(false);
		}

	}

	// Test for the Email confirmation in Gmail account
	@Test(groups = { "A" }, dependsOnMethods = { "userSignUpCheck" })
	public void gmailUserActivate() throws Exception {

		driver.get(gmUrl);
		logger.info("Gmail url opened.");

		GmailLogin gmail = new GmailLogin(driver);
		
		if (gmail.googleProductText()==true)
		{	
			String MainWindow1 = driver.getWindowHandle();
			gmail.loginGmailLink();
			

			// To handle all new opened window.
			Set<String> s0 = driver.getWindowHandles();
			Iterator<String> i0 = s0.iterator();

			while (i0.hasNext()) {
				String ChildWindow1 = i0.next();

				if (!MainWindow1.equalsIgnoreCase(ChildWindow1)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow1);
		}

		// logging into gmail using the parent email ID.
		gmail.enterEmailID(gmailParent);
		gmail.enterPassword(password);
		logger.info(signupemailId + " is the email");
		logger.info("User Logged in to the Gmail");

		// Searching for the email based on the child mail id and text of the mail
		// subject
		gmail.searchEmail(signupemailId);
		logger.info("User searched email");

		gmail.clickEmail(emailSub);
		logger.info("User clicked on the mail");

		try {
			BraveNetHomePage everified = gmail.openLink();
			Thread.sleep(500);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			BraveNetHomePage everified1 = gmail.openLink();
			logger.info("User clicked on the activate link");
			String MainWindow = driver.getWindowHandle();

			// To handle all new opened window.
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();

				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

					// Switching to Child window
					driver.switchTo().window(ChildWindow);
					boolean result = everified1.suggestionTxt();
					if (result == true) {
						AssertJUnit.assertTrue(true);
						logger.info("Successfully user account is activated");
						logger.info("Test Case Passed....");

					} else {
						logger.info("Email sent is failed...");
						logger.info("Test Case Failed....");
						captureScreen(driver, "gmailUserActivate");
						AssertJUnit.assertTrue(false);
					}

				}
			}

		}
	}
}
	}
}
