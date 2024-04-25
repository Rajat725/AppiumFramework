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
    public static String getFullName()
    {
        return faker.name().fullName();
    }
    public static String getAddress1()
    {
        return faker.address().fullAddress();
    }

    public static String getAddress2()
    {
        return faker.address().streetAddress(true);
    }

    public static String getCity()
    {
        return faker.address().cityName();
    }
    public static String getState()
    {
        return faker.address().state();
    }

    public static String getZipCode()
    {
        return faker.address().zipCode();
    }

    public static String getCountry()
    {
        return faker.address().country();
    }


}

