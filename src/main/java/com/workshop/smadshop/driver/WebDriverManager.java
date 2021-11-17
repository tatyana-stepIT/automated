package com.workshop.smadshop.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver = null;

    private WebDriverManager() {
    }

    // Get a single instance of WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            startDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        getDriver().quit();
    }

    private static void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        EventFiringWebDriver driverWithEvents = new EventFiringWebDriver(driver);
        driverWithEvents.register(new EventListener());
        driver = driverWithEvents;
    }
}
