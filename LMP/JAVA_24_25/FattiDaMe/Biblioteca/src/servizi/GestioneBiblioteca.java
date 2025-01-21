package servizi;

import modelli.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneBiblioteca {

    private List<Articolo> articoli;
    private int giorniConcessiSenzaMaggiorazione;

    public GestioneBiblioteca(int giorniConcessi) {
        this.articoli = new ArrayList<>();
        this.giorniConcessiSenzaMaggiorazione = giorniConcessi;
    }

    public void aggiungiArticolo(Articolo articolo) {
        articoli.add(articolo);
    }

    public void setGiorniConcessiSenzaMaggiorazione(int giorni) {
        this.giorniConcessiSenzaMaggiorazione = giorni;
    }

    public int getGiorniConcessiSenzaMaggiorazione() {
        return giorniConcessiSenzaMaggiorazione;
    }

    public long calcolaPrestitoPiuLungo(Articolo articolo) {
        long maxDurata = 0;
        for (Prestito prestito : articolo.getPrestiti()) {
            long durata = prestito.getDurataPrestitoInGiorni();
            if (durata > maxDurata) {
                maxDurata = durata;
            }
        }
        return maxDurata;
    }

    public List<String> verificaInconsistenze(Articolo articolo) {
        List<String> errori = new ArrayList<>();
        List<Prestito> prestiti = articolo.getPrestiti();

        for (int i = 0; i < prestiti.size(); i++) {
            Prestito p1 = prestiti.get(i);
            for (int j = i + 1; j < prestiti.size(); j++) {
                Prestito p2 = prestiti.get(j);

                if (isSovrapposto(p1, p2)) {
                    errori.add("Sovrapposizione tra prestito " + p1 + " e " + p2
                            + " per l'articolo: " + articolo.getTitolo());
                }
            }
        }
        return errori;
    }

    private ArrayList<Prestito>isSovrapposto(Lista di prestiti) {
        LocalDate inizio1 = p1.getDataInizio();
        LocalDate fine1 = p1.getDataEffettiva();
        LocalDate inizio2 = p2.getDataInizio();
        LocalDate fine2 = p2.getDataEffettiva();

        if (fine1 == null || fine2 == null) {
            return (inizio1.isBefore(inizio2) && (fine1 == null || fine1.isAfter(inizio2))) ||
                    (inizio2.isBefore(inizio1) && (fine2 == null || fine2.isAfter(inizio1)));
        }

        boolean sovrapposti = !inizio1.isAfter(fine2) && !inizio2.isAfter(fine1);
        return sovrapposti;
    }
}
