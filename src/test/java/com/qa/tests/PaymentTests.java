package com.qa.tests;

import com.qa.enums.PrdouctColour;
import com.qa.pages.*;
import com.qa.utils.RandomTextGenerator;
import org.testng.annotations.Test;

public class PaymentTests extends BaseTest {
    @Test
    public void validateSuccessPaymentTests() {
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
        PaymentPage paymentPage = checkOutPage
                .setFullName(RandomTextGenerator.getFullName())
                .setAddressLine1(RandomTextGenerator.getAddress1())
                .setAddressLine2(RandomTextGenerator.getAddress2())
                .setCity(RandomTextGenerator.getCity())
                .setState(RandomTextGenerator.getState())
                .setZipCode(RandomTextGenerator.getZipCode())
                .setCountry(RandomTextGenerator.getCountry())
                .clkPaymentButton();
        ReviewPage reviewPage = paymentPage
                .setFullName(RandomTextGenerator.getFullName())
                .setCardNumber("325812657568789")
                .setExpiryDate("03/25")
                .setSecurityCode("123")
                .clickReviewOrder();
         

    }

}
