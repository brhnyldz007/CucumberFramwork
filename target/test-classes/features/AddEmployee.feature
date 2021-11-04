#Author: Neotech Academy
Feature: Add Employee Feature
  I want to test the Add Employee Functionality

  Background: 
    Given user is logged in with valid credentials
    And user navigates to AddEmployee page

  @AddEmployee
  Scenario: Add Employee with first and last name
    When user enters employee first name "Mohammed" and last name "Salah"
    And user clicks on save button
    Then validate that employee "Mohammed Salah" is added successfully

  @second
  Scenario: Add Employee without employee id
    When user enters employee first name and last name
    And user deletes employee id
    And user clicks on save button
    Then validate that employee is added successfully

  @third
  Scenario: Add Employee and create login Credentials
    When user enters employee first name and last name
    And user clicks on Create Login Details
    And user provides credentials
    And user clicks on save button
    Then validate that employee is added successfully

  #To perform DDT using Scenario Outline and Examples keyword
  @scenarioOutline
  Scenario Outline: Adding multiple employees
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user clicks on save button
    Then validate that "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     | J          | Smith    |
      | Erdogan   | E          | Gul      |
      | Jessica   | P          | White    |

  #To perform DDT using Datatable
  @dataTable
  Scenario: Adding multiple employees
    When user enters employee details and clicks on save and validates it is added
      | FirstName | MiddleName | LastName |
      | Atoullo   | J          | Boboev   |
      | Mufasa    | T          | Duke     |
