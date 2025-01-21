package modelli;

public class Prolog extends Esame{
    private String argomentiRichiesti;
    private double votoOrale;
    private double votoScritto;

    public Prolog (int matricola, String nome, String cognome, String argomentiRichiesti, double votoOrale,double votoScritto) {
        super(matricola, nome, cognome);
        this.argomentiRichiesti = argomentiRichiesti;
        this.votoOrale = votoOrale;
        this.votoScritto = votoScritto;
    }

    public double getVotoScritto() {
        return votoScritto;
    }

    public double getVotoOrale() {
        return votoOrale;
    }

    public String getArgomentiRichiesti() {
        return argomentiRichiesti;
    }
}
