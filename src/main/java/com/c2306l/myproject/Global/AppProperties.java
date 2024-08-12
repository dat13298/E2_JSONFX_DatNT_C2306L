package com.c2306l.myproject.Global;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class AppProperties {
    private static Properties prop = new Properties();
    private static final String APP_PROPERTIES = "/Application.properties";

    static {
        try {
            InputStream inputStream = AppProperties.class.getResourceAsStream(APP_PROPERTIES);
            if (inputStream != null) {
                prop.load(inputStream);

            } else {
                System.out.println("can not find" + APP_PROPERTIES);
            }
        }catch (Exception e){
            System.out.println("static: " + e.getMessage());
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
//app.title=MyProject-Authentication
//app.width=900
//app.height=900
//user.loggedin=false
//user.username=
//user.token_key=
//hash.salt=abc123