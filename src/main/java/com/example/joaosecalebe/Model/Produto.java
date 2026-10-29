package com.example.joaosecalebe.Model;

public class  Produto {

    private String nome;
    private String categoria;
    private String tamanho;
    private double preco;
    private int quantidade;

    private long codigo;

    private String fornecedor;

    private String status;


    public Produto(String nome,String categoria,String tamanho,  double preco, int quantidade, long codigo, String fornecedor) {

        this.nome = nome;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.status = status;





    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getTamanho() {
        return tamanho;
    }

    public double getPreço() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getStatus() {
        if (quantidade <= 0) {
            return "Esgotado";
        } else if (quantidade <= 5) {
            return "Stock baixo";
        } else {
            return "Disponível";
        }
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPreço(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}