package pkg.fiap.agroterra;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class PlantacaoManager {
	
	private ArrayList<Plantacao> plantacoes;
	private ArrayList<PlantacaoAnual> plantacoesAnuais;
	private ArrayList<PlantacaoPerene> plantacoesPerenes;


	public PlantacaoManager() {
        plantacoes = new ArrayList<>();
        plantacoesAnuais = new ArrayList<>();
        plantacoesPerenes = new ArrayList<>();
		}
	
	public void cadastrarPlantacao(Scanner scanner) {
        System.out.print("Digite o tipo de solo (arenoso, argiloso, humoso, calcário): ");
        String tipoSolo = scanner.nextLine();

        System.out.print("Digite o tamanho do terreno em metros quadrados: ");
        double tamanhoTerreno = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Digite o tipo de alimento que será plantado: ");
        String tipoAlimento = scanner.nextLine();
        
        System.out.print("Digite o tipo de plantação [1] Plantação Anual, [2] Plantação Perene");
        int tipoPlantacao = scanner.nextInt();
        
        if (tipoPlantacao == 1) {
        	System.out.println("Digite a data mais recente do plantio (Dia/Mes/Ano)");
        	String inputData = scanner.next();
        	scanner.nextLine();
        	        
        	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	LocalDate dataPlantio = LocalDate.parse(inputData, formatoData);
            LocalDate currentDate = LocalDate.now();
              	
            try {
                if (dataPlantio.isAfter(currentDate)) {
                   System.out.println("A data digitada é maior que a data atual.");
                	return;
                    
                } else {
                	PlantacaoAnual plantAnual = new PlantacaoAnual(tipoSolo, tamanhoTerreno, tipoAlimento,dataPlantio);
                    plantacoesAnuais.add(plantAnual);
                    plantacoes.addAll(plantacoesAnuais);
                    System.out.println("Plantação cadastrada com sucesso!\n");

                }
            } catch (Exception e) {
                System.out.println("A data digitada é inválida.");
                return;


            }
        }
        else {
        	System.out.println("\n Planta precisa de poda? (Sim/Não/Não sei dizer) ");
        	String precisaPoda = scanner.next();
     
        	PlantacaoPerene plantPerene = new PlantacaoPerene(tipoSolo, tamanhoTerreno, tipoAlimento,precisaPoda);

            plantacoesPerenes.add(plantPerene);
            plantacoes.addAll(plantacoesPerenes);
            System.out.println("Plantação cadastrada com sucesso!\n");

        	}
    }
	
	public void tirarDuvidas(Scanner scanner) {
        System.out.println("===== DÚVIDAS =====");
        System.out.println("Sobre qual plantação você deseja tirar dúvidas?");

        String pergunta; 
        String respostaGpt;
        
        if (plantacoes.isEmpty()) {
            System.out.println("Nenhuma plantação cadastrada.\n");
            return;
        }
        
        exibirPlantacoesCadastradas();

        System.out.print("Digite o número da plantação: ");
        int numeroPlantacao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (numeroPlantacao < 1 || numeroPlantacao > plantacoes.size()) {
            System.out.println("Número de plantação inválido.\n");
            return;
        }
        
        Plantacao plantacaoSelecionada = plantacoes.get(numeroPlantacao - 1);
        ChatGPT gpt = new ChatGPT();
        
        System.out.println("Dúvidas sobre a plantação " + numeroPlantacao + ":");
        System.out.println("1. Como identificar pragas?");
        System.out.println("2. Sobre como cultivar?");
        System.out.println("3. Qual a melhor época para colher?");
        System.out.print("Digite o número da dúvida: ");
        int numeroDuvida = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (numeroDuvida) {
            case 1:
            	pergunta = plantacaoSelecionada.identificarPragas();
            	respostaGpt = gpt.GPTResponde(pergunta);
            	System.out.println(respostaGpt);
            	
                break;
            case 2:
                pergunta = plantacaoSelecionada.cultivarMelhorForma();
            	respostaGpt = gpt.GPTResponde(pergunta);
            	System.out.println(respostaGpt);
                break;
            case 3:
                pergunta = plantacaoSelecionada.melhorEpocaColheita();
            	respostaGpt = gpt.GPTResponde(pergunta);
            	System.out.println(respostaGpt);

                break; 	
            default:
                System.out.println("Dúvida inválida.");
        }

    }
	
	public void exibirPlantacoesCadastradas() {
		
        System.out.println("===== PLANTAÇÕES CADASTRADAS =====");
        if (plantacoes.isEmpty()) {
            System.out.println("Nenhuma plantação cadastrada.\n");
        } else {
        		System.out.println("<-+-+-+-+- Plantações Anuais -+-+-+-> \n");
            	for (int j  = 0; j < plantacoesAnuais.size(); j++) {
            	
                PlantacaoAnual plantacao = plantacoesAnuais.get(j);
                System.out.println("Plantação#" + (j + 1));
                System.out.println("Tipo de solo: " + plantacao.getTipoSolo());
                System.out.println("Tamanho do terreno: " + plantacao.getTamanhoTerreno() + " metros quadrados");
                System.out.println("Tipo de alimento: " + plantacao.getTipoAlimento());
                System.out.println("Data plantio Recente:" +  plantacao.mostraDataPlantio());
            }
        		System.out.println("<-+-+-+-+- Plantações Perenes -+-+-+-> \n");
            	for (int k  = 0; k < plantacoesPerenes.size(); k++) {
                	
                    PlantacaoPerene plantacao = plantacoesPerenes.get(k);
                    System.out.println("Plantação #" + (k + 1));
                    System.out.println("Tipo de solo: " + plantacao.getTipoSolo());
                    System.out.println("Tamanho do terreno: " + plantacao.getTamanhoTerreno() + " metros quadrados");
                    System.out.println("Tipo de alimento: " + plantacao.getTipoAlimento());
                    System.out.println("Necessita de poda:" +  plantacao.getPrecisaPoda());
                }
        }
        
    }

}
	
