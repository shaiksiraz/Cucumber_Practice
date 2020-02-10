Feature: Login

Scenario: Succdessful Login with Valid Credentials
	Given User Launch  browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on log out link
	Then Page Title should be "Your store. Login"
	And close browser
	
	
	Scenario Outline: Succdessful Login with Valid and Invalid Credentials
	Given User Launch  browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<Email>" and Password as "<Password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on log out link
	Then Page Title should be "Your store. Login"
	And close browser
	
	Examples:
	|Email|Password|
	|admin@yourstore.com|admin|
	|aadmin@yourstore.com|admin123|