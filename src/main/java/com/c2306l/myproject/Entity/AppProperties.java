package com.c2306l.myproject.Entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class AppProperties {
    private static Properties prop = new Properties();
    private static final String PROPERTIES_FILE = "app.properties";

    static {
        try(InputStream in = AppProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if(in != null){
                prop.load(in);
            } else {
                System.out.println("Sorry unable to load properties file");
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        prop.setProperty(key, value);
        try(FileOutputStream fos = new FileOutputStream(AppProperties.class.getClassLoader().getResource(PROPERTIES_FILE).getPath())) {
            prop.store(fos, null);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
