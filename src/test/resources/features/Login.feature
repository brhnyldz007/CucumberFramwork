@LoginFunctionality
Feature: Login Functionality
	@smoke @regression
  Scenario: Valid Login
    Given I navigated to Orange HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
    Then I will quit the browser
	@regression
  Scenario: Invalid Password
    Given I navigated to Orange HRM website
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate that Invalid credentials message is displayed
    Then I will quit the browser
