package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomers;

public class Steps extends BaseDefinitions {
	@Before
	public void setup() throws IOException {
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
				
		logger= Logger.getLogger("practice"); // added logger
		PropertyConfigurator.configure("log4j.properties");// Added logger
		
		
		String browser=configProp.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers/chromedriver");
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			//System.setProperty("webdriver.chrome.driver", "//Users/sirajshaik/Documents/Siraj/Selenium/practice001/Drivers/chromedriver.exe");
			
	        //Instantiating driver object
	        driver = new ChromeDriver();
			//driver= new SafariDriver();
		}else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
	}
	
	@Given("User Launch  browser")
	public void user_Launch_browser() {
		
		
		lp= new LoginPage(driver);
	  
	}
	
	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("*************** Opening URL *****************");
	    driver.get(url);
	    driver.manage().window().maximize();
	}
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String user, String password) {
		logger.info("***************Entering user name Password *****************");
		lp.setUserName(user);
		lp.setPassword(password);
	
	}
	
	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		logger.info("*************** click Login button *****************");
	   //Thread.sleep(5000);
		lp.clickLogin();
		 Thread.sleep(5000);
	}
	
	@Then("Page Title should be {string}")
	public void page_Title_should_be(String pageTitle) {
		logger.info("*************** Verifying home page *****************");
	    
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
				
			Assert.assertEquals(pageTitle, driver.getTitle());
			
		}
	}
	
	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("*************** Logging out *****************");
		lp.clickLogout();
		Thread.sleep(2000);
	}
	
	
	@Then("close browser")
	public void close_browser() {
		logger.info("*************** Closing Browser *****************");
		driver.close();
		driver.quit();
	}
	
	
	// Add customer Steps
	

	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		logger.info("*************** verify Dashboard screen *****************");
		addCust=new AddCustomerPage(driver);
	   Assert.assertEquals(addCust.getPageTitle(),"Dashboard / nopCommerce administration");
		
	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		logger.info("*************** Opening customer main menu *****************");
		addCust.clickOnCustomerMenu();
		Thread.sleep(2000);
	}
	
	@When("click on customer Menu Item")
	public void click_on_customer_Menu_Item() {
		logger.info("*************** Opening Customer sub menu *****************");
	    addCust.clickOnCusomerMenuItem();
	}
	
	@When("click on Add new button")
	public void click_on_Add_new_button() {
		logger.info("*************** click add new button *****************");
	   addCust.clickOnAddNewButton();
	}
	
	@Then("User can view Add new customer page")
	public void userd_can_view_Add_new_customer_pafge() {
		logger.info("*************** Verifying add customer page *****************");
		addCust.verifyPageTitle("Add a new customer / nopCommerce administration");
		
	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("*************** Entering New customer details *****************");
		
	    addCust.setEmail(randomString()+"@gmail.com");
	    addCust.setPassword("admin");
	    addCust.setFirstName("abcName");
	    addCust.setLastNamne("abcLastName");
	    addCust.clickFemale();
	    addCust.setDob("01/15/1995");
	    //addCust.setCustomerRoles("Guests");
	    
	}
	
	@When("click on Save button")
	public void click_on_Save_button() {
		logger.info("*************** Click Save Button *****************");
	   addCust.clickonSaveButton();
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		logger.info("*************** verify message new user details added successfully *****************");
	   //The new customer has been added succesfully.
		addCust.verifyMessage(string);
							   
	}
	
	
	// Search customer steps
	
	@When("Enter customer EMail")
	public void enter_customer_EMail() {
		logger.info("*************** Enteing customer Email *****************");
		searchCust=new SearchCustomers(driver);
		searchCust.setEmail("admin@yourstore.com");
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("*************** clcik Search button *****************");
	   searchCust.clickSearchButton();
	   Thread.sleep(3000);
	}
	
	@Then("User shold found Email in the Search table")
	public void user_shold_found_Email_in_the_Search_table() {
		logger.info("*************** verify customer details display in serched results *****************");
	    searchCust.verifyEmailId("admin@yourstore.com");
	}


	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		logger.info("*************** Enter customer First name *****************");
		searchCust=new SearchCustomers(driver);
	   searchCust.setFirstName("Victoria");
	}
	
	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		logger.info("*************** Enter customer Last name *****************");
		searchCust.setFLastName("Terces");
	}
	
	@Then("User shold found name in the Search table")
	public void user_shold_found_name_in_the_Search_table() {
		logger.info("*************** verify  serched results with  First Name and Last name*****************");
		searchCust.verifyFirstAndLastName("Victoria", "Terces");
	}




	
	
}
