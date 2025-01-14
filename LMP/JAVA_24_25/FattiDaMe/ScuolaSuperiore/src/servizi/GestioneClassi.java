package servizi;

import modelli.Classe;
import modelli.Studente;

import java.util.HashMap;
import java.util.Map;

public class GestioneClassi {
    private GestioneStudenti gestioneStudenti;

    public GestioneClassi() {
        this.gestioneStudenti = new GestioneStudenti();
    }

    public Map<Classe, Map<Studente, Integer>> ottieniRipetentiPerClasse(Classe classe) {
        Map<Studente, Integer> ripetenti = new HashMap<>();
        for (Studente studente : classe.getStudenti()) {
            if (gestioneStudenti.isRipetente(studente, classe)) {
                int anniRipetuti = gestioneStudenti.calcolaAnniRipetuti(studente, classe);
                ripetenti.put(studente, anniRipetuti);
            }
        }
        Map<Classe, Map<Studente, Integer>> risultato = new HashMap<>();
        risultato.put(classe, ripetenti);
        return risultato;
    }

    public void stampaRipetenti(Map<Classe, Map<Studente, Integer>> ripetentiPerClasse) {
        for (Map.Entry<Classe, Map<Studente, Integer>> entry : ripetentiPerClasse.entrySet()) {
            Classe classe = entry.getKey();
            Map<Studente, Integer> ripetenti = entry.getValue();
            System.out.println("Classe: " + classe.getNome() + ", Sezione: " + classe.getSezione());
            System.out.println("Ripetenti:");
            for (Map.Entry<Studente, Integer> studenteEntry : ripetenti.entrySet()) {
                Studente studente = studenteEntry.getKey();
                int anniRipetuti = studenteEntry.getValue();
                System.out.println("- " + studente.getNome() + " " + studente.getCognome() + " | Anni ripetuti: " + anniRipetuti);
            }
            System.out.println();
        }
    }
}
