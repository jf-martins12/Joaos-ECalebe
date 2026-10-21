package com.example.joaosecalebe.Controller;

import com.example.joaosecalebe.Model.Cargo;
import com.example.joaosecalebe.Model.HistoricoSalarial;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class controllerHistoricoSalarial {

    @FXML
    private
    TableView<Cargo> tbCargo;
    @FXML
    private TableColumn<HistoricoSalarial,String> colCargo;
    @FXML
    private TableColumn<HistoricoSalarial,Double> colSalarioa;

    @FXML
    private  TableColumn<HistoricoSalarial,Double>colNovoSalario;

    @FXML
    private TableColumn<HistoricoSalarial,Double>colData;

    @FXML TableColumn<HistoricoSalarial,String>colMotivo;

    @FXML
    public void initialize (){
        colCargo.setCellValueFactory(new PropertyValueFactory<>("Cargo"));
        colSalarioa.setCellValueFactory(new PropertyValueFactory<>("Salarioa"));
        colNovoSalario.setCellValueFactory(new PropertyValueFactory<>("NovoSalario"));
        colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        colMotivo.setCellValueFactory(new PropertyValueFactory<>("Motivo"));




    }

}

