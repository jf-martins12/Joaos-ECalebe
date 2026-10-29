package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> cbTamanho;

    @FXML
    private ComboBox<String> cbFornecedor;

    @FXML
    private TextField txpreço;

    @FXML
    private ComboBox<String> cbCategoria;

    @FXML
    private Button btncadastrar;

    @FXML
    private Button btnlimpar;




    @FXML
    public void initialize() {

        cbCategoria.getItems().addAll(
                "Camiseta", "Calça", "Bermuda",
                "Moletom", "Jaqueta", "Tênis", "Acessórios"
        );

        cbTamanho.getItems().addAll(
                "PP", "P", "M", "G", "GG",
                "38", "39", "40", "41", "42", "Único"
        );

        cbFornecedor.getItems().addAll(
                "Nike", "Adidas", "Puma", "Browns"
        );
    }

    @FXML
    public void btncadastrar() {

        String nome = txnome.getText();
        String categoria = cbCategoria.getValue();
        String tamanho = cbTamanho.getValue();
        String fornecedor = cbFornecedor.getValue();

        try {
            double preço = Double.parseDouble(txpreço.getText());
            int quantidade = Integer.parseInt(txquantidade.getText());
            long codigo = Long.parseLong(txcodigo.getText());

            boolean editando = produtoEditando != null;

            if (editando == false) {

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

            } else {

                produtoEditando.setNome(nome);
                produtoEditando.setCategoria(categoria);
                produtoEditando.setTamanho(tamanho);
                produtoEditando.setPreço(preço);
                produtoEditando.setQuantidade(quantidade);
                produtoEditando.setCodigo(codigo);
                produtoEditando.setFornecedor(fornecedor);

                produtoEditando = null;
            }

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);

            if (editando) {
                alerta.setTitle("Edição concluída");
                alerta.setHeaderText("Produto editado com sucesso!");
            } else {
                alerta.setTitle("Cadastro concluído");
                alerta.setHeaderText("Produto cadastrado com sucesso!");
            }

            alerta.setContentText(
                    "Nome: " + nome +
                            "\nCategoria: " + categoria +
                            "\nTamanho: " + tamanho +
                            "\nPreço: R$ " + preço +
                            "\nQuantidade: " + quantidade +
                            "\nCódigo: " + codigo +
                            "\nFornecedor: " + fornecedor
            );

            alerta.showAndWait();

            btnlimpar();

        } catch (NumberFormatException e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText(null);
            alerta.setContentText("Confira o preço, a quantidade e o código.");
            alerta.showAndWait();
        }
    }




    @FXML
    private void btnlimpar(){

        txnome.clear();
        cbCategoria.getSelectionModel().clearSelection();
        cbTamanho.getSelectionModel().clearSelection();
        txcodigo.clear();
        txpreço.clear();
        cbFornecedor.getSelectionModel().clearSelection();
        txquantidade.clear();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Campos limpos");
        alerta.setHeaderText(null);
        alerta.setContentText("Todos os campos foram limpos!");
        alerta.showAndWait();



    }


    private Produto produtoEditando;

    public void setProdutoParaEditar(Produto produto) {
        produtoEditando = produto;

        txnome.setText(produto.getNome());
        cbCategoria.setValue(produto.getCategoria());
        cbTamanho.setValue(produto.getTamanho());
        txpreço.setText(String.valueOf(produto.getPreço()));
        txquantidade.setText(String.valueOf(produto.getQuantidade()));
        txcodigo.setText(String.valueOf(produto.getCodigo()));
        cbFornecedor.setValue(produto.getFornecedor());



    }
}


