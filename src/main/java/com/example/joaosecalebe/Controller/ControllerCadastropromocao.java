package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerCadastropromocao {

    @FXML
    private ComboBox<Produto> cbProduto;

    @FXML
    private TextField txdesconto;

    @FXML
    private TextField txinicio;

    @FXML
    private TextField txtermino;

    @FXML
    private TextField txsolicitante;

    @FXML
    private TextField txjustificativa;

    @FXML
    private Button bntPromocao;

@FXML
    private void AbrirPromocao (ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/joaosecalebe/view/promocoes.fxml"));

        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }



    public void initialize() {

        cbProduto.getItems().addAll(BancoDeDados.produtos);
        cbProduto.setConverter(new StringConverter<Produto>() {
            @Override
            public String toString(Produto produto) {
                if (produto == null) {
                    return "";
                }
                return produto.getNome();
            }


            @Override
            public Produto fromString(String texto) {
                for (Produto produto : BancoDeDados.produtos) {
                    if (produto.getNome().equalsIgnoreCase(texto)) {
                        return produto;
                    }
                }
                return null;
            }
        });

    }

    private ArrayList<String> promocoes = new ArrayList<>();

    @FXML
    public void cadastrarPromocao() {

        Produto produtoSelecionado = cbProduto.getValue();

        String descontotexto = txdesconto.getText();
        String inicio = txinicio.getText();
        String termino = txtermino.getText();
        String solicitante = txsolicitante.getText();
        String justificativa = txjustificativa.getText();

        if (produtoSelecionado == null
        || descontotexto.isEmpty()
        ||inicio.isEmpty()
        || termino.isEmpty()
        || solicitante.isEmpty()
        ||  justificativa.isEmpty())
        {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("Preencha todos os campos da promoção.");
            alerta.showAndWait();
            return;
        }



        try {

            double desconto = Double.parseDouble(
                    descontotexto.replace(",", ".")
            );


            if (desconto <= 0 || desconto > 100) {

                Alert alerta1 = new Alert(Alert.AlertType.WARNING);
                alerta1.setTitle("Desconto inválido");
                alerta1.setHeaderText(null);
                alerta1.setContentText(
                        "O desconto deve estar entre 0 e 100%.");
                alerta1.showAndWait();
                return;
            }
            String promocao = "Produto: "
                    + produtoSelecionado.getNome()
                    + "\nData de início: " + inicio
                    + "\nData de término: " + termino
                    + "\nSolicitante: " + solicitante
                    + "\nJustificativa: " + justificativa;

            promocoes.add(promocao);
            Alert alerta1 = new Alert(Alert.AlertType.INFORMATION);
            alerta1.setHeaderText("Cadastro realizado com sucesso!");
            alerta1.setContentText(promocao);
            alerta1.showAndWait();

            txdesconto.clear();
            txinicio.clear();
            txtermino.clear();
            txsolicitante.clear();
            txjustificativa.clear();

            cbProduto.getSelectionModel().clearSelection();
        } catch (NumberFormatException e) {
            Alert alerta1 = new Alert(Alert.AlertType.ERROR);
            alerta1.setTitle("Erro");
            alerta1.setHeaderText(null);
            alerta1.setContentText(
                    "Digite um desconto numérico válido."
            );
            alerta1.showAndWait();

        }

    }

}