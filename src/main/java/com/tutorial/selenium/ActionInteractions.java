package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionInteractions {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> imgs = driver.findElements(By.cssSelector(".figure"));

        Actions action = new Actions(driver);
        action.moveToElement(imgs.get(1)).perform();

        WebElement link = driver.findElement(By.linkText("View profile"));
        link.click();

        driver.quit();
    }
}
