package modelli;

public class Dvd extends Articolo {
    private int durata; // in minuti

    public Dvd(String titolo, String entePubblicante, int annoPubblicazione, int durata) {
        super(titolo, entePubblicante, annoPubblicazione);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Dvd [titolo=" + getTitolo() +
                ", entePubblicante=" + getEntePubblicante() +
                ", anno=" + getAnnoPubblicazione() +
                ", durata(min)=" + durata + "]";
    }
}
