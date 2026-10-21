package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import com.example.joaosecalebe.Model.Produto;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.text.NumberFormat;
import java.util.Locale;

public class ControllerEstoque {

    @FXML
    private TableView<Produto> tabelaEstoque;

    @FXML
    private TableColumn<Produto, String> colproduto;

    @FXML
    private TableColumn<Produto, String> colcategoria;

    @FXML
    private TableColumn<Produto, Double> colpreco;

    @FXML
    private TableColumn<Produto, Integer> colquantidade;

    @FXML
    private TableColumn<Produto, String> coltamanho;

    @FXML
    private TableColumn<Produto, Long> colcodigo;

    @FXML
    private TableColumn<Produto, String> colfornecedor;

    @FXML
    private TableColumn<Produto, String> colstatus;

    @FXML
    private Label lbprodutoscadastrados;

    @FXML
    private Label lbpecasdisponiveis;

    @FXML
    private Label lbvalorestoque;

    @FXML
    private Button btnexcluir;

    @FXML
    private Button btneditar;


    @FXML
    public void initialize() {
        colproduto.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );

        colcategoria.setCellValueFactory(
                new PropertyValueFactory<>("categoria")
        );

        colpreco.setCellValueFactory(
                new PropertyValueFactory<>("preço")
        );

        colquantidade.setCellValueFactory(
                new PropertyValueFactory<>("quantidade")
        );

        coltamanho.setCellValueFactory(
                new PropertyValueFactory<>("tamanho")
        );

        colcodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );

        colfornecedor.setCellValueFactory(
                new PropertyValueFactory<>("fornecedor")
        );

        colstatus.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        tabelaEstoque.getItems().clear();

        for (Produto produto: BancoDeDados.produtos){
            tabelaEstoque.getItems().add(produto);
        }

        atualizarIndicadores();
    }


    private void atualizarIndicadores() {
        int totalProdutos = BancoDeDados.produtos.size();
        int totalPecas = 0;
        double valorEstoque = 0;

        for (Produto produto : BancoDeDados.produtos) {
            totalPecas += produto.getQuantidade();

            valorEstoque += produto.getQuantidade()
                    * produto.getPreço();
        }

        lbprodutoscadastrados.setText(
                String.valueOf(totalProdutos)
        );

        lbpecasdisponiveis.setText(
                String.valueOf(totalPecas)
        );

        NumberFormat moeda =
                NumberFormat.getCurrencyInstance(
                        new Locale("pt", "BR")
                );

        lbvalorestoque.setText(
                moeda.format(valorEstoque)
        );
    }
}




