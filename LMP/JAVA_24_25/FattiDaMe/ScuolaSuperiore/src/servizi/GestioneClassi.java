package servizi;

import modelli.Classe;
import modelli.Studente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestioneClassi {
    private GestioneStudenti gestioneStudenti = new GestioneStudenti();
    ArrayList<Studente> studenti = new ArrayList<>();
    HashMap<Studente, Integer> ripetenti = new HashMap<>();
    HashMap<Classe,Studente> risultato = new HashMap<>();

    public void aggiungiStudente(String nome, String cognome, String luogoNascita, String dataNascita,int annoIscrizione) {
        studenti.add(new Studente(nome,cognome,luogoNascita,dataNascita,annoIscrizione));
    }

    public  void ottieniRipetentiPerClasse(Classe classe) {
        for (Studente studente : classe.getStudenti()) {
            if (gestioneStudenti.isRipetente(studente, classe)) {
                int anniRipetuti = gestioneStudenti.calcolaAnniRipetuti(studente, classe);
                ripetenti.put(studente, anniRipetuti);
            }
        }
        risultato.put(classe, ripetenti);
    }

    public void stampaRipetenti() {
        for (HashMap.Entry<Classe, HashMap<Studente, Integer>> entry : risultato.entrySet()) {
            Classe classe = entry.getKey();
            HashMap<Studente, Integer> ripetenti = entry.getValue();
            System.out.println("Classe: " + classe.getNome() + ", Sezione: " + classe.getSezione());
            System.out.println("Ripetenti:");
            for (HashMap.Entry<Studente, Integer> studenteEntry : ripetenti.entrySet()) {
                Studente studente = studenteEntry.getKey();
                int anniRipetuti = studenteEntry.getValue();
                System.out.println("- " + studente.getNome() + " " + studente.getCognome() + " | Anni ripetuti: " + anniRipetuti);
            }
            System.out.println();
        }
    }
}
