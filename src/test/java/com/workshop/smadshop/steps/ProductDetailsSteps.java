package com.workshop.smadshop.steps;

import com.workshop.smadshop.dto.ProductDto;
import com.workshop.smadshop.page.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProductDetailsSteps {
    private ProductPage productPage;

    public ProductDetailsSteps(WebDriver driver) {
        productPage = new ProductPage(driver);
    }

    public void checkProductPageLoaded() {
        assertTrue("The product page is not loaded", productPage.isPageLoaded());
    }

    public ProductDto getProductDetails() {
        return new ProductDto(productPage.getProduct());
    }
}
