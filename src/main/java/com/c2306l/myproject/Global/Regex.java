package com.c2306l.myproject.Global;

public class Regex {
    public static boolean validateCode(String code){
        String regex = "^[A-Z]+[0-9]{2}$";
        return code.matches(regex);
    }
}