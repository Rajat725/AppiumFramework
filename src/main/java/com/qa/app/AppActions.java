package com.qa.app;

import com.google.common.collect.ImmutableMap;
import com.qa.driver.DriverManager;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;

public final class AppActions {
    private AppActions() {
    }

    public static void launchApp(String appPackage)
    {
        ((InteractsWithApps) DriverManager.getDriver()).activateApp(appPackage);
    }

    public static void clearAppData(String appPackage)
    {
        DriverManager.getDriver().executeScript("mobile: clearApp",
                ImmutableMap.of("appId",appPackage));
    }

    public static void quitApp(String appPackage)
    {
        ((InteractsWithApps) DriverManager.getDriver()).terminateApp(appPackage);
    }

    public static UiAutomator2Options getAppCapabilitiesForAndroid()
    {
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("l7dazpuo7d4djfij");
        options.setApp(appPath);
        options.setCapability("unlockType", "pattern");
        options.setCapability("unlockKey", "14753");
        options.setAutoGrantPermissions(true);
        return options;
    }

}
