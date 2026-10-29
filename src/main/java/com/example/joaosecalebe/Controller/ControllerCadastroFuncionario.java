
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

    private Funcionario funcionarioEditando = null;

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
                }
        );
    }

    public void prepararEdicao(Funcionario funcionario) {
        funcionarioEditando = funcionario;

        txNome.setText(funcionario.getNome());
        txCpf.setText(funcionario.getCpf());
        txCargo.setText(funcionario.getCargo());
        txSalario.setText(
                String.valueOf(funcionario.getSalario())
        );
    }

    @FXML
    private void confirmar(ActionEvent event) {

        String nome = txNome.getText().trim();
        String cpf = txCpf.getText().trim();
        String cargo = txCargo.getText().trim();
        String textoSalario = txSalario.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty()
                || cargo.isEmpty() || textoSalario.isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Informações incompletas",
                    "Preencha todos os dados."
            );
            return;
        }

        double salario;

        try {
            salario = Double.parseDouble(
                    textoSalario.replace("", "")
            );
        } catch (NumberFormatException e) {

            return;
        }

        if (salario <= 0) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Atenção",
                    "O salário deve ser maior que zero."
            );
            return;
        }

        for (Funcionario funcionario : BancoDeDados.funcionarios) {

            if (funcionario.getCpf().equals(cpf)
                    && funcionario != funcionarioEditando) {

                mostrarAlerta(
                        Alert.AlertType.WARNING,
                        "CPF duplicado",
                        "Já existe outro funcionário com esse CPF."
                );
                return;
            }
        }

        if (funcionarioEditando != null) {

            funcionarioEditando.setNome(nome);
            funcionarioEditando.setCpf(cpf);
            funcionarioEditando.setCargo(cargo);
            funcionarioEditando.setSalario(salario);

        } else {

            Funcionario novoFuncionario = new Funcionario(
                    nome,
                    cpf,
                    cargo,
                    salario,
                    "Ativo"
            );

            BancoDeDados.funcionarios.add(novoFuncionario);
        }

        voltarParaFuncionarios(event);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        voltarParaFuncionarios(event);
    }

    private void voltarParaFuncionarios(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/Cargo.fxml"
                    )
            );

            Parent tela = loader.load();

            ControllerFuncionario controller =
                    loader.getController();

            controller.atualizarTabela();

            Stage janela = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            janela.setScene(new Scene(tela));
            janela.show();

        } catch (Exception e) {
            e.printStackTrace();

        }
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
