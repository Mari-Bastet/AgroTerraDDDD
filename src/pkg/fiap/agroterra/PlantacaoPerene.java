package pkg.fiap.agroterra;

public class PlantacaoPerene extends Plantacao {
	
	String precisaPoda;
	
	public PlantacaoPerene(String tipoSolo, double tamanhoTerreno, String tipoAlimento,String precisaPoda) {
		super(tipoSolo, tamanhoTerreno, tipoAlimento);
		this.precisaPoda = precisaPoda;
	}
	
	public String getPrecisaPoda(){
		return precisaPoda;
		
	}

}
