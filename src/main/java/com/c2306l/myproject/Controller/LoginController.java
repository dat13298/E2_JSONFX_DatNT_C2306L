package com.c2306l.myproject.Controller;

import com.c2306l.myproject.Global.AppProperties;
import com.c2306l.myproject.Model.UsersModel;
import com.c2306l.myproject.Service.AuthenticationService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Label lblMessage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        boolean islogin = true;
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            boolean islogin = true;
            @Override
            public void handle(ActionEvent event) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                if(username.isEmpty() || password.isEmpty()){
                    lblMessage.setText("invalid username or password");
                    lblMessage.setStyle("-fx-text-fill: red");
                    islogin = false;
                } else {
                    lblMessage.setText("invalid username or password");
                    lblMessage.setStyle("-fx-text-fill: red");
                    islogin = false;
                }
                islogin = AuthenticationService.login(username, password);
                if(islogin){
                    AppProperties.setProperty("user.username", username);
                    AppProperties.setProperty("user.loggedin", "true");
                    lblMessage.setText("login success");
                    lblMessage.setStyle("-fx-text-fill: green");
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/c2306l/myproject/layout.fxml"));

                    try {
                        Scene scene = new Scene(fxmlLoader.load());
                        stage.setTitle("Main menu");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
//                        throw new RuntimeException(e);
                    }
                } else {
                    lblMessage.setText("invalid username or password");
                }
            }
        });
    }
}
