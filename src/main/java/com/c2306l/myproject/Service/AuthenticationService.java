package com.c2306l.myproject.Service;

import com.c2306l.myproject.Connectivity.MySQLConnection;
import com.c2306l.myproject.Entity.AppProperties;
import com.c2306l.myproject.Entity.User;
import com.c2306l.myproject.Model.UsersModel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Base64;

public class AuthenticationService {
//    private static final Connection conn = MySQLConnection.getConnection();

    public static boolean login(String username, String password) {
        User userLogged = UsersModel.findUserByUserName(username);
        if(userLogged.getPassword().equals(password)){
            AppProperties.setProperty("user.token_key", getToken());
//            userLogged.setTokenKey(getToken());
            return true;
        }
        return false;
    }

    private static String getToken(){
        String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890";
        String token = "";
        for(int i = 0; i < 6; i++){
            int index = (int) (Math.random() * alphabet.length());
            token += alphabet.charAt(index);
        }
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    public void logout(){
        AppProperties.setProperty("user.loggedin", "false");
        AppProperties.setProperty("user.username", "");
    }
}
