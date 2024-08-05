package com.c2306l.myproject.Model;

import com.c2306l.myproject.Connectivity.MySQLConnection;
import com.c2306l.myproject.Entity.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryStatement {
    private static final long serialVersionID = 1L;
    private static final Connection conn = MySQLConnection.getConnection();

    public static void insert(Category category){
        try {
            String query = "INSERT INTO tblcategory(code, cat_name, cat_description) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, category.getCode());
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescription());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void update(Category category){
        try {
            String query = "UPDATE tblcategory SET code=?, cat_name=?, cat_description=? WHERE cat_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, category.getCode());
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescription());
            ps.setInt(4, category.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void delete(Category category){
        try {
            String query = "DELETE FROM tblcategory WHERE cat_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, category.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static ObservableList<Category> getCategoryList(){
        ObservableList<Category> list = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM tblcategory";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCode(rs.getString("code"));
                category.setName(rs.getString("cat_name"));
                category.setDescription(rs.getString("cat_description"));
                list.add(category);
            }
            rs.close();
            ps.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static Category getById(int id){
        Category category = new Category();
        try {
            String query = "SELECT * FROM tblcategory WHERE cat_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                category.setId(rs.getInt("id"));
                category.setCode(rs.getString("code"));
                category.setName(rs.getString("cat_name"));
                category.setDescription(rs.getString("cat_description"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return category;
    }
}
