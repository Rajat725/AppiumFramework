package com.qa.tests;

import com.qa.app.AppActions;
import com.qa.driver.DriverManager;
import com.qa.server.ServerActions;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {


    @BeforeSuite(alwaysRun = true)
    public void initiateServerAndDriver() throws MalformedURLException {
        ServerActions.startServer();
        URL url = new URL("http://localhost:4723");
        DriverManager.setDriver(new AndroidDriver(url, AppActions.getAppCapabilitiesForAndroid()));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownServer() {
        if (ServerActions.getServerInstance().isRunning()) {
            ServerActions.getServerInstance().stop();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void startApp() {
        AppActions.launchApp("com.saucelabs.mydemoapp.rn");
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        AppActions.clearAppData("com.saucelabs.mydemoapp.rn");
        AppActions.quitApp("com.saucelabs.mydemoapp.rn");
    }


}
