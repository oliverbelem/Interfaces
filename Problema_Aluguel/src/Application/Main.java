package Application;

import Model.Entities.AluguelCarro;
import Model.Entities.Veiculo;
import Model.Service.ServicoAluguel;
import Model.Service.TaxaServicoBrasil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel:");
        System.out.print("Modelo do Carro: ");
        String modelo = sc.nextLine();
        System.out.print("Data e hora da retirada: ");
        LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Data e hora da devolução: ");
        LocalDateTime devolucao = LocalDateTime.parse(sc.nextLine(), fmt);

        AluguelCarro aluguel = new AluguelCarro(retirada, devolucao, new Veiculo(modelo));

        System.out.print("Entre com preço por hora: ");
        double precoHora = sc.nextDouble();
        System.out.print("Entre com preço por dia: ");
        double precoDia = sc.nextDouble();

        ServicoAluguel servico = new ServicoAluguel(precoDia, precoHora, new TaxaServicoBrasil());

        servico.ProcessoFatura(aluguel);
        System.out.println();
        System.out.println("Fatura:");
        System.out.println("Pagamento Básico: R$" + String.format("%.2f", aluguel.getFatura().getPagamentoBasico()));
        System.out.println("Imposto: R$" + String.format("%.2f",aluguel.getFatura().getImposto()));
        System.out.println("Pagamento Total: R$" + String.format("%.2f", aluguel.getFatura().getPagamentoTotal()));


        sc.close();
    }
}
