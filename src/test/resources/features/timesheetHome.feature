Feature: Timesheet Home

  Background:
    Given user is on timesheet home page "https://codat-qa-task.azurewebsites.net/"

  Scenario: Validate timesheet home page is accessible
    Then validate timesheet home page header text "Timesheets"
    Then validate timesheet home page title text "Index - Codat.Hiring.QA.UITestingTask"

  Scenario: Validate create new timesheet page is accessible
    And click on create new link
    Then validate create new time sheet page header "Create"




