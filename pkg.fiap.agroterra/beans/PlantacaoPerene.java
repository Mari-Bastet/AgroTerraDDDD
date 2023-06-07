package beans;

public class PlantacaoPerene extends Plantacao {
	
	private String precisaPoda;
	
	public PlantacaoPerene(String tipoSolo, double tamanhoTerreno, String tipoAlimento,String precisaPoda) {
		super(tipoSolo, tamanhoTerreno, tipoAlimento);
		this.precisaPoda = precisaPoda;
	}
	
	public String getPrecisaPoda(){
		return precisaPoda;
		
	}
	
}