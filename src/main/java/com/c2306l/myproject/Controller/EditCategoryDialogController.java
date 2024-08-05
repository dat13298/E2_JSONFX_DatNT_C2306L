package com.c2306l.myproject.Controller;

import com.c2306l.myproject.Entity.Category;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditCategoryDialogController implements Initializable {
    @FXML private TextField txtEditCode;
    @FXML private TextField txtEditName;
    @FXML private TextArea txtEditDescription;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;

    private Category category;
    private Stage dialogStage;
    private boolean saved = false;
    private boolean isEditMode;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setCategory(Category category) {
        this.category = category;
        if (isEditMode) {
            txtEditCode.setText(category.getCode());
            txtEditName.setText(category.getName());
            txtEditDescription.setText(category.getDescription());
        }
    }
    public void setEditMode(boolean isEditMode) {
        this.isEditMode = isEditMode;
        if (!isEditMode) {
            txtEditCode.clear();
            txtEditName.clear();
            txtEditDescription.clear();
        }
    }
    public boolean isSaved(){
        return saved;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                category.setId();
                category.setCode(txtEditCode.getText());
                category.setName(txtEditName.getText());
                category.setDescription(txtEditDescription.getText());
                saved = true;
                dialogStage.close();
            }
        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialogStage.close();
            }
        });
    }
}
