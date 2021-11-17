package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Modals {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/bootstrap/bootstrap_modal.asp");

        // Get current window handle
        String currentWindow = driver.getWindowHandle();

        // Click q button to open a modal
        driver.findElement(By.cssSelector("button[data-toggle='modal']")).click();

        Thread.sleep(1000);
//        // You may want to wait for modal to be visible -> explicit wait
//        // Identify the modal element
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement modal = (wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.className("modal-content"))));

        WebElement modal = driver.findElement(By.className("modal-content"));

        for (String windowName: driver.getWindowHandles()) {
            if (!windowName.equals(currentWindow)) {
                // For the example sake we suppose there are only 2 windows
                // Main window and modal
                driver.switchTo().window(windowName);
                break;
            }
        }
        // Do something with the modal
        modal.findElement(By.cssSelector("button[data-dismiss='modal']")).click();
        Thread.sleep(1000);

        //Switch back to main window
        driver.switchTo().window(currentWindow);

        driver.quit();
    }
}
