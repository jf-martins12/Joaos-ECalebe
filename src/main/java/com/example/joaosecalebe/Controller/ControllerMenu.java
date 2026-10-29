
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;
import com.example.joaosecalebe.Model.Funcionario;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.NumberFormat;
import java.util.Locale;

public class ControllerMenu {

    @FXML
    private Label lblReceita;

    @FXML
    private Label lblTotalVendas;

    @FXML
    private Label lblEstoque;

    @FXML
    private LineChart<String, Number> graficoVendas;

    @FXML
    private TableView<Funcionario> tblFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colFuncionario;

    @FXML
    private TableColumn<Funcionario, String> colStatus;

    @FXML
    public void initialize() {

        configurarTabelaFuncionarios();
        atualizarDashboard();
        atualizarTabelaFuncionarios();
    }

    private void configurarTabelaFuncionarios() {

        colFuncionario.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );

        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );
    }

    public void atualizarTabelaFuncionarios() {

        tblFuncionarios.getItems().setAll(
                BancoDeDados.funcionarios
        );
    }

    public void atualizarDashboard() {

        double receita = 0;
        int totalEstoque = 0;

        for (Venda venda : BancoDeDados.vendas) {
            receita += venda.getVendatotal();
        }

        for (Produto produto : BancoDeDados.produtos) {
            totalEstoque += produto.getQuantidade();
        }

        lblTotalVendas.setText(
                String.valueOf(BancoDeDados.vendas.size())
        );

        lblEstoque.setText(String.valueOf(totalEstoque));

        NumberFormat formato = NumberFormat.getCurrencyInstance(
                new Locale("pt", "BR")
        );

        lblReceita.setText(formato.format(receita));

        atualizarGrafico();
    }

    private void atualizarGrafico() {

        XYChart.Series<String, Number> serie =
                new XYChart.Series<>();

        for (Venda venda : BancoDeDados.vendas) {

            serie.getData().add(
                    new XYChart.Data<>(
                            venda.getProduto(),
                            venda.getVendatotal()
                    )
            );
        }

        graficoVendas.getData().setAll(serie);
    }
}
