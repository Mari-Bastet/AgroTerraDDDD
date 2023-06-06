package main;
import java.util.Scanner;

import pkg.fiap.agroterra.PlantacaoManager;
import pkg.fiap.agroterra.Semente;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
      
		PlantacaoManager plantacaoManager = new PlantacaoManager();
		Semente semente = new Semente();

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    plantacaoManager.cadastrarPlantacao(scanner);
                    break;
                case 2:
                    plantacaoManager.tirarDuvidas(scanner);
                    break;
                case 3:
                    plantacaoManager.exibirPlantacoesCadastradas();
                    break;
                case 4:
                	semente.manejamentoSementes(scanner);
                	
                case 0:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar plantação");
        System.out.println("2 - Tirar dúvidas");
        System.out.println("3 - Ver plantações cadastradas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

	}
}


