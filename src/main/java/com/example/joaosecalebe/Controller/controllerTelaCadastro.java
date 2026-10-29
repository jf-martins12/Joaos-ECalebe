
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.DadosLogin;

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
    private TextField txNome;

    @FXML
    private PasswordField txSenha;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLimpar;

    @FXML
    public void initialize() {

        // Formatação automática do CPF
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
        txNome.clear();
    }

    @FXML
    public void Confirmar(ActionEvent event) throws IOException {

        String nome = txNome.getText().trim();
        String cpf = txCpf.getText().trim();
        String email = txEmail.getText().trim();
        String senha = txSenha.getText();

        // Verifica se todos os campos foram preenchidos
        if (nome.isEmpty() || cpf.isEmpty()
                || email.isEmpty() || senha.isEmpty()) {

            exibirAlerta(
                    Alert.AlertType.WARNING,
                    "Informações incompletas",
                    "Preencha todas as informações."
            );

            return;
        }

        // Verifica se o e-mail está correto
        if (!email.equalsIgnoreCase(DadosLogin.email)) {

            exibirAlerta(
                    Alert.AlertType.ERROR,
                    "E-mail incorreto",
                    "Digite o e-mail correto."
            );

            return;
        }

        // Verifica se a senha está correta
        if (!senha.equals(DadosLogin.senha)) {

            exibirAlerta(
                    Alert.AlertType.ERROR,
                    "Senha incorreta",
                    "Tente novamente!"
            );

            return;
        }

        // SALVA OS DADOS PARA AS OUTRAS TELAS
        DadosLogin.nome = nome;
        DadosLogin.email = email;
        DadosLogin.cpf = cpf;
        DadosLogin.senha = senha;

        // Abre o menu do sistema
        Parent root = FXMLLoader.load(
                getClass().getResource(
                        "/com/example/joaosecalebe/view/Menu.fxml"
                )
        );

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
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

    @FXML
    public void esquecisenha(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource(
                        "/com/example/joaosecalebe/view/EsqueciSenha.fxml"
                )
        );

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
