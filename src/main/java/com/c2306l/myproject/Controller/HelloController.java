package com.c2306l.myproject.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label lbWelcome;
    @FXML
    private TextField txtCode;

    @FXML
    protected void onHelloButtonClick() {
        String code = txtCode.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (code.trim().isEmpty()) {
            lbWelcome.setText("Category not null");
            lbWelcome.setStyle("-fx-text-fill: red");
            txtCode.setStyle("-fx-border-color: red");
        }else {
            alert.setTitle("Category Confirmation");
            alert.setHeaderText("Confirmation");
            alert.setContentText("Are you sure you want to get code?");
            alert.showAndWait().ifPresent(response -> {
                if(response.getButtonData().isDefaultButton()){
                    lbWelcome.setText(code);
                    lbWelcome.setStyle("-fx-text-fill: green");
                }
                if(response.getButtonData().isCancelButton()){
                    lbWelcome.setText("Nothing to show");
                    lbWelcome.setStyle("-fx-text-fill: blue");
                }
            });


//            alert.showAndWait();
        }
//        lbWelcome.setText(code);
    }
}