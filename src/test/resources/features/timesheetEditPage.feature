Feature: Edit Timesheet

  Scenario Outline: Validate timesheet is edited successfully
    Given user is on timesheet home page "https://codat-qa-task.azurewebsites.net/"
    And click on create new link
    And enter employee id "<id>"
    And enter hourly rate "<price>"
    And select day from dropdown "<day>"
    And enter number of hours worked "<hours>"
    And enter number of minutes worked "<minutes>"
    And click on add button
    When save button is clicked
    Then validate new timesheet is created successfully "Timesheet"
    And click on back to list link
    Then validate new employee id is created successfully
    And click on edit button "<id>"
    And modify day "Sunday" hours "20" and minutes "10"
    And click on add button
    When save button is clicked
    Then validate new timesheet is created successfully "Timesheet"
    And click on back to list link
    Then user must see updated hours "30" for "<id>"

    Examples:
      |   id   |  price |  day         |  hours | minutes |
      |  CDT_88|   50   | Wednesday    |  10    |   20    |