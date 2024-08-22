package com.c2306l.myproject.Global;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class AppProperties {
    private static Properties prop = new Properties();
//    private static final String APP_PROPERTIES = "/Application.properties";
    private static final String APP_PROPERTIES = System.getProperty("user.home") + "/Application.properties";

    static {
        try {
            InputStream inputStream = AppProperties.class.getResourceAsStream(APP_PROPERTIES);
            if (inputStream != null) {
                prop.load(inputStream);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

//    public static void setProperty(String key,String defaultValue){
//        prop.setProperty(key,defaultValue);
//        try {
//            FileOutputStream fos = new FileOutputStream(APP_PROPERTIES);
//            prop.store(fos, null);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void setProperty(String key, String defaultValue) {
        prop.setProperty(key, defaultValue);
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "/Application.properties"; // Lưu tại thư mục người dùng
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            prop.store(fos, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}