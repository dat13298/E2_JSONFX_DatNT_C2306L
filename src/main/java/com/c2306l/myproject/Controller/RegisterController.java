package com.c2306l.myproject.Controller;

import com.c2306l.myproject.Service.AuthenticationService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML private Button btnRregister;

    @FXML private PasswordField txtConfirmPassword;

    @FXML private PasswordField txtPassword;

    @FXML private TextField txtUsername;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRregister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                String confirmPassword = txtConfirmPassword.getText();
                if(password.equals(confirmPassword)){
                    AuthenticationService.register(username, password);
                }
            }
        });
    }
}
