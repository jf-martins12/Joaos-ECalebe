
package com.example.joaosecalebe.Model;

public class Venda {
    private int valorunico;
    private String fornecedor;
    private double vendatotal;

    private int totalvendas;
    private String tamanho;
    private String produto;

    private int quantidade;

    public Venda(String produto, String tamanho, int quantidade, String fornecedor, int valorunico, double vendatotal, int totalvendas) {
        this.valorunico = valorunico;
        this.fornecedor = fornecedor;
        this.vendatotal = vendatotal;
        this.totalvendas = totalvendas;
        this.produto = produto;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
    }

    public int getValorunico() {
        return valorunico;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public double getVendatotal() {
        return vendatotal;
    }

    public int getTotalvendas() {
        return totalvendas;
    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

}