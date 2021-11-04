Feature: Writing Scenario with Datatable

  @Datatable
  Scenario: Add employees with datatable
    When I login to HRMS
    And I want to add employees
      | FirstName | MiddleName | LastName    |
      | Sahin     | R          | Erol        |
      | Burak     | B          | Aslan       |
      | Murat     | M          | Tashpulatov |
    Then I validate the outcomes
