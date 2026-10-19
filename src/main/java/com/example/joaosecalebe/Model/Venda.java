
package com.example.joaosecalebe.Model;

public class Venda {

    private double totalfaturado;

    private int totalvendas;

    private String produto;

    private int quantidade;

    public Venda(double totalfaturado, int totalvendas, String produto, int quantidade) {

        this.totalfaturado = totalfaturado;
        this.totalvendas = totalvendas;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public double getTotalfaturado() {
        return totalfaturado;
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