
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.DadosLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class ControllerEsqueciASenha {

    @FXML
    private TextField txemail;

    @FXML
    private TextField txnovasenha;

    @FXML
    private TextField txconfirmarsenha;

    @FXML
    public void limpar() {
        txemail.clear();
        txnovasenha.clear();
        txconfirmarsenha.clear();
    }


    @FXML
    public void confirmar() {

        String email = txemail.getText().trim();
        String senha = txnovasenha.getText();
        String confirmarSenha = txconfirmarsenha.getText();

        if (email.isEmpty() || senha.isEmpty()
                || confirmarSenha.isEmpty()) {

            mostrarAlerta(Alert.AlertType.ERROR,
                    "Preencha todos os campos");
            return;
        }

        if (!email.equalsIgnoreCase(DadosLogin.email.trim())) {
            mostrarAlerta(Alert.AlertType.ERROR,
                    "Email não cadastrado");
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            mostrarAlerta(Alert.AlertType.ERROR,
                    "As senhas não são iguais");
            return;
        }

        DadosLogin.senha = senha;

        mostrarAlerta(Alert.AlertType.INFORMATION,
                "Senha alterada com sucesso!");

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/TelaCadastro.fxml"
                    )
            );

            Stage stage = (Stage) txemail.getScene()
                    .getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void mostrarAlerta(
            Alert.AlertType tipo, String mensagem) {

        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
