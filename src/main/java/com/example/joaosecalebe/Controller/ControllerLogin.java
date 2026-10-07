package com.example.joaosecalebe.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerLogin {

    @FXML
    private
    TextField txNome;
    @FXML
    private
    TextField txCpf;

    @FXML
    public void limpar() {
        txNome.clear();
        txCpf.clear();
    }

}
