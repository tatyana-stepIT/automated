package com.workshop.smadshop.steps;

import com.workshop.smadshop.component.CatalogProduct;
import com.workshop.smadshop.dto.ProductDto;
import com.workshop.smadshop.page.CatalogPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class CatalogSteps {
    private CatalogPage catalogPage;

    public CatalogSteps(WebDriver driver) {
        catalogPage = new CatalogPage(driver);
    }

    public void checkResultListIsPresent() {
        List<CatalogProduct> productList = catalogPage.get().getProductList();

        assertThat(productList).as("The product list is empty").hasSizeGreaterThan(0);
        assertTrue("The product is empty", productList.size() > 0);
    }

    public void checkTermIsPresentInResults(String searchTerm) {
        for (CatalogProduct product : catalogPage.getProductList()) {
            assertTrue("The product doesn't contain " + searchTerm,
                    product.getName().contains(searchTerm));
        }
    }

    public ProductDto getAnyProductDetails(int productIndex) {
        return new ProductDto(catalogPage.getProductList().get(productIndex));
    }

    public int getRandomProductIndex() {
        return new Random().nextInt((catalogPage.getProductList().size()));
    }

    public void openProduct(int productIndex) {
        catalogPage.openItem(productIndex);
    }
}
