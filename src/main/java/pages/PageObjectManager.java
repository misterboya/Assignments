package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public TimesheetHomePage timesheetHomePage;
    public CreateNewTimesheetPage createNewTimesheetPage;
    public TimesheetDetailsPage timesheetDetailsPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public TimesheetHomePage getTimesheetPage() {
        timesheetHomePage = new TimesheetHomePage(driver);
        return timesheetHomePage;
    }

    public CreateNewTimesheetPage getCreateNewTimesheetPage() {
        createNewTimesheetPage = new CreateNewTimesheetPage(driver);
        return createNewTimesheetPage;
    }

    public TimesheetDetailsPage getTimesheetDetailsPage() {
        timesheetDetailsPage = new TimesheetDetailsPage(driver);
        return timesheetDetailsPage;
    }
}
