package base;

import pages.PageObjectManager;
import utilities.ConfigReader;
import utilities.Helper;

import java.io.IOException;

public class TestContextSetup {
    public BaseTest baseTest;
    public PageObjectManager pageObjectManager;
    public Helper helper;

    public TestContextSetup() throws IOException {
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.initializeDriver());
        helper = new Helper(baseTest.initializeDriver());
    }
}
