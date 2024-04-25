package com.qa.pages;

import com.qa.actions.BasicActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SuccessPage extends BasicActions {

    private final By btnContinueShopping = AppiumBy.accessibilityId("Continue Shopping button");
    private final By lblComplete = AppiumBy.accessibilityId("//android.view.ViewGroup[@content-desc=\"checkout complete screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]");
    private final By lblThanks = AppiumBy.accessibilityId("//android.view.ViewGroup[@content-desc=\"checkout complete screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]");


    public String getSeeOffMessage() {
        return getText(lblThanks);
    }

    public String getOrderCompleteMessage() {
        return getText(lblComplete);
    }

    public ProductsPage clcikContinueShoppingButton() {
        click(btnContinueShopping);
        return new ProductsPage();
    }


}
