package modelli;

public class Oop extends Esame {
    private String argomentiRichiesti;
    private double votoOrale;
    private double votoScritto;

    public Oop(int matricola, String nome, String cognome, String argomentiRichiesti, double votoOrale,double votoScritto) {
        super(matricola, nome, cognome);
        this.argomentiRichiesti = argomentiRichiesti;
        this.votoOrale = votoOrale;
        this.votoScritto = votoScritto;
    }

    public String getArgomentiRichiesti(){
        return argomentiRichiesti;
    }

    public double getVotoOrale() {
        return votoOrale;
    }

    public double getVotoScritto() {
        return votoScritto;
    }
}
