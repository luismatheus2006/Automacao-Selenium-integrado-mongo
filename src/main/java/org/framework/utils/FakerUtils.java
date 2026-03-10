package org.framework.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    private static Faker faker = new Faker();

    public static String generateEmail(){

        return faker.name().username() + "@testmail.com";

    }

    public static String generatePassword(){

        return faker.internet().password(8,16,true,true);

    }

}