package steps;

import base.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.EditTimesheetPage;

import java.io.IOException;

public class EditPageSteps {
    TestContextSetup testContextSetup;
    EditTimesheetPage editTimesheetPage;

    public EditPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.editTimesheetPage = testContextSetup.pageObjectManager.getEditTimesheetPage();
    }

    @And("click on edit button {string}")
    public void click_on_edit_button(String employeeId) {
        editTimesheetPage.clickEditLink(employeeId);
    }

    @And("modify day {string} hours {string} and minutes {string}")
    public void modify_hours_and_minutes(String day, String hours, String minutes) {
        editTimesheetPage.modifyHoursAndMinutes(day, hours, minutes);
    }

    @And("user must see updated hours {string} for {string}")
    public void user_must_see_updated_hours(String expectedHours, String id) {
        String actualHours = editTimesheetPage.validateHoursAndMinutesUpdate(id);
        Assert.assertEquals(actualHours, expectedHours);
    }
}
