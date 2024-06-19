package com.wisesoftlab.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        String configFilePath = "src/main/resources/config.properties";
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            properties = new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            try (FileInputStream input = new FileInputStream("src/main/resources/config.properties.template")) {
                properties = new Properties();
                properties.load(input);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}