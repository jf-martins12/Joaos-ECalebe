package com.example.joaosecalebe.Model;

import java.time.LocalDate;

public class Funcionario {
    private String Nome;
    private String Cpf;

    private double Salario;
    private String Senha;

    public String getCpf() {
        return Cpf;
    }
public String getNome(){
        return Nome;
}

    public double getSalario() {
        return Salario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Funcionario(String nome, String cpf, LocalDate data, double salario, String senha) {
        this.Nome = nome;
        this.Cpf = cpf;
        this.Salario = salario;
        this.Senha = senha;
    }
}
