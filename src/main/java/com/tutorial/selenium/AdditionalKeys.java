package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdditionalKeys {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/key_presses");

        // Send a specific key
        driver.findElement(By.id("target")).sendKeys(Keys.LEFT);
        Thread.sleep(1000);

        // Send a combination of keys
        driver.findElement(By.id("target")).sendKeys(Keys.chord(Keys.CONTROL, "A"));

        Thread.sleep(1000);

        driver.quit();

    }
}
