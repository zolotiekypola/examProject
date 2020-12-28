package ru.sapteh.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CloseConfirmController {
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonExit;

    public void initialize(){
    buttonExit.setOnAction(event -> {
        System.exit(0);
    });
    buttonCancel.setOnAction(event -> {
        buttonCancel.getScene().getWindow().hide();
    });
    }
}
