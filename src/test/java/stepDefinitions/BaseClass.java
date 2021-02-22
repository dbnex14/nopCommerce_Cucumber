package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public AddCustomerPage addCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	public static Logger logger;
	public Properties config;
	
	// generate random unique emails
	public static String randomString() {
		String generated = RandomStringUtils.randomAlphabetic(5);
		return generated;
	}
}

