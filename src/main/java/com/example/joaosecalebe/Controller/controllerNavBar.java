package com.example.joaosecalebe.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class controllerNavBar {

    public void irconfiguracoes(ActionEvent event) throws IOException {
        trocarTela(event, "configuracao.fxml");
    }
    public void irpromocoes(ActionEvent event) throws IOException {
        trocarTela(event, "promocao.fxml");
    }
    public void irmenu(ActionEvent event) throws IOException {
        trocarTela(event, "menu.fxml");
    }
    public void irrelatorios(ActionEvent event) throws IOException {
        trocarTela(event, "RalatorioVendas.fxml");
    }

    public void irestoque(ActionEvent event) throws IOException {
        trocarTela(event, "Estoque.fxml");
    }

    public void irfuncionarios(ActionEvent event) throws IOException {
        trocarTela(event, "Cargo.fxml");
    }

    private void trocarTela(ActionEvent event, String arquivo) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/joaosecalebe/view/" + arquivo)
        );

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
