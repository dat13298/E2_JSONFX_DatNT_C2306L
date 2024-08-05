package com.c2306l.myproject.Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/E2_shop";
    private static final String user = "root";
    private static final String password = "Tu100den10*#";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException|SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
