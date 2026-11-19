@feature_login
Feature: Login Feature
	
	@smoke @login
	Scenario: Valid Login Test 
		Given User is on Login Page
		When User enters valid username and password
		Then User should logged in successfully
 
 	@regression @login
	Scenario: Invalid Login Test 
		Given User is on Login Page
		When User enters invalid username and password
		Then Error message should be displayed
      
