import servizi.GestioneBiblioteca;

import modelli.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GestioneBiblioteca gb = new GestioneBiblioteca(15);

        Libro libro1 = new Libro("Il Signore degli Anelli", "Bompiani", 1955, 1200);
        Dvd dvd1 = new Dvd("Matrix", "Warner Bros", 1999, 136);

        gb.aggiungiArticolo(libro1);
        gb.aggiungiArticolo(dvd1);

        Prestito prestito1 = new Prestito(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 16),
                LocalDate.of(2025, 1, 10),
                "Mario",
                "Rossi",
                10.0
        );

        Prestito prestito2 = new Prestito(
                LocalDate.of(2025, 1, 10),
                LocalDate.of(2025, 1, 25),
                LocalDate.of(2025, 1, 20),
                "Luca",
                "Bianchi",
                12.0
        );

        Prestito prestito3 = new Prestito(
                LocalDate.of(2025, 1, 5),
                LocalDate.of(2025, 1, 20),
                LocalDate.of(2025, 1, 18),
                "Giulia",
                "Verdi",
                8.0
        );

        libro1.aggiungiPrestito(prestito1);
        libro1.aggiungiPrestito(prestito2);

        dvd1.aggiungiPrestito(prestito3);

        long maxDurataLibro1 = gb.calcolaPrestitoPiuLungo(libro1);
        System.out.println("Prestito più lungo (in giorni) per il libro1: " + maxDurataLibro1);

        long maxDurataDvd1 = gb.calcolaPrestitoPiuLungo(dvd1);
        System.out.println("Prestito più lungo (in giorni) per il dvd1: " + maxDurataDvd1);

        List<String> erroriLibro1 = gb.verificaInconsistenze(libro1);
        if (erroriLibro1.isEmpty()) {
            System.out.println("Nessuna sovrapposizione di prestiti per il libro1.");
        } else {
            System.out.println("Inconsistenze trovate per il libro1:");
            for (String err : erroriLibro1) {
                System.out.println(" - " + err);
            }
        }

        List<String> erroriDvd1 = gb.verificaInconsistenze(dvd1);
        if (erroriDvd1.isEmpty()) {
            System.out.println("Nessuna sovrapposizione di prestiti per il dvd1.");
        } else {
            System.out.println("Inconsistenze trovate per il dvd1:");
            for (String err : erroriDvd1) {
                System.out.println(" - " + err);
            }
        }
    }
}
