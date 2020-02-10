package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		//glue="//Users/sirajshaik/Documents/Siraj/Selenium/practice001/src/test/java/stepDefinitions/
		//features = "//Users/sirajshaik/Documents/Siraj/Selenium/practice001/Features/Login.feature",
		//features = "//Users/sirajshaik/Documents/Siraj/Selenium/practice001/Features/Customers.feature",
		//features = {".//Features/Customers.feature",".//Features/Login.feature"},
		//features = ".//Features",
		features = {".//Features/Customers.feature"},
		glue = "stepDefinitions",
		dryRun=false,
		plugin= {"pretty",
				 "html:test_report"},
		monochrome=true,
		strict = true,
		tags= {"@sanity"}
		//tags= {"@sanity","@regression"}  // tags with both sanity and regression will be executed
		//tags= {"@sanity,@regression"}  // tags with either sanity or regression will be executed
		)

public class TestRun {
	
	
	

}
