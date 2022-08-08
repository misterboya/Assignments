package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Helper;

import java.util.List;

public class TimesheetDetailsPage {
    public WebDriver driver;
    public Helper helper;

    public TimesheetDetailsPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    //By locators
    private By hourlyRateLabel = By.xpath("//dl/dt[2]");
    private By hourlyRateField = By.xpath("//dl/dd[2]");
    private By backLink = By.linkText("Back to List");
    private By allEmployees = By.xpath("//table/tbody/tr/td[5]/a[2]");

    public boolean hourlyRateCurrencyLabel(String poundSymbol) {
        return driver.findElement(hourlyRateLabel).getText().contains(poundSymbol);
    }

    public boolean hourlyRateFieldCurrencyLabel(String hourlyRateCurrencySymbol) {
        return driver.findElement(hourlyRateField).getText().contains(hourlyRateCurrencySymbol);
    }

    public void clickOnBackLink() {
        driver.findElement(backLink).click();
        helper.waitForPageToLoad(driver);
    }

    public boolean validateEmployeeDetails(String currencyLabel, String pricePrefix) {
        List<WebElement> employeeList = driver.findElements(allEmployees);

        for (int i=0; i<employeeList.size(); i++) {
            employeeList = driver.findElements(allEmployees);
            employeeList.get(i).click();
            helper.waitForPageToLoad(driver);
            if (driver.findElement(hourlyRateLabel).getText()
                    .contains(currencyLabel) && driver.findElement(hourlyRateField)
                    .getText()
                    .contains(pricePrefix)) {
                return true;
            }
            driver.findElement(backLink).click();
        }
        return false;
    }
}
