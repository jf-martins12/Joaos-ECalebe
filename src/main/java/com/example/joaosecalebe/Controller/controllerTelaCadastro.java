package com.example.joaosecalebe.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class controllerTelaCadastro {

    @FXML
    private
    TextField txNome;
    @FXML
    private
    TextField txCpf;

    @FXML
    private
    TextField txTelefone;

    @FXML
    private
    TextField txSenha;

    @FXML
    private
    TextField txEmail;
    @FXML
    private Button
            btnCadastrar;
    @FXML
    private Button
            btnLimpar;


    @FXML
    public void limpar() {
        txNome.clear();
        txCpf.clear();
        txEmail.clear();
        txTelefone.clear();
        txSenha.clear();
    }

    public void Cadastrar() {
        String Nome = txNome.getText();
        String Cpf = txCpf.getText();
        String Email = txEmail.getText();
        String Telefone = txTelefone.getText();
    }

    {
        if (txNome == null || txCpf == null || txTelefone == null || txEmail == null) {
            exibirAlerta(Alert.AlertType.INFORMATION, "informações obrigatorias", "N foi possivel concluir!");

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