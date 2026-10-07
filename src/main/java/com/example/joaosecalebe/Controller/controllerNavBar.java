package com.example.joaosecalebe.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class controllerNavBar {
    public class NavBarController {
        public void irParaInicio(ActionEvent event) throws IOException {
            trocarTela(event, "menu.fxml");
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
}
