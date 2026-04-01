package com.project.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            System.out.println(System.getProperty("user.dir"));
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            System.out.println("after fileinputstream");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("file not found Exception");
        } catch (IOException eo) {
            System.out.println("IO Exception");
        }
    }

    public static String getUsername() {
        return properties.getProperty("Username");
    }

    public static String getPassword() {
        return properties.getProperty("Password");
    }

    public static String getAmazonUrl() {
        return properties.getProperty("AmazonUrl");
    }
}
