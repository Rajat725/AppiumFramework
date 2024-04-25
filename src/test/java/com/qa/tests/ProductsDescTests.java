package com.qa.tests;

import com.qa.enums.PrdouctColour;
import com.qa.pages.ProductDescPage;
import com.qa.pages.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ProductsDescTests extends BaseTest {

    @Test
    public void validateTitleTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.getTitleOfPage();
        Assertions.assertThat(productDescPage.getTitleOfPage())
                .isNotNull()
                .isNotEmpty()
                .isEqualToIgnoringCase("Sauce Labs Bolt T-Shirt");


    }

    @Test
    public void validateProdDesc() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.getProductDesc();
        Assertions.assertThat(productDescPage.getProductDesc())
                .isNotEmpty()
                .isNotNull()
                .contains("bolt");
    }

    @Test
    public void validateAddToCartFunction() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        Assertions.assertThat(productsPage.getTitleOfPage())
                .isNotNull()
                .isNotEmpty()
                .isEqualToIgnoringCase("Products");

    }


}
