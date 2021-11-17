package com.workshop.smadshop.steps;

import com.workshop.smadshop.page.MainPage;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private MainPage mainPage;

    public SearchSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void searchItem(String searchTerm) {
        mainPage.search(searchTerm);
    }
}
