package com.example.joaosecalebe.Model;

public class Cargo { private int id;
    private String nome;
    private double salarioMinimo;
    private double salarioMaximo;
    private Departamento departamento;

    public Cargo(int id, String nome,
                 double salarioMinimo,
                 double salarioMaximo,
                 Departamento departamento) {

        this.id = id;
        this.nome = nome;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.departamento = departamento;
    }

    public Cargo(String nome, String departamento, Double salariomi, Double salarioma) {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioMinimo() {
        return salarioMinimo;
    }

    public double getSalarioMaximo() {
        return salarioMaximo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioMinimo(double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public void setSalarioMaximo(double salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}

