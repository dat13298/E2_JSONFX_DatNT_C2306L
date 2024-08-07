package com.c2306l.myproject.Global;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static Properties prop = new Properties();
    private static String APP_PROPERTIES = "app.properties";

    static {
        try {
            InputStream inputStream = AppProperties.class.getClassLoader().getResourceAsStream(APP_PROPERTIES);
            prop.load(inputStream);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

    public static void setProperty(String key,String defaultValue){
        prop.setProperty(key,defaultValue);
        try {
            FileOutputStream fos = new FileOutputStream(APP_PROPERTIES);
            prop.store(fos, null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
