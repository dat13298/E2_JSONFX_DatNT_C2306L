package com.c2306l.myproject.Connectivity;

import java.sql.*;

public class MySQLConnection {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/E2_shop";
    private static final String user = "root";
    private static final String password = "Tu100den10*#";
    private static Connection conn = null;
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
    public static void close() {
        try {
            MySQLConnection.conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
