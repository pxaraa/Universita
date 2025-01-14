package modelli;
import java.time.LocalTime;
import java.time.LocalDate;

public class Gioco {
    private String titolo;
    private String autore;
    private String casaEditrice;
    private LocalDate annoPubblicazione;
    private LocalTime durataMedia;

    public Gioco(String titolo, String autore, String casaEditrice, LocalDate annoPubblicazione, LocalTime durataMedia) {
        this.titolo = titolo;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.annoPubblicazione = annoPubblicazione;
        this.durataMedia = durataMedia;
    }

}
