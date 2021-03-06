package com.bravenet.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			fis.close();
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getSignUpURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getEmail() {
		String email = pro.getProperty("email");
		return email;
	}

	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getLoginURL() {
		String url = pro.getProperty("loginURL");
		return url;
	}

	public String getGmailURL() {
		String url = pro.getProperty("gmailUrl");
		return url;
	}

	public String getEmailSubject() {
		String emailsub = pro.getProperty("emailSubject");
		return emailsub;
	}

	public String getLogoPath() {
		String logopath = pro.getProperty("logopath");
		return logopath;
	}
	
	public String getLoginUsrName() {
		String loginusrname = pro.getProperty("loginUserName");
		return loginusrname;
	}
	
	public String getEmailSentText() {
		String esenttext= pro.getProperty("emailSntText");
		return esenttext;
	}
	
	public String getLastName() {
		String lastnme= pro.getProperty("lstnme");
		return lastnme;
	}
	public String getDateOfBirth() {
		String dob1= pro.getProperty("dateOfBirth");
		return dob1;
	}
	
	public String getFirstName() {
		String firstNme= pro.getProperty("name");
		return firstNme;
	}
	
}
