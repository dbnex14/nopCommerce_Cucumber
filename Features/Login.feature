
Feature: Login

@sanity
Scenario: Successful login
	Given Benutzer started browser
	When User opens Url "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password "admin"
	And User clicks on Login button
	Then Page title should be "Dashboard / nopCommerce administration"
	When User clicks on log out link
	Then Page title should be "Your store. Login"
	And close browser
	
@regression
Scenario Outline: Login - Data Driven
	Given User launches browser
	When User opens Url "https://admin-demo.nopcommerce.com/login"
	And User enters email as "<email>" and password "<password>"
	And User clicks on Login button
	Then Page title should be "Dashboard / nopCommerce administration"
	When User clicks on log out link
	Then Page title should be "Your store. Login"
	And close browser
	
	Examples:
		| email					| password 	|
		| admin@yourstore.com	| admin		|
		| admin1@yourstore.com	| admin123	|