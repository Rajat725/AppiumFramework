package com.qa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public final class RandomTextGenerator {
    private RandomTextGenerator() {
    }

    private static final Faker faker=new Faker(new Locale("en-IND"));

    public static String getEmail()
    {
        return faker.internet().emailAddress();

    }
    public static String getPassword(int length)
    {
        return faker.internet().password(0,length,true);
    }

}
