package com.example.joaosecalebe.DataBase;

import com.example.joaosecalebe.Model.Cargo;
import com.example.joaosecalebe.Model.Departamento;
import com.example.joaosecalebe.Model.Venda;

import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    public static ArrayList <Venda> vendas= new ArrayList<>();
    public static ArrayList <Cargo> cargos= new ArrayList<>();
    public static ArrayList<Departamento> departamentos = new ArrayList<>();




    static {
        vendas.add(new Venda(
                "Camisa", "M", 90, "Nike", 130, 1.300));

        vendas.add(new Venda(
                "Calça", "40", 90, "Browns", 180, 1.800));

        vendas.add(new Venda(
                "Tenis", "41", 90, "Nike", 300, 30.000));
    }
}




