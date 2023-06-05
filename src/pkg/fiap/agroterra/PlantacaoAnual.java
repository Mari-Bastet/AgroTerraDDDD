package pkg.fiap.agroterra;
import java.time.LocalDate;

public class PlantacaoAnual extends Plantacao {
	private String tipoSolo;
    private double tamanhoTerreno;
    private String tipoAlimento;
	LocalDate dataPlantio;

    public PlantacaoAnual(String tipoSolo, double tamanhoTerreno, String tipoAlimento, LocalDate dataPlantio) {
		super(tipoSolo, tamanhoTerreno, tipoAlimento);
		
		this.dataPlantio = dataPlantio;
		//Plantacao plantacao = new Plantacao ( tipoSolo,  tamanhoTerreno,  tipoAlimento);


	}
    
    public LocalDate mostraDataPlantio() {
    	return dataPlantio;
    	
    }
}
