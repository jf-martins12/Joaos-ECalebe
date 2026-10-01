package com.example.joaosecalebe.Model;

    public class Venda {

        private String produto;
        private String tamanho;
        private double valorUnitario;
        private double valorVendido;


        public Venda(String produto, String tamanho,
                     double valorUnitario, double valorVendido) {

            this.produto = produto;
            this.tamanho = tamanho;
            this.valorUnitario = valorUnitario;
            this.valorVendido = valorVendido;
        }


        public String getProduto() {
            return produto;
        }


        public String getTamanho() {
            return tamanho;
        }


        public double getValorUnitario() {
            return valorUnitario;
        }


        public double getValorVendido() {
            return valorVendido;
        }
    }

