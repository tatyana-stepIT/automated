package com.workshop.smadshop.tests;
import com.workshop.smadshop.dto.ProductDto;
import com.workshop.smadshop.steps.*;
import org.junit.Before;
import org.junit.Test;

public class SearchProductsTest extends BaseTest {
    /**
     * 1. Navigate to smadshop main page
     * 2. Check smadshop page loaded
     * 3. Search a product
     * 4. Check the list of items contains the search term
     * 5. Save the product data
     * 6. Open the product
     * 7. Check the data is the same as on search page
     */

    private SearchSteps searchSteps;
    private BaseSteps baseSteps;
    private CatalogSteps catalogSteps;
    private ProductDetailsSteps productDetailsSteps;
    private CheckDetailsSteps checkDetailsSteps;

    @Before
    public void setupPages() {
        searchSteps = new SearchSteps(getDriver());
        baseSteps = new BaseSteps(getDriver());
        catalogSteps = new CatalogSteps(getDriver());
        productDetailsSteps = new ProductDetailsSteps(getDriver());
        checkDetailsSteps = new CheckDetailsSteps();
    }

    @Test
    public void searchProductTest() {
        // The prerequisites will navigate to main page
        final String searchTerm = "RB29FSR";

        baseSteps.checkMainPageLoaded();
        searchSteps.searchItem(searchTerm);
        catalogSteps.checkResultListIsPresent();
        catalogSteps.checkTermIsPresentInResults(searchTerm);

        final int productIndex = catalogSteps.getRandomProductIndex();
        final ProductDto catalogProduct = catalogSteps.getAnyProductDetails(productIndex);
        catalogSteps.openProduct(productIndex);

        productDetailsSteps.checkProductPageLoaded();
        ProductDto detailedProduct = productDetailsSteps.getProductDetails();
        checkDetailsSteps.checkProductMatch(catalogProduct, detailedProduct);
    }
}