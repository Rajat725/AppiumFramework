package com.qa.utils;

public class DynamicXpath {

    public static String getXPath(String xpath, String replacedKeyword) {
        return xpath.replace("Replace", replacedKeyword);
    }
}
