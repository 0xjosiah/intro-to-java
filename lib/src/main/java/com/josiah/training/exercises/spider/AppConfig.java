package com.josiah.training.exercises.spider;

import java.io.IOException;
import java.io.InputStream;
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
    private static final String CONFIG_FILE = "spiderConfig.properties";
    private static Properties properties = new Properties();
    private InputStream in;

    public void loadConfig() throws IOException {
        try {
            in = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);
            if(in != null) properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
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

