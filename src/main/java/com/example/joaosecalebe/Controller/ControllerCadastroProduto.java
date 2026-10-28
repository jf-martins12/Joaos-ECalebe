package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerCadastroProduto {

    @FXML
    private void btnabrirestoque(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/joaosecalebe/view/Estoque.fxml"));

        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private TextField txnome;

    @FXML
    private TextField txquantidade;

    @FXML
    private TextField txcodigo;

    @FXML
    private TextField txtamanho;

    @FXML
    private TextField txfornecedor;

    @FXML
    private TextField txpreço;

    @FXML
    private TextField txcategoria;

    @FXML
    private Button btncadastrar;

    @FXML
    private Button btnlimpar;

    @FXML
    public void btncadastrar(){

        String nome = txnome.getText();
        String tamanho = txtamanho.getText();
        String categoria = txcategoria.getText();
        double preço = Double.parseDouble(txpreço.getText());
        int quantidade = Integer.parseInt(txquantidade.getText());
        long codigo = Long.parseLong(txcodigo.getText());
        String fornecedor = txfornecedor.getText();


        Produto produto = new Produto(

                nome,
                categoria,
                tamanho,
                preço,
                quantidade,
                codigo,
                fornecedor
        );
        BancoDeDados.produtos.add(produto);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro concluído");
        alerta.setHeaderText("Produto cadastrado com sucesso!");
        alerta.setContentText(
                "Nome: " + nome +
                        "\nCategoria: " + categoria +
                        "\nTamanho: " + tamanho +
                        "\nPreço: R$ " + preço +
                        "\nQuantidade: " + quantidade +
                        "\nCódigo: " + codigo +
                        "\nFornecedor: " + fornecedor );

       alerta.showAndWait();

        btnlimpar();

    }

    @FXML
    private void btnlimpar(){

        txnome.clear();
        txcategoria.clear();
        txtamanho.clear();
        txcodigo.clear();
        txpreço.clear();
        txfornecedor.clear();
        txquantidade.clear();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Campos limpos");
        alerta.setHeaderText(null);
        alerta.setContentText("Todos os campos foram limpos!");
        alerta.showAndWait();



    }



}


