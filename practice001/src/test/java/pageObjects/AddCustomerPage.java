package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utilities.CoreOperations;

public class AddCustomerPage {
	
	WebDriver driver;
	CoreOperations coreActions;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		coreActions=new CoreOperations(driver);
	}
	By lnkCustomers_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomers_menuitem= By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By btnAddnew=By.xpath("//a[@class='btn bg-blue']"); //Add new
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtcustomerRoles= By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrator')]");
	By lstitemGuests= By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors= By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemForumModerators= By.xpath("//li[contains(text(),'Forum Moderators')]");

	By drpmgrOfVendo= By.xpath("//*[@id='VendorID']");
	By rdMaleGender= By.id("Gender_Male");
	By rdFemaleGender= By.id("Gender_Female");
	
	By txtFirstName= By.id("FirstName");
	By txtLastName= By.id("LastName");
	By txtDob= By.id("DateOfBirth");
	By txtCompanyName=By.id("Company");
	By txtAdminContent= By.id("AdminComment");
	By btnSave=By.xpath("//button[@name='save']");
	
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	public void verifyPageTitle(String pageTitle) {
		Assert.assertEquals(pageTitle, driver.getTitle());
	}
	
	public void clickOnCustomerMenu() {
		//driver.findElement(lnkCustomers_menu).click();
		coreActions.clickWebElement(driver.findElement(lnkCustomers_menu));
	}
	
	public void clickOnCusomerMenuItem() {
		driver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddNewButton() {
		driver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String text) {
		driver.findElement(txtEmail).sendKeys(text);
	}

	public void setPassword(String text) {
		driver.findElement(txtPassword).sendKeys(text);
	}
	public void setFirstName(String text) {
		driver.findElement(txtFirstName).sendKeys(text);
	}
	public void setLastNamne(String text) {
		driver.findElement(txtLastName).sendKeys(text);
	}
	
	public void clickMale() {
		driver.findElement(rdMaleGender).click();
	}
	public void clickFemale() {
		driver.findElement(rdFemaleGender).click();
	}
	public void setDob(String text) {
		driver.findElement(txtDob).sendKeys(text);
	}
	public void setCompanyNamne(String text) {
		driver.findElement(txtCompanyName).sendKeys(text);
	}
	public void setCustomerRoles(String role) throws InterruptedException {
		driver.findElement(txtcustomerRoles).click();
		//driver.findElement(txtcustomerRoles).sendKeys(role);
		Thread.sleep(2000);
		switch (role) {
		case "Administrators":
		
			driver.findElement(lstitemAdministrators).click();
			break;
		case "Guests":
			driver.findElement(lstitemGuests).click();
			break;
		case "Vendors":
			driver.findElement(lstitemVendors).click();
			break;
		case "Forum Moderators":
			driver.findElement(lstitemForumModerators).click();
			break;
		}
		System.out.println("Entered customer role successfully");
	}
	public void clickonSaveButton() {
		driver.findElement(btnSave).click();
	}
	
	@SuppressWarnings("deprecation")
	public void verifyMessage(String msg) {
		Assert.assertTrue(driver.getPageSource().contains(msg));
	}
	
	
	
}
