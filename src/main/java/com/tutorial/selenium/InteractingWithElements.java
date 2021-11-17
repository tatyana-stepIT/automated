package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InteractingWithElements {
    private static final By searchResults = By.cssSelector("div[data-index='0']");
    private static final By brands = By.cssSelector("#brandsRefinements div.a-checkbox");

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/");

        // Identify a single element on the page
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("Kindle"); // Send the text to the input element
        searchInput.submit(); // submit the search

        // Identify the element once again because the previous is not available anymore
        // If not identified again the StaleElementReferenceException occurs
        searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.clear(); // clear the content of input
        searchInput.sendKeys("Amazon Fire");
        searchInput.submit();

        WebElement products = driver.findElement(searchResults);
        System.out.println(products.getText());
        System.out.println("\n" + products.getAttribute("class"));

        List<WebElement> brandsCheckBox = driver.findElements(brands);
        System.out.println("Checkbox displayed: " + brandsCheckBox.get(0).isDisplayed());
        System.out.println("Checkbox enabled: " + brandsCheckBox.get(0).isEnabled());
        System.out.println("Checkbox selected: " + brandsCheckBox.get(0).isSelected());

        brandsCheckBox.get(0).click();
        brandsCheckBox = driver.findElement(brands).findElements(By.tagName("input"));
        System.out.println("Checkbox selected: " + brandsCheckBox.get(0).isSelected());

        Thread.sleep(2000);

        driver.quit();
    }
}
