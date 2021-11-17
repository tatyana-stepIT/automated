package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/upload");
            WebElement fileUpload = driver.findElement(By.id("file-upload"));
            fileUpload.sendKeys("C:\\Users\\new\\IdeaProjects\\automated\\src\\main\\resources\\newFile.txt");
            driver.findElement(By.id("file-submit")).click();
            Thread.sleep(1000);
        } finally {
            driver.quit();
        }

    }
}
