package pkg.fiap.agroterra;

import java.util.ArrayList;
import java.util.Scanner;

public class Semente {
	
	ArrayList<Semente> sementes;
	String tipoSemente;
	double qtdSemente;
	
	
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
		System.out.println("\n [1] cadastrar lote sementes \n [2] Calcular espaçamento entre sementes \n [3] Práticas de armazenamento");
		
		int resposta = scan.nextInt();
		
		switch(resposta){
			case 1:
				cadastraSemente(scan);
				break;
			case 2:
				calculaEspacamento(scan);
				break;
		}
		
	}
	
	public void cadastraSemente(Scanner scan) {
		
		System.out.println("Qual o tipo de semente que será armazenado? ");
		String tipoSemente = scan.next();
		System.out.println("Digite a quantidade de sementes (unidade) ");
		int qtdSemente = scan.nextInt();
		
		Semente semente = new Semente(tipoSemente,qtdSemente);
		sementes.add(semente);
		
		System.out.println("Semente adicionada com sucesso!");
	}
	
	public void mostraSementes(){
		
		for(int x = 0; x < sementes.size(); x++) {
			Semente semente = sementes.get(x);
			System.out.println("#Armazenado" + (x+1));
			System.out.println("Tipo Semente......:" + semente.tipoSemente);
			System.out.println("Quantidade (un.)..:" + semente.qtdSemente);
			
		}
		
	}
	
	public void calculaEspacamento(Scanner scan) {
		
		System.out.println("Escolha um dos tipos a seguir para que o cálculo seja realizado:\n");
		mostraSementes();
		
		int resposta = scan.nextInt()-1;
		
		Semente semente = sementes.get(resposta);
		String pergunta = "Calcule o espaçamento ideal para " + semente.qtdSemente + " sementes de " + semente.tipoSemente +
						  " em um espaço de 3 metros quadrados";
		
			System.out.println(pergunta);	
		//ChatGPT.GPTResponde(pergunta);
		
		
		
	}
	
	
	
	
	
	
	
}
