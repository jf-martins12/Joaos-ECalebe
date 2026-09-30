package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.Model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerRelatorioVendas {

    @FXML
    private TableView<Venda> tabelaVendas;

    @FXML
    private TableColumn<Venda, Number> Quantidade;

    @FXML
    private TableColumn<Venda, String> Produto;

    @FXML
    private TableColumn<Venda, String> Tamanho;

    @FXML
    private TableColumn<Venda, Double> ValorUnitario;

    @FXML
    private TableColumn<Venda, Double> ValorVendido;

    @FXML
    private BarChart<String, Number> graficoVendas;


    @FXML
    public void initialize() {

        Produto.setCellValueFactory(
                new PropertyValueFactory<>("produto")
        );

        Tamanho.setCellValueFactory(
                new PropertyValueFactory<>("tamanho")
        );

        ValorUnitario.setCellValueFactory(
                new PropertyValueFactory<>("valorUnitario")
        );

        ValorVendido.setCellValueFactory(
                new PropertyValueFactory<>("valorVendido")
        );


        ObservableList<Venda> vendas = FXCollections.observableArrayList();


        tabelaVendas.setItems(vendas);

        criarGrafico(vendas);
    }


    private void criarGrafico(ObservableList<Venda> vendas) {

    XYChart.Series<String, Number> serie =
            new XYChart.Series<>();

    serie.setName("Vendas");

    for (Venda venda : vendas) {

        serie.getData().add(
                new XYChart.Data<>(
                        venda.getProduto(),
                        venda.getValorVendido()
                )
        );

    }
    graficoVendas.getData().clear();
    graficoVendas.getData().add(serie);

    }
}