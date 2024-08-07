package com.c2306l.myproject.Controller;

import com.c2306l.myproject.Entity.Category;
import com.c2306l.myproject.Model.CategoryStatement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML private Button btnEdit;
    @FXML private TableView<Category> tableCategory = new TableView<Category>();
    private ObservableList<Category> categories;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategoryStatement cs = new CategoryStatement();
//        List categories
        categories = cs.selectAll();

        tableCategory.setEditable(true);
        tableCategory.getColumns().get(0).setVisible(false);
        cid.setText("ID");
        cid.setCellValueFactory(new PropertyValueFactory<Category, String>("id"));
        ccode.setCellValueFactory(new PropertyValueFactory<Category, String>("code"));
        cname.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        cdescription.setCellValueFactory(new PropertyValueFactory<Category, String>("description"));
        tableCategory.setItems(categories);

//        add new category
        btnNewCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Category newCategory = new Category();
                boolean isEdit = false;
//                newCategory.setCode(txtCode.getText());
//                newCategory.setName(txtName.getText());
//                newCategory.setDescription(txtDescription.getText());
////                insert db
//                CategoryStatement.insert(newCategory);
////                refresh value
//                tableCategory.getItems().clear();
//                categories = CategoryStatement.getCategoryList();
//                tableCategory.setItems(categories);
//                tableCategory.refresh();
//                txtCode.clear();
//                txtName.clear();
//                txtDescription.clear();
                showFormDialog(newCategory, isEdit);
            }
        });

//        add event to table view
        tableCategory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtCode.setText(newValue.getCode());
                txtName.setText(newValue.getName());
                txtDescription.setText(newValue.getDescription());
            }
        });
//        update
        btnEditCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Category editedCategory = tableCategory.getSelectionModel().getSelectedItem();
                if (editedCategory != null) {
                    editedCategory.setCode(txtCode.getText());
                    editedCategory.setName(txtName.getText());
                    editedCategory.setDescription(txtDescription.getText());
                    cs.update(editedCategory);
                    tableCategory.refresh();
                    txtCode.clear();
                    txtName.clear();
                    txtDescription.clear();
                }
            }
        });
//        edit
        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Category selectedCategory = tableCategory.getSelectionModel().getSelectedItem();
                boolean isEdit = true;
                if (selectedCategory != null) {
                    showFormDialog(selectedCategory, isEdit);
                }
            }
        });
    }

    private void showFormDialog(Category category, boolean isEditMode) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/c2306l/myproject/editCategoryDialog.fxml"));
            Stage dialogStage = new Stage();
            CategoryStatement categoryStatement = new CategoryStatement();
            if(isEditMode){
                dialogStage.setTitle("Edit Category");
            } else {
                dialogStage.setTitle("Add Category");
            }
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(tableCategory.getScene().getWindow());
            dialogStage.setScene(new Scene(fxmlLoader.load()));

            EditCategoryDialogController controller = fxmlLoader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEditMode(isEditMode);
            controller.setCategory(category);
            dialogStage.showAndWait();
            if (controller.isSaved()) {
                if (isEditMode) {
                    categoryStatement.update(category);
                } else {
                    categoryStatement.insert(category);
                    categories = categoryStatement.selectAll();
                }
                tableCategory.setItems(categories);
                tableCategory.refresh();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
