package com.vorkylele.utils;

public class DataGenerator {

    public static String generateUsername() {
        return "user_" + (int) (Math.random() * 1000);
    }

    public static String generateEmail() {
        return "user_email_" + (int) (Math.random() * 1000) + "@example.com";
    }

    public static String generatePassword() {
        return "password" + (int) (Math.random() * 1000);
    }
}
