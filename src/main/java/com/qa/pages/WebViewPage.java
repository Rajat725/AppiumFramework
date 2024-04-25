package com.qa.pages;

import com.qa.actions.BasicActions;
import com.qa.driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Keys;

import java.util.Set;

public class WebViewPage extends BasicActions {

    private final By txtURL = AppiumBy.accessibilityId("URL input field");
    private final By btnGoToSite = AppiumBy.accessibilityId("Go To Site button");

    public WebViewPage enterURL(String url) {
        enterText(txtURL, url);
        return this;
    }

    public void clickGoToSiteButton() {
        click(btnGoToSite);
    }

    public void enterSearchKeyword(String keyword) {
        Set<String> contextHandles =
                ((AndroidDriver) DriverManager.getDriver()).getContextHandles();
        String appContext = contextHandles.toArray()[0].toString();
        String browserContext = contextHandles.toArray()[1].toString();
        ((AndroidDriver) DriverManager.getDriver()).context(browserContext);
        ((AndroidDriver) DriverManager.getDriver()).findElement(By.name("q")).sendKeys(keyword, Keys.chord(Keys.ENTER));
        ((AndroidDriver) DriverManager.getDriver()).navigate().back();
        ((AndroidDriver) DriverManager.getDriver()).context(appContext);


    }


}
