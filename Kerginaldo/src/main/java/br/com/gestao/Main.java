package main.java.br.com.gestao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Profissional> profissionais = new ArrayList<>();
        List<Servico> servicos = new ArrayList<>();

        System.out.print("Quantos profissionais você deseja cadastrar? ");
        int numProfissionais = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numProfissionais; i++) {
            System.out.print("Digite o nome do profissional: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a especialidade do profissional: ");
            String especialidade = scanner.nextLine();
            System.out.print("Digite a porcentagem de comissão do profissional: ");
            double comissao = scanner.nextDouble();
            scanner.nextLine();

            profissionais.add(new Profissional((long) (i + 1), nome, especialidade, comissao));
        }

        System.out.print("Quantos serviços você deseja cadastrar? ");
        int numServicos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numServicos; i++) {
            System.out.print("Digite o nome do serviço: ");
            String nomeServico = scanner.nextLine();
            System.out.print("Digite o valor do serviço: ");
            double valorServico = scanner.nextDouble();
            scanner.nextLine();

            servicos.add(new Servico((long) (i + 1), nomeServico, valorServico));
        }

        System.out.println("\nProfissionais:");
        for (Profissional profissional : profissionais) {
            System.out.println(profissional);
        }

        System.out.println("\nServiços:");
        for (Servico servico : servicos) {
            System.out.println(servico);
        }

        System.out.println("\nCálculo das Comissões:");
        for (Servico servico : servicos) {
            for (Profissional profissional : profissionais) {
                Double comissao = (servico.getValor() * profissional.getComissao()) / 100;
                System.out.printf("Profissional: %s - Serviço: %s - Comissão: R$ %.2f%n",
                        profissional.getNome(), servico.getNome(), comissao);
            }
        }

        scanner.close();
    }
}
