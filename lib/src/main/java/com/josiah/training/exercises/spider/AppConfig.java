package com.josiah.training.exercises.spider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/****************************************************************************
 * <b>Title:</b> AppConfig.java
 * <b>Project:</b> lib
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Sep 28, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class AppConfig {
    private static final String CONFIG_FILE_PATH = "config.properties";
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
    
    public static String getPort() {
        return properties.getProperty("port");
    }

    public static String getUsername() {
        return properties.getProperty("usr");
    }

    public static String getPassword() {
        return properties.getProperty("pw");
    }

    public static String getOptionalRoute() {
        return properties.getProperty("optional_route");
    }
}

