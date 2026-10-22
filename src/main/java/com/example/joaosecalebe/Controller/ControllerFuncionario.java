
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Funcionario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ControllerFuncionario {

    @FXML
    private Label lbativos;

    @FXML
    private Label lbCargos;

    @FXML
    private Label lbFolhaSalarial;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario, String> colCargo;

    @FXML
    private TableColumn<Funcionario, Double> colSalario;

    @FXML
    public void initialize() {

        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );

        colCargo.setCellValueFactory(
                new PropertyValueFactory<>("cargo")
        );

        colSalario.setCellValueFactory(
                new PropertyValueFactory<>("salario")
        );

        atualizarDashboard();
    }

    public void atualizarDashboard() {

        int total = BancoDeDados.funcionarios.size();

        double folhaSalarial = 0;

        Set<String> cargos = new HashSet<>();

        for (Funcionario funcionario : BancoDeDados.funcionarios) {

            folhaSalarial += funcionario.getSalario();

            if (funcionario.getCargo() != null
                    && !funcionario.getCargo().trim().isEmpty()) {

                cargos.add(funcionario.getCargo().trim());
            }
        }

        lbativos.setText(String.valueOf(total));

        lbCargos.setText(String.valueOf(cargos.size()));

        NumberFormat moeda = NumberFormat.getCurrencyInstance(
                new Locale("pt", "BR")
        );

        lbFolhaSalarial.setText(moeda.format(folhaSalarial));

        tbFuncionarios.setItems(
                FXCollections.observableArrayList(
                        BancoDeDados.funcionarios
                )
        );
    }

    @FXML
    private void abrirCadastro(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/example/joaosecalebe/view/CadastroFuncionario.fxml"
                )
        );

        Parent tela = loader.load();

        Stage janela = (Stage) ((Node) event.getSource())
                .getScene().getWindow();

        janela.setScene(new Scene(tela));
        janela.show();
    }
}
