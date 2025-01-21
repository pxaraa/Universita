package modelli;

public class Libro extends Articolo {
    private int numeroPagine;

    public Libro(String titolo, String entePubblicante, int annoPubblicazione, int numeroPagine) {
        super(titolo, entePubblicante, annoPubblicazione);
        this.numeroPagine = numeroPagine;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Libro [titolo=" + getTitolo() +
                ", entePubblicante=" + getEntePubblicante() +
                ", anno=" + getAnnoPubblicazione() +
                ", pagine=" + numeroPagine + "]";
    }
}
