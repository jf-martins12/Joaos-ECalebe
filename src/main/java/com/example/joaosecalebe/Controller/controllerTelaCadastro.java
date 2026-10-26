
package com.example.joaosecalebe.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class controllerTelaCadastro {

    @FXML
    private TextField txCpf;

    @FXML
    private TextField txEmail;

    @FXML
    private PasswordField txSenha;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLimpar;

    private String senhaCorreta = "123456";
    private String emailCorreto = "jec@gmail.com";

    @FXML
    public void initialize() {

        txCpf.textProperty().addListener((obs, antigo, novo) -> {

            String cpf = novo.replaceAll("\\D", "");

            if (cpf.length() > 11) {
                cpf = cpf.substring(0, 11);
            }

            StringBuilder formatado = new StringBuilder(cpf);

            if (cpf.length() > 9) {
                formatado.insert(9, "-");
            }

            if (cpf.length() > 6) {
                formatado.insert(6, ".");
            }

            if (cpf.length() > 3) {
                formatado.insert(3, ".");
            }

            String resultado = formatado.toString();

            if (!novo.equals(resultado)) {
                txCpf.setText(resultado);
                txCpf.positionCaret(resultado.length());
            }
        });
    }

    @FXML
    public void limpar() {
        txCpf.clear();
        txEmail.clear();
        txSenha.clear();
    }

    @FXML
    public void Confirmar(ActionEvent event) throws IOException {

        String cpf = txCpf.getText();
        String email = txEmail.getText();
        String senha = txSenha.getText();

        if (cpf.isEmpty() || email.isEmpty() || senha.isEmpty()) {

            exibirAlerta(
                    Alert.AlertType.WARNING,
                    "Informações incompletas",
                    "Coloque todas as informações"
            );

       //} else if (!email.equals(emailCorreto)) {

            //exibirAlerta(
                    //Alert.AlertType.ERROR,
                   // "E-mail incorreto",
                   // "Digite o e-mail correto"
           // );
        } else if (senha.equals(senhaCorreta)) {

            Parent root = FXMLLoader.load(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/Menu.fxml"
                    )
            );

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } else {

            exibirAlerta(
                    Alert.AlertType.ERROR,
                    "Senha incorreta",
                    "Tente novamente!"
            );
        }
    }

    private void exibirAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensagem) {

        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
