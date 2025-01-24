import modelli.*;
import servizi.*;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Creazione della scuola
        Scuola scuola = new Scuola("Liceo Scientifico Galileo");

        // Creazione di una classe
        Classe classe5A = new Classe("5A", 2006, 5, "A");

        // Creazione di studenti
        Studente studente1 = new Studente("Mario", "Rossi", "Milano", "2004-03-15", 2020);
        Studente studente2 = new Studente("Luigi", "Verdi", "Roma", "2006-05-10", 2017);

        // Aggiunta degli studenti alla classe
        classe5A.aggiungiStudente(studente1);
        classe5A.aggiungiStudente(studente2);

        // Aggiunta della classe alla scuola
        scuola.aggiungiClasse(classe5A);

        // Verifica ripetenti
        GestioneClassi gestioneScuola = new GestioneClassi();
        Map<Classe, Map<Studente, Integer>> ripetentiPerClasse = gestioneScuola.ottieniRipetentiPerClasse(classe5A);

        //Alunni presenti nella classe
        System.out.println("Numero Alunni:" + classe5A.contaStudenti());

        // Stampa ripetenti
        gestioneScuola.stampaRipetenti(ripetentiPerClasse);
    }
}
