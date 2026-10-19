package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.Database.BancoDeDados;
import com.example.joaosecalebe.Model.Cargo;
import com.example.joaosecalebe.Model.Departamento;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class controllerCargo {
    @FXML
    private
    TextField txNome;
    @FXML
    private
    TextField txSalarioma;
    @FXML
    private
    TextField txSalariomi;
    @FXML
    private
    TextField txDepartamento;
    @FXML
    private
    Button btnCadastrar;

    @FXML
    private
    Button btnEditar;

    @FXML
    private
    Button btnLimpar;

    public void limpar() {
        txNome.clear();
        txDepartamento.clear();
        txSalarioma.clear();
        txSalariomi.clear();

    }

    private Cargo CargoEditando;

    private boolean editando = false;

    public void setCargoEditando(Cargo cargo) {

        this.editando = true;
        ;
        this.CargoEditando = cargo;

        txNome.setText(cargo.getNome());
        txDepartamento.setText(cargo.getDepartamento().getNome());
        txSalariomi.setText(Double.toString(cargo.getSalarioMinimo()));
    }


    @FXML
    private
    TableView<Cargo> tbCargo;
    @FXML
    private TableColumn<Cargo, String> colNome;
    @FXML
    private TableColumn<Cargo, String> colDepartamento;

    @FXML
    private TableColumn<Cargo, String> colSalariomi;

    @FXML
    private TableColumn<Cargo, String> colSalarioma;


    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));

        colDepartamento.setCellValueFactory(new PropertyValueFactory<>("Departamento"));

        colSalariomi.setCellValueFactory(new PropertyValueFactory<>("Salariomi"));

        colSalarioma.setCellValueFactory(new PropertyValueFactory<>("Salarioma"));

    }

    @FXML
    public void CadastrarAluno() {
        String nome = txNome.getText();
        String departamento = txDepartamento.getText();
        Double salariomi = Double.parseDouble(txSalariomi.getText());
        Double salarioma = Double.parseDouble(txSalarioma.getText());


        Cargo cargo = new Cargo(nome, departamento, salariomi, salarioma);
        BancoDeDados.cargos.add(cargo);

        exibirAlerta(Alert.AlertType.INFORMATION, "Cadastro Concluído",
                "O Cargo " + nome + " foi cadastrado com sucesso!");
        limpar();


    }
    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

