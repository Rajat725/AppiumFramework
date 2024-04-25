package com.qa.pages;

import com.qa.actions.BasicActions;
import com.qa.driver.DriverManager;
import com.qa.enums.PrdouctColour;
import com.qa.utils.DynamicXpath;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductDescPage extends BasicActions {

    private final By titlePage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
    private final By btnAddToCart = AppiumBy.accessibilityId("Add To Cart button");

    private final By lblProductDesc = AppiumBy.accessibilityId("product description");

    private final By btnIncrement = AppiumBy.accessibilityId("counter plus button");

    private String productColourXpathString = "//android.view.ViewGroup[@content-desc='Replace circle']";


    public ProductsPage navigateToProductsPage() {
        DriverManager.getDriver().navigate().back();
        return new ProductsPage();
    }

    public void chooseProductColour(PrdouctColour prdouctColour) {
        click(AppiumBy.xpath(DynamicXpath.getXPath(productColourXpathString, prdouctColour.toString().toLowerCase())));
    }

    public void setTotalCountOfProductToBuy(int count) {
        for (int i = 1; i < count; i++) {
            click(btnIncrement);
        }
    }

    public String getProductDesc() {
        return getText(lblProductDesc);
    }


    public ProductDescPage clickAddToCartButton() {
        click(btnAddToCart);
        return this;
    }

    public String getTitleOfPage() {
        return getText(titlePage);
    }


}
