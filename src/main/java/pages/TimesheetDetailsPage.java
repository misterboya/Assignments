package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Helper;

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
}
