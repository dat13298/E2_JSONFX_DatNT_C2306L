package com.c2306l.myproject.Controller;

import com.c2306l.myproject.Global.AppProperties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {
    @FXML Label lbWelcome;
    @FXML MenuItem mnRegister;
    @FXML MenuItem mnList;
    @FXML
    StackPane stackPane;
    @FXML
    MenuItem mnCategoryList;

    public void setContent(Parent newContentPane){
        stackPane.getChildren().clear();
        stackPane.getChildren().add(newContentPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbWelcome.setText("Welcome " + AppProperties.getProperty("user.username"));
        mnCategoryList.setOnAction(event -> {
            //load view category
            getContentPane("/com/c2306l/myproject/category.fxml");
        });
        String css = Objects.requireNonNull(getClass().getResource("/com/c2306l/myproject/layoutCSS.css")).toExternalForm();
        stackPane.getStylesheets().add(css);
        mnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getContentPane("/com/c2306l/myproject/register.fxml");
            }
        });
    }

    public void getContentPane(String fileFXML) {
        Parent newContentPane;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fileFXML));
            newContentPane = loader.load();
            setContent(newContentPane);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
