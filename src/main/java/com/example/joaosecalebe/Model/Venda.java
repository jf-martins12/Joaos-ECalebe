
package com.example.joaosecalebe.Model;

public class Venda {

    private String produto;
    private String tamanho;
    private int quantidade;
    private double valorUnitario;
    private double valorVendido;
    private String fornecedor;

    public Venda(String produto, String tamanho, int quantidade,
                 String fornecedor, double valorUnitario, double valorVendido) {

        this.produto = produto;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.valorUnitario = valorUnitario;
        this.valorVendido = valorVendido;
    }

    public String getProduto() {
        return produto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorVendido() {
        return quantidade * valorUnitario;
    }
}