package com.example.joaosecalebe;

import com.example.joaosecalebe.DataBase.BancoDeDados;
import com.example.joaosecalebe.Model.Venda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 963, 733);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}