package com.example.joaosecalebe.Controller;


import com.example.joaosecalebe.DataBase.DadosLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class
ControllerPerfil {

    @FXML
    private Label lbNome;

    @FXML
    public void initialize() {
        lbNome.setText(DadosLogin.nome);
    }
}