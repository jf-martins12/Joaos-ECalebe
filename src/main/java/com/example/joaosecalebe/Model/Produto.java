package com.example.joaosecalebe.Model;

public class  Produto {

    private String nome;
    private String categoria;
    private double preço;
    private int quantidade;

    private long codigo;

    private String tamanho;

    private String fornecedor;





    public Produto(String tamanho, String nome, String categoria, double preço, int quantidade, long codigo,  String fornecedor) {

        this.nome = nome;
        this.codigo = codigo;
        this.tamanho = tamanho;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preço = preço;

    }

    public String getNome(){
        return nome;
    }
    public String getCategoria(){
        return categoria;
    }

    public double getPreço(){
        return preço;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public long getCodigo(){
        return codigo;
    }

    public String getTamanho(){
        return tamanho;
    }

    public String getFornecedor(){
        return fornecedor;
    }
}