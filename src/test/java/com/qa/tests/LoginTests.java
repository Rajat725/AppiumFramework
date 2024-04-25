package com.qa.tests;

import com.qa.enums.PrdouctColour;
import com.qa.pages.*;
import com.qa.utils.RandomTextGenerator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void validLoginCredTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        cartPage.clkOnCheckOutBtn();
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("bob@example.com");
        loginPage.setPassword("10203040");
        CheckOutPage checkOutPage = loginPage.clickLoginBtn(CheckOutPage.class);
        Assertions.assertThat(checkOutPage.getPageTitle())
                .isEqualToIgnoringCase("Checkout");

    }


    @Test
    public void validateDescTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        cartPage.clkOnCheckOutBtn();
        LoginPage loginPage = new LoginPage();
        Assertions.assertThat(loginPage.getDescOfPage())
                .contains("Select a username and password from the list below");

    }


    @Test
    public void invalidLoginCredTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        cartPage.clkOnCheckOutBtn();
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(RandomTextGenerator.getEmail());
        loginPage.setPassword(RandomTextGenerator.getPassword(10));
        loginPage.clickLoginBtn(LoginPage.class);
        Assertions.assertThat(loginPage.getInvalidCredError())
                .contains("Provided credentials do not match any user");

    }


    @Test
    public void validateEmptyUsernameTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        cartPage.clkOnCheckOutBtn();
        LoginPage loginPage = new LoginPage();
        loginPage.setPassword(RandomTextGenerator.getPassword(10));
        loginPage.clickLoginBtn(LoginPage.class);
        Assertions.assertThat(loginPage.getUsernameError())
                .isEqualToIgnoringCase("Username is required");


    }


    @Test
    public void validateEmptyPasswordTest() {
        ProductsPage productsPage = new ProductsPage();
        ProductDescPage productDescPage = productsPage.navigateToProductDescPage("Sauce Labs Bolt T-Shirt");
        productDescPage.setTotalCountOfProductToBuy(2);
        productDescPage.chooseProductColour(PrdouctColour.BLACK);
        productDescPage.clickAddToCartButton();
        productsPage = productDescPage.navigateToProductsPage();
        CartPage cartPage = productsPage.navigateTOYourCartPage();
        cartPage.clkOnCheckOutBtn();
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(RandomTextGenerator.getEmail());
        loginPage.clickLoginBtn(LoginPage.class);
        Assertions.assertThat(loginPage.getPasswordError())
                .isEqualToIgnoringCase("Password is required");


    }

}
