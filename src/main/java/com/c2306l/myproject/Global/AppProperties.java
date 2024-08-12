package com.c2306l.myproject.Global;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static final Properties prop = new Properties();
    private static final String APP_PROPERTIES = "app.properties";

    static {
        try {
            InputStream inputStream = AppProperties.class.getClassLoader().getResourceAsStream(APP_PROPERTIES);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println(STR."can not find \{APP_PROPERTIES}");
            }
        }catch (Exception e){
            System.out.println(STR."static: \{e.getMessage()}");
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
            System.out.println(STR."setProperties: \{e.getMessage()}");
        }
    }
}
