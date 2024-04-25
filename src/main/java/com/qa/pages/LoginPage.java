package com.qa.pages;

import com.qa.actions.BasicActions;
import io.appium.java_client.AppiumBy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public class LoginPage extends BasicActions {

    private final By textUsername = AppiumBy.accessibilityId("Username input field");
    private final By textPassword = AppiumBy.accessibilityId("Password input field");

    private final By btnLogin = AppiumBy.accessibilityId("Login button");

    private final By titlePage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");

    private final By lblLogin = AppiumBy.xpath("(//android.widget.TextView)[2]");

    private final By lblSampleUsername = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"bob@example.com-autofill\"]/android.widget.TextView");

    private final By lblSamplePassword = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"login screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]");


    private final By errorUsernameRequired = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Username-error-message\"]/android.widget.TextView");
    private final By errorPasswordRequired = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Password-error-message\"]/android.widget.TextView");
    private final By errorInvalidCredentials = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView");


    public String getValidSampleUsername() {
        return getText(lblSampleUsername);
    }

    public String getValidSamplePassword() {
        return getText(lblSamplePassword);
    }


    public String getTitleOfPage() {

        return getText(titlePage);
    }

    public String getDescOfPage() {

        return getText(lblLogin);

    }

    public LoginPage setUsername(String username) {
        enterText(textUsername, username);
        return this;
    }

    public LoginPage setPassword(String password) {
        enterText(textPassword, password);
        return this;
    }

    @SneakyThrows
    public <T> T clickLoginBtn(Class<T> classz) {
        click(btnLogin);
        return classz.getDeclaredConstructor().newInstance();
    }

    public String getUsernameError() {
        return getText(errorUsernameRequired);
    }

    public String getPasswordError() {
        return getText(errorPasswordRequired);
    }

    public String getInvalidCredError() {
        return getText(errorInvalidCredentials);
    }


}
