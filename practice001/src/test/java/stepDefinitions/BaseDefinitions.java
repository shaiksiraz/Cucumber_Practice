package stepDefinitions;

import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomers;

public class BaseDefinitions {
	
	public WebDriver driver;
	public LoginPage lp;
	public static Logger logger;
	public AddCustomerPage addCust;
	public SearchCustomers searchCust;
	public Properties configProp;
	
	public static String randomString() {
		String randomString= RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}

}
