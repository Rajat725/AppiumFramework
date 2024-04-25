package com.qa.driver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private DriverManager() {
    }
    private static final ThreadLocal<AppiumDriver> threadLocal=new ThreadLocal<>();

   public static void setDriver(AppiumDriver driver)
   {
       threadLocal.set(driver);
   }

   public synchronized static AppiumDriver getDriver()
   {
       return threadLocal.get();
   }
   public static void clearDrivers()
   {
       threadLocal.remove();
   }
}
