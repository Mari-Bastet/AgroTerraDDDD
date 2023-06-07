package beans;
import java.time.LocalDate;

public class PlantacaoAnual extends Plantacao {

	private LocalDate dataPlantio;

    public PlantacaoAnual(String tipoSolo, double tamanhoTerreno, String tipoAlimento, LocalDate dataPlantio) {
		super(tipoSolo, tamanhoTerreno, tipoAlimento);
		
		this.dataPlantio = dataPlantio;
	}
    
    public LocalDate mostraDataPlantio() {
    	return dataPlantio;
    	
    }
}
