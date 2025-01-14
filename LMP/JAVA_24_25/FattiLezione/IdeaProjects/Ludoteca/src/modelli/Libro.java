package modelli;
import java.time.LocalDate;

public class Libro {
    private String titolo;
    private String autore;
    private String casaEditrice;
    private LocalDate annoPubblicazione;
    private int pagine;
    public Libro(String titolo, String autore, String casaEditrice, LocalDate annoPubblicazione, int pagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.annoPubblicazione = annoPubblicazione;
    }
}
