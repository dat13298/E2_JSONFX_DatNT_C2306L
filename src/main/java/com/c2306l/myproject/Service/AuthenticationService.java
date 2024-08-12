package com.c2306l.myproject.Service;

import com.c2306l.myproject.Connectivity.MySQLConnection;
import com.c2306l.myproject.Entity.AppProperties;
import com.c2306l.myproject.Entity.User;
import com.c2306l.myproject.Model.UsersModel;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthenticationService {

    public static boolean login(String username, String password) {
        User userLogged = UsersModel.findUserByUserName(username);
        return BCrypt.checkpw(password, userLogged.getPassword());
    }
    public static boolean register(String username, String password) {
        String hashPw = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            String sql = "INSERT INTO users(user_name, user_password) VALUES(?, ?)";
            PreparedStatement ps = MySQLConnection.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, hashPw);
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void logout(){
        AppProperties.setProperty("user.loggedin", "false");
        AppProperties.setProperty("user.username", "");
    }
}
