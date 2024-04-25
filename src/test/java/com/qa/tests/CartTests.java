package com.qa.tests;

import com.qa.enums.PrdouctColour;
import com.qa.pages.CartPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDescPage;
import com.qa.pages.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{

    @Test
    public void validatePriceDetailsTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        Assertions.assertThat(cartPage.lblTotalItemCount()).isEqualTo( cartPage.getActualTotalProductCount());
        Assertions.assertThat(cartPage.lblTotalPrice())
                .isEqualTo(cartPage.getActualTotalPrice()
                        * cartPage.getActualTotalProductCount());

    }

    @Test
    public void validateTitleTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        Assertions.assertThat(cartPage.getPageTitle())
                .isNotNull()
                .isNotEmpty()
                .isEqualToIgnoringCase("My Cart");
    }

    @Test
    public void validateNavigToLoginPageTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        cartPage.clkOnCheckOutBtn();
        LoginPage loginPage=new LoginPage();
        Assertions.assertThat(loginPage.getTitleOfPage())
                .isNotEmpty()
                .isNotNull()
                .isEqualToIgnoringCase("Login");
    }



}
