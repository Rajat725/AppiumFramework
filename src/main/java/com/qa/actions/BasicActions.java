package com.qa.actions;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitMechanism;
import com.qa.pages.MenuBar;
import com.qa.pages.SettingScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.InteractsWithApps;
import org.openqa.selenium.By;

public class BasicActions {

    protected BasicActions() {

    }

    public SettingScreen accessSettingScreen()
    {
        MenuBar menuBar=new MenuBar();
        return menuBar.clickOnHamburgerIcon();
    }

    protected void enterText(By by, String text) {
        WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, by, 5).sendKeys(text);
    }

    protected void click(By by) {

        WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, by, 5).click();
    }

    protected String getText(By by) {
        return WaitStrategy.performExplicitWait(WaitMechanism.VISIBLE, by, 5).getAttribute("text");

    }

    protected void scrollToText(String text)
    {
        DriverManager.getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
    }
    protected void scrollToBottom()
    {

    }
    
    protected void closeApp(String appPackage)
    {
        ((InteractsWithApps) DriverManager.getDriver()).terminateApp(appPackage);
    }

    protected void launchApp(String appPackage)
    {
        ((InteractsWithApps) DriverManager.getDriver()).activateApp(appPackage);
    }
}
