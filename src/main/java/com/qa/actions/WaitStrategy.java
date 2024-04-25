package com.qa.actions;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitMechanism;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitStrategy {

    private WaitStrategy() {
    }

    public static WebElement performExplicitWait(WaitMechanism waitMechanism, By by, int secondsToWait)
    {

        if(waitMechanism==WaitMechanism.VISIBLE)
        {
            WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(secondsToWait));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        if(waitMechanism==WaitMechanism.CLICKABLE)
        {
            WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(secondsToWait));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        if(waitMechanism==WaitMechanism.PRESENCE)
        {
            WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(secondsToWait));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }

        if(waitMechanism==WaitMechanism.NONE)
        {
            return DriverManager.getDriver().findElement(by);
        }


        return null;
    }
}
