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

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/EsqueciSenha.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 963, 733);
        BancoDeDados.vendas.add(new Venda("Camisa", "M", 90, "nike",150,1500,10));
        BancoDeDados.vendas.add(new Venda("Calça","40",90,"Browns",200,2000,10));
        BancoDeDados.vendas.add(new Venda("tenis","41", 90, "Nike",300,3000,10));
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}