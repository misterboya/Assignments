package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utilities.Helper;

import java.util.List;

public class CreateNewTimesheetPage {
    public WebDriver driver;
    public Helper helper;
    private String employeeID = "";

    public CreateNewTimesheetPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    //By locators
    private By employeeIdField = By.id("Timesheet_EmployeeId");
    private By hourlyRateField = By.id("Timesheet_HourlyRate");
    private By dayDropdown = By.xpath("//table[@id='timesheet-table']/tfoot/tr/td[1]");
    private By selectDay = By.id("newEntry_Day");
    private By hoursField = By.id("newEntry_Hours");
    private By minutesField = By.id("newEntry_Minutes");
    private By addButton = By.xpath("//table[@id='timesheet-table']/tfoot/tr/td[4]");
    private By saveButton = By.xpath("//input[@type='submit']");
    private By resultNewTimesheetHeader = By.tagName("h1");
    private By backLink = By.linkText("Back to List");
    private By totalEmployees = By.xpath("//table/tbody/tr/td[1]");
    private By getEmployeeId = By.xpath("//dl/dd[1]");



    public void enterEmployeeId(String employee) {
        driver.findElement(employeeIdField).sendKeys(employee);
    }

    public void enterHourlyRate(String hourlyRate) {
        driver.findElement(hourlyRateField).clear();
        driver.findElement(hourlyRateField).sendKeys(hourlyRate);
    }

    public void selectDayFromDropdownList(String day) {
        driver.findElement(dayDropdown).click();
        Select selectDayFromDropdown = new Select(driver.findElement(selectDay));
        selectDayFromDropdown.selectByVisibleText(day);
    }

    public void enterNumberOfHoursWorked(String hours) {
        helper.javaScriptExecutorClick(hoursField);
        helper.javaScriptExecutorSendText(hours, hoursField);
    }

    public void enterNumberOfMinutesWorked(String minutes) {
        helper.javaScriptExecutorClick(minutesField);
        helper.javaScriptExecutorSendText(minutes, minutesField);
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void clickSubmitButton() {
        driver.findElement(saveButton).click();
    }

    public boolean validateNewTimesheetHeaderText(String newTimesheetPartialHeader) {
        helper.waitForPageToLoad(driver);
        employeeID = driver.findElement(getEmployeeId).getText();
        return driver.findElement(resultNewTimesheetHeader)
                .getText().contains(newTimesheetPartialHeader);
    }

    public void clickBackLink() {
        driver.findElement(backLink).click();
    }

    public boolean validateNewEmployeeID() {
        List<WebElement> employeeList = driver.findElements(totalEmployees);
        for (WebElement employee : employeeList) {
            if (employee.getText().equalsIgnoreCase(employeeID)) {
                return true;
            }
        }
        return false;
    }
}

