Feature: Timesheet Details Page

  Scenario Outline: Validate all employee details
    Given user is on timesheet home page "https://codat-qa-task.azurewebsites.net/"
    Then validate hourly rate label is "<currencyLabel>" and price symbol is "<currencyPrefix>"

    Examples:
      |  currencyLabel | currencyPrefix  |
      |       £        |       £         |
