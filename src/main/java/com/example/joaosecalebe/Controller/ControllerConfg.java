
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.DadosLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerConfg {

    @FXML
    private TextField txNome;

    @FXML
    private TextField txEmail;

    @FXML
    private TextField txCpf;

    @FXML
    private PasswordField txSenhaAtual;

    @FXML
    private PasswordField txNovaSenha;

    @FXML
    private PasswordField txConfirmarSenha;


    @FXML
    public void initialize() {
        txNome.setText(DadosLogin.nome);
        txEmail.setText(DadosLogin.email);
        txCpf.setText(DadosLogin.cpf);

        txCpf.setEditable(false);
    }


    @FXML
    public void salvarAlteracoes() {

        String nome = txNome.getText().trim();
        String email = txEmail.getText().trim();

        if (nome.isEmpty() || email.isEmpty()) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos obrigatórios",
                    "Preencha o nome e o e-mail"
            );
            return;
        }

        if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "E-mail inválido",
                    "Digite um e-mail válido"
            );
            return;
        }

        DadosLogin.nome = nome;
        DadosLogin.email = email;

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Sucesso",
                "Nome e e-mail atualizados"
        );
    }


    @FXML
    public void alterarSenha() {

        String atual = txSenhaAtual.getText();
        String nova = txNovaSenha.getText();
        String confirmar = txConfirmarSenha.getText();

        if (atual.isEmpty() || nova.isEmpty() || confirmar.isEmpty()) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos vazios",
                    "Preencha todas as informações"
            );
            return;
        }

        if (!atual.equals(DadosLogin.senha)) {
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Senha incorreta",
                    "A senha atual está incorreta"
            );
            return;
        }

        if (nova.length() < 6) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Senha inválida",
                    "A nova senha precisa ter pelo menos 6 caracteres."
            );
            return;
        }

        if (!nova.equals(confirmar)) {
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "ERRO",
                    "Senhas diferentes"
            );
            return;
        }

        DadosLogin.senha = nova;

        txSenhaAtual.clear();
        txNovaSenha.clear();
        txConfirmarSenha.clear();

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Sucesso",
                "Senha alterada"
        );
    }


    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensagem
    ) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
