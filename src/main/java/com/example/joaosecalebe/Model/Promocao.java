package com.example.joaosecalebe.Model;

public class Promocao {

    private String nomeProduto;
    private String categoria;
    private String marca;

    private double precoOriginal;
    private double precoPromocional;
    private double desconto;

    private String periodoPromocao;
    private String justificativa;
    private String nomeSolicitante;
    private String dataSolicitacao;
    private String status;

    public Promocao(String nomeProduto,String categoria, String marca, Double precoOriginal, Double precoPromocional,
                    Double desconto, String periodoPromocao, String justificativa, String nomeSolicitante,
                    String dataSolicitacao, String status){

        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.precoOriginal = precoOriginal;
        this.precoPromocional = precoPromocional;
        this.desconto = desconto;
        this.periodoPromocao = periodoPromocao;
        this.justificativa = justificativa;
        this.nomeSolicitante = nomeSolicitante;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;

    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecoOriginal() {
        return precoOriginal;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getPrecoPromocional() {
        return precoPromocional;
    }

    public String getPeriodoPromocao() {
        return periodoPromocao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setJustificativa(String justificativa) { this.justificativa = justificativa;}
}
