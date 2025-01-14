package servizi;

import modelli.Gioco;
import modelli.Libro;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestioneProdotti {
    private ArrayList<Gioco> scaffaleGiochi = new ArrayList<>();
    private ArrayList<Libro> scaffaleLibri = new ArrayList<>();

    public void addLibro(String autore, String titolo, String casaEditrice, LocalDate annoPubblicazione, int pagine){
        this.scaffaleLibri.add(new Libro(autore, titolo, casaEditrice, annoPubblicazione, pagine));
    }
    public void addGioco(String titolo, String autore, String casaEditrice, LocalDate annoPubblicazione, LocalTime durataMedia){
        this.scaffaleGiochi.add(new Gioco(titolo, autore, casaEditrice, annoPubblicazione, durataMedia));

    }

    public void prestitoGioco(){

    }

    public ArrayList<Gioco> getScaffaleGiochi() {
        return scaffaleGiochi;
    }
    public ArrayList<Libro> getScaffaleLibri() {
        return scaffaleLibri;
    }
}
