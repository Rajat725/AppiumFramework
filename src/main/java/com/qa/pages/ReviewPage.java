package com.qa.pages;

import com.qa.actions.BasicActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ReviewPage extends BasicActions {


    private final By btnPlaceOrder= AppiumBy.accessibilityId("Place Order button");

    public SuccessPage clickPlaceOrderButton()
    {
        click(btnPlaceOrder);
        return new SuccessPage();
    }
}
