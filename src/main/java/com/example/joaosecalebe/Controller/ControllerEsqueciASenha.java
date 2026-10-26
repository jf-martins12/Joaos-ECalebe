package com.example.joaosecalebe.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerEsqueciASenha {
    @FXML
    TextField txemail;
    @FXML
    TextField txnovasenha;
    @FXML
    TextField txconfirmarsenha;
    @FXML
    Button btnconfirmar;
    @FXML
    Button btnlimpar;
    @FXML
    Button btneditar;


    @FXML
    public void limpar() {
        txemail.clear();
        txnovasenha.clear();
        txconfirmarsenha.clear();
    }


    public void confirmar() {


        String senha = txnovasenha.getText();
        String email = txemail.getText();
        String confirmarsenha = txconfirmarsenha.getText();

        if (email.equals("")) {


            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Digite seu email");
            alert.showAndWait();
            return;
        }

        if (!senha.equals(confirmarsenha)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("As senhas não são iguais");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("A sua senha foi trocada ");
        alert.showAndWait();
        return;


    }
}

