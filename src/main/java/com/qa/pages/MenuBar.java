package com.qa.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MenuBar {

    private final By btnHamburger= AppiumBy.accessibilityId("open menu");
    public SettingScreen clickOnHamburgerIcon()
    {
        return new SettingScreen();
    }
}
