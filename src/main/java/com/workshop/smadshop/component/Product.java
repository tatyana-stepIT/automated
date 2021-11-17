package com.workshop.smadshop.component;

import org.openqa.selenium.WebElement;

import static com.workshop.smadshop.utils.RegexParser.parseInteger;

public abstract class Product {

    protected abstract WebElement getPriceEl();

    protected abstract WebElement getNameEl();

    public int getPrice() {
        return parseInteger(getPriceEl().getText());
    }

    public String getName() {
        return getNameEl().getText();
    }
}
