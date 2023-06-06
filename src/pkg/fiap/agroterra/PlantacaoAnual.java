package pkg.fiap.agroterra;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlantacaoAnual extends Plantacao {
<<<<<<< HEAD
	
	String tipoSolo;
=======
	private String tipoSolo;
    private double tamanhoTerreno;
    private String tipoAlimento;
>>>>>>> parent of 694d575 (Alterações parte 2)
	LocalDate dataPlantio;
	ArrayList<PlantacaoAnual> plantAnual;
    
    public PlantacaoAnual(){
		plantAnual = new ArrayList<>();
}
    
    public PlantacaoAnual(String tipoSolo, double tamanhoTerreno, String tipoAlimento, LocalDate dataPlantio) {
		super(tipoSolo, tamanhoTerreno, tipoAlimento);
		
		this.dataPlantio = dataPlantio;
<<<<<<< HEAD
		plantAnual = new ArrayList<>();
=======
		//Plantacao plantacao = new Plantacao ( tipoSolo,  tamanhoTerreno,  tipoAlimento);


>>>>>>> parent of 694d575 (Alterações parte 2)
	}

    
    public LocalDate mostraDataPlantio() {
    	return dataPlantio;
    	
    }
    
    public void adicionaPlantacaoAnual(PlantacaoAnual novaPlantacao) {
    	plantAnual.add(novaPlantacao);
    	System.out.println("ADICIONOU A PLANTAÇÃO ANUAL COM SUCESSO");
    }
    
    
    public void mostraPlantacoesAnuais() {
    	
    
		System.out.println("<-+-+-+-+- Plantações Anuais ENTROU -+-+-+-> \n");
    	for (int j  = 0; j < plantAnual.size(); j++) {
    	
    	PlantacaoAnual plantacao = plantAnual.get(j);
        System.out.println("Plantação#" + (j + 1));
        System.out.println("Tipo de solo: " + plantacao.tipoSolo);
        System.out.println("Tamanho do terreno: " + plantacao.getTamanhoTerreno() + " metros quadrados");
        System.out.println("Tipo de alimento: " + plantacao.getTipoAlimento());
        System.out.println("Data plantio Recente:" +  plantacao.mostraDataPlantio());
    	
    }
  }
}
