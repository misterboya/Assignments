package steps;

import base.BaseTest;
import base.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ApplicationHooks extends BaseTest {
    private TestContextSetup testContextSetup;

    public ApplicationHooks(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }

    @Before
    public void launchBrowser() throws IOException {
       testContextSetup.baseTest.initializeDriver();
    }

    @After
    public void quitBrowser() throws IOException {
        testContextSetup.baseTest.initializeDriver().quit();
    }
}
