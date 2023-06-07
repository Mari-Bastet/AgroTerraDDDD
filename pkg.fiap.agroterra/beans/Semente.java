package beans;

import java.util.ArrayList;
import java.util.Scanner;

public class Semente {
	
	private ArrayList<Semente> sementes;
	private String tipoSemente;
	private double qtdSemente;
	
	
	public Semente() {
		sementes = new ArrayList<>();

	}
	
	public Semente(String tipoSemente, int qtdSemente) {
		
		this.tipoSemente = tipoSemente;
		this.qtdSemente = qtdSemente;
		sementes = new ArrayList<>();
	}

	public void manejamentoSementes(Scanner scan){
		System.out.println("\n O que gostaria de fazer com relação a suas sementes? ");
		System.out.println("\n [1] cadastrar lote sementes \n [2] Ver lotes \n [3] Calcular Espaçamento para Plantio");
		
		int resposta = scan.nextInt();
		
		switch(resposta){
			case 1:
				cadastraSemente(scan);
				break;
				
			case 2: 
				mostraSementes();
				break;
			case 3:
				calculaEspacamento(scan);
				break;
		}
	}
	
	public void cadastraSemente(Scanner scan) {
		
		System.out.println("A semente de qual alimento que será armazenada? ");
		String tipoSemente = scan.next();
		System.out.println("Digite a quantidade de sementes (unidade): ");
		int qtdSemente = scan.nextInt();
		scan.nextLine();
		
		Semente semente = new Semente(tipoSemente,qtdSemente);
		sementes.add(semente);
		
		System.out.println("Semente adicionada com sucesso!");
	}
	
	public void mostraSementes(){
		
		if(sementes.isEmpty()){
			System.out.println("Não há lotes cadastrados.");
		}
		
		else {
		for(int x = 0; x < sementes.size(); x++) {
			Semente semente = sementes.get(x);
			System.out.println("#Armazenado" + (x+1));
			System.out.println("Tipo Semente......:" + semente.tipoSemente);
			System.out.println("Quantidade (un.)..:" + semente.qtdSemente);
			
		}
	  }
	}
	
	public void calculaEspacamento(Scanner scan) {
		
		ChatGPT gpt = new ChatGPT();
		System.out.println("Escolha um dos tipos a seguir para que o cálculo seja realizado:\n");
		mostraSementes();
		
		int resposta = scan.nextInt()-1;
		
		System.out.println("Digite a área planejada para plantio (em metros quadrados): ");
		double tamanhoPlantio = scan.nextDouble();
		
		Semente semente = sementes.get(resposta);
		String pergunta = "Calcule o espaçamento ideal para " + semente.qtdSemente + " sementes de " + semente.tipoSemente +
						  " em um espaço de " + tamanhoPlantio + "metros quadrados";
		
		String respostaGpt = gpt.GPTResponde(pergunta);
		System.out.println(respostaGpt);
		
		}
}
