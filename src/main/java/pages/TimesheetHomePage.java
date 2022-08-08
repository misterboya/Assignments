package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Helper;

import java.util.Iterator;
import java.util.List;

public class TimesheetHomePage {
    public WebDriver driver;
    public Helper helper;

    public TimesheetHomePage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
    }

    //By locators
    private By timesheetHeader = By.tagName("h1");
    private By createNewTimesheet = By.linkText("Create New");
    private By createNewTimesheetHeader = By.tagName("h1");
    private By detailsLink = By.linkText("Details");

    public boolean validateURL(String partialURL) {
        return driver.getCurrentUrl().contains(partialURL);
    }

    public String getTimesheetHeader() {
        return driver.findElement(timesheetHeader).getText();
    }

    public String getTitleName() {
        return driver.getTitle();
    }

    public void clickCreateNewTimesheetLink() {
        driver.findElement(createNewTimesheet).click();
        helper.waitForPageToLoad(driver);
    }

    public void clickOnDetailsLink() {
        driver.findElement(detailsLink).click();
        helper.waitForPageToLoad(driver);
    }

    public String getCreateNewTimesheetHeader() {
        return driver.findElement(createNewTimesheetHeader).getText();
    }
}
