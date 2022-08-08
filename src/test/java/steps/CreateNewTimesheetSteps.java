package steps;

import base.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateNewTimesheetPage;

import java.io.IOException;

public class CreateNewTimesheetSteps {
    TestContextSetup testContextSetup;
    CreateNewTimesheetPage createNewTimesheetPage;

    public CreateNewTimesheetSteps(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup=testContextSetup;
        this.createNewTimesheetPage = testContextSetup.pageObjectManager.getCreateNewTimesheetPage();
    }

    @And("enter employee id {string}")
    public void enter_employee_id(String employeeId) {
        createNewTimesheetPage.enterEmployeeId(employeeId);
    }

    @And("enter hourly rate {string}")
    public void enter_hourly_rate(String hourlyRate) {
        createNewTimesheetPage.enterHourlyRate(hourlyRate);
    }

    @And("select day from dropdown {string}")
    public void select_day_from_dropdown(String day) {
        createNewTimesheetPage.selectDayFromDropdownList(day);
    }

    @And("enter number of hours worked {string}")
    public void enter_number_of_hours_worked(String hours) {
        createNewTimesheetPage.enterNumberOfHoursWorked(hours);
    }

    @And("enter number of minutes worked {string}")
    public void enter_number_of_minutes_worked(String minutes) {
        createNewTimesheetPage.enterNumberOfMinutesWorked(minutes);
    }

    @And("click on add button")
    public void click_on_add_button() {
        createNewTimesheetPage.clickAddButton();
    }

    @When("save button is clicked")
    public void save_button_is_clicked() {
        createNewTimesheetPage.clickSubmitButton();
    }

    @Then("validate new timesheet is created successfully {string}")
    public void validate_new_timesheet_is_created_successfully(String expectednewTimesheetHeader) {
        Assert.assertTrue(createNewTimesheetPage.
                validateNewTimesheetHeaderText(expectednewTimesheetHeader));
    }

    @And("click on back to list link")
    public void click_on_back_to_list_link() {
        createNewTimesheetPage.clickBackLink();
    }

    @Then("validate new employee id is created successfully")
    public void validate_new_employee_id_is_created_successfully() {
        Assert.assertTrue(createNewTimesheetPage.validateNewEmployeeID());
    }

    @Then("validate employee id {string} is deleted successfully")
    public void validate_employee_id_is_deleted_successfully(String deleteEmployee) {
        Assert.assertTrue(createNewTimesheetPage.clickDelete(deleteEmployee));
    }

    @Then("validate error handling message is displayed")
    public void validate_error_handling_message_is_displayed() {
        Assert.assertFalse(createNewTimesheetPage.validateErrorMessage());
    }

}
