package com.example.joaosecalebe.Model;

public class Fornecedor {
    private String Nome;
    private int Cnpj;

    public Fornecedor(String nome, int cnpj) {
        this.Nome = nome;
        this.Cnpj = cnpj;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCnpj(int cnpj) {
        Cnpj = cnpj;
    }

    public int getCnpj() {
        return Cnpj;
    }



}
