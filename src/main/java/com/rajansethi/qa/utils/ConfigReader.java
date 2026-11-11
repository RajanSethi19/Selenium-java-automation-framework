package com.rajansethi.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Reads values from config.properties so that URLs, browser and
 * credentials are never hard-coded inside test classes.
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties file", e);
        }
    }

    public static String get(String key) {
        // A command-line value wins over the file, e.g. mvn test -Dheadless=true -Dbrowser=firefox
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue.trim();
        }
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key not found in config.properties: " + key);
        }
        return value.trim();
    }
}
