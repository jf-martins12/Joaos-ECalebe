package com.example.joaosecalebe.DataBase;

import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;

import java.util.ArrayList;

public class BancoDeDados {

    public static ArrayList <Venda> vendas= new ArrayList<>();

    static {
        vendas.add(new Venda(150.00, 1, "Camiseta", 5));
        vendas.add(new Venda(300.00, 1, "Calça", 3));
        vendas.add(new Venda(200.00, 1, "Tênis", 2));
    }


    public static ArrayList <Produto> produtos=new ArrayList<>();

}




