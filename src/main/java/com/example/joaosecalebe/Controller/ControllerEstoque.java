package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import javafx.fxml.FXML;
import com.example.joaosecalebe.Model.Produto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerEstoque {

    @FXML
    private TableView<Produto> tabelaEstoque;

    @FXML
    private TableColumn<Produto, String> colProduto;

    @FXML
    private TableColumn<Produto, String> colCategoria;

    @FXML
    private TableColumn<Produto, Double> colPreço;

    @FXML
    private TableColumn<Produto, Integer> colQuantidade;

    @FXML
    private TableColumn<Produto, String> colTamanho;

    @FXML
    private TableColumn<Produto, Long> colCodigo;

    @FXML
    private TableColumn<Produto, String> colFornecedor;


    public void initialize(){
        colProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colFornecedor.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        colPreço.setCellValueFactory(new PropertyValueFactory<>("preço"));

        for (Produto produto: BancoDeDados.produtos){
            tabelaEstoque.getItems().add(produto);
        }
    }

}




