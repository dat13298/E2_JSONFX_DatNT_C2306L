package com.c2306l.myproject.Model;

import com.c2306l.myproject.Connectivity.MySQLConnection;
import com.c2306l.myproject.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersModel {
    private static Connection conn = MySQLConnection.getConnection();
    public static User findUserByUserName(String userName) {
        String sql = "SELECT user_password FROM users WHERE user_name = ?";
        User user = new User();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setUsername(userName);
                user.setPassword(rs.getString("user_password"));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

}
