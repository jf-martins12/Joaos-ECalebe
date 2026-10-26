
package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Venda;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class ControllerRelatorioVendas {

    @FXML
    private Label txtotalfaturado;

    @FXML
    private Label txtotalvendas;

    @FXML
    private PieChart graficopagamento;

    @FXML
    private LineChart<String, Number> graficovendas;

    @FXML
    private TableView<Venda> tabelaVendas;

    @FXML
    private TableColumn<Venda, String> produto;

    @FXML
    private TableColumn<Venda, String> fornecedor;

    @FXML
    private TableColumn<Venda, Integer> valorUnitario;

    @FXML
    private TableColumn<Venda, Double> valorVendido;

    @FXML
    public void initialize() {
        configurarTabela();
        atualizarRelatorio();
        criarGraficoPagamentos();
    }

    private void configurarTabela() {

        produto.setCellValueFactory(
                new PropertyValueFactory<>("produto")
        );

        fornecedor.setCellValueFactory(
                new PropertyValueFactory<>("fornecedor")
        );

        valorUnitario.setCellValueFactory(
                new PropertyValueFactory<>("valorunico")
        );

        valorVendido.setCellValueFactory(
                new PropertyValueFactory<>("valortotal")
        );

        tabelaVendas.getItems().setAll(BancoDeDados.vendas);
    }

    private void atualizarRelatorio() {

        double faturamento = 0;
        int quantidadeVenda = 0;

        for (Venda venda : BancoDeDados.vendas) {
            faturamento += venda.getVendatotal();
            quantidadeVenda += venda.getTotalvendas();
        }

        NumberFormat moeda = NumberFormat.getCurrencyInstance(
                new Locale("pt", "BR")
        );

        txtotalfaturado.setText(moeda.format(faturamento));
        txtotalvendas.setText(String.valueOf(quantidadeVenda));

        criarGrafico(BancoDeDados.vendas);
    }

    private void criarGrafico(ArrayList<Venda> vendas) {

        XYChart.Series<String, Number> serie =
                new XYChart.Series<>();

        serie.setName("Faturamento em reais");

        Map<String, Double> faturamentoPorProduto =
                new LinkedHashMap<>();

        for (Venda venda : vendas) {

            String nomeProduto = venda.getProduto();

            double valor = venda.getVendatotal();

            faturamentoPorProduto.put(
                    nomeProduto,
                    faturamentoPorProduto.getOrDefault(nomeProduto, 0.0)
                            + valor
            );
        }

        for (Map.Entry<String, Double> item
                : faturamentoPorProduto.entrySet()) {

            serie.getData().add(
                    new XYChart.Data<>(
                            item.getKey(),
                            item.getValue()
                    )
            );
        }

        graficovendas.getData().clear();
        graficovendas.getData().add(serie);
    }

    private void criarGraficoPagamentos() {

        graficopagamento.getData().clear();

        // Valores demonstrativos: ainda não vêm do BancoDeDados.
        graficopagamento.getData().addAll(
                new PieChart.Data("Pix", 45),
                new PieChart.Data("Cartão", 35),
                new PieChart.Data("Dinheiro", 20)
        );
    }
}

