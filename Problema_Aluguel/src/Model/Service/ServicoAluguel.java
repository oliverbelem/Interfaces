package Model.Service;

import Model.Entities.AluguelCarro;
import Model.Entities.Fatura;

import java.time.Duration;

public class ServicoAluguel {

    private Double precoDia;
    private Double precoHora;

    private TaxaServico taxaServico;

    public ServicoAluguel(Double precoDia, Double precoHora, TaxaServico taxaServico) {
        this.precoDia = precoDia;
        this.precoHora = precoHora;
        this.taxaServico = taxaServico;
    }

    public void ProcessoFatura(AluguelCarro aluguelCarro){

        double minutos =  Duration.between(aluguelCarro.getRecebimento(), aluguelCarro.getEntrega()).toMinutes();
        double horas = minutos / 60.0;

        double pgBasico;
        if(horas <= 12.0){
            pgBasico = precoHora * Math.ceil(horas);
        }else{
            pgBasico = precoDia * Math.ceil(horas / 24.0);
        }

        double taxa = taxaServico.taxa(pgBasico);

        aluguelCarro.setFatura(new Fatura(pgBasico , taxa));
    }

}
