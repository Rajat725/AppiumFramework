package com.qa.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.actions.BasicActions;
import com.qa.actions.WaitStrategy;
import com.qa.driver.DriverManager;
import com.qa.enums.WaitMechanism;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasicActions {
    By titlePage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");

    By cardsProduct = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"store item\"]");

    By productsName = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\"]");
    By productsPrice = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item price\"]");

    By btnSort = AppiumBy.accessibilityId("sort button");
    By btnAscPrice = AppiumBy.accessibilityId("priceAsc");

    By btnYourCart = AppiumBy.accessibilityId("cart badge");

    public String getTitleOfPage() {
        return getText(titlePage);
    }

    public int getTotalProductCount() {
        WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, cardsProduct, 5);
        return DriverManager.getDriver().findElements(cardsProduct).size();
    }

    public String getProductPrice(String productName) {
        WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, cardsProduct, 5);
        scrollToText(productName);
        final List<WebElement> cards = DriverManager.getDriver().findElements(cardsProduct);
        final WebElement matchedCard = cards.stream().filter(card -> card.findElement(productsName).getAttribute("text")
                .equalsIgnoreCase(productName)).findFirst().orElse(null);
        return matchedCard.findElement(productsPrice).getAttribute("text");
    }


    public ProductDescPage navigateToProductDescPage(String productName) {
//        scrollToText(productName);
//
//            final List<WebElement> elements = DriverManager.getDriver().findElements(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"store item\"]"));
//            final WebElement text = elements.stream().filter(el -> el.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\"]"))
//                    .getAttribute("text")
//                    .equalsIgnoreCase(productName)).findFirst().orElse(null);
//            text.click();




        WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, cardsProduct, 5);
        scrollToText(productName);
        List<WebElement> cards = DriverManager.getDriver().findElements(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])"));
         WebElement matchedCard = cards.stream().filter(card -> card.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\"]")).getAttribute("text")
                .equalsIgnoreCase(productName)).findFirst().orElse(null);
        matchedCard.click();
        return new ProductDescPage();
    }

    public ProductsPage sortProductByPrice() {
        click(btnSort);
        click(btnAscPrice);
        return this;
    }

    public List<Double> getProductsPriceInList() {
        WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, cardsProduct, 5);
        return DriverManager.getDriver().findElements(productsPrice)
                .stream().map(price -> Double.parseDouble( price.getAttribute("text").substring(1))).collect(Collectors.toList());


    }

    public CartPage navigateTOYourCartPage() {
        click(btnYourCart);
        return new CartPage();
    }


}
