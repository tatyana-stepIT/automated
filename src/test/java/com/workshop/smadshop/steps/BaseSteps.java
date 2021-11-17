package com.workshop.smadshop.steps;

import com.workshop.smadshop.page.MainPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class BaseSteps {
    private MainPage mainPage;

    public BaseSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void checkMainPageLoaded() {
        assertTrue("The main page is not loaded", mainPage.isPageLoaded());
    }
}
