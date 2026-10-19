package com.example.joaosecalebe.Database;

import com.example.joaosecalebe.Model.Cargo;
import com.example.joaosecalebe.Model.Departamento;
import com.example.joaosecalebe.Model.Venda;

import com.example.joaosecalebe.Model.Produto;
import com.example.joaosecalebe.Model.Venda;

import java.util.ArrayList;

public class BancoDeDados {

    public static ArrayList <Venda> vendas= new ArrayList<>();
    public static ArrayList <Cargo> cargos= new ArrayList<>();
    public static ArrayList<Departamento> departamentos = new ArrayList<>();




    static {
        vendas.add(new Venda("Camisa", "M", 139.00, 6.950));
        vendas.add(new Venda("Calça","40",150.90,9.054));
        vendas.add(new Venda("tenis","41", 400.00, 8.000));


    }


    public static ArrayList <Produto> produtos=new ArrayList<>();

}




