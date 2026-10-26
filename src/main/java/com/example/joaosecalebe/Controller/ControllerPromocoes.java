package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Promocao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Optional;

public class ControllerPromocoes {

    @FXML
    private TableView<Promocao> Tabelapromocao;

    @FXML
    private TableColumn<Promocao, String> colProduto;

    @FXML
    private TableColumn<Promocao, Double> colPromocao;

    @FXML
    private TableColumn<Promocao, String> colData;

    @FXML
    private TableColumn<Promocao, String> colResponsavel;

    @FXML
    private TableColumn<Promocao, String> colStatus;

    @FXML
    private TableColumn<Promocao, String> colAcoes;

    @FXML
    private TextField txtpesquisar;

    @FXML
    private Label lblProduto;

    @FXML
    private Label lblCategoria;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblDesconto;

    @FXML
    private Label lblprecoOriginal;

    @FXML
    private Label lblprecoPromocional;

    @FXML
    private Label lblperiodoPromocao;

    @FXML
    private TextField txtJustificativa;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblData;

    private Promocao promocaoSelecionada;

    public void initialize() {

        colProduto.setCellValueFactory(
                new PropertyValueFactory<>("nomeProduto"));

        colPromocao.setCellValueFactory(
                new PropertyValueFactory<>("desconto"));

        colData.setCellValueFactory(
                new PropertyValueFactory<>("dataSolicitacao"));

        colResponsavel.setCellValueFactory(
                new PropertyValueFactory<>("nomeSolicitante"));

        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        colAcoes.setCellValueFactory(
                new PropertyValueFactory<>("status"));
    }

    private void atualizarTabela(ArrayList<Promocao> promocaos) {
        Tabelapromocao.getItems().setAll(promocaos);
    }

    private void mostrarDetalhe(Promocao promocao) {

        if (promocao == null) {
            promocaoSelecionada = null;
            return;
        }

        promocaoSelecionada = promocao;

        lblProduto.setText(promocao.getNomeProduto());
        lblCategoria.setText(promocao.getCategoria());
        lblMarca.setText(promocao.getMarca());

        lblDesconto.setText(promocao.getDesconto() + "%");

        lblprecoOriginal.setText(
                String.format("R$ %.2f", promocao.getPrecoOriginal()));

        lblprecoPromocional.setText(
                String.format("R$ %.2f", promocao.getPrecoPromocional()));

        lblperiodoPromocao.setText(promocao.getPeriodoPromocao());

        txtJustificativa.setText(promocao.getJustificativa());

        lblNome.setText(promocao.getNomeSolicitante());
        lblData.setText(promocao.getDataSolicitacao());

    }

    @FXML
    public void Pendentes() {
        filtrarStatus("Pendente");
    }

    @FXML
    public void Aprovadas() {
        filtrarStatus("Aprovada");
    }

    @FXML
    public void Rejeitadas() {
        filtrarStatus("Rejeitada");
    }

    private void filtrarStatus(String status) {

        ArrayList<Promocao> filtradas = new ArrayList<>();

        for (Promocao promocao : BancoDeDados.promocaos) {

            if (promocao.getStatus().equalsIgnoreCase(status)) ;
            {
                filtradas.add(promocao);
            }
        }
        atualizarTabela(filtradas);
        limparDetalhes();
    }

    public void pesquisarProduto() {

        String pesquisa = txtpesquisar.getText().toLowerCase();

        ArrayList<Promocao> encontradas = new ArrayList<>();

        for (Promocao promocao : BancoDeDados.promocaos) {
            if (promocao.getNomeProduto().toLowerCase().contains(pesquisa)) {
                encontradas.add(promocao);
            }
        }

        atualizarTabela(encontradas);
        limparDetalhes();

    }

    public void Aprovar() {

        if (promocaoSelecionada == null) {
            mostrarAviso("Selecione uma promoção.");
            return;
        }

        promocaoSelecionada.setStatus("Aprovada");


        atualizarTabela(BancoDeDados.promocaos);
        limparDetalhes();
    }

    public void Rejeitar() {

        if (promocaoSelecionada == null) {
            mostrarAviso("Selecione uma promoção");
            return;
        }
        promocaoSelecionada.setStatus("Rejeitado"
        );

        atualizarTabela(BancoDeDados.promocaos);
        limparDetalhes();
    }

    public void adicionarObservacao() {

        if (promocaoSelecionada == null) {
            mostrarAviso("Selecione uma promoção");
            return;

        }

        TextInputDialog dialog = new TextInputDialog(
                promocaoSelecionada.getJustificativa()
        );

        dialog.setTitle("Observação");
        dialog.setHeaderText("Adicionar obsaervação á promoção");
        dialog.setContentText("Observação: ");

        Optional<String> resultado = dialog.showAndWait();

        resultado.ifPresent(observacao -> {
            promocaoSelecionada.setJustificativa(observacao);
            txtJustificativa.setText(observacao);
        });
    }

    private void limparDetalhes() {
        promocaoSelecionada = null;

        lblProduto.setText("");
        lblCategoria.setText("");
        lblMarca.setText("");
        lblDesconto.setText("");
        lblprecoOriginal.setText("");
        lblprecoPromocional.setText("");
        lblperiodoPromocao.setText("");
        txtJustificativa.setText("");
        lblNome.setText("");
        lblData.setText("");
    }

    private void mostrarAviso(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Atenção");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();


    }
}
