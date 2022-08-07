package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor executor;

    public Helper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitForEelementToBeClickable(By locator, int duration) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForEelementToBeVisible(By locator, int duration) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void doubleClick(By locator) {
        driver.findElement(locator).click();
        driver.findElement(locator).click();
    }

    public void javaScriptExecutorClick(By locator) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void javaScriptExecutorSendText(String inputText, By locator) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='"+inputText+"';", driver.findElement(locator));
    }

    public void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        webDriverWait.until(pageLoadCondition);
    }
}
