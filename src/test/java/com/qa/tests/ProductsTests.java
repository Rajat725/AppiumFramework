package com.qa.tests;

import com.qa.pages.CartPage;
import com.qa.pages.ProductDescPage;
import com.qa.pages.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTests extends BaseTest {

    @Test
    public void validateTitleTest() {
        ProductsPage productsPage = new ProductsPage();
        Assertions.assertThat(productsPage.getTitleOfPage())
                .isNotNull()
                .isNotEmpty()
                .isEqualToIgnoringCase("Products");
    }

    @Test
    public void validateProductCountTest() {
        ProductsPage productsPage = new ProductsPage();
        Assertions.assertThat(productsPage.getTotalProductCount())
                .isNotZero()
                .isGreaterThan(2)
                .isEqualTo(6);
    }

    @Test
    public void validateProductPrice() {
        ProductsPage productsPage = new ProductsPage();
        Assertions.assertThat(productsPage.getProductPrice("Sauce Labs Backpack"))
                .isNotEmpty()
                .isNotNull()
                .isEqualToIgnoringCase("$29.99");
    }

    @Test
    public void validateNavigationToDescriptionPage() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Backpack");
        Assertions.assertThat(productDescPage.getTitleOfPage())
                .isEqualToIgnoringCase("Sauce Labs Backpack");
    }

    @Test
    public void validateNavigationToYourCartPage() {
        ProductsPage productsPage = new ProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        Assertions.assertThat(cartPage.getPageTitle())
                .isEqualToIgnoringCase("No Items");
    }

    @Test
    public void validateSortingFunctioanlity() {
        ProductsPage productsPage = new ProductsPage();
        List<Double> originalPriceList = productsPage.getProductsPriceInList();
        productsPage.sortProductByPrice();
        List<Double> sortedPriceList = productsPage.getProductsPriceInList();
        Assertions.assertThat(originalPriceList).isNotEqualTo(sortedPriceList);
        Assertions.assertThat(sortedPriceList).isSorted();
    }


}
