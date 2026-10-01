package com.example.joaosecalebe.DataBase;

import com.example.joaosecalebe.Model.Venda;

import java.util.ArrayList;

public class BancoDeDados {

    public static ArrayList <Venda> vendas= new ArrayList<>();

    static {
        vendas.add(new Venda("Camisa", "M", 139.00, 6.950));
        vendas.add(new Venda("Calça","40",150.90,9.054));
        vendas.add(new Venda("tenis","41", 400.00, 8.000));
    }
}




