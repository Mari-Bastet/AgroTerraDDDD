package pkg.fiap.agroterra;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlantacaoAnual extends Plantacao {
	
	String tipoSolo;
	LocalDate dataPlantio;
	ArrayList<PlantacaoAnual> plantAnual;

    public PlantacaoAnual(String tipoSolo, double tamanhoTerreno, String tipoAlimento, LocalDate dataPlantio) {
		super(tipoSolo, tamanhoTerreno, tipoAlimento);
		
		this.dataPlantio = dataPlantio;
		plantAnual = new ArrayList<>();
	}
    
    public LocalDate mostraDataPlantio() {
    	return dataPlantio;
    	
    }
    
    public void adicionaPlantacaoAnual(PlantacaoAnual novaPlantacao) {
    	plantAnual.add(novaPlantacao);
    }
    
    
    public void mostraPlantacoesAnuais() {
    	
    
		System.out.println("<-+-+-+-+- Plantações Anuais -+-+-+-> \n");
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
