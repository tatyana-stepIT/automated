package com.workshop.smadshop.page;

import com.workshop.smadshop.component.SearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    //The elements specific to this page only
    @FindBy(id = "logo")
    private WebElement logo;

    // Page components
    // 1. The parts of the page only with some logic in it
    // 2. The parts of different pages
    private final SearchComponent searchComponent;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        searchComponent = new SearchComponent(driver);
    }

    // The atomic operations on elements on this page
    public boolean isPageLoaded() {
        return logo.isDisplayed();
    }

    public void search(String searchTerm) {
        searchComponent.search(searchTerm);
    }
}
