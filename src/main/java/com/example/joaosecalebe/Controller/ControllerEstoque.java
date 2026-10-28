package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import com.example.joaosecalebe.Model.Produto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

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

    @FXML
    public void EditarProduto() {
        Produto produtoSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();

        if (produtoSelecionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atenção");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um produto para editar!");
            alerta.showAndWait();
            return;
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Editar Produto");
        alerta.setHeaderText("Produto selecionado");
        alerta.setContentText("Produto: " + produtoSelecionado.getNome());
        alerta.showAndWait();

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/CadastroVenda.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = (Stage) tabelaEstoque.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Não foi possível abrir a tela de edição.");
            alerta.showAndWait();
        }
    }




    @FXML
    public void AdicionarProduto() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/joaosecalebe/view/CadastroVenda.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = (Stage) tabelaEstoque.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void ExcluirProduto() {
        Produto produtoSelecionado = tabelaEstoque.getSelectionModel().getSelectedItem();

        if (produtoSelecionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atenção");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecione um produto para excluir!");
            alerta.showAndWait();
            return;
        }

        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Excluir Produto");
        confirmacao.setHeaderText("Deseja excluir este produto?");
        confirmacao.setContentText("Produto: " + produtoSelecionado.getNome());

        Optional<ButtonType> resposta = confirmacao.showAndWait();

        if (resposta.isPresent() && resposta.get() == ButtonType.OK) {
            BancoDeDados.produtos.remove(produtoSelecionado);
            tabelaEstoque.getItems().remove(produtoSelecionado);

            atualizarIndicadores();

            Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
            sucesso.setTitle("Sucesso");
            sucesso.setHeaderText(null);
            sucesso.setContentText("Produto excluído com sucesso!");
            sucesso.showAndWait();
        }
    }
    public void atualizarTabela() {
        tabelaEstoque.getItems().clear();

        for (Produto produto : BancoDeDados.produtos) {
            tabelaEstoque.getItems().add(produto);
        }

        atualizarIndicadores();
    }
}




