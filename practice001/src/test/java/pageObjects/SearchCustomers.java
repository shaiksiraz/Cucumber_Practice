package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.CoreOperations;
import utilities.WaitHelper;

public class SearchCustomers {
	
	WebDriver driver;
	public CoreOperations coreOperations;
	
	public SearchCustomers(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		coreOperations=new CoreOperations(driver);
	}
	
	By txtSearchEmail= By.id("SearchEmail");
	By txtSearchFirstName= By.id("SearchFirstName");
	By txtSearchLastName = By.id("SearchLastName");
	By btnSearch = By.id("search-customers");
	
	By tblRows = By.xpath("//table[@id='customers-grid']//tbody/tr");
	By tblCols = By.xpath("//table[@id='customers-grid']//tbody/tr/td");
	
	@FindBy (how = How.XPATH, using = "//table[@id = 'customers-grid']")
	WebElement table;
	
	public  void setEmail(String emailid) {
		coreOperations.setObjectValue(driver.findElement(txtSearchEmail), emailid);
				
	}
	public void setFirstName(String fName) {
		coreOperations.setObjectValue(driver.findElement(txtSearchFirstName), fName);
	}
		
	public void setFLastName(String lName) {
		coreOperations.setObjectValue(driver.findElement(txtSearchLastName), lName);
	}
	public void clickSearchButton() {
		coreOperations.clickWebElement(driver.findElement(btnSearch));
	}
	public int getNoOfRows() {
		List<WebElement> tableRows;
		tableRows= driver.findElements(tblRows);
		return(tableRows.size());
	}
	
	public int getNoOfCols() {
		List<WebElement> tableCols;
		
		tableCols= driver.findElements(tblCols);
		return(tableCols.size());
	}
	
	public void verifyEmailId(String emailId) {
		boolean flag = false;
		int noOfRowsInTable=getNoOfRows();
		//System.out.println("No of rows in searched table is :" + noOfRowsInTable);
		
		for (int i=1;i<=noOfRowsInTable;i++) {
			 String email = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			 //System.out.println(" email fetched : "+ email);
			 
			 if (emailId.equalsIgnoreCase(email)) {
				 flag=true;
				 System.out.println("exited from the loop email is :" + email);
				 break;
			 }
				 
		}		
			Assert.assertTrue(flag);	
	}
	
	public void verifyFirstAndLastName(String firstName ,String lastName) {
		boolean flag = false;
		int noOfRowsInTable=getNoOfRows();
		//System.out.println("No of rows in searched table is :" + noOfRowsInTable);
		
		for (int i=1;i<=noOfRowsInTable;i++) {
			 String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			 //System.out.println(" email fetched : "+ email);
			 String[] names=name.split(" ");
			 
			 if (names[0].equalsIgnoreCase(firstName) && names[1].equalsIgnoreCase(lastName)) {
				 flag=true;
				 System.out.println("exited from the loop email is :" + name);
				 break;
			 }
				 
		}
		
			Assert.assertTrue(flag);
		
		
	}
	
}
