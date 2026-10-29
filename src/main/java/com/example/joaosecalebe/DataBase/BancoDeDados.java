package com.example.joaosecalebe.DataBase;

import com.example.joaosecalebe.Model.Cargo;
import com.example.joaosecalebe.Model.Departamento;
import com.example.joaosecalebe.Model.Venda;

import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.joaosecalebe.Model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    public static ArrayList<Venda> vendas = new ArrayList<>();
    public static ArrayList<Cargo> cargos = new ArrayList<>();
    public static ArrayList<Departamento> departamentos = new ArrayList<>();

    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();


    static {
        vendas.add(new Venda("Camisa", "M", 90, "nike", 150, 1500, 10));
        vendas.add(new Venda("Calça", "40", 90, "Browns", 200, 2000, 10));
        vendas.add(new Venda("tenis", "41", 90, "Nike", 300, 3000, 10));

    }
}



