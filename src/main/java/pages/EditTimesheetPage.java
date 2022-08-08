package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Helper;

import java.util.List;

public class EditTimesheetPage {
    public WebDriver driver;
    public Helper helper;

    public EditTimesheetPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    //By locators
    private By selectEditRow = By.xpath("//table/tbody/tr/td[1]");
    private By hoursField = By.id("newEntry_Hours");
    private By minutesField = By.id("newEntry_Minutes");
    private By dayDropdown = By.xpath("//table[@id='timesheet-table']/tfoot/tr/td[1]");
    private By selectDay = By.id("newEntry_Day");

    public void clickEditLink(String employeeID) {
        List<WebElement> employeeRows = driver.findElements(selectEditRow);

        for (int i = 0; i < employeeRows.size(); i++) {
            employeeRows = driver.findElements(selectEditRow);
            if (employeeRows.get(i).getText()
                    .contains(employeeID)) {
                driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(), '" + employeeID + "')]/following-sibling::td[4]/a[1]"))
                        .click();
                break;
            }
        }
    }

    public void modifyHoursAndMinutes(String day, String hours, String minutes) {
        driver.findElement(dayDropdown).click();
        Select selectDayFromDropdown = new Select(driver.findElement(selectDay));
        selectDayFromDropdown.selectByVisibleText(day);
        helper.javaScriptExecutorClick(hoursField);
        helper.javaScriptExecutorSendText(hours, hoursField);
        helper.javaScriptExecutorClick(minutesField);
        helper.javaScriptExecutorSendText(minutes, minutesField);
    }

    public String validateHoursAndMinutesUpdate(String id) {
        List<WebElement> employeeRows = driver.findElements(selectEditRow);
        String updatedHours = "";
        for (int i = 0; i < employeeRows.size(); i++) {
            employeeRows = driver.findElements(selectEditRow);
            if (employeeRows.get(i).getText()
                    .contains(id)) {
                updatedHours = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(), '" + id + "')]/following-sibling::td[2]"))
                        .getText();
                return updatedHours;
            }
        }
        return null;
    }
}
