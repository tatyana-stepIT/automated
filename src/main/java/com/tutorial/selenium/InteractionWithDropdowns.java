package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InteractionWithDropdowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
//        select.getWrappedElement().click();

        for (WebElement element: select.getOptions())
            System.out.println("Available options: " + element.getText());

        System.out.println("Is multi-select: " + select.isMultiple());

        select.selectByValue("1"); // Attribute value
        Thread.sleep(1000);
        select.selectByVisibleText("Option 2"); // Visible text
        Thread.sleep(1000);
        select.selectByIndex(2); // Select by index
        Thread.sleep(1000);

        driver.quit();

    }
}
