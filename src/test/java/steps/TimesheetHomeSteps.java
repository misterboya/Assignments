package steps;

import base.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.TimesheetHomePage;


import java.io.IOException;

public class TimesheetHomeSteps {
    TestContextSetup testContextSetup;
    TimesheetHomePage timesheetHomePage;

    public TimesheetHomeSteps(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup=testContextSetup;
        this.timesheetHomePage = testContextSetup.pageObjectManager.getTimesheetPage();
    }

    @Given("user is on timesheet home page {string}")
    public void user_is_on_timesheet_home_page(String url) throws IOException {
        boolean currentURL = timesheetHomePage.validateURL(url);
        Assert.assertTrue(currentURL);
    }

    @Then("validate timesheet home page header text {string}")
    public void validate_timesheet_home_page_header_text(String expectedHeaderText) {
        String actualHeader = timesheetHomePage.getTimesheetHeader();
        Assert.assertEquals(actualHeader, expectedHeaderText, "Header text is incorrect.");
    }

    @Then("validate timesheet home page title text {string}")
    public void validate_timesheet_home_page_title_text(String expectedTitle) {
        String actualTitle = timesheetHomePage.getTitleName();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect.");
    }

    @And("click on create new link")
    public void click_on_create_new_link() {
        timesheetHomePage.clickCreateNewTimesheetLink();
    }

    @Then("validate create new time sheet page header {string}")
    public void validate_create_new_time_sheet_page_header(String createNewHeaderText) {
        String actualCreateNewTimesheetHeader = timesheetHomePage.getCreateNewTimesheetHeader();
        Assert.assertEquals(actualCreateNewTimesheetHeader, createNewHeaderText,
                "Create New timesheet header is incorrect.");
    }
}
