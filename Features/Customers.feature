
Feature: Customers

Background: Common steps for each scenario
	Given User launches browser
	When User opens Url "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password "admin"
	And User clicks on Login button
	Then User can view Dashboard

@sanity
Scenario: Add a new customer
	When User clicks on customers menu
	And User clicks on customer menu item
	And User clicks on Add new button
	Then User can view Add new customer page
	When User enters customer info
	And User cliks on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser
	
@regression
Scenario: Search customer by email
	When User clicks on customers menu
	And User clicks on customer menu item
	And User enters customer email
	When User clicks on search button
	Then User should find email in the search table
	And close browser
	
@dino
Scenario: Search Customer by Name
	When User clicks on customers menu
	And User clicks on customer menu item
    And User enters customer first name
    And User enters customer last name
    When User clicks on search button
    Then User should find name in the search table
    And close browser