package com.workshop.smadshop.component;

import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@ToString
public class CatalogProduct extends Product {

    private final WebElement price;
    private final WebElement name;

    public CatalogProduct(WebElement productEl) {
        price = productEl.findElement(By.className("price_cart"));
        name = productEl.findElement(By.cssSelector(".name span"));
    }

    @Override
    protected WebElement getPriceEl() {
        return price;
    }

    @Override
    protected WebElement getNameEl() {
        return name;
    }
}
