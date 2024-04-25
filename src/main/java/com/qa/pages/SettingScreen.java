package com.qa.pages;

import com.qa.actions.BasicActions;
import com.qa.enums.SettingScreenOptions;
import com.qa.utils.DynamicXpath;
import io.appium.java_client.AppiumBy;

public class SettingScreen extends BasicActions {
    private String items="//android.view.ViewGroup[@content-desc='menu item Replace']";


    public void clickOnSettingOptions(SettingScreenOptions settingScreenOptions)
    {
        click(AppiumBy.xpath(DynamicXpath.getXPath(items,settingScreenOptions.getValue().toString())));
    }
}
