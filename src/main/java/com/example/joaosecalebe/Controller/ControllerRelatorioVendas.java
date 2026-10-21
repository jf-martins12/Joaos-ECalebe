package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Venda;



import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static com.example.joaosecalebe.DataBase.BancoDeDados.vendas;

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
    public void initialize() {
        atualizarRelatorio();
        criarGraficoPagamentos();
        }

        private void atualizarRelatorio(){
        double faturamento = 0;
        int quantidadeVenda = 0;


        for (Venda venda : BancoDeDados.vendas){
            faturamento += venda.getTotalfaturado();
            quantidadeVenda += venda.getTotalvendas();
            }

            NumberFormat moeda =
                    NumberFormat.getCurrencyInstance(
                         new Locale("pt", "BR")
                    );
        txtotalfaturado.setText(moeda.format(faturamento));
            txtotalvendas.setText(String.valueOf(quantidadeVenda));







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

    private void criarGraficoPagamentos() {
        graficopagamento.getData().clear();

        graficopagamento.getData().addAll(
                new PieChart.Data("Pix", 45),
                new PieChart.Data("Cartão", 35),
                new PieChart.Data("Dinheiro", 20)
        );
    }
    }
