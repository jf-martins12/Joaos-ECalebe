package com.example.joaosecalebe.model;

public class Gerente {
    private String Nome ;

    private Double Cpf ;

    private String Email;

    private Double Telefone;

    public cadastro (String nome, Double cpf){
        this.Nome=nome;
        this.Cpf=cpf;
        this.Email=Email;
        this.Telefone=Telefone;
    }
    public String getNome {return nome;}
    public void setNome(String nome){this.Nome=nome; }

    public String get;


    public String getNome() {
        return Nome;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setTelefone(Double telefone) {
        Telefone = telefone;
    }

    public void setGetNome(String getNome) {
        this.getNome = getNome;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public void setCpf(Double cpf) {
        Cpf = cpf;
    }

    public Double getCpf() {
        return Cpf;
    }

    public String getEmail() {
        return Email;
    }

    public Double getTelefone() {
        return Telefone;
    }

    public String getGetNome() {
        return getNome;
    }

    public String getGet() {
        return get;
    }
}
