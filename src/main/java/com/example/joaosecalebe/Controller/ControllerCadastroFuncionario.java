
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Funcionario;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerCadastroFuncionario {

    @FXML
    private TextField txNome;

    @FXML
    private TextField txCpf;

    @FXML
    private TextField txCargo;

    @FXML
    private TextField txSalario;

    @FXML
    private void confirmar(ActionEvent event) throws IOException {

        String nome = txNome.getText().trim();
        String cpf = txCpf.getText().trim();
        String cargo = txCargo.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty()
                || cargo.isEmpty()
                || txSalario.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Atenção",
                    "Preencha todos os campos."
            );
            return;
        }

        double salario;

        try {
            salario = Double.parseDouble(
                    txSalario.getText().trim().replace(",", ".")
            );
        } catch (NumberFormatException e) {
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Salário inválido",
                    "Digite um salário válido. Exemplo: 2500,00"
            );
            return;
        }

        if (salario < 0) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Atenção",
                    "O salário não pode ser negativo."
            );
            return;
        }

        for (Funcionario funcionario : BancoDeDados.funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                mostrarAlerta(
                        Alert.AlertType.WARNING,
                        "CPF já cadastrado",
                        "Já existe um funcionário com esse CPF."
                );
                return;
            }
        }

        // Mantém o construtor atual do seu model.
        Funcionario funcionario = new Funcionario(
                nome, cpf, cargo, salario, ""
        );

        BancoDeDados.funcionarios.add(funcionario);

        mostrarAlerta(
                Alert.AlertType.INFORMATION,
                "Cadastro concluído",
                "Funcionário cadastrado com sucesso!"
        );

        voltarParaFuncionarios(event);
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        voltarParaFuncionarios(event);
    }

    private void voltarParaFuncionarios(ActionEvent event)
            throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/example/joaosecalebe/view/MenuFuncionario.fxml"
                )
        );

        Parent tela = loader.load();

        Stage janela = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        janela.setScene(new Scene(tela));
        janela.show();
    }

    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensagem) {

        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
