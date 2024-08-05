package com.c2306l.myproject.Controller;

import com.c2306l.myproject.Entity.Category;
import com.c2306l.myproject.Model.CategoryStatement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @FXML private TableColumn<Category, String> cid;
    @FXML private TableColumn<Category, String> ccode;
    @FXML private TableColumn<Category, String> cname;
    @FXML private TableColumn<Category, String> cdescription;
    @FXML private TextField txtCode;
    @FXML private TextField txtName;
    @FXML private TextArea txtDescription;
    @FXML private Button btnNewCategory;
    @FXML private Button btnEditCategory;
    @FXML private TableView<Category> tableCategory = new TableView<Category>();
    private ObservableList<Category> categories;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        List categories
        categories = CategoryStatement.getCategoryList();

        tableCategory.setEditable(true);
        tableCategory.getColumns().get(0).setVisible(false);
        cid.setText("ID");
        cid.setCellValueFactory(new PropertyValueFactory<Category, String>("id"));
        ccode.setCellValueFactory(new PropertyValueFactory<Category, String>("code"));
        cname.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        cdescription.setCellValueFactory(new PropertyValueFactory<Category, String>("description"));
        tableCategory.setItems(categories);
        btnNewCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Category newCategory = new Category();
                newCategory.setCode(txtCode.getText());
                newCategory.setName(txtName.getText());
                newCategory.setDescription(txtDescription.getText());
                CategoryStatement.insert(newCategory);
                tableCategory.getItems().clear();
                categories = CategoryStatement.getCategoryList();
                tableCategory.setItems(categories);
                tableCategory.refresh();
                txtCode.clear();
                txtName.clear();
                txtDescription.clear();
            }
        });
    }

}
