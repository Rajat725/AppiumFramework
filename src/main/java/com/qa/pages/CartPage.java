package com.qa.pages;

import com.google.common.collect.ImmutableMap;
import com.qa.actions.BasicActions;
import com.qa.driver.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.*;

public class CartPage extends BasicActions {

    private final By titlePage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");

    private final By btnCheckout = AppiumBy.accessibilityId("Proceed To Checkout button");

    private final By lblTotalPrice = AppiumBy.accessibilityId("total price");

    private final By lblTotalItem = AppiumBy.accessibilityId("total number");

    private final By cardsProduct = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"product row\"]");

    private final By cardProductName = AppiumBy.accessibilityId("product label");
    private final By cardProductPrice = AppiumBy.accessibilityId("product price");
    private final By cardProductTotalCount = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"counter amount\"]/android.widget.TextView");

    public int getActualTotalProductCount() {
        Map<String, Integer> mapProductsCount = new HashMap<>();
        boolean canScrollMore = true;

        while (canScrollMore == true) {

            List<WebElement> cards = DriverManager.getDriver().findElements(cardsProduct);
            for (WebElement card : cards) {
                String productCount = card.findElement(cardProductTotalCount).getText();
                String productName = card.findElement(cardProductName).getText();
                System.out.println(productCount+productName);
                mapProductsCount.put(productName, Integer.parseInt(productCount));
            }

            WebElement cartSrceen = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("cart screen"));
            canScrollMore = (Boolean) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) cartSrceen).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));

        }
        int totalCount = 0;
        for (Map.Entry<String, Integer> entry : mapProductsCount.entrySet()) {

            totalCount += entry.getValue();
        }
        return totalCount;

    }

    public double getActualTotalPrice() {

        Map<String, Double> mapProductsPrice = new HashMap<>();
        boolean canScrollMore = true;

        while (canScrollMore == true) {

            List<WebElement> cards = DriverManager.getDriver().findElements(cardsProduct);
            for (WebElement card : cards) {
                String productPrice = card.findElement(cardProductPrice).getText().substring(1);
                String productName = card.findElement(cardProductName).getText();
                mapProductsPrice.put(productName, Double.parseDouble(productPrice));
            }

            WebElement cartSrceen = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("cart screen"));
            canScrollMore = (Boolean) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) cartSrceen).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));


        }
        double totalPrice = 0;
        for (Map.Entry<String, Double> entry : mapProductsPrice.entrySet()) {

            totalPrice += entry.getValue();
        }
        return totalPrice;
    }

    public int lblTotalItemCount() {
        return Integer.parseInt(getText(lblTotalItem).substring(0, 1).trim());
    }

    public double lblTotalPrice()
    {
        return Double.parseDouble(getText(lblTotalPrice).substring(1).trim());
    }
    public void clkOnCheckOutBtn() {
        click(btnCheckout);
    }

    public String getPageTitle() {
        return getText(titlePage);
    }
}
