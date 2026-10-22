package com.example.joaosecalebe.Model;

import java.time.LocalDate;

public class Funcionario {
    private String Nome;
    private String Cpf;
    private String Cargo;
    private double Salario;
    private String Senha;

    public String getNome() {
        return Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getCargo() {
        return Cargo;
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

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Funcionario(String nome, String cpf, String cargo, double salario, String senha) {
        Nome = nome;
        Cpf = cpf;
        Cargo = cargo;
        Salario = salario;
        Senha = senha;
    }
}