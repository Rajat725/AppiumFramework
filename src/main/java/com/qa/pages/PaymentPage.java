package com.qa.pages;

import com.qa.actions.BasicActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class PaymentPage extends BasicActions {

    private final By titlePage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");

    private final By txtFullName = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]");
    private final By txtCardNumber = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]");
    private final By txtExpirationDate = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]");
    private final By txtSecurityCode = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]");
    private final By btnReviewOrder = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]");


    public ReviewPage clickReviewOrder() {
        click(btnReviewOrder);
        return new ReviewPage();
    }

    public PaymentPage setCardNumber(String cardNumber) {
        enterText(txtCardNumber, cardNumber.substring(0, 14));
        return this;
    }

    public PaymentPage setExpiryDate(String expiryDate) {
        enterText(txtExpirationDate, expiryDate);
        return this;
    }

    public PaymentPage setSecurityCode(String securityCode) {
        enterText(txtSecurityCode, securityCode);
        return this;
    }


    public PaymentPage setFullName(String fullName) {
        enterText(txtFullName, fullName);
        return this;
    }

    public String getTitleOfPage() {
        return getText(titlePage);
    }


}
