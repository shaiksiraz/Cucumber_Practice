package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CoreOperations;

public class LoginPage {

	public WebDriver ldriver;
	public CoreOperations coreActions;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
		coreActions= new CoreOperations(ldriver);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")	
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void setUserName(String usr) {
		txtEmail.clear();
		txtEmail.sendKeys(usr);
	}
	
	public void clickLogin() throws InterruptedException {
		//Thread.sleep(5000);
		//btnLogin.click();
		//Thread.sleep(5000);
		coreActions.clickWebElement(btnLogin);
		
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
