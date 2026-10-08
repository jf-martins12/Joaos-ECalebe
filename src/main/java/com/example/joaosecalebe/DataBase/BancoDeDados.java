package com.example.joaosecalebe.DataBase;

import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;

import java.util.ArrayList;

public class BancoDeDados {

    public static ArrayList <Venda> vendas= new ArrayList<>();

    static {
    vendas.add(new Venda("Camisa", "M",100 , "Nike",139.90, 13990.00));
        vendas.add(new Venda("Calça","40",80 ,"Browns",180.90,14472.00));
        vendas.add(new Venda("tenis","41", 60 , "Nike", 300.00, 18000.00));
    }


    public static ArrayList <Produto> produtos=new ArrayList<>();

}




