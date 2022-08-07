Feature: Create New Timesheet

Scenario Outline: Validate new timesheet is create successfully
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

  Examples:
  |   id   |  price |  day      |  hours | minutes |
  |  CDT_01|   50   | Friday    |  10    |   20    |
  |  CDT_02|   40   | Monday    |  8     |   15    |
  |  CDT_03|   30   | Tuesday   |  7     |   30    |
  |  CDT_04|   20   | Wednesday |  20    |   10    |
  |  CDT_05|   10   | Thursday  |  30    |   25    |