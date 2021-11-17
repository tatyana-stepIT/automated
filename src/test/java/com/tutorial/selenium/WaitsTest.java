package com.tutorial.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitsTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.out.println("Setting web driver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Closing the driver");
        driver.quit();
    }

    @Test
    public void testAImplicitWait() {
        driver.get("https://www.google.com");
        // Specifies the amount of time the driver should wait
        // when searching for an element if it is not immediately present
        // Is applicable for the given instance of driver
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        WebElement element = driver.findElement(By.name("q"));
    }

    @Test
    public void testBExplicitWait() {
        driver.get("https://www.google.com");
        // Specifies the amount of time the driver should wait
        // when searching for an element until the given condition is true
        // Is applicable only for this specific element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> elements = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.name("q0")));
    }

    @Test
    public void testCFluentWait() {
        driver.get("https://www.google.com");
        // An implementation of the Wait interface that may have its timeout
        // and polling interval configured on the fly
        // In this situation will wait 30 seconds for an element to be present on the page,
        // checking for its presence once every 600 milliseconds
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(600))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });
    }

}
