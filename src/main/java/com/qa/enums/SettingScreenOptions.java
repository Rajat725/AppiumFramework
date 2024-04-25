package com.qa.enums;

public enum SettingScreenOptions {

    CATALOG("catalog"),
    QRCODESCANNER("qr code scanner"),
    WEBVIEW("webview"),
    GEOLOCATION("geo location"),
    DRAWING("drawing"),
    ABOUT("about"),
    RESETAPPSTATE("reset app"),
    FINGERPRINT("biometrics"),
    LOGIN("log in"),
    LOGOUT("log out"),
    APICALLS("api calls"),
    SAUCEBOTVIDEOS("sauce bot video");


    private String value;

    private SettingScreenOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
