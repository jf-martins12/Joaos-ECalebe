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
        BancoDeDados.vendas.add(new Venda("Camisa", "M", 139.00, 6.950));
        BancoDeDados.vendas.add(new Venda("Calça","40",150.90,9.054));
        BancoDeDados.vendas.add(new Venda("tenis","41", 400.00, 8.000));

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/RelatorioVendas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 537);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}