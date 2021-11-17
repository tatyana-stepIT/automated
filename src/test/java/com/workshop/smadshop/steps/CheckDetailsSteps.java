package com.workshop.smadshop.steps;

import com.workshop.smadshop.dto.ProductDto;

import static org.junit.Assert.assertEquals;

public class CheckDetailsSteps {
    public void checkProductMatch(ProductDto catalogProduct, ProductDto detailedProduct) {
        assertEquals("Catalog product is not equal to product from details page",
                catalogProduct, detailedProduct);
    }
}
