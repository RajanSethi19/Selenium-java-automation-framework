package com.rajansethi.qa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Takes a screenshot of the current browser.
 * BaseTest calls this automatically when a test fails,
 * so a failure always comes with visual proof.
 */
public class ScreenshotUtil {

    public static void takeScreenshot(String testName) {
        try {
            File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path destination = Path.of("screenshots", testName + "_" + timestamp + ".png");
            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(), destination);
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException | NullPointerException e) {
            System.out.println("Could not take screenshot: " + e.getMessage());
        }
    }
}
