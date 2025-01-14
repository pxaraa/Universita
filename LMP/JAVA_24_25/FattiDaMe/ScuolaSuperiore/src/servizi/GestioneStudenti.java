package servizi;

import java.time.LocalDate;
import modelli.Classe;
import modelli.Studente;

public class GestioneStudenti {
    LocalDate dataCorrente = LocalDate.now();
    int annoCorrente = dataCorrente.getYear();

    //verifica se lo studente è ripetente
    public boolean isRipetente(Studente studente, Classe classe) {
        return annoCorrente - (studente.getAnnoIscrizione() + classe.getCorso()) > 0;
    }

    // calcola di quanti anni è ripetente lo studente
    public int calcolaAnniRipetuti(Studente studente, Classe classe) {
        int anniRipetuti =annoCorrente - (studente.getAnnoIscrizione() + classe.getCorso());
        return Math.max(0, anniRipetuti);
    }
}
