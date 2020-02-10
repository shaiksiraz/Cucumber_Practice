Feature: Customers

 Background: Below are comon steps for customers features
 	Given User Launch  browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers Menu
	And click on customer Menu Item
 @sanity
Scenario: Add new Customer
	
	
	And click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser

@regression		
Scenario: Search Customer by EMailID
	
	And Enter customer EMail
	When Click on search button
	Then User shold found Email in the Search table
	And close browser

@regression	
Scenario: Search Customer by First and LastName
	
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User shold found name in the Search table
	And close browser