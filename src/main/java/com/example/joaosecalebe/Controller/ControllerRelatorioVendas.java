package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.Model.Venda;


import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.ArrayList;

import static com.example.joaosecalebe.DataBase.BancoDeDados.vendas;

public class ControllerRelatorioVendas {

    @FXML
    private TableView<Venda> tabelaVendas;

    @FXML
    private TableColumn<Venda, String> produto;

    @FXML
    private TableColumn<Venda, String> tamanho;

    @FXML
    private TableColumn<Venda, Integer> quantidade;

    @FXML
    private TableColumn<Venda, String> fornecedor;

    @FXML
    private TableColumn<Venda, Double> valorUnitario;

    @FXML
    private TableColumn<Venda, Double> valorVendido;




    @FXML
    private LineChart<String, Number> graficovendas;


    @FXML
    public void initialize() {



        produto.setCellValueFactory(
                new PropertyValueFactory<>("produto")
        );

        tamanho.setCellValueFactory(
                new PropertyValueFactory<>("tamanho")
        );

        quantidade.setCellValueFactory(
                new PropertyValueFactory<>("quantidade")
        );

        fornecedor.setCellValueFactory(
                new PropertyValueFactory<>("fornecedor")
        );

        valorUnitario.setCellValueFactory(
                new PropertyValueFactory<>("valorUnitario")
        );

        valorVendido.setCellValueFactory(
                new PropertyValueFactory<>("valorVendido")
        );


        tabelaVendas.getItems().setAll(vendas);


    criarGrafico(vendas);
}





    private void criarGrafico(ArrayList<Venda> vendas) {



XYChart.Series<String, Number> serie =
                        new XYChart.Series<>();

        serie.setName("Vendas");

       for (Venda venda : vendas) {

serie.getData().add(
                    new XYChart.Data<>(
                            venda.getProduto(),
                            venda.getQuantidade()
                )
        );



    }
    graficovendas.getData().clear();
    graficovendas.getData().add(serie);



    }
}
