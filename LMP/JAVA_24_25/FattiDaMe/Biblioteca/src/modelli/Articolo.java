package modelli;

import java.util.ArrayList;
import java.util.List;

public abstract class Articolo {
    private String titolo;
    private String entePubblicante;
    private int annoPubblicazione;

    private List<Prestito> prestiti;

    public Articolo(String titolo, String entePubblicante, int annoPubblicazione) {
        this.titolo = titolo;
        this.entePubblicante = entePubblicante;
        this.annoPubblicazione = annoPubblicazione;
        this.prestiti = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getEntePubblicante() {
        return entePubblicante;
    }

    public void setEntePubblicante(String entePubblicante) {
        this.entePubblicante = entePubblicante;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void aggiungiPrestito(Prestito prestito) {
        this.prestiti.add(prestito);
    }

    @Override
    public String toString() {
        return "Articolo [titolo=" + titolo +
                ", entePubblicante=" + entePubblicante +
                ", annoPubblicazione=" + annoPubblicazione + "]";
    }
}
