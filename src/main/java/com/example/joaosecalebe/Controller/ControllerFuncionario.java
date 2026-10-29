
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Funcionario;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.util.Optional;

public class ControllerFuncionario {

    @FXML
    private javafx.scene.control.Label lbTotal;

    @FXML
    private javafx.scene.control.Label lbAtivos;

    @FXML
    private javafx.scene.control.Label lbInativos;

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colCpf;

    @FXML
    private TableColumn<Funcionario, String> colCargo;

    @FXML
    private TableColumn<Funcionario, Double> colSalario;

    @FXML
    private TableColumn<Funcionario, String> colStatus;

    @FXML
    private Button btnAdicionar;

    private ObservableList<Funcionario> listaFuncionarios;

    @FXML
    public void initialize() {

        colFuncionarios.setCellValueFactory(
                new PropertyValueFactory<>("nome"));

        colCpf.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));

        colCargo.setCellValueFactory(
                new PropertyValueFactory<>("cargo"));

        colSalario.setCellValueFactory(
                new PropertyValueFactory<>("salario"));

        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        listaFuncionarios = FXCollections.observableArrayList(
                BancoDeDados.funcionarios
        );

        tabelaFuncionarios.setItems(listaFuncionarios);

        atualizarDashboard();
    }
    @FXML
    private void alterarStatus() {

        Funcionario selecionado = tabelaFuncionarios
                .getSelectionModel()
                .getSelectedItem();

        if (selecionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Selecione um funcionário.");
            alerta.showAndWait();
            return;
        }

        String novoStatus;

        if ("Ativo".equalsIgnoreCase(selecionado.getStatus())) {
            novoStatus = "Inativo";
        } else {
            novoStatus = "Ativo";
        }

        selecionado.setStatus(novoStatus);

        atualizarTabela();
    }
    public void atualizarDashboard() {

        int total = listaFuncionarios.size();
        int ativos = 0;
        int inativos = 0;

        for (Funcionario funcionario : listaFuncionarios) {

            if ("Ativo".equalsIgnoreCase(funcionario.getStatus())) {
                ativos++;
            } else if ("Inativo".equalsIgnoreCase(funcionario.getStatus())) {
                inativos++;
            }
        }

        lbTotal.setText(String.valueOf(total));
        lbAtivos.setText(String.valueOf(ativos));
        lbInativos.setText(String.valueOf(inativos));
    }

    @FXML
    public void adicionarFuncionario() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/CadastroFuncionario.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = (Stage) btnAdicionar.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Erro",
                    "Não foi possível abrir o cadastro."
            );
        }
    }

    @FXML
    public void editarFuncionario(ActionEvent event) {
        Funcionario selecionado = tabelaFuncionarios
                .getSelectionModel().getSelectedItem();

        if (selecionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atenção");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um funcionário para editar.");
            alerta.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/CadastroFuncionario.fxml"
                    )
            );

            Parent tela = loader.load();

            ControllerCadastroFuncionario controller =
                    loader.getController();

            controller.prepararEdicao(selecionado);

            Stage janela = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            janela.setScene(new Scene(tela));
            janela.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    public void excluirFuncionario() {

        Funcionario funcionario = tabelaFuncionarios.getSelectionModel()
                .getSelectedItem();

        if (funcionario == null) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Atenção",
                    "Selecione um funcionário para excluir"
            );
            return;
        }

        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmar exclusão");
        confirmacao.setHeaderText("Excluir funcionário");
        confirmacao.setContentText(
                "Deseja realmente excluir esse funcionario ?"
        );

        Optional<ButtonType> resultado = confirmacao.showAndWait();

        if (resultado.isPresent()
                && resultado.get() == ButtonType.OK) {

            BancoDeDados.funcionarios.remove(funcionario);

            atualizarTabela();
        }
    }



    public void atualizarTabela() {

        listaFuncionarios.setAll(BancoDeDados.funcionarios);

        tabelaFuncionarios.refresh();

        atualizarDashboard();
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
