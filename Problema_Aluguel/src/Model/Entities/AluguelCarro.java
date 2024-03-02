package Model.Entities;

import java.time.LocalDateTime;

public class AluguelCarro {

    private LocalDateTime recebimento;
    private LocalDateTime entrega;

    private Veiculo veiculo;
    private Fatura fatura;

    public AluguelCarro() {

    }

    public AluguelCarro(LocalDateTime recebimento, LocalDateTime entrega, Veiculo veiculo) {
        this.recebimento = recebimento;
        this.entrega = entrega;
        this.veiculo = veiculo;
    }

    public LocalDateTime getRecebimento() {
        return recebimento;
    }

    public void setRecebimento(LocalDateTime recebimento) {
        this.recebimento = recebimento;
    }

    public LocalDateTime getEntrega() {
        return entrega;
    }

    public void setEntrega(LocalDateTime entrega) {
        this.entrega = entrega;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
