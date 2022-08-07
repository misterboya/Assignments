Feature: Timesheet Details Page

  Scenario: Validate timesheet details page currency
    Given user is on timesheet home page "https://codat-qa-task.azurewebsites.net/"
    And click on details link
    Then validate hourly rate currency label is "£"
    Then validate currency symbol for hourly rate field is "£"
