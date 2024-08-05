package com.c2306l.myproject.global;

import java.util.regex.Pattern;

public class Regex {
    public static boolean validateCode(String code){
        String regex = "^[A-Z]+[0-9]{2}$";
        return code.matches(regex);
    }
}