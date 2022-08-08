package steps;

import base.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CreateNewTimesheetPage;
import pages.TimesheetDetailsPage;
import pages.TimesheetHomePage;

import java.io.IOException;

public class TimesheetDetailsPageSteps {
    TestContextSetup testContextSetup;
    TimesheetDetailsPage timesheetDetailsPage;
    TimesheetHomePage timesheetHomePage;

    public TimesheetDetailsPageSteps(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup=testContextSetup;
        this.timesheetHomePage = testContextSetup.pageObjectManager.getTimesheetPage();
        this.timesheetDetailsPage = testContextSetup.pageObjectManager.getTimesheetDetailsPage();
    }

    @And("click on details link")
    public void click_on_details_link() {
        timesheetHomePage.clickOnDetailsLink();
    }

    @Then("validate hourly rate currency label is {string}")
    public void validate_hourly_rate_currency_label(String currencyLabel) {
        Assert.assertTrue(timesheetDetailsPage.hourlyRateCurrencyLabel(currencyLabel));
    }

    @Then("validate currency symbol for hourly rate field is {string}")
    public void validate_currency_symbol_for_hourly_rate_field(String hourlyRateCurrencySymbol) {
        Assert.assertTrue(timesheetDetailsPage.hourlyRateFieldCurrencyLabel(hourlyRateCurrencySymbol));
    }

    @Then("validate hourly rate label is {string} and price symbol is {string}")
    public void validate_hourly_rate_label_and_price_symbol(String currencyLabel,
                                                            String currencySymbol) {
        Assert.assertTrue(timesheetDetailsPage.validateEmployeeDetails(currencyLabel, currencySymbol));
    }
}
