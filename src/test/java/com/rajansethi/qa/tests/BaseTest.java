package com.rajansethi.qa.tests;

import com.rajansethi.qa.pages.LoginPage;
import com.rajansethi.qa.utils.ConfigReader;
import com.rajansethi.qa.utils.DriverFactory;
import com.rajansethi.qa.utils.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Setup and teardown shared by every test class:
 * open the browser and go to the login page before each test,
 * take a screenshot on failure, and close the browser after each test.
 */
public class BaseTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        loginPage = new LoginPage().open(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.takeScreenshot(result.getName());
        }
        DriverFactory.quitDriver();
    }
}
