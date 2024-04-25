package com.qa.pages;

import com.qa.actions.BasicActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckOutPage extends BasicActions {

    private final By titlePage= AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
    private final By textFullName =AppiumBy.accessibilityId("Full Name* input field");
    private final By textAddressLine1 =AppiumBy.accessibilityId("Address Line 1* input field");
    private final By TextAddressLine2 =AppiumBy.accessibilityId("Address Line 2 input field");
    private final By textCity =AppiumBy.accessibilityId("City* input field");
    private final By textState =AppiumBy.accessibilityId("State/Region input field");
    private final By textZipCode =AppiumBy.accessibilityId("Zip Code* input field");
    private final By textCountry =AppiumBy.accessibilityId("Country* input field");
    private final By btnPayment =AppiumBy.accessibilityId("To Payment button");


    public PaymentPage clkPaymentButton()
    {
        click(btnPayment);
        return new PaymentPage();
    }

    public CheckOutPage setCountry(String country)
    {
        enterText(textCountry,country);
        return this;
    }

    public CheckOutPage setZipCode(String zipCode)
    {
        enterText(textZipCode,zipCode);
        return this;
    }

    public CheckOutPage setState(String state)
    {
        enterText(textState,state);
        return this;
    }

    public CheckOutPage setCity(String city)
    {
        enterText(textCity,city);
        return this;
    }

    public CheckOutPage setAddressLine2(String addressLine2)
    {
        enterText(TextAddressLine2,addressLine2);
        return this;
    }

    public CheckOutPage setAddressLine1(String addressLine1)
    {
        enterText(textAddressLine1,addressLine1);
        return this;
    }
    public CheckOutPage setFullName(String fullName)
    {
        enterText(textFullName,fullName);
        return this;
    }

    public String getPageTitle()
    {
        return getText(titlePage);
    }
}
