package com.example.joaosecalebe.Model;
import java.time.LocalDate;

public class HistoricoSalarial {

    private int id;
    private Cargo cargo;
    private double salarioAnterior;
    private double novoSalario;
    private LocalDate dataAlteracao;
    private String motivo;

    public HistoricoSalarial(
            int id,
            Cargo cargo,
            double salarioAnterior,
            double novoSalario,
            String motivo) {

        this.id = id;
        this.cargo = cargo;
        this.salarioAnterior = salarioAnterior;
        this.novoSalario = novoSalario;
        this.motivo = motivo;
        this.dataAlteracao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public double getSalarioAnterior() {
        return salarioAnterior;
    }

    public double getNovoSalario() {
        return novoSalario;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public String getMotivo() {
        return motivo;
    }
}

