
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;
import com.example.joaosecalebe.Model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableView<Funcionario> tabelaFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colStatus;

    private ObservableList<Funcionario> listaFuncionarios =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colFuncionarios.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );

        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        atualizarDashboard();
        atualizarFuncionarios();
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

        lblEstoque.setText(
                String.valueOf(totalEstoque)
        );

        NumberFormat formato = NumberFormat.getCurrencyInstance(
                new Locale("pt", "BR")
        );

        lblReceita.setText(formato.format(receita));

        atualizarGrafico();
        atualizarFuncionarios();
    }

    public void atualizarFuncionarios() {

        listaFuncionarios.setAll(BancoDeDados.funcionarios);

        tabelaFuncionarios.setItems(listaFuncionarios);

        tabelaFuncionarios.refresh();
    }

    private void atualizarGrafico() {

        XYChart.Series<String, Number> serie =
                new XYChart.Series<>();

        serie.setName("Vendas");

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
