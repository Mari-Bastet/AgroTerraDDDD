package pkg.fiap.agroterra;

public class Plantacao {
    private String tipoSolo;
    private double tamanhoTerreno;
    private String tipoAlimento;

    public Plantacao(String tipoSolo, double tamanhoTerreno, String tipoAlimento) {
        this.tipoSolo = tipoSolo;
        this.tamanhoTerreno = tamanhoTerreno;
        this.tipoAlimento = tipoAlimento;
    }


    public String getTipoSolo() {
        return tipoSolo;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public String identificarPragas() {
        return "Possuo uma plantação de " + tipoAlimento +
                " com terreno de " + tamanhoTerreno + " metros quadrados e solo " +
                tipoSolo + ", quais são as possíveis pragas?";
    }

    public String cultivarMelhorForma() {
        return "Possuo uma plantação de " + tipoAlimento +
                ", com terreno de " + tamanhoTerreno + " metros quadrados e solo " +
                tipoSolo + ", como cultivar de uma melhor forma?";
    }

    public String melhorEpocaColheita() {
        return "Possuo um terreno " + tipoSolo +
                ", planto " + tipoAlimento + " e tenho " + tamanhoTerreno +
                " metros, é a melhor época para colheita?";
    }

    
}
