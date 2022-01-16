package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaderTwo {

    private static Properties properties; // declare a variable
    // static blocks: it initiates every time I call class name

    static {
        String path = "configurationTwo.properties";
        try {
            properties = new Properties(); // created properties object
            FileInputStream file = new FileInputStream(path); // throws java io execption, checked exception
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

}
