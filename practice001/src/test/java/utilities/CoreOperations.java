package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoreOperations {
	WebDriver driver;
	WaitHelper waithelper;
	
	public CoreOperations(WebDriver driver) {
		this.driver= driver;
		waithelper = new WaitHelper(driver);
		
	}
	
	public  void clickWebElement(WebElement we) {
		waithelper.WaitForElement(we, 30);
		we.click();
		
	}
	
	public void setObjectValue(WebElement we,String objectValue) {
		waithelper.WaitForElement(we, 20);
		we.clear();
		we.sendKeys(objectValue);
	}

}
