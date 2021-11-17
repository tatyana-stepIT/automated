package com.workshop.smadshop.tests;

import com.workshop.smadshop.driver.WebDriverManager;
import com.workshop.smadshop.utils.PropertyReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    private final static String URL = PropertyReader.getConfigProperty("url");

    @BeforeClass
    public static void setUp() {
        System.out.println("Setting web driver");
        driver = WebDriverManager.getDriver();
        driver.get(URL);
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Closing the driver");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
