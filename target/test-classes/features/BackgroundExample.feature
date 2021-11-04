Feature: Background Example

  Background: 
    Given Precondition1
    And Precondition2

  @Background
  Scenario: Example1
    When Test step Nr1 firstname is "Hakan" and lastname is "Kurhan"
    And Test step Nr2
    And Test step Nr3 age is 30
    Then Validation N1
    And Validation N2

  @Background
  Scenario: Example2
    When Test step Nr4
    And Test step Nr5
    And Test step Nr6
    Then Validation N3
    And Validation N4

#----------------
#Hooks @Before method is executed before Background steps
#Hooks methods are executed FOR EVERY feature file
#Background steps are executed ONLY FOR THIS feature file
#----------------
#Hooks -> @Before
#Background
#Scenario1
#Hooks -> @After
#----------------
#Hooks -> @Before
#Background
#Scenario2
#Hooks -> @After
#----------------
#Hooks -> @Before
#Background
#Scenario3
#Hooks -> @After
#----------------
