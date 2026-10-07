package com.example.joaosecalebe.model;

public class compra {
    private String produto;
    private int quantidade;
    private double preco;

    public compra(String produto, int quantidade, double preco) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public String getProduto(){
        return produto;
    }
    public void setProduto(String produto){
        this.produto=produto;
    }
     public int getQuantide(){
        return quantidade;
     }
     public void setQuantidade(String quantidadede){
        this.quantidade=quantidade;
     }

     public void getPreco(Double preco){this.preco=preco;}

    public void setPreco(Double preco){this.preco=preco;}


    public double getTotal(){
        return quantidade*preco;
    }
}











