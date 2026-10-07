package com.example.joaosecalebe.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerCadastroGerente {
    @FXML private
    TextField txNome;
    @FXML private
    TextField txCpf;

    @FXML private Button
    btnCadastrar;
    @FXML private Button
    btnLimpar;


    @FXML public void limpar () {
        txNome.clear();
        txCpf.clear();
    }
    public void CadastrarGerente (){
        String Nome=txNome.getText();
        String Cpf =txCpf.getText();
    }
    {if (txNome==null||txCpf==null){
    exibirAlerta(Alert.AlertType.INFORMATION, "Aviso", "Por favor insira seu nome");

    }


    }
    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }










}
