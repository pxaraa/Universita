import modelli.Persona;
import servizi.GestioneAlbero;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GestioneAlbero gest = new GestioneAlbero();

        Persona nonnoPaterno = new Persona("Giacomo", "Alessi", "RSSMRA80A01X001A",
                LocalDate.of(1980, 1, 1), "Roma");

        Persona nonnaMaterna = new Persona("Paola", "Neri", "NERPLA81D04X001D",
                LocalDate.of(1981, 4, 1), "Milano");

        Persona padre = new Persona("Giuseppe", "Alessi", "RSSGPP00E05X001E",
                LocalDate.of(2000, 5, 1), "Roma");
        Persona madre = new Persona("Giulia", "Bianchi", "BNCELN01F06X001F",
                LocalDate.of(2001, 6, 1), "Milano");

        Persona figlio = new Persona("Marco", "Rossi", "RSSMRC20G07X001G",
                LocalDate.of(2020, 7, 1), "Roma");

        padre.setPadre(nonnoPaterno);
        madre.setMadre(nonnaMaterna);
        figlio.setPadre(padre);
        figlio.setMadre(madre);
        nonnoPaterno.setDataMorte(LocalDate.of(2010, 1, 1));

        gest.calcolaDimensione(figlio);
        gest.profonditàAlbero(figlio);
        gest.getTuttiAntenati(figlio);
    }
}
