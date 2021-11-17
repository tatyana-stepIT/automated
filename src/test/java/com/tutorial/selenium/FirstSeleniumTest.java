package com.tutorial.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FirstSeleniumTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        // Init webdriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testASearch(){
        // Identify a single element on the page
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("Kindle"); // Send the text to the input element
        searchInput.submit(); // submit the search

        assertTrue("The url doesn't contain the expected term",
                driver.getCurrentUrl().contains("Kindle"));
    }

    @Test
    public void testBFilters(){
        WebElement searchInput = driver.findElement(By.id("low-price"));
        searchInput.sendKeys("150");
        searchInput.submit(); // submit the search

        List<WebElement> prices = driver.findElements(
                By.cssSelector(".sg-col-inner .a-price .a-price-whole"));
        for (WebElement price: prices) {
            assertTrue("The price is lower than 150",
                    Integer.parseInt(price.getText()) >= 150);
        }
    }


}
